package org.mc.study.server.message.netty.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.mc.study.server.message.netty.protocol.MessageRequestPacket;
import org.mc.study.server.message.netty.protocol.MessageResponsePacket;
import org.mc.study.server.message.netty.protocol.PacketCode;

import java.util.Date;

/**
 * @author machao
 * @date 2021/4/3
 */
public class MessageRequestHandler extends SimpleChannelInboundHandler<MessageRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageRequestPacket messageRequestPacket) throws Exception {
        System.out.println(new Date() + "客户端收到消息：" + messageRequestPacket.getMessage());
        MessageResponsePacket messageResponsePacket = new MessageResponsePacket();
        messageResponsePacket.setMessage("客户端回复[" + messageRequestPacket.getMessage() + "]");
        ctx.channel().writeAndFlush(messageResponsePacket);
    }
}
