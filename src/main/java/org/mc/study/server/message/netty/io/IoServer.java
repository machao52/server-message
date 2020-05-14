package org.mc.study.server.message.netty.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * @author machao
 * @date 2019-12-11
 */
public class IoServer {

    private static int n = 0;

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(6000);
        System.out.println("服务端初始化成功");
        //new Thread(() -> {
            while (true) {
                System.out.println("标志1 " + n);
                Socket socket = serverSocket.accept();
                new Thread(() -> {
                    try {
                        System.out.println("标志2");
                        InputStream inputStream = socket.getInputStream();
                        int len;
                        byte[] data = new byte[1024];
                        while ((len = inputStream.read(data)) != -1) {
                            String str = new String(data, 0, len);
                            System.out.println(str);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();

            }
        //}).start();


    }

}
