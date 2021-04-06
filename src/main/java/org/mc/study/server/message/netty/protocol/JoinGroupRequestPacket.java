package org.mc.study.server.message.netty.protocol;

import lombok.Data;

import static org.mc.study.server.message.netty.protocol.Command.JOIN_GROUP_REQUEST;

/**
 * @author machao
 * @date 2021/04/06
 */

@Data
public class JoinGroupRequestPacket extends Packet {

    private String groupId;
    
    @Override
    public byte getCommand() {
        return JOIN_GROUP_REQUEST;
    }
}
