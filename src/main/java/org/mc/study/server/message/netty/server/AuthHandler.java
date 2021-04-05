package org.mc.study.server.message.netty.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.mc.study.server.message.netty.utils.SessionUtil;

/**
 * @author machao
 * @date 2021/4/5
 */
public class AuthHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (!SessionUtil.hasLogin(ctx.channel())) {
            ctx.channel().close();
        }else{
            ctx.pipeline().remove(this);
            super.channelRead(ctx, msg);
        }
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        if(SessionUtil.hasLogin(ctx.channel())){
            System.out.println("当前连接登录验证完毕，无需再次验证，AuthHandler已移除");
        }else{
            System.out.println("无登录验证，强制关闭连接");
        }
    }
}
