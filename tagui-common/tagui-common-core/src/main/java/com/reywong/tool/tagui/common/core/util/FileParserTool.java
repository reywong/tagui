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
 * Create:       13-3-28-下午3:09
 *
 * History:      13-3-28-下午3:09 modify  by  wangrui
 */
package com.reywong.tool.tagui.common.core.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Properties;

public class FileParserTool {
    private static final Logger logger = LoggerFactory.getLogger(FileParserTool.class);

    /**
     * 获得文件地址</br>
     *
     * @param fileName 文件名
     * @return 返回文件的路径
     */
    public static String getUrl(String fileName) {
        String path = "";
        try {
            path = FileParserTool.class.getClassLoader().getResource(fileName).toString().substring(6);
            path = path.replace("%20", " ");// 如果你的文件路径中包含空格，是必定会报错的
        } catch (Exception e) {
            path = System.getProperty("user.dir") + "/" + fileName;
        }

        //linux下系统
        if (path != null) {
            if (!path.contains(":") && !path.startsWith("/")) {
                path = "/" + path;
            }
        }
        return path;
    }

    /**
     * 读取配置文件<br>
     *
     * @param key 配置文件的key
     * @return 返回对应的值
     */
    public static String getPropertiesValue(String key) {
        String empUrl = FileParserTool.getUrl("config.properties");
        String result = "";
        InputStream in = null;
        Properties p = new Properties();
        try {
            in = new BufferedInputStream(new FileInputStream(empUrl));
            p.load(in);
            result = p.getProperty(key);
        } catch (FileNotFoundException e) {
            try {
                in = FileParserTool.class.getClassLoader().getResourceAsStream("config.properties");
                p.load(in);
                result = p.getProperty(key);
            } catch (IOException e1) {
                System.out.println("配置文件不存在");
            }


            //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            System.out.println("读取文件失败"); //To change body of catch statement use File | Settings | File Templates.
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                System.out.println("输入流关闭失败！");
            }
        }
        return result;
    }


    /**
     * 获取properties值
     *
     * @param fileName 文件名称
     * @param key      key值
     * @return
     */
    public static String getPropertiesValue(String fileName, String key) {
        String empUrl = FileParserTool.getUrl(fileName);
        String result = "";
        InputStream in = null;
        Properties p = new Properties();
        try {
            in = new BufferedInputStream(new FileInputStream(empUrl));
            p.load(in);
            result = p.getProperty(key);
        } catch (FileNotFoundException e) {
            try {
                in = FileParserTool.class.getClassLoader().getResourceAsStream("config.properties");
                p.load(in);
                result = p.getProperty(key);
            } catch (IOException e1) {
                System.out.println("配置文件不存在");
            }
        } catch (IOException e) {
            System.out.println("读取文件失败");
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                System.out.println("输入流关闭失败！");
            }
        }
        return result;
    }

    /**
     * 读取xml文件
     *
     * @return
     */
    public static String getXMLValue() {
        String result = "";


        return result;
    }

    /**
     * 读取文件数据
     *
     * @param fileName 文件名称
     * @return 返回文件内容
     */
    public static String getFileText(String fileName) {
        String result = null;
        String fileUrl = getUrl(fileName);
        FileReader fr = null;
        BufferedReader br = null;
        StringBuffer sb = new StringBuffer();

        try {
            fr = new FileReader(fileUrl);
            br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            result = sb.toString();
        } catch (FileNotFoundException e) {
            logger.error("文件不存在", e);
        } catch (UnsupportedEncodingException e) {
            logger.error("文件编码有误", e);
        } catch (IOException e) {
            logger.error("I/O读取异常", e);
        } finally {
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                logger.error("解析URL：" + fileUrl);
                logger.error("数据流关闭异常", e);

            }

        }
        return result;
    }

    /**
     * 文件数据
     *
     * @param fileName 文件名称
     * @param data     要写入的文件内容，清除文件原有内容
     * @return 返回文件内容
     */
    public static void writeFileText(String data, String fileName) {
        BufferedWriter writer = null;
        String url = getUrl(fileName);
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(url))));
            writer.write(data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        }
    }

    /**
     * 向文件后添加内容 </br>
     *
     * @param data     要添加的内容
     * @param fileName 文件名
     */
    public static void appendFileText(String data, String fileName) {
        BufferedWriter writer = null;
        String url = getUrl(fileName);
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(url), true)));
            writer.write(data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        }
    }

    /**
     * 清除文件的内容</br>
     *
     * @param fileName 文件名
     */
    public static void clear(String fileName) {
        BufferedWriter writer = null;
        String url = getUrl(fileName);
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(url))));
            writer.write("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        }
    }


}
