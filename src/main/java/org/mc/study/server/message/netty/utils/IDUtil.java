package org.mc.study.server.message.netty.utils;

import java.util.UUID;

/**
 * @author machao
 * @date 2021/04/06
 */
public class IDUtil {

    public static String randomId() {
        return UUID.randomUUID().toString().split("-")[0];
    }

}
