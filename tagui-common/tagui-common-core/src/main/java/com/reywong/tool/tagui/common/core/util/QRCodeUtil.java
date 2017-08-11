package com.reywong.tool.tagui.common.core.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Encoder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangrui on 2016/4/26.
 */
public class QRCodeUtil {
    private static final Logger logger = LoggerFactory.getLogger(QRCodeUtil.class);

    /**
     * 将二维码进行base64编码
     *
     * @param content
     * @return
     * @throws WriterException
     * @throws java.io.IOException
     */
    public static String qrCodeTobase64(String content) throws WriterException, IOException {
        String result = "";
        int width = 1280; // 图像宽度
        int height = 1280; // 图像高度
        String format = "png";// 图像类型
        Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content,
                BarcodeFormat.QR_CODE, width, height, hints);// 生成矩阵
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, format, baos);
        byte[] data = baos.toByteArray();
        //对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        result = encoder.encode(data);
        return result;
    }
}
