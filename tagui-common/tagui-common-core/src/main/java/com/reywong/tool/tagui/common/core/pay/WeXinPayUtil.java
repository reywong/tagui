package com.reywong.tool.tagui.common.core.pay;

import com.yxtc.framework.platform.util.HttpUtil;
import com.yxtc.framework.platform.util.ParamUtils;
import com.yxtc.framework.platform.util.StringUtils;
import com.yxtc.framework.platform.util.XmlUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.*;

/**
 * Created by wangrui on 2016/4/13.
 */
public class WeXinPayUtil {
    private static final Logger logger = LoggerFactory.getLogger(WeXinPayUtil.class);

    public static void main(String[] args) {
        String trade_type = "NATIVE";
        String body = "扫码订单";
        int total_fee = 100;
        String out_trade_no = "CODE000001";
        String spbill_create_ip = "192.168.1.1";
        Map test = WeXinPayUtil.createQRCodePayInfo(trade_type, body, total_fee, out_trade_no, spbill_create_ip);

        System.out.println("=========================================");
    }

    /**
     * 微信支付统一下单接口
     *
     * @param trade_type       交易类型
     * @param body             订单名称
     * @param total_fee        订单费用
     * @param out_trade_no     订单编号
     * @param spbill_create_ip 客户端ip
     * @return
     */
    public static Map createPayInfo(String trade_type, String body, int total_fee, String out_trade_no, String spbill_create_ip) {
        SortedMap<Object, Object> map = new TreeMap<Object, Object>();
        map.put("appid", ParamUtils.getWeiXinParam().getAppid());
        map.put("mch_id", ParamUtils.getWeiXinParam().getMchid());
        map.put("nonce_str", StringUtils.getRandomStr(32));
        map.put("body", body);
        if (out_trade_no != null && out_trade_no.startsWith("CZ")) {
            map.put("out_trade_no", out_trade_no);
        } else {
            map.put("out_trade_no", out_trade_no + "_" + System.currentTimeMillis());
        }
        map.put("total_fee", total_fee);
        map.put("spbill_create_ip", spbill_create_ip);
        map.put("notify_url", ParamUtils.getWeiXinParam().getNotify_url());
        map.put("trade_type", trade_type);
        String key = createSign(map);
        map.put("sign", key);
        String xml = XmlUtil.mapToXml(map);
        logger.info("[开始]调用微信统一支付接口，参数" + xml);
        String returnXml = null;
        try {
            returnXml = HttpUtil.httpsRequest(ParamUtils.getWeiXinParam().getUnifiedorder(), "POST", xml);
        } catch (NoSuchAlgorithmException e) {
            logger.error("请求异常", e);
        } catch (NoSuchProviderException e) {
            logger.error("请求异常", e);
        } catch (KeyManagementException e) {
            logger.error("请求异常", e);
        } catch (IOException e) {
            logger.error("请求异常", e);
        }
        logger.info("[结束]调用微信统一支付接口，返回" + returnXml);
        //获取返回APP所需参数
        Map requestMap = XmlUtil.xmlToMap(returnXml);
        return requestMap;
    }

    /**
     * 公众账号扫码支付
     *
     * @param trade_type
     * @param body
     * @param total_fee
     * @param out_trade_no
     * @param spbill_create_ip
     * @return
     */
    public static Map createQRCodePayInfo(String trade_type, String body, int total_fee, String out_trade_no, String spbill_create_ip) {
        SortedMap<Object, Object> map = new TreeMap<Object, Object>();
        map.put("appid", ParamUtils.getWeiXinGZParam().getAppid());
        map.put("mch_id", ParamUtils.getWeiXinGZParam().getMchid());
        map.put("nonce_str", StringUtils.getRandomStr(32));
        map.put("body", body);
        if (out_trade_no != null && out_trade_no.startsWith("CZ")) {
            map.put("out_trade_no", out_trade_no);
        } else {
            map.put("out_trade_no", out_trade_no + "_" + System.currentTimeMillis());
        }
        map.put("total_fee", total_fee);
        map.put("spbill_create_ip", spbill_create_ip);
        map.put("notify_url", ParamUtils.getWeiXinGZParam().getNotify_url());
        map.put("trade_type", trade_type);
        String key = createGZSign(map);
        map.put("sign", key);
        String xml = XmlUtil.mapToXml(map);
        logger.info("[开始]调用微信统一支付接口，参数" + xml);
        String returnXml = null;
        try {
            returnXml = HttpUtil.httpsRequest(ParamUtils.getWeiXinGZParam().getUnifiedorder(), "POST", xml);
        } catch (NoSuchAlgorithmException e) {
            logger.error("请求异常", e);
        } catch (NoSuchProviderException e) {
            logger.error("请求异常", e);
        } catch (KeyManagementException e) {
            logger.error("请求异常", e);
        } catch (IOException e) {
            logger.error("请求异常", e);
        }
        logger.info("[结束]调用微信统一支付接口，返回" + returnXml);
        //获取返回APP所需参数
        Map requestMap = XmlUtil.xmlToMap(returnXml);
        return requestMap;
    }

    /**
     * 微信公众账号签名
     *
     * @param parameters
     * @return
     */
    public static String createGZSign(SortedMap<Object, Object> parameters) {
        StringBuffer sb = new StringBuffer();
        Set es = parameters.entrySet();//所有参与传参的参数按照accsii排序（升序）
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            Object v = entry.getValue();
            if (null != v && !"".equals(v) && !"sign".equals(k) && !"key".equals(k)) {
                sb.append(k + "=" + v + "&");
            }
        }
        sb.append("key=" + ParamUtils.getWeiXinGZParam().getKey());
        String characterEncoding = "UTF-8";
        String sign = MD5Encode(sb.toString(), characterEncoding).toUpperCase();
        return sign;
    }

    /**
     * 校验签名
     *
     * @param sign
     * @param map
     * @return
     */
    public static boolean checkSign(String sign, Map map) {
        boolean result = false;
        SortedMap sortedMap = new TreeMap();
        if (map instanceof Map) {
            Set set = map.keySet();
            Iterator it = set.iterator();
            for (; it.hasNext(); ) {
                String key = (String) it.next();
                sortedMap.put(key, map.get(key));
            }
        }
        String signKey = createSign(sortedMap);
        if (sign.equals(signKey)) {
            result = true;
        }
        return result;
    }

    /**
     * 时间戳
     *
     * @return
     */
    public static String createTimestamp() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }

    /**
     * 微信支付签名算法sign
     *
     * @param parameters
     * @return
     */
    public static String createSign(SortedMap<Object, Object> parameters) {
        StringBuffer sb = new StringBuffer();
        Set es = parameters.entrySet();//所有参与传参的参数按照accsii排序（升序）
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            Object v = entry.getValue();
            if (null != v && !"".equals(v) && !"sign".equals(k) && !"key".equals(k)) {
                sb.append(k + "=" + v + "&");
            }
        }
        sb.append("key=" + ParamUtils.getWeiXinParam().getKey());
        String characterEncoding = "UTF-8";
        String sign = MD5Encode(sb.toString(), characterEncoding).toUpperCase();
        return sign;
    }

    private static String byteArrayToHexString(byte b[]) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++)
            resultSb.append(byteToHexString(b[i]));

        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n += 256;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    public static String MD5Encode(String origin, String charsetname) {
        String resultString = null;
        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (charsetname == null || "".equals(charsetname))
                resultString = byteArrayToHexString(md.digest(resultString
                        .getBytes()));
            else
                resultString = byteArrayToHexString(md.digest(resultString
                        .getBytes(charsetname)));
        } catch (Exception exception) {
        }
        return resultString;
    }

    private static final String hexDigits[] = {"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};


}
