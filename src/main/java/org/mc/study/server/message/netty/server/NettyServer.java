package org.mc.study.server.message.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import org.mc.study.server.message.netty.handler.LifeCycleTestHandler;
import org.mc.study.server.message.netty.handler.PacketDecode;
import org.mc.study.server.message.netty.handler.PacketEncode;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author machao
 * @date 2021/03/31
 */
public class NettyServer {

    public static volatile int connectCount = 0;

    public static void main(String[] args) {

        ServerBootstrap serverBootstrap = new ServerBootstrap();

        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workGroup = new NioEventLoopGroup();

        serverBootstrap.group(bossGroup, workGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 7, 4));
                        socketChannel.pipeline().addLast(new LifeCycleTestHandler());
                        socketChannel.pipeline().addLast(new PacketDecode());
                        socketChannel.pipeline().addLast(new LoginRequestHandler());
                        socketChannel.pipeline().addLast(new MessageRequestHandler());
                        socketChannel.pipeline().addLast(new PacketEncode());
                    }
                });
        serverBootstrap.bind(6000).addListener(future -> {
            if (future.isSuccess()) {
                //课后思考题
                /*Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(new Runnable() {
                    public void run() {
                        System.out.println("当前连接数：" + connectCount);
                    }
                }, 0, 3, TimeUnit.SECONDS);*/
            }
        });

    }

}
