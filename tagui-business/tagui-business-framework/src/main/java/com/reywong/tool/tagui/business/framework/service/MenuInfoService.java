package com.reywong.tool.tagui.business.framework.service;

import com.yxtc.framework.platform.pojo.framework.MenuInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by wangrui on 2016/3/21.
 */
@Component(value = "menuInfoService")
public class MenuInfoService {
    private final static Logger logger = LoggerFactory.getLogger(MenuInfoService.class);
    @Autowired
    private MenuInfoMapper menuInfoMapper;

    /**
     * 插入二级目录
     *
     * @param menuInfo
     * @return
     */
    public int insertSelective(MenuInfo menuInfo) {
        return menuInfoMapper.insertSelective(menuInfo);
    }

    /**
     * 根据主键更新二级目录
     *
     * @param menuInfo
     * @return
     */
    public int updateByPrimaryKeySelective(MenuInfo menuInfo) {
        return menuInfoMapper.updateByPrimaryKeySelective(menuInfo);
    }

    /**
     * 查询二级目录
     *
     * @param menuInfo
     * @return
     */
    public List<MenuInfo> select(MenuInfo menuInfo) {
        return menuInfoMapper.select(menuInfo);
    }

    /**
     * 删除二级目录
     *
     * @param id
     * @return
     */
    public int delete(int id) {
        return menuInfoMapper.deleteByPrimaryKey(id);
    }

}

