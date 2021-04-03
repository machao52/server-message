package org.mc.study.server.message.netty.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.mc.study.server.message.netty.protocol.PacketCode;

import java.util.List;

/**
 * @author machao
 * @date 2021/4/3
 */
public class PacketDecode extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        list.add(PacketCode.INSTANCE.decode(byteBuf));
    }
}
