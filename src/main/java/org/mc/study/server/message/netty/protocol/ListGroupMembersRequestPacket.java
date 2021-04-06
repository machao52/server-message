package org.mc.study.server.message.netty.protocol;

import lombok.Data;

import static org.mc.study.server.message.netty.protocol.Command.LIST_GROUP_MEMBERS_REQUEST;

/**
 * @author machao
 * @date 2021/04/06
 */

@Data
public class ListGroupMembersRequestPacket extends Packet {

    private String groupId;

    @Override
    public byte getCommand() {
        return LIST_GROUP_MEMBERS_REQUEST;
    }
}
