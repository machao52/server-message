package org.mc.study.server.message.netty.protocol;

import lombok.Data;

import java.util.List;

import static org.mc.study.server.message.netty.protocol.Command.LIST_GROUP_MEMBERS_RESPONSE;

/**
 * @author machao
 * @date 2021/04/06
 */

@Data
public class ListGroupMembersResponsePacket extends Packet {

    private boolean success;

    private String reason;

    private String groupId;

    private List<String> usernameList;

    @Override
    public byte getCommand() {
        return LIST_GROUP_MEMBERS_RESPONSE;
    }
}
