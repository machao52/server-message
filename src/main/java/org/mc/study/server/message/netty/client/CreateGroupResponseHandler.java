package org.mc.study.server.message.netty.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.mc.study.server.message.netty.protocol.CreateGroupResponsePacket;

/**
 * @author machao
 * @date 2021/04/06
 */
public class CreateGroupResponseHandler extends SimpleChannelInboundHandler<CreateGroupResponsePacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, CreateGroupResponsePacket createGroupResponsePacket) throws Exception {
        System.out.print("群创建成功，id为[" + createGroupResponsePacket.getGroupId() + "]");
        System.out.println("群里面有：" + createGroupResponsePacket.getUsernameList());
    }

}
