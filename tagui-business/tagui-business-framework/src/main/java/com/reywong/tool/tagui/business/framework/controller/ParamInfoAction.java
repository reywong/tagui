package com.reywong.tool.tagui.business.framework.controller;

import com.reywong.tool.tagui.business.framework.service.ParamInfoService;
import com.yxtc.framework.platform.pojo.JqgridBean;
import com.yxtc.framework.platform.pojo.PageBean;
import com.yxtc.framework.platform.pojo.ReturnInfoBean;
import com.yxtc.framework.platform.pojo.framework.ParamInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by wangrui on 2016/3/25.
 */
@Controller
@RequestMapping("/paramInfoAction")
public class ParamInfoAction {
    private final Logger logger = LoggerFactory.getLogger(ParamInfoAction.class);
    @Autowired
    private ParamInfoService paramInfoService;
    /**
     * 根据参数类型id获取参数列表
     *
     * @param map
     * @return
     */
    public List getParamInfo(Map map) {
        String paramtypeid = (String) map.get("paramtypeid");
        return paramInfoService.getParamInfoByParamTypeId(paramtypeid);
    }

    @RequestMapping("/getMap")
    @ResponseBody
    public JqgridBean getMap(ParamInfo paramInfo, PageBean pageBean) throws IOException {
        if (pageBean != null && pageBean.getPage() != null) {
            paramInfo.setStartNum(String.valueOf((pageBean.getPage() - 1) * pageBean.getRows()));
            paramInfo.setRows(String.valueOf(pageBean.getRows()));
        }
        List<ParamInfo> list = paramInfoService.getParamInfoList(paramInfo);
        pageBean.setRecords(paramInfoService.selectMaxNum(paramInfo));
        return new JqgridBean(pageBean.getPage(), pageBean.getTotal(), pageBean.getRecords(), list);
    }

    @RequestMapping("/updateMap")
    @ResponseBody
    public ReturnInfoBean updateMap(ParamInfo paramInfo) {
        //默认执行失败
        ReturnInfoBean returnInfoBean = new ReturnInfoBean(ReturnInfoBean.ERROR, "执行失败");
        //执行的sql结果  默认为0
        Integer sqlResult = 0;
        if (paramInfo != null) {
            if (paramInfo.getOper() != null && paramInfo.getOper().equals("add")) { //如果执行添加操作
                sqlResult = paramInfoService.insert(paramInfo);
            } else if (paramInfo.getOper() != null && paramInfo.getOper().equals("del")) { //如果执行删除操作
                sqlResult = paramInfoService.delete(paramInfo);
            } else if (paramInfo.getOper() != null && paramInfo.getOper().equals("edit")) { //如果执行更新操作
                paramInfo.setUpdatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                sqlResult = paramInfoService.update(paramInfo);
            }
        }
        if (sqlResult > 0) {
            returnInfoBean.setResult(ReturnInfoBean.SUCCESS);
            returnInfoBean.setMessage("执行成功");
        }
        return returnInfoBean;

    }
}
