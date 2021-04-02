package org.mc.study.server.message.netty.protocol;

import lombok.Data;

import static org.mc.study.server.message.netty.protocol.Command.MESSAGE_REQUEST;

/**
 * @author machao
 * @date 2021/04/02
 */

@Data
public class MessageRequestPacket extends Packet {

    private String message;

    @Override
    public byte getCommand() {
        return MESSAGE_REQUEST;
    }
}
