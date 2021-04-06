package org.mc.study.server.message.netty.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.mc.study.server.message.netty.protocol.JoinGroupResponsePacket;

/**
 * @author machao
 * @date 2021/04/06
 */
public class JoinGroupResponseHandler extends SimpleChannelInboundHandler<JoinGroupResponsePacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, JoinGroupResponsePacket joinGroupResponsePacket) throws Exception {
        if (joinGroupResponsePacket.isSuccess()) {
            System.out.println("加入群[" + joinGroupResponsePacket.getGroupId() + "]成功！");
        } else {
            System.out.println("加入群[" + joinGroupResponsePacket.getGroupId() + "]失败，失败原因：" + joinGroupResponsePacket.getReason());
        }
    }

}
