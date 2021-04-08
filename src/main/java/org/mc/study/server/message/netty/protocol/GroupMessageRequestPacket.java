package org.mc.study.server.message.netty.protocol;

import lombok.Data;
import lombok.NoArgsConstructor;

import static org.mc.study.server.message.netty.protocol.Command.GROUP_MESSAGE_REQUEST;

/**
 * @author machao
 * @date 2021/04/07
 */

@Data
@NoArgsConstructor
public class GroupMessageRequestPacket extends Packet {

    private String groupId;

    private String message;

    public GroupMessageRequestPacket(String groupId, String message) {
        this.groupId = groupId;
        this.message = message;
    }

    @Override
    public byte getCommand() {
        return GROUP_MESSAGE_REQUEST;
    }
}
