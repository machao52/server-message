package org.mc.study.server.message.netty.protocol;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import org.mc.study.server.message.netty.serialize.Serializer;

import java.util.HashMap;
import java.util.Map;

import static org.mc.study.server.message.netty.protocol.Command.*;

/**
 * @author machao
 * @date 2021/03/31
 */
public class PacketCode {

    public static final int MAGIC_NUMBER = 0X12345678;

    public static final PacketCode INSTANCE = new PacketCode();

    private final Map<Byte, Class<? extends Packet>> packetTypeMap;


    public PacketCode() {
        packetTypeMap = new HashMap<>();
        packetTypeMap.put(LOGIN_REQUEST, LoginRequestPacket.class);
        packetTypeMap.put(LOGIN_RESPONSE, LoginResponsePacket.class);
        packetTypeMap.put(MESSAGE_REQUEST, MessageRequestPacket.class);
        packetTypeMap.put(MESSAGE_RESPONSE, MessageResponsePacket.class);
    }

    public ByteBuf encode(ByteBufAllocator byteBufAllocator, Packet packet) {

        //创建buffer对象
        ByteBuf byteBuf = byteBufAllocator.ioBuffer();

        byte[] bytes = Serializer.DEFAULT.serialize(packet);

        byteBuf.writeInt(MAGIC_NUMBER);
        byteBuf.writeByte(packet.getVersion());
        byteBuf.writeByte(Serializer.DEFAULT.getSerializeAlgorithm());
        byteBuf.writeByte(packet.getCommand());
        byteBuf.writeInt(bytes.length);
        byteBuf.writeBytes(bytes);
        return byteBuf;
    }


    public Packet decode(ByteBuf byteBuf) {

        //跳过魔数
        byteBuf.skipBytes(4);

        //跳过版本号
        byteBuf.skipBytes(1);

        //序列化算法
        byte serializeAlgorithm = byteBuf.readByte();

        //指令
        byte command = byteBuf.readByte();

        //数据长度
        int length = byteBuf.readInt();

        byte[] bytes = new byte[length];

        byteBuf.readBytes(bytes);

        Class<? extends Packet> requestType = getRequestType(command);

        if (requestType != null) {
            return Serializer.DEFAULT.deSerialize(requestType, bytes);
        }

        return null;

    }

    public Class<? extends Packet> getRequestType(byte command) {
        return packetTypeMap.get(command);
    }

}
