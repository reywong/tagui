package com.reywong.tool.tagui.business.framework.service;

import com.yxtc.framework.platform.pojo.ReturnInfoBean;
import com.yxtc.framework.platform.pojo.framework.UserInfo;
import com.yxtc.framework.platform.pojo.framework.UserInfoKey;
import com.yxtc.framework.platform.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: wangrui
 * Date: 13-10-10
 * Time: 下午2:42
 * To change this template use File | Settings | File Templates.
 */
@Component(value = "userInfoService")
public class UserInfoService {
    private final static Logger logger = LoggerFactory.getLogger(UserInfoService.class);

    @Autowired
    private UserInfoMapper userInfoMapper;
    //日志记录工具

    /**
     * 登陆drp
     *
     * @param userid   用户id
     * @param password 密码
     * @return
     */
    public ReturnInfoBean login(String userid, String password) {
        ReturnInfoBean returnInfoBean = new ReturnInfoBean();
        if (StringUtils.isBlank(userid)) {
            returnInfoBean.setFlag(false);
            returnInfoBean.setMessage("用户id不能为空");
        } else if (StringUtils.isBlank(password)) {
            returnInfoBean.setFlag(false);
            returnInfoBean.setMessage("密码不能为空");
        } else {
            UserInfo userInfo = new UserInfo();
            userInfo.setUserid(userid);
            userInfo.setPassword(StringUtils.encryptMD5(password));
            List list = userInfoMapper.select(userInfo);
            if (list != null && list.size() > 0) {
                returnInfoBean.setFlag(true);
                returnInfoBean.setMessage("登录成功");
            } else {
                returnInfoBean.setFlag(false);
                returnInfoBean.setMessage("用户名或密码错误");
            }
        }
        return returnInfoBean;
    }

    /**
     * 根据用户名查询用户信息
     *
     * @param userid
     * @return
     */

    public UserInfo getUserInfo(String userid) {
        UserInfo result = new UserInfo();
        UserInfo userInfo = new UserInfo();
        userInfo.setUserid(userid);
        List<UserInfo> list = userInfoMapper.select(userInfo);
        if (list != null && list.size() > 0) {
            result = list.get(0);
        }
        return result;
    }


    /**
     * 获取用户角色列表
     *
     * @param userId
     * @return
     */
    public List<Map> getUserRoleByUserId(String userId) {
        return userInfoMapper.getUserRoleByUserId(userId);
    }

    /**
     * 根据用户角色获取目录列表
     *
     * @param roleIdList
     * @return
     */
    public List<Map> getUserRoleMenuList(List roleIdList) {
        return userInfoMapper.getUserRoleMenuList(roleIdList);
    }

    /**
     * 获取用户列表
     *
     * @param userInfo
     * @return
     */
    public List<UserInfo> getUserInfoList(UserInfo userInfo) {
        List<UserInfo> result = new ArrayList<UserInfo>();
        result = userInfoMapper.select(userInfo);
        return result;
    }

    /**
     * @param userInfo
     * @return
     */
    public int selectMaxNum(UserInfo userInfo) {
        return userInfoMapper.selectMaxNum(userInfo);
    }


    /**
     * 根据主键删除
     *
     * @param id
     * @return
     */
    public int deleteForId(int id) {
        UserInfoKey userInfoKey = new UserInfoKey();
        userInfoKey.setId(id);
        return userInfoMapper.deleteByPrimaryKey(userInfoKey);
    }

    /**
     * 根据条件插入
     *
     * @param userInfo
     * @return
     */
    public int insertSelective(UserInfo userInfo) {
        return userInfoMapper.insertSelective(userInfo);
    }

    /**
     * 根据主键id来更新
     *
     * @param userInfo
     * @return
     */
    public int updateSelective(UserInfo userInfo) {
        return userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }

    /**
     * 更新或插入用户信息
     *
     * @param userInfo
     * @return
     */
    public boolean insertOrUpdateUserInfo(UserInfo userInfo) {
        boolean result = false;
        int t = 0;
        String userId = userInfo.getUserid();
        if (StringUtils.isBlank(userId)) {
            UserInfo tempUserInfo = getUserInfo(userId);
            if (tempUserInfo != null && StringUtils.isNotBlank(tempUserInfo.getUserid())) {
                t = updateSelective(userInfo);
            } else {
                t = insertSelective(userInfo);
            }
        }
        if (t > 0) {
            result = true;
        }
        return result;
    }


}
