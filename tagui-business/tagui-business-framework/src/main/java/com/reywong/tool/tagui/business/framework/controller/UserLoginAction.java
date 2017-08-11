package com.reywong.tool.tagui.business.framework.controller;

import com.reywong.tool.tagui.business.framework.service.UserInfoService;
import com.yxtc.framework.platform.pojo.ReturnInfoBean;
import com.yxtc.framework.platform.pojo.framework.UserInfo;
import com.yxtc.framework.platform.pojo.framework.UserInfoBean;
import com.yxtc.framework.platform.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: wangrui
 * Date: 13-10-23
 * Time: 上午9:38
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/userLoginAction")
public class UserLoginAction {
    private static final Logger logger = LoggerFactory.getLogger(UserLoginAction.class);
    @Autowired
    private UserInfoService userInfoService;

    /**
     * 返回登录页面
     *
     * @return
     */
    @RequestMapping("/toLogin")
    public String toLogin(HttpServletRequest request) {
        String result = "login";
        UserInfoBean userInfoBean = (UserInfoBean) request.getSession().getAttribute("userInfoBean");
        if (null != userInfoBean) {
            result = "index";

        }


        return result;
    }

    /**
     * 登陆
     *
     * @return
     */
    @RequestMapping("/login")
    public String login(String userId, String password, HttpServletRequest request, HttpServletResponse response, Map<Object, Object> map) {
        String result = "login";
        ReturnInfoBean returnInfoBean = new ReturnInfoBean();
        UserInfoBean userInfoBean = (UserInfoBean) request.getSession().getAttribute("userInfoBean");
        if (null == userInfoBean) {
            if (StringUtils.isBlank(userId)) {
                returnInfoBean.setFlag(false);
                returnInfoBean.setMessage("用户名不能为空");
            } else if (StringUtils.isBlank(password)) {
                returnInfoBean.setFlag(false);
                returnInfoBean.setMessage("密码不能为空");
            } else {
                returnInfoBean = userInfoService.login(userId, password);
                //如果登录正确
                if (returnInfoBean.isFlag()) {
//                构建session

                    buildUserInfoBean(request, userId);
//                创建用户名的cookie
                    Cookie cookie = new Cookie("userId", userId);
                    cookie.setPath("/");
                    cookie.setMaxAge(60 * 60 * 24 * 10);
                    String domainName = "";
                    if (StringUtils.isNotBlank(domainName)) {
                        cookie.setDomain(domainName);
                    }
//                将cookie响应到客户本地
                    response.addCookie(cookie);
                    //跳转到需要登录的页面
                    String url = (String) request.getSession().getAttribute("url");
                    if (url != null) {
                        result = "redirect:" + url;
                        request.getSession().removeAttribute("url");
                    } else {
                        result = "index";
                    }
                }
            }
            map.put("returnInfoBean", returnInfoBean);
        } else {
            result = "index";
        }
        return result;
    }

    /**
     * 获得目录列表
     *
     * @return
     */
    public List getUserRoleMenuList(List<Map> roleList) {
        List result = new ArrayList();
        List<String> roleIdList = new ArrayList();
        if (roleList != null) {
            for (int i = 0; i < roleList.size(); i++) {
                Map<String, String> roleMap = roleList.get(i);
                roleIdList.add(roleMap.get("roleid"));
            }
        }
        result = userInfoService.getUserRoleMenuList(roleIdList);
        return result;
    }


    /**
     * 获取userInfoBean
     *
     * @param request
     * @return
     */
    public UserInfoBean getUserInfoBean(HttpServletRequest request) {
        UserInfoBean userInfoBean = new UserInfoBean();
        String userId = getUserId(request);
        if (StringUtils.isNotBlank(userId)) {
            buildUserInfoBean(request, userId);
            HttpSession session = request.getSession();
            userInfoBean = session.getAttribute("userInfoBean") == null ? new UserInfoBean() : (UserInfoBean) session.getAttribute("userInfoBean");
        }
        return userInfoBean;
    }


    /**
     * 构建bean
     *
     * @param request
     * @param userid
     */
    public UserInfoBean buildUserInfoBean(HttpServletRequest request, String userid) {
        UserInfoBean userInfoBean = new UserInfoBean();
        HttpSession httpSession = request.getSession();
        //如果用户不存在，将cookie里面的用户填充
        if (StringUtils.isBlank(userid)) {
            userid = getUserId(request);
        }
        //如果用户存在
        if (StringUtils.isNotBlank(userid)) {

            //获得用户信息
            UserInfo userInfo = userInfoService.getUserInfo(userid);
            userInfoBean.setUserInfo(userInfo);
            //获得用户的权限
            List userRole = userInfoService.getUserRoleByUserId(userInfo.getUserid());
            //设置用户权限
            userInfoBean.setUserrole(userRole);
            List menuList = new ArrayList();
            if (userRole != null && userRole.size() > 0) {
                menuList = getUserRoleMenuList(userInfoBean.getUserrole());
            }
            userInfoBean.setMenuList(menuList);
            //将用户信息设置session中
            httpSession.setAttribute("userInfoBean", userInfoBean);
        }
        return userInfoBean;
    }

    /**
     * 获得cookie中的userId
     *
     * @param request 传入request对象
     * @return 返回sessionId
     */
    public String getUserId(HttpServletRequest request) {
        String result = "";
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if ("userId".equals(cookies[i].getName())) {
                    result = cookies[i].getValue();
                }
            }
        }
        return result;
    }

    /**
     * 检查用户
     *
     * @param userId
     * @param password
     * @return
     */

    public String checkUser(String userId, String password) {
        String result = "";
        //如果用户正确 returnInfoBean.isFlag=true   returnInfoBean.getMessage=用户id（实质就是用户名）
        //如果用户错误 returnInfoBean.isFlag=false   returnInfoBean.getMessage=错误信息或者reywong
        ReturnInfoBean returnInfoBean = userInfoService.login(userId, password);
        //如果用户登录正确，返回用户名，否则返回“”字符串
        if (returnInfoBean.isFlag()) {
            result = returnInfoBean.getMessage();
        }
        return result;
    }

    /**
     * 退出
     *
     * @return
     */
    @RequestMapping("/unLogin")
    public String unLogin(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("userId")) {
                    Cookie cookie = new Cookie(cookies[i].getName(), null);
                    cookie.setMaxAge(0);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                }
            }
        }
        HttpSession session = request.getSession();
        session.removeAttribute("userInfoBean");
        session.invalidate();
        return "login";
    }


    /**
     * 判断用户是否包含该角色
     *
     * @param roleList
     * @param roleId
     * @return
     */
    public boolean checkRole(List<Map> roleList, String roleId) {
        boolean result = false;
        if (roleList != null) {
            for (int i = 0; i < roleList.size(); i++) {
                Map<String, String> roleMap = roleList.get(i);
                String temp_roleId = roleMap.get("roleid");
                if (temp_roleId.equals(roleId)) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

}
