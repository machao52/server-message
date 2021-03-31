package org.mc.study.server.message.netty.serialize;

import org.mc.study.server.message.netty.serialize.impl.JsonSerialize;

/**
 * @author machao
 * @date 2021/03/31
 */
public interface Serializer {

    Serializer DEFAULT = new JsonSerialize();

    /**
     * 获取序列化算法
     *
     * @return
     */
    byte getSerializeAlgorithm();

    /**
     * java对象转成二进制
     *
     * @param object
     * @return
     */
    byte[] serialize(Object object);

    /**
     * 二进制转成java对象
     *
     * @param clazz
     * @param bytes
     * @param <T>
     * @return
     */
    <T> T deSerialize(Class<T> clazz, byte[] bytes);


}
