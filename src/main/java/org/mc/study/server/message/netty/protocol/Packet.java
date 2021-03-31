package org.mc.study.server.message.netty.protocol;

import lombok.Data;

/**
 * @author machao
 * @date 2021/03/31
 */

@Data
public abstract class Packet {


    private byte version = 1;

    public abstract byte getCommand();

}
