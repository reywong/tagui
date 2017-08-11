package com.reywong.tool.tagui.business.framework.controller;

import com.reywong.tool.tagui.business.framework.service.MenuInfoService;
import com.reywong.tool.tagui.business.framework.service.MenuRightService;
import com.reywong.tool.tagui.business.framework.service.MenuService;
import com.yxtc.framework.platform.pojo.framework.Menu;
import com.yxtc.framework.platform.pojo.framework.MenuInfo;
import com.yxtc.framework.platform.pojo.framework.MenuRight;
import com.yxtc.framework.platform.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
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
public class MenuInfoAction {
    private static final Logger logger =  LoggerFactory.getLogger(MenuInfoAction.class);
    @Autowired
    private MenuService menuService;
    @Autowired
    private MenuInfoService menuInfoService;
    @Autowired
    private MenuRightService menuRightService;

    /**
     * 获得一级目录列表
     *
     *
     *
     * @return
     */
    public List getMenu(Menu menu) {
        return menuService.getMenu(menu);
    }

    /**
     * 添加或更新一级目录
     *
     * @param menu
     * @param flag
     * @return
     */

    public List updateMenu(Menu menu, String flag) {
        if (StringUtils.isNotBlank(flag)) {
            //通id获取信息
            if (flag.equals("0")) {
                menuService.insertSelective(menu);
            } else if (flag.equals("1")) {
                menuService.updateByPrimaryKeySelective(menu);
            }
        }
        return null;
    }

    /**
     * 删除一级目录
     *
     * @param map
     * @return
     */
    public List delMenu(Map map) {
        String id = (String) map.get("id");
        if (StringUtils.isNotBlank(id)) {
            int id_int = Integer.valueOf(id);
            menuService.deleteByPrimaryKey(id_int);
            menuRightService.deleteByMenuId(id);
        }
        return null;
    }

    /**
     * 查询 二级目录
     *
     * @param menuInfo
     * @return
     */
    public List getMenuInfo(MenuInfo menuInfo) {
        List result = new ArrayList();
        result = menuInfoService.select(menuInfo);
        return result;
    }


    /**
     * 修改二级目录信息
     *
     * @param menuinfo
     * @param flag
     * @return
     */
    public void updateMenuInfo(MenuInfo menuinfo, String flag) {
        if (StringUtils.isNotBlank(flag)) {
            if (flag.equals("0")) {
                menuInfoService.insertSelective(menuinfo);
            } else if (flag.equals("1")) {
                menuInfoService.updateByPrimaryKeySelective(menuinfo);
            }
        }
    }

    /**
     * 删除二级目录信息
     *
     * @param map
     * @return
     */

    public void delMenuInfo(Map map) {
        String id = (String) map.get("id");
        if (StringUtils.isNotBlank(id)) {
            menuInfoService.delete(Integer.valueOf(id));
            //删除目录相关的角色
            MenuRight menuRight = new MenuRight();
            menuRight.setMenuinfoid(id);
            menuRightService.deleteByMenuInfoId(id);
        }
    }
}
