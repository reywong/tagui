package com.reywong.tool.tagui.business.framework.service;

import com.yxtc.framework.platform.pojo.ReturnInfoBean;
import com.yxtc.framework.platform.pojo.framework.Menu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wangrui on 2016/3/4.
 */
@Component(value = "menuService")
public class MenuService {
    private final static Logger logger = LoggerFactory.getLogger(MenuService.class);
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private MenuInfoMapper menuInfoMapper;

    /**
     * 查询一级目录
     *
     * @param menu
     * @return
     */
    public List<Menu> getMenu(Menu menu) {
        return menuMapper.select(menu);
    }

    /**
     * 插入一级目录
     *
     * @param menu
     * @return
     */
    public int insertSelective(Menu menu) {
        return menuMapper.insertSelective(menu);
    }

    /**
     * 更新一级目录
     *
     * @param menu
     * @return
     */
    public int updateByPrimaryKeySelective(Menu menu) {
        return menuMapper.updateByPrimaryKeySelective(menu);
    }

    /**
     * 删除一级目录
     *
     * @param id
     * @return
     */
    @Transactional
    public ReturnInfoBean deleteByPrimaryKey(int id) {
        ReturnInfoBean returnInfoBean = new ReturnInfoBean();
        menuMapper.deleteByPrimaryKey(id);
        menuInfoMapper.delete(String.valueOf(id));
        //TODO 删除用户权限

        return returnInfoBean;
    }
}
