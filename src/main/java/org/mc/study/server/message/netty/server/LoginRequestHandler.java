package org.mc.study.server.message.netty.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.mc.study.server.message.netty.protocol.LoginRequestPacket;
import org.mc.study.server.message.netty.protocol.LoginResponsePacket;
import org.mc.study.server.message.netty.protocol.PacketCode;

/**
 * @author machao
 * @date 2021/4/3
 */
public class LoginRequestHandler extends SimpleChannelInboundHandler<LoginRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginRequestPacket loginRequestPacket) throws Exception {
        LoginResponsePacket loginResponsePacket = new LoginResponsePacket();
        if (valid()) {
            System.out.println(loginRequestPacket.getUsername() + "登陆成功！");
            loginResponsePacket.setSuccess(true);
        }
        ctx.channel().writeAndFlush(loginResponsePacket);
    }

    public boolean valid() {
        return true;
    }
}
