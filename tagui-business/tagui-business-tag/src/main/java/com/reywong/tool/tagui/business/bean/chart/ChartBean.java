package com.reywong.tool.tagui.business.bean.chart;

import java.util.List;

public class ChartBean {
    /**
     * x labels
     */
    private String[] labels;

    /**
     * string 为每组数据的label,Integer 为数据，与labels数量对应
     */
    private List<ChartSetBean> datas;

    public String[] getLabels() {
        return labels;
    }

    public void setLabels(String[] labels) {
        this.labels = labels;
    }

    public List<ChartSetBean> getDatas() {
        return datas;
    }

    public void setDatas(List<ChartSetBean> datas) {
        this.datas = datas;
    }
}
