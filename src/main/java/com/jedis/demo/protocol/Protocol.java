package com.jedis.demo.protocol;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author weiqisheng
 * @Title: Protocol
 * @ProjectName Jedis
 * @Description: TODO  消息协议层
 * @date 2021/3/2311:39
 */
public class Protocol {


    //字符
    public static final String DOLLAR_BYTES = "$";
    //数组
    public static final String ASTERISK_BYTES = "*";
    //空格
    public static final String BACK_BYTES = "\r\n";

    /**
     * 组合命令
     * @param outputStream
     * @param command
     * @param args
     */
    public static void sendCommand(OutputStream outputStream,Command command,byte[] ... args){
        StringBuffer sb = new StringBuffer();
        sb.append(ASTERISK_BYTES).append(args.length + 1).append(BACK_BYTES);
        sb.append(DOLLAR_BYTES).append(command.name().length()).append(BACK_BYTES);
        sb.append(command.name()).append(BACK_BYTES);
        for (final byte[] arg : args){
            sb.append(DOLLAR_BYTES).append(arg.length).append(BACK_BYTES);
            sb.append(new String(arg)).append(BACK_BYTES);
        }
        try {
            outputStream.write(sb.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static enum Command {
        SET,GET
    }
}
