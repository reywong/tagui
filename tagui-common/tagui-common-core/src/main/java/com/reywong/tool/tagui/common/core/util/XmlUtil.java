/**
 *
 * File Desc:    
 *
 * Product AB:   热风投资有限公司
 *
 * Module Name:  
 *
 * Author:       wangrui
 *
 * Create:       13-6-14-下午4:03
 *
 * History:      13-6-14-下午4:03 modify  by  wangrui
 */
package com.reywong.tool.tagui.common.core.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.*;

public class XmlUtil {

    private final static Logger logger = LoggerFactory.getLogger(XmlUtil.class);

    /**
     * 将数据流转化成字符串
     *
     * @param is 数据流
     * @return 解析后的字符串
     */
    public String streamToString(InputStream is) {
        String result = "";
        BufferedReader reader = null;
        StringBuffer sb = new StringBuffer();
        String line = "";
        InputStreamReader isr = null;
        try {
            isr = new InputStreamReader(is, "UTF-8");
            reader = new BufferedReader(isr);
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
            result = sb.toString();
        } catch (UnsupportedEncodingException e) {
            logger.error("解析数据流失败!!", e);
        } catch (IOException e) {
            logger.error("解析数据流失败!!", e);
        } finally {
            try {
                is.close();
                isr.close();
                reader.close();
            } catch (IOException e) {
                logger.error("数据流关闭失败！", e);
            }
        }
        logger.info("请求数据：" + result);
        return result;
    }


    /**
     * xml解析
     *
     * @param xmlString xml格式字符串
     * @param nodeName  xml节点名称
     * @return 对应节点值
     */
    public String readStringXml(String xmlString, String nodeName) {
        String result = "";
        Document doc = null;
        try {

            doc = DocumentHelper.parseText(xmlString);

            Element rootElt = doc.getRootElement(); // 获取根节点

            result = rootElt.elementTextTrim(nodeName);
        } catch (DocumentException e) {
            logger.error("解析xml错误", e);

        }
        return result;
    }

    /**
     * 将xml转换成map
     *
     * @param xmlString
     * @return map数据
     */
    public static Map xmlToMap(String xmlString) {
        Map result = new HashMap();
        Map<String, String> map = new HashMap<String, String>();
        Document doc = null;
        try {
            doc = DocumentHelper.parseText(xmlString); // 将字符串转为XML
            Element rootElt = doc.getRootElement(); // 获取根节点
            List<Element> list = rootElt.elements();//获取根节点下所有节点
            for (Element element : list) {  //遍历节点
                map.put(element.getName(), element.getText()); //节点的name为map的key，text为map的value
            }
        } catch (DocumentException e) {
            logger.error("文档解析失败",e);
        } catch (Exception e) {
            logger.error("处理异常",e);
        }
        return map;
    }


    /**
     * map转换成xmlx
     *
     * @param map
     * @return
     */
    public static String mapToXml(Map map) {
        String result = "";
        Document document = DocumentHelper.createDocument();
        Element xml = document.addElement("xml");
        Set keySet = map.keySet();
        Iterator it = keySet.iterator();
        for (; it.hasNext(); ) {
            String key = (String) it.next();
            String value = String.valueOf(map.get(key));
            xml.addElement(key).addText(value);
        }
        result = document.asXML();
        return result;
    }

    public static String mapToXmlNew(Map map) {
        StringBuffer sb = new StringBuffer();
        sb.append("<xml>");
        Set keySet = map.keySet();
        Iterator it = keySet.iterator();
        for (; it.hasNext(); ) {
            String key = (String) it.next();
            String value = String.valueOf(map.get(key));
            sb.append("<" + key + ">" + value + "</" + key + ">");
        }
        sb.append("</xml>");
        return sb.toString();
    }


    /**
     * 获得文本信息
     *
     * @param xmlString 返回的字符串信息
     * @param nodeName  节点名称
     * @return
     */

    public String getTextInfo(String xmlString, String nodeName) {
        String result = "";
        result = readStringXml(xmlString, nodeName);
        return result;
    }

    /**
     * 发送文本信息
     *
     * @param map 信息列表
     * @return 信息xml文本
     */
    public String sendTextInfo(Map map) {
        String result = "";
        Document document = DocumentHelper.createDocument();
        Element xml = document.addElement("xml");
        Set keySet = map.keySet();
        Iterator it = keySet.iterator();
        for (; it.hasNext(); ) {
            String key = (String) it.next();
            String value = (String) map.get(key);
            xml.addElement(key).addCDATA(value);
        }
        result = document.asXML();
        return result;
    }

    /**
     * 回复音乐消息
     *
     * @param map
     * @return
     */
    public String sendMusicInfo(Map map, List list) {
        String result = "";

        Document document = DocumentHelper.createDocument();
        Element xml = document.addElement("xml");

        //头文件不为空
        if (map != null) {
            Set keySet = map.keySet();
            Iterator it = keySet.iterator();
            for (; it.hasNext(); ) {
                String key = (String) it.next();
                String value = (String) map.get(key);
                xml.addElement(key).addCDATA(value);
            }
        }

        //子元素
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Map musicMap = (Map) list.get(i);
                Element music = xml.addElement("Music");
                Set keySet = musicMap.keySet();
                Iterator it = keySet.iterator();
                for (; it.hasNext(); ) {
                    String key = (String) it.next();
                    String value = (String) musicMap.get(key);
                    music.addElement(key).addCDATA(value);
                }
            }

        }
        result = document.asXML();
        return result;
    }

    /**
     * 回复图片信息
     *
     * @param map
     * @param musicMap
     * @return
     */
    public String sendImageInfo(Map map, Map musicMap) {
        String result = "";

        Document document = DocumentHelper.createDocument();
        Element xml = document.addElement("xml");

        //头文件不为空
        if (map != null) {
            Set keySet = map.keySet();
            Iterator it = keySet.iterator();
            for (; it.hasNext(); ) {
                String key = (String) it.next();
                String value = (String) map.get(key);
                xml.addElement(key).addCDATA(value);
            }
        }

        //子元素

        Element music = xml.addElement("Image");
        Set keySet = musicMap.keySet();
        Iterator it = keySet.iterator();
        for (; it.hasNext(); ) {
            String key = (String) it.next();
            String value = (String) musicMap.get(key);
            music.addElement(key).addCDATA(value);

            result = document.asXML();
        }
        return result;

    }

    /**
     * 回复语音信息
     *
     * @param map
     * @param voiceMap
     * @return
     */
    public String sendVoiceInfo(Map map, Map voiceMap) {
        String result = "";

        Document document = DocumentHelper.createDocument();
        Element xml = document.addElement("xml");

        //头文件不为空
        if (map != null) {
            Set keySet = map.keySet();
            Iterator it = keySet.iterator();
            for (; it.hasNext(); ) {
                String key = (String) it.next();
                String value = (String) map.get(key);
                xml.addElement(key).addCDATA(value);
            }
        }

        //子元素

        Element voice = xml.addElement("Voice");
        Set keySet = voiceMap.keySet();
        Iterator it = keySet.iterator();
        for (; it.hasNext(); ) {
            String key = (String) it.next();
            String value = (String) voiceMap.get(key);
            voice.addElement(key).addCDATA(value);

            result = document.asXML();
        }
        return result;

    }

    /**
     * 回复视频信息
     *
     * @param map
     * @param videoMap
     * @return
     */
    public String sendVideoInfo(Map map, Map videoMap) {
        String result = "";
        Document document = DocumentHelper.createDocument();
        Element xml = document.addElement("xml");

        //头文件不为空
        if (map != null) {
            Set keySet = map.keySet();
            Iterator it = keySet.iterator();
            for (; it.hasNext(); ) {
                String key = (String) it.next();
                String value = (String) map.get(key);
                xml.addElement(key).addCDATA(value);
            }
        }

        //子元素

        Element video = xml.addElement("Video");
        Set keySet = videoMap.keySet();
        Iterator it = keySet.iterator();
        for (; it.hasNext(); ) {
            String key = (String) it.next();
            String value = (String) videoMap.get(key);
            video.addElement(key).addCDATA(value);
            result = document.asXML();
        }
        return result;

    }


    /**
     * 发送图文信息
     *
     * @param map
     * @param list
     * @return
     */

    public String sendPicTextInfo(Map map, List list) {
        String result = "";

        Document document = DocumentHelper.createDocument();
        Element xml = document.addElement("xml");

        //头文件不为空
        if (map != null) {
            Set keySet = map.keySet();
            Iterator it = keySet.iterator();
            for (; it.hasNext(); ) {
                String key = (String) it.next();
                String value = (String) map.get(key);
                xml.addElement(key).addCDATA(value);
            }
        }

        //子元素
        Element articles = xml.addElement("Articles");
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Map musicMap = (Map) list.get(i);
                Element item = articles.addElement("item");
                Set keySet = musicMap.keySet();
                Iterator it = keySet.iterator();
                for (; it.hasNext(); ) {
                    String key = (String) it.next();
                    String value = (String) musicMap.get(key);
                    item.addElement(key).addCDATA(value);
                }
            }

        }
        result = document.asXML();

        return result;
    }

    /**
     * 文本消息回复
     *
     * @param toUserName
     * @param fromUserName
     * @param createTime
     * @param msgType
     * @param content
     * @return
     */

    public String sendTextInfo(String toUserName, String fromUserName, String createTime, String msgType, String content) {
        String result = "";
        StringBuffer sb = new StringBuffer();
        sb.append("<xml>\n");
        sb.append("<ToUserName><![CDATA[" + toUserName + "]]></ToUserName>\n");
        sb.append("<FromUserName><![CDATA[" + fromUserName + "]]></FromUserName>\n");
        sb.append("<CreateTime>" + createTime + "</CreateTime>\n");
        sb.append("<MsgType><![CDATA[" + msgType + "]]></MsgType>\n");
        sb.append("<Content><![CDATA[" + content + "]]></Content>\n");
        sb.append("</xml>");
        result = sb.toString();
        return result;
    }

}


