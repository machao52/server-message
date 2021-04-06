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

    byte LOGOUT_REQUEST = 5;

    byte LOGOUT_RESPONSE = 6;

    byte CREATE_GROUP_REQUEST = 7;

    byte CREATE_GROUP_RESPONSE = 8;

    byte JOIN_GROUP_REQUEST = 9;

    byte JOIN_GROUP_RESPONSE = 10;

    byte QUIT_GROUP_REQUEST = 11;

    byte QUIT_GROUP_RESPONSE = 12;

    byte LIST_GROUP_MEMBERS_REQUEST = 13;

    byte LIST_GROUP_MEMBERS_RESPONSE = 14;

}
