package com.jedis.demo.listaence;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author weiqisheng
 * @Title: Listense
 * @ProjectName Jedis
 * @Description: TODO
 * @date 2021/3/2314:43
 */
public class Listense {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6379);
        Socket socket = serverSocket.accept();
        byte[] byets = new byte[1024];
        socket.getInputStream().read(byets);
        System.out.println(byets.toString());


    }
}
