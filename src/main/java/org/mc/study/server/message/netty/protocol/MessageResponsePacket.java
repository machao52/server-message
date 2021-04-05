package org.mc.study.server.message.netty.protocol;

import lombok.Data;

import static org.mc.study.server.message.netty.protocol.Command.MESSAGE_RESPONSE;

/**
 * @author machao
 * @date 2021/04/02
 */

@Data
public class MessageResponsePacket extends Packet {

    private String fromUserId;

    private String fromUsername;

    private String message;

    @Override
    public byte getCommand() {
        return MESSAGE_RESPONSE;
    }
}
