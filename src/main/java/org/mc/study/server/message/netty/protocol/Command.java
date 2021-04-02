package org.mc.study.server.message.netty.protocol;

/**
 * @author machao
 * @date 2021/03/31
 */
public interface Command {

    byte LOGIN_REQUEST = 1;

    byte LOGIN_RESPONSE = 2;

    byte MESSAGE_REQUEST = 3;

    byte MESSAGE_RESPONSE = 4;


}
