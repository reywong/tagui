package com.reywong.tool.tagui.logic.framework.dao;

import com.yxtc.framework.platform.pojo.framework.UserInfo;
import com.yxtc.framework.platform.pojo.framework.UserInfoKey;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component(value = "userInfoMapper")
public interface UserInfoMapper {
    int deleteByPrimaryKey(UserInfoKey key);

    int insert(UserInfo userInfo);

    int insertSelective(UserInfo userInfo);

    List<UserInfo> select(UserInfo userinfo);

    List<Map> getUserRoleByUserId(@Param(value = "userId") String userId);

    List<Map> getUserRoleMenuList(@Param(value = "roleIdList") List roleIdList);

    int selectMaxNum(UserInfo userInfo);

    int updateByPrimaryKeySelective(UserInfo userInfo);

    int updateByPrimaryKey(UserInfo record);
}