package com.reywong.tool.tagui.common.core.util;

/**
 *
 * File Desc:
 *
 * Product AB:   优选停车
 *
 * Module Name:
 *
 * Author:       wangrui
 *
 * Create:       13-7-12-上午10:42
 *
 * History:      13-7-12-上午10:42 modify  by  wangrui
 */

import com.yxtc.framework.platform.pojo.AppResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Map;
import java.util.Random;

public class StringUtils {
    private static final Logger logger = LoggerFactory.getLogger(StringUtils.class);

    /**
     * 判断字符串是否不为空或空字符串
     *
     * @param str 字符串
     * @return
     */
    public static boolean isNotBlank(Object str) {
        boolean result = false;
        if (str != null && !"".equals(str)) {
            result = true;
        }
        return result;
    }

    /**
     * 判断字符串是否为空或空字符串
     *
     * @param str 字符串
     * @return
     */
    public static boolean isBlank(Object str) {
        boolean result = false;
        if (str == null || "".equals(str)) {
            result = true;
        }
        return result;
    }


    /**
     * MD5加密
     *
     * @param key 要加密的值
     * @return
     */
    public static String encryptMD5(String key) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(key.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    buf.append("0");
                }

                buf.append(Integer.toHexString(i));
            }
            result = buf.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * MD5加密
     *
     * @param key  要加密的值
     * @param type 16 位或 32 位
     * @return
     */
    public static String encryptMD5(String key, String type) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(key.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    buf.append("0");
                }

                buf.append(Integer.toHexString(i));
            }
            if (isBlank(type)) {
                type = "32";
            }
            if (type.equals("16")) {
                result = buf.toString().substring(8, 24);

            } else {
                result = buf.toString();
            }

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 将数组转化成"|"分隔的字符串
     *
     * @param datas 字符串数组
     * @return
     */
    public static String stringsToString(String[] datas) {
        String result = "";
        if (datas != null && datas.length > 0) {
            StringBuffer sb = new StringBuffer();
            int t = datas.length;
            for (int i = 0; i < t; i++) {
                if (i != t - 1) {
                    sb.append(datas[i] + "|");
                } else {
                    sb.append(datas[i]);
                }
            }
            result = sb.toString();
        }
        return result;
    }

    /**
     * base 64 encode
     *
     * @param bytes 待编码的byte[]
     * @return 编码后的base 64 code
     */
    public static String base64Encode(byte[] bytes) {
        return new BASE64Encoder().encode(bytes);
    }

    /**
     * base 64 decode
     *
     * @param base64Code 待解码的base 64 code
     * @return 解码后的byte[]
     * @throws Exception
     */
    public static byte[] base64Decode(String base64Code) throws Exception {
        return StringUtils.isBlank(base64Code) ? null : new BASE64Decoder().decodeBuffer(base64Code);
    }

    /**
     * AES加密
     *
     * @param content    待加密的内容
     * @param encryptKey 加密密钥
     * @return 加密后的byte[]
     * @throws Exception
     */
    public static byte[] aesEncryptToBytes(String content, String encryptKey) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128, new SecureRandom(encryptKey.getBytes()));

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(kgen.generateKey().getEncoded(), "AES"));

        return cipher.doFinal(content.getBytes("utf-8"));
    }

    /**
     * AES加密为base 64 code
     *
     * @param content    待加密的内容
     * @param encryptKey 加密密钥
     * @return 加密后的base 64 code
     * @throws Exception
     */
    public static String aesEncrypt(String content, String encryptKey) throws Exception {
        return base64Encode(aesEncryptToBytes(content, encryptKey));
    }

    /**
     * AES解密
     *
     * @param encryptBytes 待解密的byte[]
     * @param decryptKey   解密密钥
     * @return 解密后的String
     * @throws Exception
     */
    public static String aesDecryptByBytes(byte[] encryptBytes, String decryptKey) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128, new SecureRandom(decryptKey.getBytes()));

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(kgen.generateKey().getEncoded(), "AES"));
        byte[] decryptBytes = cipher.doFinal(encryptBytes);

        return new String(decryptBytes, "UTF-8");
    }

    /**
     * 将base 64 code AES解密
     *
     * @param encryptStr 待解密的base 64 code
     * @param decryptKey 解密密钥
     * @return 解密后的string
     * @throws Exception
     */
    public static String aesDecrypt(String encryptStr, String decryptKey) throws Exception {
        return StringUtils.isBlank(encryptStr) ? null : aesDecryptByBytes(base64Decode(encryptStr), decryptKey);
    }


    /**
     * 获取随机数
     *
     * @param length
     * @return
     */
    public static String getRandomStr(int length) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        int max = 9;
        int min = 1;
        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(max - min + 1) + min);
        }
        return sb.toString();
    }


    /**
     * 获随机数
     *
     * @param length
     * @param min
     * @param max
     * @return
     */
    public static String getRandomStr(int length, int min, int max) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(max - min + 1) + min);
        }
        return sb.toString();
    }

    /**
     * 解密返回值
     *
     * @param returnInfo
     * @param decodeKey
     * @return
     */
    public static AppResult decrypeReturnData(String returnInfo, String decodeKey) {
        AppResult result = new AppResult();
        Map temp = DataTypeChangeTool.jsonToMap(returnInfo);
        boolean success = (Boolean) temp.get("success");
        String msg = (String) temp.get("msg");
        String datas = (String) temp.get("datas");
        try {
            if (StringUtils.isNotBlank(datas)) {
                String dedatas = AESOperator.decrypt(datas, decodeKey);
                if (dedatas.contains("[")) {
                    result.setDatas(DataTypeChangeTool.jsonToList(dedatas));
                } else {
                    result.setDatas(DataTypeChangeTool.jsonToMap(dedatas));
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        result.setSuccess(success);
        result.setMsg(msg);
        return result;
    }


    /**
     * 解密返回值
     *
     * @param returnInfo
     * @param decodeKey
     * @return
     */
    public static String decrypeReturnStr(String returnInfo, String decodeKey) {
        AppResult result = decrypeReturnData(returnInfo, decodeKey);
        return DataTypeChangeTool.beanToJSON(result);
    }

}