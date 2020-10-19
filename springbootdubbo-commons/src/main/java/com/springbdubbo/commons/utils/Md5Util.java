package com.springbdubbo.commons.utils;

import org.springframework.util.DigestUtils;

import java.io.Serializable;

/**
 * 加密类
 * @author liuyuxuan
 *
 */
public class Md5Util implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 加密方法
     * @param str
     * @return
     */
    public static String  getEncryption(String str){

        return  DigestUtils.md5DigestAsHex(str.getBytes());
    }

    public static void main(String[] args) {
        System.out.println(Md5Util.getEncryption("123456"));
    }


}
