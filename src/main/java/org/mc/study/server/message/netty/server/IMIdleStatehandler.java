package org.mc.study.server.message.netty.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/**
 * @author machao
 * @date 2021/04/08
 */
public class IMIdleStatehandler extends IdleStateHandler {

    private static final int READER_IDLE_TIME = 15;


    public IMIdleStatehandler() {
        super(READER_IDLE_TIME, 0, 0, TimeUnit.SECONDS);
    }

    @Override
    protected void channelIdle(ChannelHandlerContext ctx, IdleStateEvent evt) throws Exception {
        System.out.println(READER_IDLE_TIME + "秒未读到数据，关闭连接");
        ctx.channel().close();
    }
}
