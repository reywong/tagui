package com.reywong.tool.tagui.business.framework.controller;


import com.reywong.tool.tagui.business.framework.service.UserRoleService;
import com.yxtc.framework.platform.pojo.ReturnInfoBean;
import com.yxtc.framework.platform.pojo.framework.UserRole;
import com.yxtc.framework.platform.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: wangrui
 * Date: 13-10-17
 * Time: 上午9:30
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/userRoleAction")
public class UserRoleAction {
    private static final Logger logger = LoggerFactory.getLogger(UserRoleAction.class);
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private UserLoginAction userLoginAction;

    /**
     * DWR查询用户角色
     *
     * @param userRole
     * @return
     */
    public List<UserRole> getMap(UserRole userRole) {
        return userRoleService.select(userRole);
    }

    /**
     * 更新
     *
     * @param userRole
     * @param flag
     * @param request
     * @return
     */
    public ReturnInfoBean updateMap(UserRole userRole, String flag, HttpServletRequest request) {
        ReturnInfoBean result = new ReturnInfoBean();
        String message = "";
        boolean state = false;

        if (StringUtils.isNotBlank(flag)) {
            int t = 0;
            if (flag.equals("0")) {
                t = userRoleService.insertUserRole(userRole);
            } else if (flag.equals("1")) {
                t = userRoleService.deleteUserRole(userRole);
            }
            if (t > 0) {
                state = true;
                message = "操作成功！";
            } else {
                message = "操作失败！";
            }
        } else {
            message = "参数flag丢失！";
        }
        result.setMessage(message);
        result.setFlag(state);
        return null;
    }


    /**
     * 通过roleid获取用户列表
     *
     * @param roleid
     * @return
     */

    public List<Map> getUserInfo(String roleid) {
        List<Map> result = new ArrayList<Map>();
        Map map = new HashMap();
        map.put("roleid", roleid);
        result = userRoleService.selectUserIdByRoleId(map);
        return result;
    }

}