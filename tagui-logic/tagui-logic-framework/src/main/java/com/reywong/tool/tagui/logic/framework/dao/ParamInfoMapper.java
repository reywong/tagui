package com.reywong.tool.tagui.logic.framework.dao;

import com.reywong.tool.tagui.logic.framework.domain.framework.ParamInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "paramInfoMapper")
public interface ParamInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ParamInfo record);

    int insertSelective(ParamInfo record);

    ParamInfo selectByPrimaryKey(Integer id);

    List<ParamInfo> getParamInfoByParamTypeId(@Param(value = "paramtypeid") String paramtypeid);

    int updateByPrimaryKeySelective(ParamInfo record);

    int updateByPrimaryKey(ParamInfo record);

    List<ParamInfo> select(ParamInfo paramInfo);

    Integer selectMaxNum(ParamInfo paramInfo);
}