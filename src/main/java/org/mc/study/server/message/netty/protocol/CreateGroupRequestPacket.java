package org.mc.study.server.message.netty.protocol;

import lombok.Data;

import java.util.List;

import static org.mc.study.server.message.netty.protocol.Command.CREATE_GROUP_REQUEST;

/**
 * @author machao
 * @date 2021/04/06
 */
@Data
public class CreateGroupRequestPacket extends Packet {

    private List<String> userIdList;

    @Override
    public byte getCommand() {
        return CREATE_GROUP_REQUEST;
    }
}
