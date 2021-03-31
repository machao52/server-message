package org.mc.study.server.message.netty;

import com.alibaba.fastjson.JSON;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.mc.study.server.message.netty.protocol.LoginRequestPacket;
import org.mc.study.server.message.netty.protocol.LoginResponsePacket;
import org.mc.study.server.message.netty.protocol.Packet;
import org.mc.study.server.message.netty.protocol.PacketCode;

/**
 * @author machao
 * @date 2021/03/31
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        Packet packet = PacketCode.INSTANCE.decode(byteBuf);

        if (packet instanceof LoginRequestPacket) {
            LoginRequestPacket loginRequestPacket = (LoginRequestPacket) packet;
            LoginResponsePacket loginResponsePacket = new LoginResponsePacket();
            if (valid()) {
                System.out.println(loginRequestPacket.getUsername() + "登陆成功！");
                loginResponsePacket.setSuccess(true);
            }
            ByteBuf buffer = PacketCode.INSTANCE.encode(ctx.alloc(), loginResponsePacket);
            ctx.channel().writeAndFlush(buffer);
        }
    }

    public boolean valid() {
        return true;
    }
}
