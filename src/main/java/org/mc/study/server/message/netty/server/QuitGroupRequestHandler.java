package org.mc.study.server.message.netty.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import org.mc.study.server.message.netty.protocol.QuitGroupRequestPacket;
import org.mc.study.server.message.netty.protocol.QuitGroupResponsePacket;
import org.mc.study.server.message.netty.utils.SessionUtil;

/**
 * @author machao
 * @date 2021/04/06
 */
public class QuitGroupRequestHandler extends SimpleChannelInboundHandler<QuitGroupRequestPacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, QuitGroupRequestPacket quitGroupRequestPacket) throws Exception {
        String groupId = quitGroupRequestPacket.getGroupId();
        ChannelGroup channelGroup = SessionUtil.getChannelGroup(groupId);
        channelGroup.remove(ctx.channel());

        QuitGroupResponsePacket quitGroupResponsePacket = new QuitGroupResponsePacket();
        quitGroupResponsePacket.setSuccess(true);
        quitGroupResponsePacket.setGroupId(groupId);
        ctx.channel().writeAndFlush(quitGroupResponsePacket);
    }
}
