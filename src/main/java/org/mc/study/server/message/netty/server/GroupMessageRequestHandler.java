package org.mc.study.server.message.netty.server;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import org.mc.study.server.message.netty.protocol.GroupMessageRequestPacket;
import org.mc.study.server.message.netty.protocol.GroupMessageResponsePacket;
import org.mc.study.server.message.netty.session.Session;
import org.mc.study.server.message.netty.utils.SessionUtil;

/**
 * @author machao
 * @date 2021/04/07
 */

@ChannelHandler.Sharable
public class GroupMessageRequestHandler extends SimpleChannelInboundHandler<GroupMessageRequestPacket> {

    public static final GroupMessageRequestHandler INSTANCE = new GroupMessageRequestHandler();

    private GroupMessageRequestHandler(){

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, GroupMessageRequestPacket groupMessageRequestPacket) throws Exception {
        String groupId = groupMessageRequestPacket.getGroupId();
        ChannelGroup channelGroup = SessionUtil.getChannelGroup(groupId);

        Session session = SessionUtil.getSession(ctx.channel());
        String fromUser = session.getUserId() + ":" + session.getUsername();

        GroupMessageResponsePacket groupMessageResponsePacket = new GroupMessageResponsePacket();
        groupMessageResponsePacket.setFromGroupId(groupId);
        groupMessageResponsePacket.setFromUser(fromUser);
        groupMessageResponsePacket.setMessage(groupMessageRequestPacket.getMessage());
        channelGroup.writeAndFlush(groupMessageResponsePacket);

    }
}
