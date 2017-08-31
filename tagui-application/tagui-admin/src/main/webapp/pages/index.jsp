<%@ page import="com.alibaba.fastjson.JSON" %>
<%@ page import="com.reywong.tool.tagui.business.bean.MenuBean" %>
<%@ page import="com.reywong.tool.tagui.business.bean.chart.ChartBean" %>
<%@ page import="com.reywong.tool.tagui.business.bean.chart.ChartSetBean" %>
<%@ page import="com.reywong.tool.tagui.business.bean.chart.PolarCharSetBean" %>
<%@ page import="com.reywong.tool.tagui.business.bean.chart.PolarChartBean" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/include/header.jsp" %>
<!DOCTYPE html>
<html>

<head>
    <tagUI:basePlugin title="welcome to tagUI"/>
    <!--选择相应的插件-->
    <tagUI:charJsPlugin/>
</head>

<body>
<%
    MenuBean menuBean1 = new MenuBean();
    menuBean1.setLabel("Dashboards");
    MenuBean subMenuBean1 = new MenuBean();
    subMenuBean1.setLabel("Dashboard v.1");
    subMenuBean1.setUrl("pages/index.jsp");
    MenuBean subMenuBean2 = new MenuBean();
    subMenuBean2.setLabel("Dashboard v.2");
    subMenuBean2.setUrl("demo/dashboard_2.html");
    MenuBean subMenuBean3 = new MenuBean();
    subMenuBean3.setLabel("Dashboard v.3");
    subMenuBean3.setUrl("demo/dashboard_3.html");
    MenuBean subMenuBean4 = new MenuBean();
    subMenuBean4.setLabel("Dashboard v.4");
    subMenuBean4.setUrl("demo/dashboard_4_1.html");
    List<MenuBean> menuBeanList1 = new ArrayList<MenuBean>();
    menuBeanList1.add(subMenuBean1);
    menuBeanList1.add(subMenuBean2);
    menuBeanList1.add(subMenuBean3);
    menuBeanList1.add(subMenuBean4);
    menuBean1.setMenuBeanList(menuBeanList1);
    MenuBean menuBean2 = new MenuBean();
    menuBean2.setUrl("demo/layouts.html");
    menuBean2.setLabel("Layouts");
    menuBean2.setImg("fa fa-diamond");
    List<MenuBean> menuBeans = new ArrayList<MenuBean>();
    menuBeans.add(menuBean1);
    menuBeans.add(menuBean2);
%>

<%
    List lineList = new ArrayList();
    ChartBean chartBean = new ChartBean();
    chartBean.setLabels(new String[]{"January", "February", "March", "April", "May", "June", "July"});
    Integer[] lineData = new Integer[]{65, 59, 80, 81, 56, 55, 40};
    ChartSetBean lineMap = new ChartSetBean();
    lineMap.setLabel("myData");
    lineMap.setDatas(lineData);
    lineList.add(lineMap);
    lineMap = new ChartSetBean();
    lineData = new Integer[]{28, 48, 40, 19, 86, 27, 90};
    lineMap.setLabel("myData1");
    lineMap.setDatas(lineData);
    lineList.add(lineMap);
    chartBean.setDatas(lineList);
    System.out.println("charBean=" + JSON.toJSONString(chartBean));
%>
<%
    PolarChartBean polarChartBean = new PolarChartBean();
    List<PolarCharSetBean> polarCharSetList = new ArrayList<PolarCharSetBean>();
    PolarCharSetBean polarCharSet = new PolarCharSetBean();
    polarCharSet.setLabel("App");
    polarCharSet.setValue(300);
    polarCharSetList.add(polarCharSet);
    polarCharSet = new PolarCharSetBean();
    polarCharSet.setLabel("App1");
    polarCharSet.setValue(140);
    polarCharSetList.add(polarCharSet);
    polarCharSet = new PolarCharSetBean();
    polarCharSet.setLabel("App2");
    polarCharSet.setValue(200);
    polarCharSetList.add(polarCharSet);
    polarChartBean.setDatas(polarCharSetList);
    System.out.println("polarChartBean=" + JSON.toJSONString(polarChartBean));
%>

<tagUI:wrapper>
    <!--start left-side-->
    <tagUI:leftMenu json="<%=JSON.toJSONString(menuBeans)%>"/>
    <!--end left-side-->
    <tagUI:pageWrapper>
        <!--start top side-->
        <tagUI:top welcome="欢迎使用tagUI框架" loginOutUrl="#"/>
        <!--end top side-->
        <tagUI:pageHeading json="<%=JSON.toJSONString(menuBeans)%>"/>

        <!--start content-->
        <tagUI:pageContent>
            <tagUI:row>
                <tagUI:col colNum="4">
                    sdfffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff
                    sdfffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff
                    sfffffffffffffffffffffffffffffffffffffffffffffffffffff
                    sdffffffffffffffffffffffffffffffffffffffffffffffff
                    sdffffffffffffffffffffffffffffffffffffffffffffffffffff
                    sdffffffffffffffffffffff
                    ddddddddddddddddddd
                </tagUI:col>
                <tagUI:col colNum="4" title="我的面板">

                    ddddddddddddddddddd
                </tagUI:col>
            </tagUI:row>
            <tagUI:row>

                <tagUI:col colNum="8" title="我的面板">

                    ddddddddddddddddddd
                </tagUI:col>
                <tagUI:col colNum="4" title="我的面板">

                    ddddddddddddddddddd
                </tagUI:col>

            </tagUI:row>

            <tagUI:row>
                <tagUI:col colNum="6" title="sm">
                    <tagUI:lineChar id="ddd" json="<%=JSON.toJSONString(chartBean)%>"/>
                </tagUI:col>
                <tagUI:col colNum="6" title="55555">
                    <tagUI:barChar id="ddddd" json="<%=JSON.toJSONString(chartBean)%>"/>
                </tagUI:col>
                <tagUI:col colNum="6" title="radar">
                    <tagUI:radarChar id="radar" json="<%=JSON.toJSONString(chartBean)%>"/>
                </tagUI:col>
            </tagUI:row>
            <tagUI:row>
                <tagUI:col colNum="6" title="polarChart">
                    <tagUI:polarChart id="polarChart" json="<%=JSON.toJSONString(polarChartBean)%>"/>
                </tagUI:col>
                <tagUI:col colNum="6" title="pieChart">
                    <tagUI:pieChart id="pieChart" fillPercent="20" json="<%=JSON.toJSONString(polarChartBean)%>"/>
                </tagUI:col>
            </tagUI:row>
            <tagUI:row>
                <tagUI:col colNum="6" title="dddddddddd">
                    <div>
                        <canvas id="rey" height="140"></canvas>
                    </div>
                </tagUI:col>

            </tagUI:row>
        </tagUI:pageContent>
        <!--end content-->


        <!--start footer-->
        <tagUI:footer/>
        <!--end footer-->

    </tagUI:pageWrapper>
</tagUI:wrapper>
<%--<script type="application/javascript">--%>
    <%--tagUI_linechart('rey', <%=JSON.toJSONString(chartBean)%>, true)--%>
<%--</script>--%>
</body>
</html>
