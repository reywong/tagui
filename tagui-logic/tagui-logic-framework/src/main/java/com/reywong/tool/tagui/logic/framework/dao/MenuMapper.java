package com.reywong.tool.tagui.logic.framework.dao;

import com.reywong.tool.tagui.logic.framework.domain.framework.Menu;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "menuMapper")
public interface MenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    List<Menu> select(Menu menu);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
}