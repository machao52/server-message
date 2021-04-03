package org.mc.study.server.message.netty.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.mc.study.server.message.netty.protocol.Packet;
import org.mc.study.server.message.netty.protocol.PacketCode;

/**
 * @author machao
 * @date 2021/4/3
 */
public class PacketEncode extends MessageToByteEncoder<Packet> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Packet packet, ByteBuf byteBuf) throws Exception {
        PacketCode.INSTANCE.encode(byteBuf, packet);
    }
}
