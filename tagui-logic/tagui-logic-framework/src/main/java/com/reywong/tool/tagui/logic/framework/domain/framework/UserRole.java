package com.reywong.tool.tagui.logic.framework.domain.framework;

public class UserRole {
    private Integer id;

    private String userid;

    private String roleid;

    private String roleName;

    private String add1;

    private String descirbes;

    private String state;

    private String createdatetime;

    private String updatedatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid == null ? null : roleid.trim();
    }

    public String getDescirbes() {
        return descirbes;
    }

    public void setDescirbes(String descirbes) {
        this.descirbes = descirbes == null ? null : descirbes.trim();
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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getAdd1() {
        return add1;
    }

    public void setAdd1(String add1) {
        this.add1 = add1;
    }
}