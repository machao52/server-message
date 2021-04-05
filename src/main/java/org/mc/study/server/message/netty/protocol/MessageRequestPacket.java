package org.mc.study.server.message.netty.protocol;

import lombok.Data;
import lombok.NoArgsConstructor;

import static org.mc.study.server.message.netty.protocol.Command.MESSAGE_REQUEST;

/**
 * @author machao
 * @date 2021/04/02
 */

@Data
@NoArgsConstructor
public class MessageRequestPacket extends Packet {

    private String toUserId;

    private String message;

    public MessageRequestPacket(String toUserId, String message) {
        this.toUserId = toUserId;
        this.message = message;
    }

    @Override
    public byte getCommand() {
        return MESSAGE_REQUEST;
    }
}
