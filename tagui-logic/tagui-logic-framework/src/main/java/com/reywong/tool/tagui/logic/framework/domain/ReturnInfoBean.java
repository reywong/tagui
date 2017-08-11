package com.reywong.tool.tagui.logic.framework.domain;

/**
 * Created by wangrui on 2016/3/2.
 */
public class ReturnInfoBean {
    public static final String SUCCESS="success";
    public static final String ERROR="error";

    //返回标志
    boolean flag;
    //返回信息
    String message;
    // 响应结果 success=成功 error=异常
    private String result;
    //响应的实体数据
    private Object data;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public ReturnInfoBean(String message, String result) {
        this.message = message;
        this.result = result;
    }

    public ReturnInfoBean(boolean flag, String message, String result, Object data) {
        this.flag = flag;
        this.message = message;
        this.result = result;
        this.data = data;
    }

    //返回的数据
    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }






    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ReturnInfoBean(String message, boolean flag) {
        this.message = message;
        this.flag = flag;
    }

    public ReturnInfoBean(boolean flag) {
        this.flag = flag;
    }

    public ReturnInfoBean() {
    }

    public ReturnInfoBean(Object data, boolean flag, String message) {
        this.data = data;
        this.flag = flag;
        this.message = message;
    }
}
