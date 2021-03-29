package com.jedis.demo.client;


import com.jedis.demo.connnect.Connection;
import com.jedis.demo.protocol.Protocol;

/**
 * @author weiqisheng
 * @Title: Clinet
 * @ProjectName Jedis
 * @Description: TODO
 * @date 2021/3/2311:39
 */
public class Clinet {

    Connection connection;

    public Clinet(String host,int port){
        this.connection = new Connection(host, port);
    }

    public String set(String key,String value){
        connection.sendCommand(Protocol.Command.SET,key.getBytes(),value.getBytes());
        return connection.backStatus();
    }

    public String get(String key){
        connection.sendCommand(Protocol.Command.GET,key.getBytes());
        return connection.backStatus();
    }
}
