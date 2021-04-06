package org.mc.study.server.message.netty.client;

import io.netty.channel.Channel;
import org.mc.study.server.message.netty.protocol.ListGroupMembersRequestPacket;

import java.util.Scanner;

/**
 * @author machao
 * @date 2021/04/06
 */
public class ListGroupMembersConsoleCommand implements ConsoleCommand {

    @Override
    public void exec(Scanner scanner, Channel channel) {
        ListGroupMembersRequestPacket listGroupMembersRequestPacket = new ListGroupMembersRequestPacket();
        System.out.println("输入 groupId，获取群成员列表：");
        String groupId = scanner.next();
        listGroupMembersRequestPacket.setGroupId(groupId);
        channel.writeAndFlush(listGroupMembersRequestPacket);
    }

}
