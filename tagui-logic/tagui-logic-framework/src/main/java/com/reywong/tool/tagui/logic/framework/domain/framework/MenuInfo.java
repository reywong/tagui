package com.reywong.tool.tagui.logic.framework.domain.framework;

public class MenuInfo {
    private Integer id;

    private String menuinfoname;

    private Integer ordernum;

    private String describes;

    private String menuid;

    private String url;

    private String state;

    private String createdatetime;

    private String updatedatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuinfoname() {
        return menuinfoname;
    }

    public void setMenuinfoname(String menuinfoname) {
        this.menuinfoname = menuinfoname == null ? null : menuinfoname.trim();
    }

    public Integer getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(Integer ordernum) {
        this.ordernum = ordernum;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes == null ? null : describes.trim();
    }

    public String getMenuid() {
        return menuid;
    }

    public void setMenuid(String menuid) {
        this.menuid = menuid == null ? null : menuid.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCreatedatetime() {
        return createdatetime;
    }

    public void setCreatedatetime(String createdatetime) {
        this.createdatetime = createdatetime == null ? null : createdatetime.trim();
    }

    public String getUpdatedatetime() {
        return updatedatetime;
    }

    public void setUpdatedatetime(String updatedatetime) {
        this.updatedatetime = updatedatetime == null ? null : updatedatetime.trim();
    }
}