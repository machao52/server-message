package org.mc.study.server.message.netty.protocol;

import lombok.Data;

import static org.mc.study.server.message.netty.protocol.Command.QUIT_GROUP_RESPONSE;

/**
 * @author machao
 * @date 2021/04/06
 */

@Data
public class QuitGroupResponsePacket extends Packet {

    private String groupId;

    private boolean success;

    private String reason;

    @Override
    public byte getCommand() {
        return QUIT_GROUP_RESPONSE;
    }
}
