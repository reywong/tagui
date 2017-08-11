package com.reywong.tool.tagui.business.framework.service;

import com.yxtc.framework.platform.pojo.framework.RoleInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangrui on 2016/3/21.
 */
@Component(value = "roleInfoService")
public class RoleInfoService {
    private final static Logger logger = LoggerFactory.getLogger(RoleInfoService.class);
    @Autowired
    private RoleInfoMapper roleInfoMapper;

    /**
     * 获取role信息
     *
     * @param roleInfo
     * @return
     */
    public List<RoleInfo> select(RoleInfo roleInfo) {
        List<RoleInfo> result = null;
        try {
            result = new ArrayList<RoleInfo>();
            result = roleInfoMapper.selectByRole(roleInfo);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        return result;
    }
    /**
     * 获取总记录条数
     *
     * @param roleInfo
     * @return
     */
    public int selectMaxNum(RoleInfo roleInfo) {
        return  roleInfoMapper.selectMaxNum(roleInfo);
    }




    /**
     * 选择插入数据库
     *
     * @param roleInfo
     * @return
     */
    public int insertSelective(RoleInfo roleInfo) {
        int result = 0;
        result = roleInfoMapper.insertSelective(roleInfo);
        return result;
    }


    /**
     * 更新角色信息
     *
     * @param roleInfo
     * @return
     */
    public int updateByPrimaryKeySelective(RoleInfo roleInfo) {
        int result = 0;
        result = roleInfoMapper.updateByPrimaryKeySelective(roleInfo);
        return result;
    }


    /**
     * 删除角色信息
     *
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(int id) {
        return roleInfoMapper.deleteByPrimaryKey(id);
    }
}
