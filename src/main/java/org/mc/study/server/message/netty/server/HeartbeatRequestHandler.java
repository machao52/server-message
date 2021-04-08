package org.mc.study.server.message.netty.server;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.mc.study.server.message.netty.protocol.HeartbeatRequestPacket;
import org.mc.study.server.message.netty.protocol.HeartbeatResponsePacket;

/**
 * @author machao
 * @date 2021/04/08
 */

@ChannelHandler.Sharable
public class HeartbeatRequestHandler extends SimpleChannelInboundHandler<HeartbeatRequestPacket> {

    public static final HeartbeatRequestHandler INSTANCE = new HeartbeatRequestHandler();

    private HeartbeatRequestHandler() {

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HeartbeatRequestPacket heartbeatRequestPacket) throws Exception {
        ctx.writeAndFlush(new HeartbeatResponsePacket());
    }
}
