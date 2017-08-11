package com.reywong.tool.tagui.business.framework.service;

import com.yxtc.framework.platform.pojo.framework.MenuRight;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by wangrui on 2016/3/25.
 */
@Component(value = "menuRightService")
public class MenuRightService {
    private final static Logger logger = LoggerFactory.getLogger(MenuRightService.class);
    @Autowired
    private MenuRightMapper menuRightMapper;

    /**
     * 获取目录权限
     *
     * @param menuRight
     * @return
     */
    public List<MenuRight> getMenuRight(MenuRight menuRight) {
        return menuRightMapper.select(menuRight);

    }


    /**
     * 插入用户权限
     *
     * @param menuRight
     * @return
     */
    public int insertMenuRight(MenuRight menuRight) {
        return menuRightMapper.insertSelective(menuRight);
    }


    /**
     * 删除用户权限
     *
     * @param id
     * @return
     */
    public int deleteMenuRight(int id) {
        return menuRightMapper.deleteByPrimaryKey(id);
    }


    /**
     * 根据二级目录删除权限
     *
     * @param menuInfoId
     * @return
     */
    public int deleteByMenuInfoId(String menuInfoId) {
        return menuRightMapper.deleteByMenuInfoId(menuInfoId);
    }

    /**
     * 根据一级目录删除权限
     *
     * @param menuId
     * @return
     */
    public int deleteByMenuId(String menuId) {
        return menuRightMapper.deleteByMenuId(menuId);
    }


    /**
     * 判断目录是否存在
     *
     * @param userid
     * @param menuinfoid
     * @param righttype
     * @return
     */
    public boolean checkUserRight(String userid, String menuinfoid, String righttype) {
        boolean result = false;
        List<Map> rightList = menuRightMapper.getUserRight(userid);
        if (rightList != null && rightList.size() > 0) {
            for (int i = 0; i < rightList.size(); i++) {
                Map rightMap = rightList.get(i);
                String right_menuinfoid = (String) rightMap.get("menuinfoid");
                String right_righttype = (String) rightMap.get("righttype");
                if (menuinfoid.equals(right_menuinfoid) && righttype.equals(right_righttype)) {
                    result = true;
                    break;
                }

            }
        }
        return result;
    }
}
