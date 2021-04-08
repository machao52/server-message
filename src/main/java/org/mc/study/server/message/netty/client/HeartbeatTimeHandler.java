package org.mc.study.server.message.netty.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.mc.study.server.message.netty.protocol.HeartbeatRequestPacket;

import java.util.concurrent.TimeUnit;

/**
 * @author machao
 * @date 2021/04/08
 */
public class HeartbeatTimeHandler extends ChannelInboundHandlerAdapter {

    private static final int HEARTBEAT_INTERVAL = 5;


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        scheduleSendHeartbeat(ctx);
        super.channelActive(ctx);
    }

    private void scheduleSendHeartbeat(ChannelHandlerContext ctx) {
        ctx.executor().schedule(() -> {
            if (ctx.channel().isActive()) {
                ctx.writeAndFlush(new HeartbeatRequestPacket());
                scheduleSendHeartbeat(ctx);
            }
        }, HEARTBEAT_INTERVAL, TimeUnit.SECONDS);
    }

}
