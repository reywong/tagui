package com.reywong.tool.tagui.business.tag.module;

import com.alibaba.fastjson.JSON;
import com.reywong.tool.tagui.business.bean.MenuBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wangrui
 * Date: 13-10-15
 * Time: 上午9:58
 * To change this template use File | Settings | File Templates.
 */
public class PageHeadingTag extends TagSupport {
    private String json;

    @Override
    public int doStartTag() {
        JspWriter out = this.pageContext.getOut();
        try {
            String path = ((HttpServletRequest) this.pageContext.getRequest()).getContextPath();
            String servletPath = path + ((HttpServletRequest) this.pageContext.getRequest()).getServletPath();
            StringBuffer html = new StringBuffer("");

            if (json != null) {
                List<MenuBean> menuList = JSON.parseArray(json, MenuBean.class);
                if (menuList != null && menuList.size() > 0) {
                    //menu
                    for (int i = 0; i < menuList.size(); i++) {
                        MenuBean menu = menuList.get(i);
                        String label = menu.getLabel();
                        String url = menu.getUrl();

                        List<MenuBean> subMenu = menu.getMenuBeanList();

                        if (subMenu != null && subMenu.size() > 0) {

                            for (int j = 0; j < subMenu.size(); j++) {
                                menu = subMenu.get(j);
                                url = menu.getUrl();
                                String subLabel = menu.getLabel();
                                if (url != null && !url.trim().equals("")) {
                                    url = path + (url.startsWith("/") ? url : "/" + url);
                                }

                                if (url != null && url.equals(servletPath)) {
                                    html.append("<div class=\"row wrapper border-bottom white-bg page-heading\">\n" +
                                            "    <div class=\"col-lg-10\">\n" +
                                            "        <h2>" + subLabel + "</h2>\n" +
                                            "        <ol class=\"breadcrumb\">\n" +
                                            "            <li>\n" +
                                            "                Home\n" +
                                            "            </li>\n" +
                                            "            <li>\n" +
                                            label + "\n" +
                                            "            </li>\n" +
                                            "            <li class=\"active\">\n" +
                                            "                <strong>" + subLabel + "</strong>\n" +
                                            "            </li>\n" +
                                            "        </ol>\n" +
                                            "    </div>\n" +
                                            "    <div class=\"col-lg-2\">\n" +
                                            "\n" +
                                            "    </div>\n" +
                                            "</div>");
                                }
                            }
                        } else {
                            if (url != null && !url.trim().equals("")) {
                                url = path + (url.startsWith("/") ? url : "/" + url);
                            }

                            if (url != null && url.equals(servletPath)) {
                                html.append("<div class=\"row wrapper border-bottom white-bg page-heading\">\n" +
                                        "    <div class=\"col-lg-10\">\n" +
                                        "        <h2>" + label + "</h2>\n" +
                                        "        <ol class=\"breadcrumb\">\n" +
                                        "            <li>\n" +
                                        "                Home\n" +
                                        "            </li>\n" +
                                        "            <li class=\"active\">\n" +
                                        "                <strong>" + label + "</strong>\n" +
                                        "            </li>\n" +
                                        "        </ol>\n" +
                                        "    </div>\n" +
                                        "    <div class=\"col-lg-2\">\n" +
                                        "\n" +
                                        "    </div>\n" +
                                        "</div>");
                            }
                        }
                    }
                }
            }
            out.print(html);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        JspWriter out = this.pageContext.getOut();
        try {
            out.println();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return SKIP_BODY;

    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }
}
