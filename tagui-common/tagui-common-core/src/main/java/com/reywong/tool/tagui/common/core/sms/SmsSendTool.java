package com.reywong.tool.tagui.common.core.sms;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
import com.yxtc.framework.platform.util.ParamUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wangrui on 2016/4/6.
 */
public class SmsSendTool {
    private static final Logger logger = LoggerFactory.getLogger(SmsSendTool.class);


//    public static boolean sendSms(String phoneno, String message) {
//        boolean result = false;
//        String username = ParamUtils.getSmsUser();
//        String password = ParamUtils.getSmsPassword();
//        String url = ParamUtils.getSmsUrl() + "?" + "phone=" + phoneno + "&message=" + message + "&user=" + username + "&pwd=" + password;
//        String requetInfo = null;
//        try {
//            requetInfo = HttpUtil.httpClientGet(url);
//            if (StringUtils.isNotBlank(requetInfo)) {
//                if (requetInfo.split(";")[0].equals("OK")) {
//                    result = true;
//                }
//            }
//        } catch (IOException e) {
//            logger.error(e);
//        }
//
//        return result;
//    }

    /**
     * 发送短信
     *
     * @param phoneno
     * @param message
     * @return
     */
    public static boolean sendSms(String phoneno, String message) {
        boolean result = false;
        String url = ParamUtils.getDaYuSMSParam().getUrl();
        String appid = ParamUtils.getDaYuSMSParam().getAppId();
        String secret = ParamUtils.getDaYuSMSParam().getAppSecret();
        TaobaoClient client = new DefaultTaobaoClient(url, appid, secret);
        AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
        req.setSmsType("normal");
        req.setSmsFreeSignName(ParamUtils.getDaYuSMSParam().getSmsSign());
        req.setSmsParamString("{\"code\":\""+message+"\",\"product\":\"优选停车\"}");
        req.setRecNum(phoneno);
        req.setSmsTemplateCode(ParamUtils.getDaYuSMSParam().getSmsTemplet());
        AlibabaAliqinFcSmsNumSendResponse rsp = null;
        try {
            rsp = client.execute(req);
            String reqInfo = rsp.getBody();
            if (reqInfo.contains("\"success\":true")) {
                result = true;
            }
            logger.debug("[大鱼短信]" + rsp.getBody());
        } catch (ApiException e) {
            logger.error("短信发送错误", e);

        }
        return result;
    }

    public static void main(String[] args) {
        String phoneno="18621116061";
        String message="111111";
        SmsSendTool.sendSms(phoneno,message);
    }

}
