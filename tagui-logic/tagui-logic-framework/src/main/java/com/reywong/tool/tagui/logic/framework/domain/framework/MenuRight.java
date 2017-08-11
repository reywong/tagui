package com.reywong.tool.tagui.logic.framework.domain.framework;

public class MenuRight {
    private Integer id;

    private String roleid;

    private String menuid;

    private String menuinfoid;

    private String righttype;

    private String state;

    private String createdatetime;

    private String updatedatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid == null ? null : roleid.trim();
    }

    public String getMenuid() {
        return menuid;
    }

    public void setMenuid(String menuid) {
        this.menuid = menuid == null ? null : menuid.trim();
    }

    public String getMenuinfoid() {
        return menuinfoid;
    }

    public void setMenuinfoid(String menuinfoid) {
        this.menuinfoid = menuinfoid == null ? null : menuinfoid.trim();
    }

    public String getRighttype() {
        return righttype;
    }

    public void setRighttype(String righttype) {
        this.righttype = righttype == null ? null : righttype.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
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