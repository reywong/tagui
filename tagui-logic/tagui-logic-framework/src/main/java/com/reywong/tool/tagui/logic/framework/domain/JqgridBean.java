package com.reywong.tool.tagui.logic.framework.domain;

/**
 * Created by Administrator on 2016/4/2.
 * Jqgrid响应结果实体类
 */
public class JqgridBean {
    private Integer page;
    private Integer total;
    private Integer records;
    private Object rows;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotal() {
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

    public Object getRows() {
        return rows;
    }

    public void setRows(Object rows) {
        this.rows = rows;
    }

    public JqgridBean() {
    }

    public JqgridBean(Integer page, Integer total, Integer records, Object rows) {
        this.page = page;
        this.total = total;
        this.records = records;
        this.rows = rows;
    }
}
