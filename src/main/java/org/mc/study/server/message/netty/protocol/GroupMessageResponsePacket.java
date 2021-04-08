package org.mc.study.server.message.netty.protocol;

import lombok.Data;

import static org.mc.study.server.message.netty.protocol.Command.GROUP_MESSAGE_RESPONSE;

/**
 * @author machao
 * @date 2021/04/07
 */

@Data
public class GroupMessageResponsePacket extends Packet {

    private String fromGroupId;

    private String fromUser;

    private String message;

    @Override
    public byte getCommand() {
        return GROUP_MESSAGE_RESPONSE;
    }
}
