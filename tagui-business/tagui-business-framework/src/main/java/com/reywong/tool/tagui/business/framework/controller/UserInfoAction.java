package com.reywong.tool.tagui.business.framework.controller;

import com.reywong.tool.tagui.business.framework.service.UserInfoService;
import com.yxtc.framework.platform.pojo.JqgridBean;
import com.yxtc.framework.platform.pojo.PageBean;
import com.yxtc.framework.platform.pojo.framework.UserInfo;
import com.yxtc.framework.platform.util.DataTypeChangeTool;
import com.yxtc.framework.platform.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: wangrui
 * Date: 13-10-11
 * Time: 下午4:43
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/userInfoAction")
public class UserInfoAction {
    //日志记录工具
    private final Logger logger = LoggerFactory.getLogger(UserInfoAction.class);
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private UserLoginAction userLoginAction;

    @RequestMapping("/usermanager")
    public String userInfo() {
        String result = "usermanager";
        return result;
    }

    @RequestMapping("/getMap")
    @ResponseBody
    public JqgridBean getMap(UserInfo userInfo, PageBean pageBean) throws IOException {
        if (pageBean != null && pageBean.getPage() != null) {
            userInfo.setStartNum(String.valueOf((pageBean.getPage() - 1) * pageBean.getRows()));
            userInfo.setRows(String.valueOf(pageBean.getRows()));
        }
        List<UserInfo> list = userInfoService.getUserInfoList(userInfo);
        pageBean.setRecords(userInfoService.selectMaxNum(userInfo));
        return new JqgridBean(pageBean.getPage(), pageBean.getTotal(), pageBean.getRecords(), list);
    }

    /**
     * @param userInfo
     * @return
     */
    public List<UserInfo> getUserInfo(UserInfo userInfo) {
        return userInfoService.getUserInfoList(userInfo);
    }


    @RequestMapping("/updateMap")
    public void updateMap(HttpServletRequest request, HttpServletResponse response) {
        //oper 操作方式
        //edit  add    del  id
        Map resultMap = new HashMap();
        Map paramMap = request.getParameterMap();

        //判断执行方法 数据格式   key:object[]
        String oper = ((String[]) paramMap.get("oper"))[0];
        if (StringUtils.isNotBlank(oper)) {
            int t = 0;
            UserInfo userInfo = new UserInfo();
            if (oper.equals("add")) {
                String userid = ((String[]) paramMap.get("userid"))[0];
                String username = ((String[]) paramMap.get("username"))[0];
                String usertype = ((String[]) paramMap.get("usertypename"))[0];
                String email = ((String[]) paramMap.get("email"))[0];
                String telphone = ((String[]) paramMap.get("telphone"))[0];
                String createtime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                userInfo.setUserid(userid);
                userInfo.setUsername(username);
                userInfo.setPassword(StringUtils.encryptMD5("yxtc"));
                userInfo.setEmail(email);
                userInfo.setTelphone(telphone);
                userInfo.setUsertype(usertype);
                userInfo.setCreatepersonid(userLoginAction.getUserId(request));
                userInfo.setCreatetime(createtime);
                t = userInfoService.insertSelective(userInfo);
                if (t > 0) {
                    resultMap.put("flag", "1");
                    resultMap.put("message", "插入成功");
                } else {
                    resultMap.put("flag", "1");
                    resultMap.put("message", "插入失败");
                }
            } else if (oper.equals("del")) {
                int id = Integer.valueOf(((String[]) paramMap.get("id"))[0]);
                t = userInfoService.deleteForId(id);
                if (t > 0) {
                    resultMap.put("flag", "1");
                    resultMap.put("message", "删除成功");
                } else {
                    resultMap.put("flag", "1");
                    resultMap.put("message", "删除失败");
                }
            } else if (oper.equals("edit")) {
                String id = ((String[]) paramMap.get("id"))[0];
                String username = ((String[]) paramMap.get("username"))[0];
                String usertype = ((String[]) paramMap.get("usertypename"))[0];
                String email = ((String[]) paramMap.get("email"))[0];
                String telphone = ((String[]) paramMap.get("telphone"))[0];
                String updatetime = new SimpleDateFormat("yyyy-dd-MM HH:mm:ss").format(new Date());
                userInfo.setId(Integer.valueOf(id));
                userInfo.setUsername(username);
                userInfo.setEmail(email);
                userInfo.setTelphone(telphone);
                userInfo.setUsertype(usertype);
                userInfo.setCreatepersonid(userLoginAction.getUserId(request));
                userInfo.setUpdatetime(updatetime);
                t = userInfoService.updateSelective(userInfo);
                if (t > 0) {
                    resultMap.put("flag", "1");
                    resultMap.put("message", "修改成功");
                } else {
                    resultMap.put("flag", "1");
                    resultMap.put("message", "修改失败");
                }
            }
        }
        try {
            response.getWriter().write(DataTypeChangeTool.mapToJson(resultMap));
        } catch (IOException e) {
            logger.error("异常",e);
        }
    }

    @RequestMapping("/getUserType")
    @ResponseBody
    public void getUserType(){


    }
}
