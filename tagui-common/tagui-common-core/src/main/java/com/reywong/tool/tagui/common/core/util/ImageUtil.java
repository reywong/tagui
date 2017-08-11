package com.reywong.tool.tagui.common.core.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: yangweiwei
 * Date: 16-3-30
 * Time: 下午10:32
 * To change this template use File | Settings | File Templates.
 */
public class ImageUtil {
    private static Logger logger = LoggerFactory.getLogger(ImageUtil.class);

    /**
     * 按图片流文件生成图片
     *
     * @param path           图片路径
     * @param streamFileData BASE64 加密图片
     * @param imageName      生成图片名称
     * @param parkId         停车场ID
     * @param updateTime     上传时间
     * @return 图片存放路径
     */
    public static String buildImageByStreamFile(String path, String streamFileData, String imageName, String parkId, String updateTime) {
        String imageURLResult = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date updateTimeDate = null;
        try {
            updateTimeDate = sdf.parse(updateTime);
        } catch (Exception dateEx) {
            updateTimeDate = new Date();
        }
        SimpleDateFormat sdfPath = new SimpleDateFormat("yyyyMMdd");
        updateTime = sdfPath.format(updateTimeDate);
        path = path.endsWith("/") ? path : path + "/";
        String initPath = path + parkId + File.separator + updateTime + File.separator;
        String initURL = initPath + imageName;
        try {
            byte[] imageByteData = StringUtils.base64Decode(streamFileData);
            try {
                File dir = new File(initPath);
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                File imageFile = new File(initURL);
                FileImageOutputStream imageOutput = new FileImageOutputStream(imageFile);
                imageOutput.write(imageByteData, 0, imageByteData.length);
                imageOutput.close();

                imageURLResult = imageFile.getPath();
            } catch (Exception ex) {
                logger.error("Exception: " + ex);
            }
        } catch (Exception e) {
            logger.error("解析BASE64图片流文件出错！", e);
        }
        return imageURLResult;
    }


    /**
     * 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
     *
     * @param imgUrl 图片地址
     * @return
     */
    public static String imgPathToBase64(String imgUrl) {
        String result = "";
        File file = new File(imgUrl);
        if (file.exists()) {
            InputStream in = null;
            byte[] data = null;
            //读取图片字节数组
            try {
                in = new FileInputStream(imgUrl);
                data = new byte[in.available()];
                in.read(data);
                in.close();
                //对字节数组Base64编码
                BASE64Encoder encoder = new BASE64Encoder();
                result = encoder.encode(data);
            } catch (IOException e) {
                logger.error("I/O异常", e);
            }

        }
        return result;//返回Base64编码过的字节数组字符串
    }


    /**
     * 给图片加水印
     *
     * @param imgUrl
     * @param content
     * @return
     */
    public static String imgPathToIconBase64(String imgUrl, String content) {
        String result = "";
        ByteArrayOutputStream os = null;
        //logo地址if(!file.exists())
        File file = new File(imgUrl);
        if (file.exists()) {
            String iconUrl = FileParserTool.getUrl("img/logo.png");
            try {
                Image srcImg = ImageIO.read(new File(imgUrl));
                BufferedImage buffImg = new BufferedImage(srcImg.getWidth(null),
                        srcImg.getHeight(null), BufferedImage.TYPE_INT_RGB);
                //得到画笔对象
                Graphics g = buffImg.getGraphics();
                int width = buffImg.getWidth();
                int height = buffImg.getHeight();
                //创建你要附加的图象。
                ImageIcon imgIcon = new ImageIcon(iconUrl);
                //得到Image对象。
                Image img = imgIcon.getImage();
                //将小图片绘到大图片上。
                g.drawImage(srcImg.getScaledInstance(srcImg.getWidth(null), srcImg.getHeight(null), Image.SCALE_SMOOTH), 0, 0, null);
                //5,300 .表示你的小图片在大图片上的位置。
                g.drawImage(img, 0, 30, null);
                // 3、设置水印旋转
                //设置颜色。
                g.setColor(Color.RED);
                //最后一个参数用来设置字体的大小
                Font f = new Font("宋体", Font.BOLD, 30);
                g.setFont(f);
                //10,20 表示这段文字在图片上的位置(x,y) .第一个是你设置的内容。
                g.drawString(content, width - 500, height - 20);
                g.dispose();
                os = new ByteArrayOutputStream();
                //创键编码器，用于编码内存中的图象数据。
                ImageIO.write(buffImg, "JPG", os);
                BASE64Encoder encoder = new BASE64Encoder();
                result = encoder.encode(os.toByteArray());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
        return result;
    }


}
