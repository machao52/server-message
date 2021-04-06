package org.mc.study.server.message.netty.protocol;

import lombok.Data;
import lombok.NoArgsConstructor;

import static org.mc.study.server.message.netty.protocol.Command.MESSAGE_REQUEST;

/**
 * @author machao
 * @date 2021/04/02
 */

@Data
public class MessageRequestPacket extends Packet {

    private String toUserId;

    private String message;

    /**
     * 必须要有这无参构造函数
     */
    public MessageRequestPacket() {
    }

    public MessageRequestPacket(String toUserId, String message) {
        this.toUserId = toUserId;
        this.message = message;
    }

    @Override
    public byte getCommand() {
        return MESSAGE_REQUEST;
    }
}
