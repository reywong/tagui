package com.reywong.tool.tagui.common.core.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: wangrui
 * Date: 13-10-25
 * Time: 下午2:40
 * To change this template use File | Settings | File Templates.
 */

public class ParamUtils {
    private static final Logger logger = LoggerFactory.getLogger(ParamUtils.class);
    @Autowired
    private ParamInfoMapper paramInfoMapper;

    public static String getDomain() {
        String domain = "";
        ParamInfoService paramInfoService = (ParamInfoService) SpringUtil.getBean("paramInfoService");
        List<ParamInfo> paramInfoList = paramInfoService.getParamInfoByParamTypeId("16");
        if (paramInfoList != null && paramInfoList.size() > 0) {
            for (int i = 0; i < paramInfoList.size(); i++) {
                ParamInfo paramInfo = paramInfoList.get(i);
                String paramkey = paramInfo.getParamkey();
                if (paramkey.equals("domain")) {
                    String paramvalue = paramInfo.getParamvalue();
                    domain = paramvalue.endsWith("/") ? paramvalue.substring(0, paramvalue.length() - 1) : paramvalue;
                }
            }
        }
        //默认值
        if (StringUtils.isBlank(domain)) {
            domain = "localhost";
            logger.error("请填写[其他默认参数-domain]参数，默认设置为" + domain);

        }
        return domain;
    }


    /**
     * 获取角色id
     *
     * @return
     */
    public static String getAdminRoleId() {
        return "1";
    }


    /**
     * 停车场
     *
     * @return
     */
    public static String userParkType() {
        return "2";
    }




    /**
     * 微信APP账号参数
     *
     * @return
     */
    public static WeiXinParam getWeiXinParam() {
        WeiXinParam weiXinParam = new WeiXinParam();
        String appid = "";
        String appsecret = "";
        String mchid = "";
        String unifiedorder = "";
        String notify_url = "";
        String key = "";
        ParamInfoService paramInfoService = (ParamInfoService) SpringUtil.getBean("paramInfoService");
        List<ParamInfo> paramInfoList = paramInfoService.getParamInfoByParamTypeId("4");
        if (paramInfoList != null && paramInfoList.size() > 0) {
            for (int i = 0; i < paramInfoList.size(); i++) {
                ParamInfo paramInfo = paramInfoList.get(i);
                String paramkey = paramInfo.getParamkey();
                if (paramkey.equals("appid")) {
                    appid = paramInfo.getParamvalue();
                } else if (paramkey.equals("appsecret")) {
                    appsecret = paramInfo.getParamvalue();
                } else if (paramkey.equals("mchid")) {
                    mchid = paramInfo.getParamvalue();
                } else if (paramkey.equals("unifiedorder")) {
                    unifiedorder = paramInfo.getParamvalue();
                } else if (paramkey.equals("notify_url")) {
                    notify_url = paramInfo.getParamvalue();
                } else if (paramkey.equals("key")) {
                    key = paramInfo.getParamvalue();
                }
            }
        }


        if (StringUtils.isBlank(appid)) {
            logger.error("请填写[微信支付参数-appid]参数");
        } else if (StringUtils.isBlank(appsecret)) {
            logger.error("请填写[微信支付参数-appsecret]参数");
        } else if (StringUtils.isBlank(mchid)) {
            logger.error("请填写[微信支付参数-mchid]参数");
        } else if (StringUtils.isBlank(unifiedorder)) {
            logger.error("请填写[微信支付参数-unifiedorder]参数");
        } else if (StringUtils.isBlank(notify_url)) {
            logger.error("请填写[微信支付参数-notify_url]参数");
        } else if (StringUtils.isBlank(key)) {
            logger.error("请填写[微信支付参数-key]参数");
        } else {
            weiXinParam.setAppid(appid);
            weiXinParam.setAppsecret(appsecret);
            weiXinParam.setMchid(mchid);
            weiXinParam.setNonce_str(UUID.randomUUID().toString());
            weiXinParam.setUnifiedorder(unifiedorder);
            weiXinParam.setNotify_url(notify_url);
            weiXinParam.setKey(key);
        }
        return weiXinParam;
    }


    /**
     * 微信公众账号账号参数
     *
     * @return
     */
    public static WeiXinParam getWeiXinGZParam() {
        WeiXinParam weiXinParam = new WeiXinParam();
        String appid = "";
        String appsecret = "";
        String mchid = "";
        String unifiedorder = "";
        String notify_url = "";
        String key = "";
        ParamInfoService paramInfoService = (ParamInfoService) SpringUtil.getBean("paramInfoService");
        List<ParamInfo> paramInfoList = paramInfoService.getParamInfoByParamTypeId("5");
        if (paramInfoList != null && paramInfoList.size() > 0) {
            for (int i = 0; i < paramInfoList.size(); i++) {
                ParamInfo paramInfo = paramInfoList.get(i);
                String paramkey = paramInfo.getParamkey();
                if (paramkey.equals("appid")) {
                    appid = paramInfo.getParamvalue();
                } else if (paramkey.equals("appsecret")) {
                    appsecret = paramInfo.getParamvalue();
                } else if (paramkey.equals("mchid")) {
                    mchid = paramInfo.getParamvalue();
                } else if (paramkey.equals("unifiedorder")) {
                    unifiedorder = paramInfo.getParamvalue();
                } else if (paramkey.equals("notify_url")) {
                    notify_url = paramInfo.getParamvalue();
                } else if (paramkey.equals("key")) {
                    key = paramInfo.getParamvalue();
                }
            }
        }


        if (StringUtils.isBlank(appid)) {
            logger.error("请填写[微信公众账号参数-appid]参数");
        } else if (StringUtils.isBlank(appsecret)) {
            logger.error("请填写[微信公众账号参数-appsecret]参数");
        } else if (StringUtils.isBlank(mchid)) {
            logger.error("请填写[微信公众账号参数-mchid]参数");
        } else if (StringUtils.isBlank(unifiedorder)) {
            logger.error("请填写[微信公众账号参数-unifiedorder]参数");
        } else if (StringUtils.isBlank(notify_url)) {
            logger.error("请填写[微信公众账号参数-notify_url]参数");
        } else if (StringUtils.isBlank(key)) {
            logger.error("请填写[微信公众账号参数-key]参数");
        } else {
            weiXinParam.setAppid(appid);
            weiXinParam.setAppsecret(appsecret);
            weiXinParam.setMchid(mchid);
            weiXinParam.setNonce_str(UUID.randomUUID().toString());
            weiXinParam.setUnifiedorder(unifiedorder);
            weiXinParam.setNotify_url(notify_url);
            weiXinParam.setKey(key);
        }
        return weiXinParam;
    }


    /**
     * 支付宝参数
     *
     * @return
     */
    public static AlipayParam getAlipayParam() {
        AlipayParam alipayParam = new AlipayParam();
        String partner = "";
        String appid = "";
        String public_key = "";
        String private_key = "";
        String ali_public_key = "";
        String seller_id = "";
        String sign_type = "";
        String https_verify_url = "";
        String open_api_gateway = "";
        String notify_url = "";
        ParamInfoService paramInfoService = (ParamInfoService) SpringUtil.getBean("paramInfoService");
        List<ParamInfo> paramInfoList = paramInfoService.getParamInfoByParamTypeId("6");
        if (paramInfoList != null && paramInfoList.size() > 0) {
            for (int i = 0; i < paramInfoList.size(); i++) {
                ParamInfo paramInfo = paramInfoList.get(i);
                String paramkey = paramInfo.getParamkey();
                if (paramkey.equals("partner")) {
                    partner = paramInfo.getParamvalue();
                } else if (paramkey.equals("appid")) {
                    appid = paramInfo.getParamvalue();
                } else if (paramkey.equals("public_key")) {
                    public_key = paramInfo.getParamvalue();
                } else if (paramkey.equals("private_key")) {
                    private_key = paramInfo.getParamvalue();
                } else if (paramkey.equals("ali_public_key")) {
                    ali_public_key = paramInfo.getParamvalue();
                } else if (paramkey.equals("seller_id")) {
                    seller_id = paramInfo.getParamvalue();
                } else if (paramkey.equals("sign_type")) {
                    sign_type = paramInfo.getParamvalue();
                } else if (paramkey.equals("https_verify_url")) {
                    https_verify_url = paramInfo.getParamvalue();
                } else if (paramkey.equals("open_api_gateway")) {
                    open_api_gateway = paramInfo.getParamvalue();
                } else if (paramkey.equals("notify_url")) {
                    notify_url = paramInfo.getParamvalue();
                }
            }
        }

        if (StringUtils.isBlank(partner)) {
            logger.error("请填写[支付宝支付参数-partner]参数");
        } else if (StringUtils.isBlank(appid)) {
            logger.error("请填写[支付宝支付参数-appid]参数");
        } else if (StringUtils.isBlank(public_key)) {
            logger.error("请填写[支付宝支付参数-public_key]参数");
        } else if (StringUtils.isBlank(private_key)) {
            logger.error("请填写[支付宝支付参数-private_key]参数");
        } else if (StringUtils.isBlank(ali_public_key)) {
            logger.error("请填写[支付宝支付参数-ali_public_key]参数");
        } else if (StringUtils.isBlank(seller_id)) {
            logger.error("请填写[支付宝支付参数-seller_id]参数");
        } else if (StringUtils.isBlank(sign_type)) {
            logger.error("请填写[支付宝支付参数-sign_type]参数");
        } else if (StringUtils.isBlank(https_verify_url)) {
            logger.error("请填写[支付宝支付参数-https_verify_url]参数");
        } else if (StringUtils.isBlank(open_api_gateway)) {
            logger.error("请填写[支付宝支付参数-open_api_gateway]参数");
        } else if (StringUtils.isBlank(notify_url)) {
            logger.error("请填写[支付宝支付参数-notify_url]参数");
        } else {
            alipayParam.setPartner(partner);
            alipayParam.setAppid(appid);
            alipayParam.setPublic_key(public_key);
            // 商户的私钥
            alipayParam.setPrivate_key(private_key);
            // 字符编码格式 目前支持 gbk 或 utf-8
            alipayParam.setInput_charset("utf-8");
            // 支付宝的公钥，无需修改该值
            alipayParam.setAli_public_key(ali_public_key);
            alipayParam.setSeller_id(seller_id);
            // 签名方式 不需修改
            alipayParam.setSign_type(sign_type);
            alipayParam.setHttps_verify_url(https_verify_url);
            //网关
            alipayParam.setOpen_api_gateway(open_api_gateway);
            //异步通知地址
            alipayParam.setNotify_url(notify_url);
        }
        return alipayParam;
    }

    /**
     * 获取极光推送参数
     *
     * @return
     */
    public static JPushParam getJPushParam() {
        JPushParam jPushParam = new JPushParam();
        String appkey = "";
        String mastersecret = "";
        ParamInfoService paramInfoService = (ParamInfoService) SpringUtil.getBean("paramInfoService");
        List<ParamInfo> paramInfoList = paramInfoService.getParamInfoByParamTypeId("7");
        if (paramInfoList != null && paramInfoList.size() > 0) {
            for (int i = 0; i < paramInfoList.size(); i++) {
                ParamInfo paramInfo = paramInfoList.get(i);
                String paramkey = paramInfo.getParamkey();
                if (paramkey.equals("appkey")) {
                    appkey = paramInfo.getParamvalue();
                } else if (paramkey.equals("mastersecret")) {
                    mastersecret = paramInfo.getParamvalue();
                }
            }
        }


        if (StringUtils.isBlank(appkey)) {
            logger.error("请填写[极光推送参数-appkey]参数");
        } else if (StringUtils.isBlank(mastersecret)) {
            logger.error("请填写[极光推送参数-mastersecret]参数");
        } else {
            jPushParam.setAppKey("ee2b76feca2b1129910cd88b");
            jPushParam.setMasterSecret("c31cb982ca2458f935a38811");
        }

        return jPushParam;
    }


    /**
     * 大鱼短信
     *
     * @return
     */
    public static DaYuSMSParam getDaYuSMSParam() {
        DaYuSMSParam daYuSMSParam = new DaYuSMSParam();
        String url = "";
        String appid = "";
        String appsecret = "";
        String smssign = "";
        String smstemplet = "";
        ParamInfoService paramInfoService = (ParamInfoService) SpringUtil.getBean("paramInfoService");
        List<ParamInfo> paramInfoList = paramInfoService.getParamInfoByParamTypeId("8");
        if (paramInfoList != null && paramInfoList.size() > 0) {
            for (int i = 0; i < paramInfoList.size(); i++) {
                ParamInfo paramInfo = paramInfoList.get(i);
                String paramkey = paramInfo.getParamkey();
                if (paramkey.equals("url")) {
                    url = paramInfo.getParamvalue();
                } else if (paramkey.equals("appid")) {
                    appid = paramInfo.getParamvalue();
                } else if (paramkey.equals("appsecret")) {
                    appsecret = paramInfo.getParamvalue();
                } else if (paramkey.equals("smssign")) {
                    smssign = paramInfo.getParamvalue();
                } else if (paramkey.equals("smstemplet")) {
                    smstemplet = paramInfo.getParamvalue();
                }
            }
        }


        if (StringUtils.isBlank(url)) {
            logger.error("请填写[大鱼短信参数-url]参数");
        } else if (StringUtils.isBlank(appid)) {
            logger.error("请填写[大鱼短信参数-appid]参数");
        } else if (StringUtils.isBlank(appsecret)) {
            logger.error("请填写[大鱼短信参数-appsecret]参数");
        } else if (StringUtils.isBlank(smssign)) {
            logger.error("请填写[大鱼短信参数-smssign]参数");
        } else if (StringUtils.isBlank(smstemplet)) {
            logger.error("请填写[大鱼短信参数-smstemplet]参数");
        } else {
            daYuSMSParam.setUrl(url);
            daYuSMSParam.setAppId(appid);
            daYuSMSParam.setAppSecret(appsecret);
            daYuSMSParam.setSmsSign(smssign);
            daYuSMSParam.setSmsTemplet(smstemplet);
        }

        return daYuSMSParam;
    }


    /**
     * 获取邮箱服务器地址
     *
     * @return
     */
    public static Map<String, String> getEmailParam() {
        Map result = new HashMap();
        String hostname = "";
        String port = "";
        String username = "";
        String password = "";
        String fromemail = "";
        ParamInfoService paramInfoService = (ParamInfoService) SpringUtil.getBean("paramInfoService");
        List<ParamInfo> paramInfoList = paramInfoService.getParamInfoByParamTypeId("9");
        if (paramInfoList != null && paramInfoList.size() > 0) {
            for (int i = 0; i < paramInfoList.size(); i++) {
                ParamInfo paramInfo = paramInfoList.get(i);
                String paramkey = paramInfo.getParamkey();
                if (paramkey.equals("hostname")) {
                    hostname = paramInfo.getParamvalue();
                } else if (paramkey.equals("port")) {
                    port = paramInfo.getParamvalue();
                } else if (paramkey.equals("username")) {
                    username = paramInfo.getParamvalue();
                } else if (paramkey.equals("password")) {
                    password = paramInfo.getParamvalue();
                } else if (paramkey.equals("fromemail")) {
                    fromemail = paramInfo.getParamvalue();
                }
            }
        }


        if (StringUtils.isBlank(hostname)) {
            logger.error("请填写[邮箱服务器参数-hostname]参数");
        } else if (StringUtils.isBlank(port)) {
            logger.error("请填写[邮箱服务器参数-port]参数");
        } else if (StringUtils.isBlank(username)) {
            logger.error("请填写[邮箱服务器参数-username]参数");
        } else if (StringUtils.isBlank(password)) {
            logger.error("请填写[邮箱服务器参数-password]参数");
        } else if (StringUtils.isBlank(fromemail)) {
            logger.error("请填写[邮箱服务器参数-fromemail]参数");
        } else {
            result.put("hostname", hostname);
            result.put("port", port);
            result.put("username", username);
            result.put("password", password);
            result.put("fromemail", fromemail);
        }
        return result;
    }





    /**
     * 获取更新版本信息
     */
    public static Map getVersionInfo(String systemtype, String versionno) {
        Map result = new HashMap();
        String i_versionno = "";
        String i_downloadurl = "";
        String i_versioninfo = "";
        String i_update = "";
        String a_versionno = "";
        String a_downloadurl = "";
        String a_versioninfo = "";
        String a_update = "";
        ParamInfoService paramInfoService = (ParamInfoService) SpringUtil.getBean("paramInfoService");
        List<ParamInfo> paramInfoList = paramInfoService.getParamInfoByParamTypeId("12");
        if (paramInfoList != null && paramInfoList.size() > 0) {
            for (int i = 0; i < paramInfoList.size(); i++) {
                ParamInfo paramInfo = paramInfoList.get(i);
                String paramkey = paramInfo.getParamkey();
                if (paramkey.equals("i_versionno")) {
                    i_versionno = paramInfo.getParamvalue();
                } else if (paramkey.equals("i_downloadurl")) {
                    i_downloadurl = paramInfo.getParamvalue();
                } else if (paramkey.equals("i_versioninfo")) {
                    i_versioninfo = paramInfo.getParamvalue();
                } else if (paramkey.equals("i_update")) {
                    i_update = paramInfo.getParamvalue();
                } else if (paramkey.equals("a_versionno")) {
                    a_versionno = paramInfo.getParamvalue();
                } else if (paramkey.equals("a_downloadurl")) {
                    a_downloadurl = paramInfo.getParamvalue();
                } else if (paramkey.equals("a_versioninfo")) {
                    a_versioninfo = paramInfo.getParamvalue();
                } else if (paramkey.equals("a_update")) {
                    a_update = paramInfo.getParamvalue();
                }
            }
        }


        if (StringUtils.isBlank(i_versionno)) {
            logger.error("请填写[版本升级参数-i_versionno]参数");
        } else if (StringUtils.isBlank(i_downloadurl)) {
            logger.error("请填写[版本升级参数-i_downloadurl]参数");
        } else if (StringUtils.isBlank(i_versioninfo)) {
            logger.error("请填写[版本升级参数-i_versioninfo]参数");
        } else if (StringUtils.isBlank(i_update)) {
            logger.error("请填写[版本升级参数-i_update]参数");
        } else if (StringUtils.isBlank(a_versionno)) {
            logger.error("请填写[版本升级参数-a_versionno]参数");
        } else if (StringUtils.isBlank(a_downloadurl)) {
            logger.error("请填写[版本升级参数-a_downloadurl]参数");
        } else if (StringUtils.isBlank(a_versioninfo)) {
            logger.error("请填写[版本升级参数-a_versioninfo]参数");
        } else if (StringUtils.isBlank(a_update)) {
            logger.error("请填写[版本升级参数-a_update]参数");
        } else {
            if (systemtype.equals("0")) {
                result.put("versionno", i_versionno);
                result.put("downloadurl", i_downloadurl);
                result.put("versioninfo", i_versioninfo);
                if (versionno.equals(i_versionno)) {
                    result.put("update", "0");
                } else {
                    result.put("update", i_update);
                }

            } else {
                result.put("versionno", a_versionno);
                result.put("downloadurl", a_downloadurl);
                result.put("versioninfo", a_versioninfo);
                if (versionno.equals(a_versionno)) {
                    result.put("update", "0");
                } else {
                    result.put("update", a_update);
                }
            }
        }
        return result;
    }


    /**
     * 百度API参数
     *
     * @return
     */
    public static BaiduOpenAPIParam getBaiduMapApi() {
        BaiduOpenAPIParam baiduOpenAPIParam = new BaiduOpenAPIParam();
        String geocding = "";
        String weather = "";
        ParamInfoService paramInfoService = (ParamInfoService) SpringUtil.getBean("paramInfoService");
        List<ParamInfo> paramInfoList = paramInfoService.getParamInfoByParamTypeId("13");
        if (paramInfoList != null && paramInfoList.size() > 0) {
            for (int i = 0; i < paramInfoList.size(); i++) {
                ParamInfo paramInfo = paramInfoList.get(i);
                String paramkey = paramInfo.getParamkey();
                if (paramkey.equals("geocding")) {
                    geocding = paramInfo.getParamvalue();
                } else if (paramkey.equals("weather")) {
                    weather = paramInfo.getParamvalue();
                }
            }
        }


        if (StringUtils.isBlank(geocding)) {
            logger.error("请填写[百度API参数-geocding]参数");
        } else if (StringUtils.isBlank(weather)) {
            logger.error("请填写[百度API参数-weather]参数");
        } else {
            baiduOpenAPIParam.setGeocdingURL(geocding);
            baiduOpenAPIParam.setWeatherURL(weather);
        }
        return baiduOpenAPIParam;
    }


    /**
     * 百度apistore参数
     *
     * @return
     */
    public static BaiduApiStoreParam getBaiduAppStrore() {
        BaiduApiStoreParam baiduApiStoreParam = new BaiduApiStoreParam();
        String apikey = "";
        String oilurl = "";
        ParamInfoService paramInfoService = (ParamInfoService) SpringUtil.getBean("paramInfoService");
        List<ParamInfo> paramInfoList = paramInfoService.getParamInfoByParamTypeId("14");
        if (paramInfoList != null && paramInfoList.size() > 0) {
            for (int i = 0; i < paramInfoList.size(); i++) {
                ParamInfo paramInfo = paramInfoList.get(i);
                String paramkey = paramInfo.getParamkey();
                if (paramkey.equals("apikey")) {
                    apikey = paramInfo.getParamvalue();
                } else if (paramkey.equals("oilurl")) {
                    oilurl = paramInfo.getParamvalue();
                }
            }
        }
        if (StringUtils.isBlank(apikey)) {
            logger.error("请填写[百度apistore参数-apikey]参数");
        } else if (StringUtils.isBlank(oilurl)) {
            logger.error("请填写[百度apistore参数-oilurl]参数");
        } else {
            baiduApiStoreParam.setApikey(apikey);
            baiduApiStoreParam.setOilURL(oilurl);
        }
        return baiduApiStoreParam;
    }


}
