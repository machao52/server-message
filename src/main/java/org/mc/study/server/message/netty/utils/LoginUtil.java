package org.mc.study.server.message.netty.utils;

import io.netty.channel.Channel;
import io.netty.util.Attribute;
import org.mc.study.server.message.netty.attribute.Attributes;

/**
 * @author machao
 * @date 2021/04/02
 */
public class LoginUtil {

    public static void markAsLogin(Channel channel) {
        channel.attr(Attributes.LOGIN).set(true);
    }

    public static boolean hasLogin(Channel channel) {
        Attribute<Boolean> loginAttr = channel.attr(Attributes.LOGIN);
        return loginAttr.get() != null;
    }

}
