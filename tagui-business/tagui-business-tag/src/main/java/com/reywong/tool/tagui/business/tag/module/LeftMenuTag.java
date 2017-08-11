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
public class LeftMenuTag extends TagSupport {
    /**
     *
     */
    private String json;

    @Override
    public int doStartTag() {
        JspWriter out = this.pageContext.getOut();
        try {
            //check request page ,and collapse the submenu
            String path = ((HttpServletRequest) this.pageContext.getRequest()).getContextPath();
            String servletPath = path + ((HttpServletRequest) this.pageContext.getRequest()).getServletPath();
            StringBuffer html = new StringBuffer("" +
                    "<nav class=\"navbar-default navbar-static-side\" role=\"navigation\">\n" +
                    "<div class=\"sidebar-collapse\">" +
                    "<ul class=\"nav metismenu\" id=\"side-menu\">" +
                    "<li class=\"nav-header\">\n" +
                    "    <div class=\"dropdown profile-element\">\n" +
                    "        <span><img alt=\"image\" class=\"img-circle\" src=\"" + path + "/pages/img/profile_small.jpg\"/> </span>\n" +
                    "    </div>\n" +
                    "</li>");

            if (json != null) {
                List<MenuBean> menuList = JSON.parseArray(json, MenuBean.class);
                String activeMenu = "";
                String collapse = "collapse";
                if (menuList != null && menuList.size() > 0) {
                    //menu
                    for (int i = 0; i < menuList.size(); i++) {
                        MenuBean menu = menuList.get(i);
                        String label = menu.getLabel();
                        String img = menu.getImg();
                        String url = menu.getUrl();

                        if (url != null && !url.trim().equals("")) {
                            url = path + (url.startsWith("/") ? url : "/" + url);
                        } else {
                            url = "#";
                        }


                        //check current request page
                        if (url.equals(servletPath)) {
                            activeMenu = " class=\"active\" ";
                        } else {
                            activeMenu = "";
                        }


                        //set a default menu img
                        if (img == null || img.trim().equals("")) {
                            img = "fa fa-th-large";
                        }

                        //check if has subMenu,if has then url=currentURL else url=url
                        List<MenuBean> subMenu = menu.getMenuBeanList();

                        //check if has subMenu
                        if (subMenu != null && subMenu.size() > 0) {
                            StringBuffer subMenuHtml = new StringBuffer();
                            subMenuHtml.append("<li ${activeMenu} >\n" +
                                    " <a href=\"" + path + url + "\">\n" +
                                    "        <i class=\"" + img + "\"></i>\n" +
                                    "        <span class=\"nav-label\">" + label + "</span>\n" +
                                    "        <span class=\"fa arrow\"></span>\n" +
                                    " </a>\n");
                            subMenuHtml.append("<ul class=\"nav nav-second-level ${collapse}\">");

                            for (int j = 0; j < subMenu.size(); j++) {
                                String subActive = "";
                                menu = subMenu.get(j);
                                label = menu.getLabel();
                                url = menu.getUrl();
                                if (url != null && !url.trim().equals("")) {
                                    url = path + (url.startsWith("/") ? url : "/" + url);
                                }

                                if (url != null && url.equals(servletPath)) {
                                    //if subMenu is active ,update menu css
                                    subActive = " class=\"active\" ";
                                    collapse = "";
                                } else {
                                    subActive = "";
                                }
                                subMenuHtml.append("<li " + subActive + "><a href=\"" + path + url + "\">" + label + "</a></li>\n");
                            }

                            //if subMenu is active
                            if (collapse.equals("")) {
                                html.append(subMenuHtml.toString().replace("${activeMenu}", " class=\"active\" ").replace("${collapse}", collapse));
                            } else {
                                html.append(subMenuHtml.toString().replace("${activeMenu}", "").replace("${collapse}", collapse));
                            }

                            html.append("</ul>\n" +
                                    "</li>\n");
                        } else {
                            html.append("<li  " + activeMenu + ">" +
                                    " <a href=\"" + url + "\">\n" +
                                    "        <i class=\"" + img + "\"></i>\n" +
                                    "        <span class=\"nav-label\">" + label + "</span>\n" +
                                    "        <span class=\"fa arrow\"></span>\n" +
                                    "    </a>");
                        }
                    }
                }
            }

            html.append("</ul>\n" +
                    "</div>\n" +
                    "</nav>\n\n");
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
