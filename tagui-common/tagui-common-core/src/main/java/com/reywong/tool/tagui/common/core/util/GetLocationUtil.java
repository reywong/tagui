package com.reywong.tool.tagui.common.core.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: wangrui
 * Date: 13-9-12
 * Time: 上午10:53
 * To change this template use File | Settings | File Templates.
 */
public class GetLocationUtil {
    private static final Logger logger = LoggerFactory.getLogger(GetLocationUtil.class);
    private static final String OUTPUT = "xml";
    private static final String KEY = "45570ffb2ab0f1e1f8522aa70f276b638db1748d1234b141fdbb3c4c6c84bd9e";
    private static double DEF_PI = 3.14159265359; // PI2.
    private static double DEF_2PI = 6.28318530712; // 2*PI3.
    private static double DEF_PI180 = 0.01745329252; // PI/180.04.
    private static double DEF_R = 6370693.5; // radius of earth5.

    /**
     * 根据地址获取返回数据
     *
     * @param address 地址
     * @param city    所在城市
     * @return
     */
    public static String getLocaitonStr(String address, String city) {
        String ret = "";
        if (address != null && !address.equals("")) {
            try {
                address = URLEncoder.encode(address, "UTF-8");//进行这一步是为了避免乱码
            } catch (UnsupportedEncodingException e1) {
                logger.error("转码失败", e1);
            }
            String urlparam = "http://api.map.baidu.com/geocoder?address=" + address + "&output=" + OUTPUT + "&city=" + city + "&key=" + KEY + "";
            if (StringUtils.isBlank(city)) {
                urlparam = "http://api.map.baidu.com/geocoder?address=" + address + "&output=" + OUTPUT + "&key=" + KEY + "";
            }
            String url = urlparam;
            URL urlmy = null;
            try {
                urlmy = new URL(url);
                HttpURLConnection con = (HttpURLConnection) urlmy.openConnection();
                con.setFollowRedirects(true);
                con.setInstanceFollowRedirects(false);
                con.connect();
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
                String s = "";
                StringBuffer sb = new StringBuffer("");
                while ((s = br.readLine()) != null) {
                    sb.append(s + "\r\n");
                }
                ret = "" + sb;
            } catch (MalformedURLException e) {
                logger.error("通过http方式获取地址信息失败", e);
            } catch (IOException e) {
                logger.error("文件读取失败", e);
            }
        }
        return ret;
    }

    /**
     * 获取经纬度
     *
     * @param locationXml
     * @return
     */
    public static Map getLocationXY(String locationXml) {
        Map result = new HashMap();
        if (StringUtils.isNotBlank(locationXml)) {
            try {
                Document document = DocumentHelper.parseText(locationXml);
                Element root = document.getRootElement();
                Iterator it_e1 = root.elementIterator();
                for (; it_e1.hasNext(); ) {
                    Element element = (Element) it_e1.next();
                    //返回成功
                    if (element.getName().trim().toLowerCase().equals("result")) {
                        result.put(element.getName(), element.getTextTrim());
                        Iterator it_e2 = element.elementIterator();
                        for (; it_e2.hasNext(); ) {
                            Element element2 = (Element) it_e2.next();
                            if (element2.getName().toLowerCase().equals("location")) {
                                Iterator it_e3 = element2.elementIterator();
                                for (; it_e3.hasNext(); ) {
                                    Element element3 = (Element) it_e3.next();
                                    result.put(element3.getName(), element3.getTextTrim());
                                }
                            } else {
                                result.put(element2.getName(), element2.getTextTrim());
                            }

                        }

                    }
                }
            } catch (DocumentException e) {
//                logger.error("数据格式错误！");
            }
        }


        return result;
    }

    /**
     * 获取长度
     *
     * @param lon1 经度1
     * @param lat1 纬度1
     * @param lon2 经度2
     * @param lat2 纬度2
     * @return 两点之间的长度，单位m
     */
    public static double getShortDistance(double lon1, double lat1, double lon2, double lat2) {
        double ew1, ns1, ew2, ns2;
        double dx, dy, dew;
        double distance;
        // 角度转换为弧度
        ew1 = lon1 * DEF_PI180;
        ns1 = lat1 * DEF_PI180;
        ew2 = lon2 * DEF_PI180;
        ns2 = lat2 * DEF_PI180;
        // 经度差
        dew = ew1 - ew2;
        // 若跨东经和西经180 度，进行调整
        if (dew > DEF_PI)
            dew = DEF_2PI - dew;
        else if (dew < -DEF_PI)
            dew = DEF_2PI + dew;
        dx = DEF_R * Math.cos(ns1) * dew; // 东西方向长度(在纬度圈上的投影长度)
        dy = DEF_R * (ns1 - ns2); // 南北方向长度(在经度圈上的投影长度)
        // 勾股定理求斜边长
        distance = Math.sqrt(dx * dx + dy * dy);
        return distance;
    }

    /**
     * 获取直线长度
     *
     * @param lon1 经度1
     * @param lat1 纬度1
     * @param lon2 经度2
     * @param lat2 纬度2
     * @return 两点之间的长度，单位m
     */
    public double getLongDistance(double lon1, double lat1, double lon2, double lat2) {
        double ew1, ns1, ew2, ns2;
        double distance;
        // 角度转换为弧度
        ew1 = lon1 * DEF_PI180;
        ns1 = lat1 * DEF_PI180;
        ew2 = lon2 * DEF_PI180;
        ns2 = lat2 * DEF_PI180;
        // 求大圆劣弧与球心所夹的角(弧度)
        distance = Math.sin(ns1) * Math.sin(ns2) + Math.cos(ns1) * Math.cos(ns2) * Math.cos(ew1 - ew2);
        // 调整到[-1..1]范围内，避免溢出
        if (distance > 1.0)
            distance = 1.0;
        else if (distance < -1.0)
            distance = -1.0;
        // 求大圆劣弧长度
        distance = DEF_R * Math.acos(distance);
        return distance;
    }


    public static String getProvinceByJW(String lat, String lon) {
        String result = "";
        String url = ParamUtils.getBaiduMapApi().getGeocdingURL();
        url = url.replace("${lat}", lat).replace("${lon}", lon);
        try {
            String returnJson = HttpUtil.httpClientGet(url);
            Map map = DataTypeChangeTool.jsonToMap(returnJson);
            Map dataMap = (Map) map.get("result");
            result = (String) ((Map) dataMap.get("addressComponent")).get("province");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {

//        String lat1 = "39.929986";
//        lat1 = "31.184446";
//        String lng1 = "116.395645";
//        String sql="select * from core_parkdic where id>16488";

//
//
//        lng1 = "121.413624";
//        String lat2 = "31.249162";
//        lat2 = "";
//        String lng2 = "121.487899";
//        lng2 = ,
//        GetLocationUtil getLocationUtil = new GetLocationUtil();
//        System.out.println(GetLocationUtil.getLocaitonStr("上海市虹口区四川北路甜爱支路280号", "上海市"));
        System.out.println("1111");
//        String d= getLocationUtil.getProvinceByJW(lat1,lng1);
//        String destDate = DateHandlerTool.getDesDate("2016-05-25", Integer.valueOf("0"), DateHandlerTool.DAY, "yyyy-MM-dd");
//        System.out.println(d);
//        double result = getLocationUtil.getDistance(Double.parseDouble(lng1), Double.parseDouble(lat1), Double.parseDouble(lng2), Double.parseDouble(lat2));
//        System.out.println(result);
//        double mLat1 = 39.90923; // point1纬度
//        double mLon1 = 116.357428; // point1经度
//        double mLat2 = 39.90923;// point2纬度
//        double mLon2 = 116.397428;// point2经度

//        mLat1 = Double.parseDouble(lat1); // point1纬度
//        mLon1 = Double.parseDouble(lng1); // point1经度
//        mLat2 = Double.parseDouble(lat2);// point2纬度
//        mLon2 = Double.parseDouble(lng2);// point2经度


//        double distance = getLocationUtil.getLongDistance(mLon1, mLat1, mLon2, mLat2);
//        System.out.println(distance);

    }
//    public static void main(String[] args) {
//        String sql = "select org_id,address from hw_org_info where address is not null and (location_x ='' or location_x is null)";
//        List list = DataBaseHandlerTool.selectBySql(sql);
//        for (int i = 0; i < list.size(); i++) {
//            Map temp = (Map) list.get(i);
//            String org_id = (String) temp.get("org_id");
//            String address = (String) temp.get("address");
//            String locationXML = GetLocationUtil.getLocaitonStr(address, "");
//            Map map = GetLocationUtil.getLocationXY(locationXML);
//            String location_x = (String) map.get("lat");
//            String f = "";
//            if (StringUtils.isBlank(location_x)) {
//                for (int j = 0; j < address.length(); j++) {
//                    locationXML = GetLocationUtil.getLocaitonStr(address.substring(0, address.length() - j), "");
//                    map = GetLocationUtil.getLocationXY(locationXML);
//                    location_x = (String) map.get("lat");
//                    if (StringUtils.isNotBlank(location_x)) {
//                        f = address.substring(0, address.length() - j);
//                        break;
//                    }
//
//                }
//            }
//            String location_y = (String) map.get("lng");
//
//            String level = (String) map.get("level");
//            System.out.println("address=" + f + " and location_x=" + location_x + " and location_y=" + location_y + " and level=" + level);
//            sql = "update hw_org_info set location_x='" + location_x + "',location_y='" + location_y + "',level='" + level + "' where org_id='" + org_id + "'";
//            DataBaseHandlerTool.updateDelSQL(sql);
//
//        }

//        //导数据
//        String sql =" select * from hw_org_info ";
//        List source = DataBaseHandlerTool.selectBySql(sql);
//
//        Connection connection = DataBaseHandlerTool.getOutConnection();
//        DataBaseHandlerTool.insertData(connection, "hw_org_info", source);
//        if (connection != null) {
//            try {
//                connection.close();
//            } catch (SQLException e) {
//                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//            }
//        }
//        System.exit(0);
////
//        <location>
//        <lat>30.264743</lat>
//        <lng>120.12773</lng>
//        </location>
//        <precise>1</precise>
//        <confidence>80</confidence>
//        <level>购物</level>


//    }

}
