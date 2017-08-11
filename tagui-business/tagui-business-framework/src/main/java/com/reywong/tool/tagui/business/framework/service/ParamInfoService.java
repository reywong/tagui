package com.reywong.tool.tagui.business.framework.service;

import com.yxtc.framework.platform.pojo.framework.ParamInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by wangrui on 2016/3/25.
 */
@Component(value = "paramInfoService")
public class ParamInfoService {
    private final static Logger logger = LoggerFactory.getLogger(ParamInfoService.class);
    @Autowired
    private ParamInfoMapper paramInfoMapper;

    /**
     * 根据参数类型id获取参数列表
     *
     * @param paramtypeid
     * @return
     */
    public List<ParamInfo> getParamInfoByParamTypeId(String paramtypeid) {
        return paramInfoMapper.getParamInfoByParamTypeId(paramtypeid);
    }

    public Integer selectMaxNum(ParamInfo paramInfo){
        return paramInfoMapper.selectMaxNum(paramInfo);
    }

    /**
     * 根据对象查询参数列表
     * @param paramInfo
     * @return
     */
    public List<ParamInfo> getParamInfoList(ParamInfo paramInfo) {
        return paramInfoMapper.select(paramInfo);
    }

    /**
     * 保存
     * @param paramInfo
     * @return
     */
    public Integer insert(ParamInfo paramInfo){
        paramInfo.setCreatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        paramInfo.setState("1");
        return paramInfoMapper.insert(paramInfo);
    }
    /**
     * 删除
     * @param paramInfo
     * @return
     */
    public Integer delete(ParamInfo paramInfo){
        if(paramInfo.getId()==null){
          return 0;
        }else{
            return paramInfoMapper.deleteByPrimaryKey(paramInfo.getId());

        }
    }
    /**
     * 更新
     * @param paramInfo
     * @return
     */
    public Integer update(ParamInfo paramInfo){
        return paramInfoMapper.updateByPrimaryKeySelective(paramInfo);
    }



}
