package com.reywong.tool.tagui.business.framework.service;

import com.yxtc.framework.platform.pojo.framework.UserRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by wangrui on 2016/3/24.
 */
@Component(value = "userRoleService")
public class UserRoleService {
    private final static Logger logger = LoggerFactory.getLogger(UserRoleService.class);
    @Autowired
    private UserRoleMapper userRoleMapper;

    /**
     * 获取用户角色信息
     *
     * @param userRole
     * @return
     */
    public List<UserRole> select(UserRole userRole) {
        return userRoleMapper.select(userRole);
    }

    /**
     * 插入用户角色
     *
     * @param userRole
     * @return
     */
    public int insertUserRole(UserRole userRole) {
        return userRoleMapper.insertSelective(userRole);
    }

    /**
     * 根据roleId获取用户列表
     *
     * @param map
     * @return
     */
    public List<Map> selectUserIdByRoleId(Map map) {
        return userRoleMapper.selectUserIdByRoleId(map);
    }

    /**
     * 删除用户角色
     *
     * @param userRole
     * @return
     */
    public int deleteUserRole(UserRole userRole) {
        return userRoleMapper.deleteByPrimaryKey(userRole.getId());
    }
}
