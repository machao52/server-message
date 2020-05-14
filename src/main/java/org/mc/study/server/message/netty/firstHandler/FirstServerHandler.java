package org.mc.study.server.message.netty.firstHandler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;
import java.util.Date;

/**
 * @author machao
 * @date 2019-12-22
 */
public class FirstServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println(new Date() + "服务端接收到数据-->" + byteBuf.toString(Charset.forName("UTF-8")));

        ByteBuf b=getByteBuf(ctx);
        ctx.writeAndFlush(b);
    }

    public ByteBuf getByteBuf(ChannelHandlerContext ctx) {
        byte[] bytes = "你好，大侠！".getBytes(Charset.forName("UTF-8"));
        ByteBuf byteBuf = ctx.alloc().buffer();
        byteBuf.writeBytes(bytes);
        return byteBuf;
    }
}
