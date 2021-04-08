package org.mc.study.server.message.netty.protocol;

import static org.mc.study.server.message.netty.protocol.Command.HEARTBEAT_REQUEST;

/**
 * @author machao
 * @date 2021/04/08
 */
public class HeartbeatRequestPacket extends Packet {
    @Override
    public byte getCommand() {
        return HEARTBEAT_REQUEST;
    }
}
