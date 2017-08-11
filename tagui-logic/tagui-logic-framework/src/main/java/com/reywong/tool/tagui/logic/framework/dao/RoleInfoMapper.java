package com.reywong.tool.tagui.logic.framework.dao;

import com.reywong.tool.tagui.logic.framework.domain.framework.RoleInfo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "roleInfoMapper")
public interface RoleInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RoleInfo record);

    int insertSelective(RoleInfo record);

    List<RoleInfo> selectByRole(RoleInfo record);

    RoleInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoleInfo record);

    int updateByPrimaryKey(RoleInfo record);

    int selectMaxNum(RoleInfo record);
}