package com.reywong.tool.tagui.business.tag.chart;

import com.alibaba.fastjson.JSON;
import com.reywong.tool.tagui.business.bean.chart.ChartBean;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.*;

public class BarChartTag extends TagSupport {
    private String id;
    private String height;
    private String json;


    public int doStartTag() {
        JspWriter out = this.pageContext.getOut();
        try {
            StringBuffer html = new StringBuffer();
            if (id == null || id.trim().equals("")) {
                id = "tagUI_barChart" + new Date().getTime();
            }
            if (height == null || height.trim().equals("")) {
                height = "140";
            }
            //添加控件
            html.append("<div>\n" +
                    "<canvas id=\"" + id + "\" height=\"" + height + "\"></canvas>\n" +
                    "</div>\n");
            String[] colors = {"220,220,220", "26,179,148"};
            //添加数据
            if (json != null && !json.trim().equals("")) {
                ChartBean chartBean = JSON.parseObject(json, ChartBean.class);
                Map barData = new HashMap();
                Map barOptions = new HashMap();

                barData.put("labels", chartBean.getLabels());

                List datasets = new ArrayList();
                List<Map<String, Integer[]>> datas = chartBean.getDatas();
                if (datas != null) {
                    for (int i = 0; i < datas.size(); i++) {
                        Map<String, Integer[]> mapSet = datas.get(i);
                        Map dataset = new HashMap();
                        for (String key : mapSet.keySet()) {
                            dataset.put("label", key);
                            dataset.put("fillColor", "rgba(" + colors[i % colors.length] + ",0.5)");
                            dataset.put("strokeColor", "rgba(" + colors[i % colors.length] + ",0.8)");
                            dataset.put("highlightFill", "rgba(" + colors[i % colors.length] + ",0.75)");
                            dataset.put("highlightStroke", "rgba(" + colors[i % colors.length] + ",1)");
                            dataset.put("data", mapSet.get(key));
                        }
                        datasets.add(dataset);
                    }
                }

                barData.put("datasets", datasets);
                //barOptions
                barOptions.put("scaleBeginAtZero", true);
                barOptions.put("scaleShowGridLines", true);
                barOptions.put("scaleGridLineColor", "rgba(0,0,0,.05)");
                barOptions.put("scaleGridLineWidth", 1);
                barOptions.put("barShowStroke", true);
                barOptions.put("barStrokeWidth", 2);
                barOptions.put("barValueSpacing", 5);
                barOptions.put("barDatasetSpacing", 1);
                barOptions.put("responsive", true);

                html.append("<script type=\"application/javascript\">");
                html.append("function barchart_" + id + "() {\n");
                html.append("var barData_" + id + "=" + JSON.toJSONString(barData) + "; \n ");
                html.append("var barOptions_" + id + " = " + JSON.toJSONString(barOptions) + ";\n ");
                html.append("var ctx_" + id + " = document.getElementById(\"" + id + "\").getContext(\"2d\");\n");
                html.append("new Chart(ctx_" + id + ").Bar(barData_" + id + ", barOptions_" + id + ");\n");
                html.append("}\n");
                html.append("$(function () {\n");
                html.append("barchart_" + id + "();\n");
                html.append(" })\n");
                html.append("</script>");
            }
            out.println(html);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        return SKIP_BODY;

    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

}
