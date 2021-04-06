package org.mc.study.server.message.netty.client;

import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @author machao
 * @date 2021/04/06
 */
public interface ConsoleCommand {

    /**
     * 执行命令
     *
     * @param scanner
     * @param channel
     */
    void exec(Scanner scanner, Channel channel);

}
