package org.mc.study.server.message.netty.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.mc.study.server.message.netty.protocol.LoginRequestPacket;
import org.mc.study.server.message.netty.protocol.LoginResponsePacket;
import org.mc.study.server.message.netty.protocol.MessageRequestPacket;
import org.mc.study.server.message.netty.protocol.Packet;
import org.mc.study.server.message.netty.utils.LoginUtil;

/**
 * @author machao
 * @date 2021/4/3
 */
public class LoginResponseHandler extends SimpleChannelInboundHandler<LoginResponsePacket> {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端连接成功，开始登陆。。。");
        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();
        loginRequestPacket.setUserId("A888999");
        loginRequestPacket.setUsername("machao");
        loginRequestPacket.setPassword("123456");
        ctx.channel().writeAndFlush(loginRequestPacket);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginResponsePacket loginResponsePacket) throws Exception {
        if (loginResponsePacket.isSuccess()) {
            System.out.println("客户端登录成功！");
            LoginUtil.markAsLogin(ctx.channel());
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端连接被关闭");
    }
}
