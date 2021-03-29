package com.jedis.demo.connnect;

import com.jedis.demo.protocol.Protocol;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author weiqisheng
 * @Title: Connection
 * @ProjectName Jedis
 * @Description: TODO  jedis的传输层
 * @date 2021/3/2310:55
 */
public class Connection {

    private Socket socket;

    /**
     * redis连接地址
     */
    private String host;
    /**
     * redis的端口号
     */
    private int port;

    private InputStream inputStream;

    private OutputStream outputStream;

    public Connection(String host, int port) {
        this.host = host;
        this.port = port;
    }

    /**
     * 创建连接
     * @return
     */
    //IO复用
    public Connection connection(){
        try {
            if (!isConnect()){
                System.out.println(111);
                socket = new Socket(host,port);
                inputStream = socket.getInputStream();;
                outputStream = socket.getOutputStream();
            }else {
                return this;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    /**
     * 发送数据和命令
     * @param command
     * @param args
     * @return
     */
    public Connection sendCommand(Protocol.Command command, byte[] ... args){
        connection().connection();
        Protocol.sendCommand(outputStream,command,args);
        return this;
    }

    public String backStatus(){
        byte[] bytes = new byte[1024];
        try {
            socket.getInputStream().read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(bytes);
    }

    public boolean isConnect() {
        return socket != null && socket.isBound();
    }
}
