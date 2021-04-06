package org.mc.study.server.message.netty.client;

import io.netty.channel.Channel;
import org.mc.study.server.message.netty.protocol.QuitGroupRequestPacket;

import java.util.Scanner;

/**
 * @author machao
 * @date 2021/04/06
 */
public class QuitGroupConsoleCommand implements ConsoleCommand {

    @Override
    public void exec(Scanner scanner, Channel channel) {
        QuitGroupRequestPacket quitGroupRequestPacket = new QuitGroupRequestPacket();

        System.out.println("输入 groupId,退出群聊：");
        String groupId = scanner.next();
        quitGroupRequestPacket.setGroupId(groupId);
        channel.writeAndFlush(quitGroupRequestPacket);
    }


}
