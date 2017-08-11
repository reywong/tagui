package com.reywong.tool.tagui.logic.framework.dao;

import com.yxtc.framework.platform.pojo.framework.MenuRight;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component(value = "menuRightMapper")
public interface MenuRightMapper {
    int deleteByPrimaryKey(Integer id);

    int deleteByMenuInfoId(String menuInfoId);

    int deleteByMenuId(String menuId);

    int insert(MenuRight record);

    int insertSelective(MenuRight record);

    MenuRight selectByPrimaryKey(Integer id);

    List<MenuRight> select(MenuRight menuRight);

    int updateByPrimaryKeySelective(MenuRight record);

    int updateByPrimaryKey(MenuRight record);

    List<Map> getUserRight(@Param(value = "userid") String userid);
}