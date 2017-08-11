package com.reywong.tool.tagui.logic.framework.domain.framework;

public class Menu {
    private Integer id;

    private String menuname;

    private Integer ordernum;

    private String describes;

    private String state;

    private String pic;

    private String createdatetime;

    private String updatedatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname == null ? null : menuname.trim();
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
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