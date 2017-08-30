package com.reywong.tool.tagui.business.bean.chart;

import java.util.List;
import java.util.Map;

public class ChartBean {
    /**
     * x labels
     */
    private String[] labels;

    /**
     * string 为每组数据的label,Integer 为数据，与labels数量对应
     */
    private List<Map<String, Integer[]>> datas;

    public String[] getLabels() {
        return labels;
    }

    public void setLabels(String[] labels) {
        this.labels = labels;
    }

    public List<Map<String, Integer[]>> getDatas() {
        return datas;
    }

    public void setDatas(List<Map<String, Integer[]>> datas) {
        this.datas = datas;
    }
}
