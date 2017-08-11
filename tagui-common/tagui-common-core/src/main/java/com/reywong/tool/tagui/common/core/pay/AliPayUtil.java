package com.reywong.tool.tagui.common.core.pay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.yxtc.framework.platform.util.DataTypeChangeTool;
import com.yxtc.framework.platform.util.ParamUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangrui on 2016/4/15.
 */
public class AliPayUtil {
    private static final Logger logger = LoggerFactory.getLogger(AliPayUtil.class);

    /**
     * 返回支付宝支付参数
     *
     * @param body
     * @param total_fee
     * @param out_trade_no
     * @return
     */
    public static Map createPayInfo(String body, int total_fee, String out_trade_no) {
        Map result = new HashMap();
        result.put("partner", ParamUtils.getAlipayParam().getPartner());
        result.put("seller_id", ParamUtils.getAlipayParam().getSeller_id());
        if (out_trade_no != null && out_trade_no.startsWith("CZ")) {
            result.put("out_trade_no", out_trade_no);
        } else {
            result.put("out_trade_no", out_trade_no + "_" + System.currentTimeMillis());
        }

        result.put("subject", "优选停车消费");
        result.put("body", body);
        DecimalFormat df = new DecimalFormat("######0.00");
        result.put("total_fee", df.format(total_fee / 100.0));
        result.put("notify_url", ParamUtils.getAlipayParam().getNotify_url());
        result.put("service", "mobile.securitypay.pay");
        result.put("payment_type", "1");
        result.put("private_key", ParamUtils.getAlipayParam().getPrivate_key());
        result.put("_input_charset", ParamUtils.getAlipayParam().getInput_charset());
        return result;
    }


    /**
     * 支付宝扫码支付
     *
     * @param body
     * @param total_fee
     * @param out_trade_no
     * @return
     */
    public static String createQRCodePayInfo(String body, int total_fee, String out_trade_no) {
        String qrcodeResult = "";
        String subject = "优选停车";
        DecimalFormat df = new DecimalFormat("######0.00");
        String totalAmount = df.format(total_fee / 100.0);
        Map map = new HashMap();
        map.put("out_trade_no", out_trade_no + "_" + System.currentTimeMillis());
        map.put("total_amount", Float.valueOf(totalAmount));
        map.put("subject", body);
        map.put("body", body);
        AlipayClient client = new DefaultAlipayClient(ParamUtils.getAlipayParam().getOpen_api_gateway(), ParamUtils.getAlipayParam().getAppid(), ParamUtils.getAlipayParam().getPrivate_key(), "json", "utf-8", ParamUtils.getAlipayParam().getPublic_key());

        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
        request.setNotifyUrl(ParamUtils.getAlipayParam().getNotify_url());
        request.setBizContent(DataTypeChangeTool.mapToJson(map));
        try {
            AlipayTradePrecreateResponse response = client.execute(request);
            if (response.isSuccess()) {
                qrcodeResult = response.getQrCode();
            }
        } catch (AlipayApiException e) {
            logger.error("调用支付宝失败", e);
        }
        return qrcodeResult;
    }
}
