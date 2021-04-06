package org.mc.study.server.message.netty.protocol;

import lombok.Data;

import java.util.List;

import static org.mc.study.server.message.netty.protocol.Command.CREATE_GROUP_RESPONSE;

/**
 * @author machao
 * @date 2021/04/06
 */

@Data
public class CreateGroupResponsePacket extends Packet {

    private boolean success;

    private String groupId;

    private List<String> usernameList;

    @Override
    public byte getCommand() {
        return CREATE_GROUP_RESPONSE;
    }

}
