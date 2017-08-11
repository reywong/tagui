package com.reywong.tool.tagui.business.framework.controller;

import com.reywong.tool.tagui.business.framework.service.RoleInfoService;
import com.yxtc.framework.platform.pojo.JqgridBean;
import com.yxtc.framework.platform.pojo.PageBean;
import com.yxtc.framework.platform.pojo.framework.RoleInfo;
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
 * Date: 13-10-17
 * Time: 上午9:30
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/roleInfoAction")
public class RoleInfoAction {
    private static final Logger logger = LoggerFactory.getLogger(RoleInfoAction.class);
    @Autowired
    private RoleInfoService roleInfoService;

    @RequestMapping("/getMap")
    @ResponseBody
    public JqgridBean getMap(RoleInfo roleInfo, PageBean pageBean) {
        if(pageBean!=null&&pageBean.getPage()!=null){
            roleInfo.setStartNum(String.valueOf((pageBean.getPage() - 1) * pageBean.getRows()));
            roleInfo.setRows(String.valueOf(pageBean.getRows()));
        }
        List<RoleInfo> list = roleInfoService.select(roleInfo);
        pageBean.setRecords(roleInfoService.selectMaxNum(roleInfo));
        return new JqgridBean(pageBean.getPage(), pageBean.getTotal(),pageBean.getRecords(),list);
    }

    /**
     * DWR获取角色信息
     *
     * @param roleInfo
     * @return
     */
    public List getRoleInfo(RoleInfo roleInfo) {
        return roleInfoService.select(roleInfo);
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
            RoleInfo roleInfo = new RoleInfo();
            if (oper.equals("add")) {
                String rolename = ((String[]) paramMap.get("rolename"))[0];
                String describes = ((String[]) paramMap.get("describes"))[0];
                String createtime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                roleInfo.setRolename(rolename);
                roleInfo.setDescribes(describes);
                roleInfo.setCreatedatetime(createtime);
                t = roleInfoService.insertSelective(roleInfo);
                if (t > 0) {
                    resultMap.put("flag", "1");
                    resultMap.put("message", "插入成功");
                } else {
                    resultMap.put("flag", "1");
                    resultMap.put("message", "插入失败");
                }
            } else if (oper.equals("del")) {
                int id = Integer.valueOf(((String[]) paramMap.get("id"))[0]);
                t = roleInfoService.deleteByPrimaryKey(id);
                if (t > 0) {
                    resultMap.put("flag", "1");
                    resultMap.put("message", "删除成功");
                } else {
                    resultMap.put("flag", "1");
                    resultMap.put("message", "删除失败");
                }
            } else if (oper.equals("edit")) {
                String id = ((String[]) paramMap.get("id"))[0];
                String rolename = ((String[]) paramMap.get("rolename"))[0];
                String describes = ((String[]) paramMap.get("describes"))[0];
                String updatetime = new SimpleDateFormat("yyyy-dd-MM HH:mm:ss").format(new Date());
                roleInfo.setId(Integer.valueOf(id));
                roleInfo.setRolename(rolename);
                roleInfo.setDescribes(describes);
                roleInfo.setUpdatedatetime(updatetime);
                t = roleInfoService.updateByPrimaryKeySelective(roleInfo);
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

}
