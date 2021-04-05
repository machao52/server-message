package org.mc.study.server.message.netty.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.mc.study.server.message.netty.protocol.LoginRequestPacket;
import org.mc.study.server.message.netty.protocol.LoginResponsePacket;
import org.mc.study.server.message.netty.session.Session;
import org.mc.study.server.message.netty.utils.SessionUtil;

/**
 * @author machao
 * @date 2021/4/3
 */
public class LoginResponseHandler extends SimpleChannelInboundHandler<LoginResponsePacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginResponsePacket loginResponsePacket) throws Exception {
        String userId = loginResponsePacket.getUserId();
        String username = loginResponsePacket.getUsername();
        if (loginResponsePacket.isSuccess()) {
            SessionUtil.bindSession(new Session(userId, username), ctx.channel());
            System.out.println("[" + username + "] 登录成功，userId为：" + userId);
        } else {
            System.out.println("[" + username + "] 登录失败，原因为：" + loginResponsePacket.getReason());
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端连接被关闭");
    }
}
