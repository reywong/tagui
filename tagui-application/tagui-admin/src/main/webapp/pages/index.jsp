<%@ page import="com.reywong.tool.tagui.business.bean.MenuBean" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.alibaba.fastjson.JSON" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/include/header.jsp" %>
<!DOCTYPE html>
<html>

<head>
    <tagUI:basePlugin title="welcome to tagUI"/>
    <!--选择相应的插件-->
    <%--<%@include file="/include/head.jsp" %>--%>
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
        </tagUI:pageContent>
        <!--end content-->

        <!--start footer-->
        <tagUI:footer/>
        <!--end footer-->

    </tagUI:pageWrapper>
</tagUI:wrapper>
</body>
</html>
