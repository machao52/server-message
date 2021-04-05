package org.mc.study.server.message.netty.client;


import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import org.mc.study.server.message.netty.handler.PacketDecode;
import org.mc.study.server.message.netty.handler.PacketEncode;
import org.mc.study.server.message.netty.protocol.MessageRequestPacket;
import org.mc.study.server.message.netty.protocol.PacketCode;
import org.mc.study.server.message.netty.server.LoginRequestHandler;
import org.mc.study.server.message.netty.utils.LoginUtil;

import java.util.Date;
import java.util.Scanner;

/**
 * @author machao
 * @date 2021/03/31
 */
public class NettyClient {

    public static void main(String[] args) {

        Bootstrap bootstrap = new Bootstrap();

        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        bootstrap.group(workerGroup)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 7, 4));
                        socketChannel.pipeline().addLast(new PacketDecode());
                        socketChannel.pipeline().addLast(new LoginResponseHandler());
                        socketChannel.pipeline().addLast(new MessageResponseHandler());
                        socketChannel.pipeline().addLast(new PacketEncode());
                    }
                });

        bootstrap.connect("localhost", 6000).addListener(future -> {
            if (future.isSuccess()) {
                System.out.println(new Date() + "：连接成功，启动控制台线程。。。");
                Channel channel = ((ChannelFuture) future).channel();
                startConsoleThread(channel);
            }
        });
    }

    public static void startConsoleThread(Channel channel) {
        new Thread(() -> {
            while (!Thread.interrupted()) {
                if (LoginUtil.hasLogin(channel)) {
                    System.out.println("输入消息发送至服务端：");
                    Scanner scanner = new Scanner(System.in);
                    String line = scanner.nextLine();
                    MessageRequestPacket messageRequestPacket = new MessageRequestPacket();
                    messageRequestPacket.setMessage(line);
                    channel.writeAndFlush(messageRequestPacket);
                }
            }
        }).start();

    }

}
