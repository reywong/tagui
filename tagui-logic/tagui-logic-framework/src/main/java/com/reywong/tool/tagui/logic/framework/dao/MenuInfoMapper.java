package com.reywong.tool.tagui.logic.framework.dao;

import com.reywong.tool.tagui.logic.framework.domain.framework.MenuInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "menuInfoMapper")
public interface MenuInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int delete(@Param(value = "menuid") String menuid);

    int insert(MenuInfo record);

    int insertSelective(MenuInfo record);

    MenuInfo selectByPrimaryKey(Integer id);

    List<MenuInfo> select(MenuInfo menuInfo);

    int updateByPrimaryKeySelective(MenuInfo record);

    int updateByPrimaryKey(MenuInfo record);
}