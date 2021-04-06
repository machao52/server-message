package org.mc.study.server.message.netty.client;

import io.netty.channel.Channel;
import org.mc.study.server.message.netty.protocol.LoginRequestPacket;

import java.util.Scanner;

/**
 * @author machao
 * @date 2021/04/06
 */
public class LoginConsoleCommand implements ConsoleCommand {

    @Override
    public void exec(Scanner scanner, Channel channel) {
        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();
        System.out.print("请输入用户名：");
        loginRequestPacket.setUsername(scanner.nextLine());
        loginRequestPacket.setPassword("pwd");
        channel.writeAndFlush(loginRequestPacket);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
