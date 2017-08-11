package com.reywong.tool.tagui.common.core.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by wangrui on 2016/3/2.
 */
public class AppConfigurationUtil {
    private static Logger logger = LoggerFactory.getLogger(AppConfigurationUtil.class);

    private static Properties prop = new Properties();

    static {
        InputStream is = AppConfigurationUtil.class.getClassLoader().getResourceAsStream("config/appConfiguration.properties");
        try {
            prop.load(is);
        } catch (IOException e) {
            logger.error("[error]Could not load appConfiguration.properties", e);
        }
    }

    public static String getPropertyValue(String key) {
        return getPropertyValue(key, null);
    }

    public static String getPropertyValue(String key, String defaultValue) {
        return prop.getProperty(key, defaultValue);
    }
}
