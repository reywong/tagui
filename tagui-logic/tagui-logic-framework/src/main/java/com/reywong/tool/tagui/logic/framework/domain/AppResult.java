package com.reywong.tool.tagui.logic.framework.domain;

/**
 * Created by Administrator on 2016/4/6.
 * app响应对象
 */
public class AppResult {
     //是否成功标志  false=不成功  true=成功
     private Boolean success;
    //响应消息
     private String msg;
    //响应数据
     private Object datas;

    public AppResult(Boolean success, String msg, Object datas) {
        this.success = success;
        this.msg = msg;
        this.datas = datas;
    }

    public AppResult(Boolean success, Object datas) {
        this.success = success;
        this.datas = datas;
    }

    public AppResult(Boolean success, String msg) {

        this.success = success;
        this.msg = msg;
    }

    public AppResult(Object datas) {

        this.datas = datas;
    }

    public AppResult(String msg) {

        this.msg = msg;
    }

    public AppResult(Boolean success) {

        this.success = success;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getDatas() {
        return datas;
    }

    public void setDatas(Object datas) {
        this.datas = datas;
    }

    public AppResult() {
    }

}
