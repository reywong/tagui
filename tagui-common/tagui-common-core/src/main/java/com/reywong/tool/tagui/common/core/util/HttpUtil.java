package com.reywong.tool.tagui.common.core.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/**
 * Created by wangrui on 2016/4/1.
 */
public class HttpUtil {
    private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    /**
     * 发送json
     *
     * @param json
     * @param urlStr
     * @return
     */
    public static String httpClient(String json, String urlStr) {
        String result = "";
        URL url = null;
        BufferedReader reader = null;
        StringBuffer sb = new StringBuffer();
        String line = "";
        InputStreamReader isr = null;
        InputStream is = null;
        try {
            url = new URL(urlStr);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setDoOutput(true);
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-type", "application/json;text/html");
            con.setRequestProperty("Accept-Charset", "utf-8");
            con.setRequestProperty("contentType", "utf-8");
            OutputStreamWriter out = new OutputStreamWriter(con.getOutputStream());
            out.write(json);
            out.flush();
            out.close();
            is = con.getInputStream();
            isr = new InputStreamReader(is, "UTF-8");
            reader = new BufferedReader(isr);
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
            result = sb.toString();
            is.close();
            isr.close();
            reader.close();
        } catch (MalformedURLException e) {
            logger.error("URL错误", e);
        } catch (UnsupportedEncodingException e) {
            logger.error("不支持该编码", e);
        } catch (IOException e) {
            logger.error("读取文件异常", e);
        }
        return result;
    }


    /**
     * URL编码（utf-8）
     *
     * @param source
     * @return
     */
    public static String urlEncodeUTF8(String source) {
        String result = source;
        try {
            result = java.net.URLEncoder.encode(source, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 获取微信返回
     *
     * @param requestUrl
     * @param requestMethod
     * @param outputStr
     * @return
     * @throws java.security.NoSuchAlgorithmException
     * @throws java.security.NoSuchProviderException
     * @throws java.security.KeyManagementException
     * @throws java.net.MalformedURLException
     * @throws java.io.IOException
     * @throws java.net.ProtocolException
     * @throws java.io.UnsupportedEncodingException
     */
    public static String httpsRequest(String requestUrl, String requestMethod, String outputStr)
            throws NoSuchAlgorithmException, NoSuchProviderException, KeyManagementException, MalformedURLException,
            IOException, ProtocolException, UnsupportedEncodingException {
        // 创建SSLContext对象，并使用我们指定的信任管理器初始化
        TrustManager[] tm = {new HttpsX509TrustManager()};
        SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
        sslContext.init(null, tm, new java.security.SecureRandom());
        // 从上述SSLContext对象中得到SSLSocketFactory对象
        SSLSocketFactory ssf = sslContext.getSocketFactory();

        URL url = new URL(requestUrl);
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        conn.setSSLSocketFactory(ssf);

        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setUseCaches(false);
        // 设置请求方式（GET/POST）
        conn.setRequestMethod(requestMethod);
        // 当outputStr不为null时向输出流写数据
        if (null != outputStr) {
            OutputStream outputStream = conn.getOutputStream();
            // 注意编码格式
            outputStream.write(outputStr.getBytes("UTF-8"));
            outputStream.close();
        }

        // 从输入流读取返回内容
        InputStream inputStream = conn.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String str = null;
        StringBuffer buffer = new StringBuffer();
        while ((str = bufferedReader.readLine()) != null) {
            buffer.append(str);
        }

        bufferedReader.close();
        inputStreamReader.close();
        inputStream.close();
        inputStream = null;
        conn.disconnect();
        return buffer.toString();
    }

    /**
     * 获取ip地址
     *
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request) {
        try {
            String ip = request.getHeader("X-Forwarded-For");
            if (StringUtils.isNotBlank(ip) && !"unKnown".equalsIgnoreCase(ip)) {
                //多次反向代理后会有多个ip值，第一个ip才是真实ip
                int index = ip.indexOf(",");
                if (index != -1) {
                    return ip.substring(0, index);
                } else {
                    return ip;
                }
            }
            ip = request.getHeader("X-Real-IP");
            if (StringUtils.isNotBlank(ip) && !"unKnown".equalsIgnoreCase(ip)) {
                return ip;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return request.getRemoteAddr();
    }

    /**
     * get请求
     *
     * @param url
     * @return
     */
    public static String httpClientGet(String url) throws IOException {
        String result = "";
        //创建HttpClientBuilder
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        //HttpClient
        CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
        HttpGet httpGet = new HttpGet(url);
        try {
            //执行get请求
            HttpResponse httpResponse = closeableHttpClient.execute(httpGet);
            //获取响应消息实体
            HttpEntity entity = httpResponse.getEntity();
            //响应状态
            logger.debug("访问url:" + url);
            logger.debug("返回状态：" + httpResponse.getStatusLine());
            //判断响应实体是否为空
            if (entity != null) {
                result = EntityUtils.toString(entity);
            }
        } finally {
            try {
                //关闭流并释放资源
                closeableHttpClient.close();
            } catch (IOException e) {
                logger.error("关闭流失败", e);
            }
        }
        return result;
    }

}
