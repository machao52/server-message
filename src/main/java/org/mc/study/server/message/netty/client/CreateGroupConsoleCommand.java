package org.mc.study.server.message.netty.client;

import io.netty.channel.Channel;
import org.mc.study.server.message.netty.protocol.CreateGroupRequestPacket;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author machao
 * @date 2021/04/06
 */
public class CreateGroupConsoleCommand implements ConsoleCommand {

    @Override
    public void exec(Scanner scanner, Channel channel) {
        CreateGroupRequestPacket createGroupRequestPacket = new CreateGroupRequestPacket();
        System.out.println("[拉人群聊] 输入userId列表，userId之间用英文逗号隔开：");
        String userIdList = scanner.next();
        createGroupRequestPacket.setUserIdList(Arrays.asList(userIdList.split(",")));
        channel.writeAndFlush(createGroupRequestPacket);
    }
}
