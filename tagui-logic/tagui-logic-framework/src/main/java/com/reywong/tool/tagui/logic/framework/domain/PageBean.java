package com.reywong.tool.tagui.logic.framework.domain;

/**
 * Created by zhangyajun on 2016/4/1.
 */
public class PageBean {
    /**
     "total":2,"page":1,"records":13,"rows":
     */

    /**
     * 当前页
     */
    private Integer page;
    /**
     * 每页显示的记录条数
     */
    private Integer rows;
    /**
     * 总页数
     */
    private Integer total;
    /**
     * 总记录条数
     */
    private Integer records;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        //默认10
        if(rows==null){
            rows=10;
        }
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getTotal() {
        if(records==null){
            records=0;
        }
        if (records % getRows() == 0) {
            total = records / getRows();
        } else {
            total = records / getRows() + 1;
        }
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getRecords() {
        return records;
    }

    public void setRecords(Integer records) {
        this.records = records;
    }
}
