package org.mc.study.server.message.netty.byteBuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

import java.util.Arrays;

/**
 * @author machao
 * @date 2021/03/30
 */
public class ByteBufTest {

    public static void main(String[] args) {
        ByteBuf buffer = ByteBufAllocator.DEFAULT.buffer(9, 100);
        print("buffer(80, 100)", buffer);

        buffer.writeBytes(new byte[]{1, 2, 3, 4});
        print("writeBytes(new byte[]{1, 2, 3, 4})", buffer);

        buffer.writeInt(12);
        print("writeInt(12)", buffer);

        //write 方法改变写指针, 写完之后写指针等于 capacity 的时候，buffer 不可写
        buffer.writeBytes(new byte[]{8});
        print("writeBytes(new byte[]{8})", buffer);

        //write 方法改变写指针，写的时候发现buffer不可写则开始扩容，扩容之后capacity随机改变
        buffer.writeBytes(new byte[]{90});
        print("writeBytes(new byte[]{90})", buffer);

        //get不改变读写指针
        System.out.println("getByte(3) 返回：" + buffer.getByte(0));
        System.out.println("getShort(3) 返回：" + buffer.getShort(0));
        System.out.println("getInt(3) 返回：" + buffer.getInt(0));
        print("getByte()", buffer);

        //set不改变读写指针
        buffer.setByte(buffer.readableBytes() + 1, 4);
        print("setByte()", buffer);

        byte[] dsg = new byte[4];
        buffer.readBytes(dsg);
        System.out.println("readBytes(4) 返回：" + Arrays.toString(dsg));
        print("readBytes(4)", buffer);

    }

    private static void print(String action, ByteBuf buffer) {
        System.out.println("after==========" + action + "==========");
        System.out.println("capacity(): " + buffer.capacity());
        System.out.println("maxCapacity(): " + buffer.maxCapacity());
        System.out.println("readerIndex(): " + buffer.readerIndex());
        System.out.println("readableBytes(): " + buffer.readableBytes());
        System.out.println("isReadable(): " + buffer.isReadable());
        System.out.println("writerIndex(): " + buffer.writerIndex());
        System.out.println("writableBytes(): " + buffer.writableBytes());
        System.out.println("isWritable(): " + buffer.isWritable());
        System.out.println("maxWritableBytes(): " + buffer.maxWritableBytes());
        System.out.println();
    }

}
