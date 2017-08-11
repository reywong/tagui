package com.reywong.tool.tagui.business.bean;

import java.util.List;

/**
 * Created by wangrui on 2017/8/1.
 */
public class MenuBean {
    /**
     * label
     */
    private String label;
    /**
     * img
     */
    private String img;
    /**
     * url
     */
    private String url;
    /**
     * subMenuList
     */
    private List<MenuBean> menuBeanList;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<MenuBean> getMenuBeanList() {
        return menuBeanList;
    }

    public void setMenuBeanList(List<MenuBean> menuBeanList) {
        this.menuBeanList = menuBeanList;
    }
}
