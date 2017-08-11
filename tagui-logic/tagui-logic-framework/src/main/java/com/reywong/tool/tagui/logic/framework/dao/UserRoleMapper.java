package com.reywong.tool.tagui.logic.framework.dao;

import com.yxtc.framework.platform.pojo.framework.UserRole;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component(value = "userRoleMapper")
public interface UserRoleMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Integer id);

    List<UserRole> select(UserRole userRole);

    List<Map> selectUserIdByRoleId(Map map);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);
}