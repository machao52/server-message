package org.mc.study.server.message.netty.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.mc.study.server.message.netty.protocol.MessageResponsePacket;
import org.mc.study.server.message.netty.protocol.Packet;

import java.util.Date;

/**
 * @author machao
 * @date 2021/4/3
 */
public class MessageResponseHandler extends SimpleChannelInboundHandler<MessageResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, MessageResponsePacket messageResponsePacket) throws Exception {
        System.out.println(new Date() + "客户端收到服务端的消息：" + messageResponsePacket.getMessage());
    }
}
