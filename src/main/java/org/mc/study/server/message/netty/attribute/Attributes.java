package org.mc.study.server.message.netty.attribute;

import io.netty.util.AttributeKey;
import org.mc.study.server.message.netty.session.Session;

/**
 * @author machao
 * @date 2021/04/02
 */
public interface Attributes {

    AttributeKey<Session> SESSION = AttributeKey.newInstance("session");

}
