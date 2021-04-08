package org.mc.study.server.message.netty.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.mc.study.server.message.netty.protocol.GroupMessageResponsePacket;

/**
 * @author machao
 * @date 2021/04/07
 */
public class GroupMessageResponseHandler extends SimpleChannelInboundHandler<GroupMessageResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, GroupMessageResponsePacket groupMessageResponsePacket) throws Exception {
        System.out.println("收到群[" + groupMessageResponsePacket.getFromGroupId() + "]中" +
                "[" + groupMessageResponsePacket.getFromUser() + "]发来的消息：" + groupMessageResponsePacket.getMessage());
    }
}
