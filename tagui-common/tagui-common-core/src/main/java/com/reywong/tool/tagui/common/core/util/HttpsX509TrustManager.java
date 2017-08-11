package com.reywong.tool.tagui.common.core.util;

import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * 信任证书管理器
 * @author rory.wu
 * @version 1.0
 * @since 2015年08月07日
 */
public class HttpsX509TrustManager implements X509TrustManager{
	
	public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {  
    }  
  
    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {  
    }  
  
    public X509Certificate[] getAcceptedIssuers() {  
        return null;  
    }  
}
