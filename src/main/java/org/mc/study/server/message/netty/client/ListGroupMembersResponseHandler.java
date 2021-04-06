package org.mc.study.server.message.netty.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.mc.study.server.message.netty.protocol.ListGroupMembersResponsePacket;

/**
 * @author machao
 * @date 2021/04/06
 */
public class ListGroupMembersResponseHandler extends SimpleChannelInboundHandler<ListGroupMembersResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ListGroupMembersResponsePacket listGroupMembersResponsePacket) throws Exception {
        if (listGroupMembersResponsePacket.isSuccess()) {
            System.out.println("群[" + listGroupMembersResponsePacket.getGroupId() + "]中的人包括：" + listGroupMembersResponsePacket.getUsernameList());
        }
    }
}
