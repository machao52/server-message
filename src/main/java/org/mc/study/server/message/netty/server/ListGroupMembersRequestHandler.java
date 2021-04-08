package org.mc.study.server.message.netty.server;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import org.mc.study.server.message.netty.protocol.ListGroupMembersRequestPacket;
import org.mc.study.server.message.netty.protocol.ListGroupMembersResponsePacket;
import org.mc.study.server.message.netty.session.Session;
import org.mc.study.server.message.netty.utils.SessionUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author machao
 * @date 2021/04/06
 */

@ChannelHandler.Sharable
public class ListGroupMembersRequestHandler extends SimpleChannelInboundHandler<ListGroupMembersRequestPacket> {

    public static final ListGroupMembersRequestHandler INSTANCE = new ListGroupMembersRequestHandler();

    private ListGroupMembersRequestHandler(){

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ListGroupMembersRequestPacket listGroupMembersRequestPacket) throws Exception {
        String groupId = listGroupMembersRequestPacket.getGroupId();
        ChannelGroup channelGroup = SessionUtil.getChannelGroup(groupId);

        List<String> usernameList = new ArrayList<>();
        for (Channel channel : channelGroup) {
            Session session = SessionUtil.getSession(channel);
            usernameList.add(session.getUserId() + ":" + session.getUsername());
        }

        ListGroupMembersResponsePacket listGroupMembersResponsePacket = new ListGroupMembersResponsePacket();
        listGroupMembersResponsePacket.setSuccess(true);
        listGroupMembersResponsePacket.setGroupId(groupId);
        listGroupMembersResponsePacket.setUsernameList(usernameList);
        ctx.channel().writeAndFlush(listGroupMembersResponsePacket);
    }


}
