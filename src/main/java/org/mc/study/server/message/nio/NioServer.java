package org.mc.study.server.message.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * @author machao
 * @date 2019-12-11
 */
public class NioServer {

    public static void main(String[] args) throws IOException {
        Selector serverSelector = Selector.open();
        Selector clientSelector = Selector.open();

        new Thread(() -> {
            try {
                //对应io编程中服务启动
                ServerSocketChannel listenerChannel = ServerSocketChannel.open();
                listenerChannel.socket().bind(new InetSocketAddress(6000));
                listenerChannel.configureBlocking(false);
                listenerChannel.register(serverSelector, SelectionKey.OP_ACCEPT);
                while (true) {
                    //检测是否有新的连接，这里阻塞时间为1ms
                    if (serverSelector.select(1) > 0) {
                        Set<SelectionKey> set = serverSelector.selectedKeys();
                        Iterator<SelectionKey> keyIterator = set.iterator();
                        while (keyIterator.hasNext()) {
                            SelectionKey selectionKey = keyIterator.next();
                            if (selectionKey.isAcceptable()) {
                                try {
                                    //每来一个新连接，不需要创建一个线程，而是直接注册到clientSelector
                                    SocketChannel socketChannel = ((ServerSocketChannel) selectionKey.channel()).accept();
                                    socketChannel.configureBlocking(false);
                                    socketChannel.register(clientSelector, SelectionKey.OP_READ);
                                } finally {
                                    keyIterator.remove();
                                }
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }).start();

        new Thread(() -> {
            try {
                while (true) {
                    if (clientSelector.select(1) > 0) {
                        Set<SelectionKey> set = clientSelector.selectedKeys();
                        Iterator<SelectionKey> keyIterator = set.iterator();
                        while (keyIterator.hasNext()) {
                            SelectionKey selectionKey = keyIterator.next();
                            if (selectionKey.isReadable()) {
                                try {
                                    SocketChannel clientChannel = (SocketChannel) selectionKey.channel();
                                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                                    clientChannel.read(byteBuffer);
                                    byteBuffer.flip();
                                    System.out.println(Charset.defaultCharset().newDecoder().decode(byteBuffer).toString());
                                } finally {
                                    keyIterator.remove();
                                    selectionKey.interestOps(SelectionKey.OP_READ);
                                }
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }).start();


    }

}
