package com.reywong.tool.tagui.logic.framework.domain.framework;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wangrui
 * Date: 13-10-23
 * Time: 上午11:00
 * To change this template use File | Settings | File Templates.
 */
public class UserInfoBean implements Serializable {
    private UserInfo userInfo;
    private List userrole;
    private List menuList;

    public List getUserrole() {
        return userrole;
    }

    public void setUserrole(List userrole) {
        this.userrole = userrole;
    }

    public UserInfo getUserInfo() {

        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public List getMenuList() {
        return menuList;
    }

    public void setMenuList(List menuList) {
        this.menuList = menuList;
    }
}
