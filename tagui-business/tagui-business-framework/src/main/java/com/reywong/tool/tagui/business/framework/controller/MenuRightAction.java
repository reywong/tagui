package com.reywong.tool.tagui.business.framework.controller;

import com.reywong.tool.tagui.business.framework.service.MenuRightService;
import com.reywong.tool.tagui.business.framework.service.MenuService;
import com.yxtc.framework.platform.pojo.framework.Menu;
import com.yxtc.framework.platform.pojo.framework.MenuRight;
import com.yxtc.framework.platform.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangrui on 2016/3/25.
 */
@Controller
public class MenuRightAction {
    private static final Logger logger = LoggerFactory.getLogger(MenuRightAction.class);
    @Autowired
    private MenuRightService menuRightService;
    @Autowired
    private MenuService menuService;
    /**
     * 获取用户目录权限列表
     *
     * @param menuRight
     * @return
     */
    public List getMenuRight(MenuRight menuRight) {
        List result = new ArrayList();
        result = menuRightService.getMenuRight(menuRight);
        return result;
    }

    /**
     * 更新权限
     *
     * @param menuRight
     * @return
     */
    public List updateMenuRight(MenuRight menuRight, String flag) {
        if (StringUtils.isNotBlank(flag)) {
            if (flag.equals("0")) {
                menuRightService.insertMenuRight(menuRight);
            } else if (flag.equals("1")) {
                menuRightService.deleteMenuRight(menuRight.getId());
            }

        }
        return menuService.getMenu(new Menu());
    }


    /**
     * 判断用户目录权限
     *
     * @param userid
     * @param menuid
     * @param menuinfoid
     * @return
     */
    public boolean checkMenuRight(String userid, String menuid, String menuinfoid) {
        return true;
    }
}
