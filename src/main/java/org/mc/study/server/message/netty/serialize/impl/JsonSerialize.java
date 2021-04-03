package org.mc.study.server.message.netty.serialize.impl;


import com.alibaba.fastjson.JSON;
import org.mc.study.server.message.netty.serialize.Serializer;
import org.mc.study.server.message.netty.serialize.SerializerAlgorithm;

/**
 * @author machao
 * @date 2021/03/31
 */
public class JsonSerialize implements Serializer {

    @Override
    public byte getSerializeAlgorithm() {
        return SerializerAlgorithm.JSON;
    }

    @Override
    public byte[] serialize(Object object) {
        return JSON.toJSONBytes(object);
    }

    @Override
    public <T> T deSerialize(Class<T> clazz, byte[] bytes) {
        return JSON.parseObject(bytes, clazz);
    }


}
