package com.reywong.tool.tagui.logic.framework.domain.framework;

public class ParamInfo {
    private Integer id;

    private String paramtypeid;

    private String paramtypename;

    private String paramkey;

    private String paramvalue;

    private String paramtext;

    private String usetype;

    private String state;

    private String createpersonid;

    private String createtime;

    private String updatetime;
    private String startNum;
    private String rows;
    private String oper;

    public String getOper() {
        return oper;
    }

    public void setOper(String oper) {
        this.oper = oper;
    }

    public String getStartNum() {
        return startNum;
    }

    public void setStartNum(String startNum) {
        this.startNum = startNum;
    }

    public String getRows() {
        return rows;
    }

    public void setRows(String rows) {
        this.rows = rows;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParamtypeid() {
        return paramtypeid;
    }

    public void setParamtypeid(String paramtypeid) {
        this.paramtypeid = paramtypeid == null ? null : paramtypeid.trim();
    }

    public String getParamtypename() {
        return paramtypename;
    }

    public void setParamtypename(String paramtypename) {
        this.paramtypename = paramtypename == null ? null : paramtypename.trim();
    }

    public String getParamkey() {
        return paramkey;
    }

    public void setParamkey(String paramkey) {
        this.paramkey = paramkey == null ? null : paramkey.trim();
    }

    public String getParamvalue() {
        return paramvalue;
    }

    public void setParamvalue(String paramvalue) {
        this.paramvalue = paramvalue == null ? null : paramvalue.trim();
    }

    public String getParamtext() {
        return paramtext;
    }

    public void setParamtext(String paramtext) {
        this.paramtext = paramtext == null ? null : paramtext.trim();
    }

    public String getUsetype() {
        return usetype;
    }

    public void setUsetype(String usetype) {
        this.usetype = usetype == null ? null : usetype.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getCreatepersonid() {
        return createpersonid;
    }

    public void setCreatepersonid(String createpersonid) {
        this.createpersonid = createpersonid == null ? null : createpersonid.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime == null ? null : updatetime.trim();
    }
}