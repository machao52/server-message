package org.mc.study.server.message.netty.attribute;

import io.netty.util.AttributeKey;

/**
 * @author machao
 * @date 2021/04/02
 */
public interface Attributes {

    AttributeKey<Boolean> LOGIN = AttributeKey.newInstance("login");

}
