package org.mc.study.server.message.netty.client;

import io.netty.channel.Channel;
import org.mc.study.server.message.netty.protocol.JoinGroupRequestPacket;

import java.util.Scanner;

/**
 * @author machao
 * @date 2021/04/06
 */
public class JoinGroupConsoleCommand implements ConsoleCommand {

    @Override
    public void exec(Scanner scanner, Channel channel) {
        JoinGroupRequestPacket joinGroupRequestPacket = new JoinGroupRequestPacket();
        System.out.print("输入 groupId，加入群聊：");
        String groupId = scanner.next();
        joinGroupRequestPacket.setGroupId(groupId);
        channel.writeAndFlush(joinGroupRequestPacket);
    }

}
