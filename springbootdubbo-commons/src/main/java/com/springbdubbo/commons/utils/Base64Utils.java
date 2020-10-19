package com.springbdubbo.commons.utils;

import java.io.IOException;
import java.util.Base64;

/**
 * Base64加密工具类
 * @author liuyuxuan
 *
 */
public class Base64Utils {

    /**
     * Base64编码(JDK1.8以后才能使用)
     * @param data 要加密的字符数组
     * @return String 加密后的16进制字符串
     */
    public static String encode_JDK18(String data){
        return Base64.getEncoder().encodeToString(data.getBytes());
    }

    /**
     * Base64解码(JDK1.8以后才能使用)
     * @param data 要解密的字符串
     * @return String 解密后的字符串
     * @throws IOException
     */
    public static String  decode_JDK18(String data) throws IOException {
        return new String(Base64.getDecoder().decode(data));
    }
}

