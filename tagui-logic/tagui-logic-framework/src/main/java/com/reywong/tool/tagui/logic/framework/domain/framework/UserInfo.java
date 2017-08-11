package com.reywong.tool.tagui.logic.framework.domain.framework;

public class UserInfo extends UserInfoKey {
    private String username;

    private String password;

    private String usertype;

    private String usertypename;

    private String companyid;

    private String companyname;

    private String parkid;

    private String parkname;

    private String parkaddress;

    private String merchantcompanyid;

    private String merchantcompanyname;

    private String merchantid;

    private String merchantname;

    private String email;

    private String telphone;

    private String regeisttime;

    private String state;

    private String startNum;

    private String rows;

    private String sord;

    private String sidx;

    private String createpersonid;

    private String createtime;

    private String updatetime;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype == null ? null : usertype.trim();
    }

    public String getCompanyid() {
        return companyid;
    }

    public void setCompanyid(String companyid) {
        this.companyid = companyid == null ? null : companyid.trim();
    }

    public String getParkid() {
        return parkid;
    }

    public void setParkid(String parkid) {
        this.parkid = parkid == null ? null : parkid.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone == null ? null : telphone.trim();
    }

    public String getRegeisttime() {
        return regeisttime;
    }

    public void setRegeisttime(String regeisttime) {
        this.regeisttime = regeisttime == null ? null : regeisttime.trim();
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

    public String getUsertypename() {
        return usertypename;
    }

    public void setUsertypename(String usertypename) {
        this.usertypename = usertypename;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getParkname() {
        return parkname;
    }

    public void setParkname(String parkname) {
        this.parkname = parkname;
    }

    public String getParkaddress() {
        return parkaddress;
    }

    public void setParkaddress(String parkaddress) {
        this.parkaddress = parkaddress;
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

    public String getSord() {
        return sord;
    }

    public void setSord(String sord) {
        this.sord = sord;
    }

    public String getSidx() {
        return sidx;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
    }

    public String getMerchantcompanyid() {
        return merchantcompanyid;
    }

    public void setMerchantcompanyid(String merchantcompanyid) {
        this.merchantcompanyid = merchantcompanyid;
    }

    public String getMerchantcompanyname() {
        return merchantcompanyname;
    }

    public void setMerchantcompanyname(String merchantcompanyname) {
        this.merchantcompanyname = merchantcompanyname;
    }

    public String getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(String merchantid) {
        this.merchantid = merchantid;
    }

    public String getMerchantname() {
        return merchantname;
    }

    public void setMerchantname(String merchantname) {
        this.merchantname = merchantname;
    }
}