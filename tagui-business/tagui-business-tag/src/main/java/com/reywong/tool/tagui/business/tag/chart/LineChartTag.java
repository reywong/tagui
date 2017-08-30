package com.reywong.tool.tagui.business.tag.chart;

import com.alibaba.fastjson.JSON;
import com.reywong.tool.tagui.business.bean.chart.ChartBean;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.*;

public class LineChartTag extends TagSupport {
    private String id;
    private String height;
    private String json;
    private String datasetFill;


    public int doStartTag() {
        JspWriter out = this.pageContext.getOut();
        try {
            StringBuffer html = new StringBuffer();
            if (id == null || id.trim().equals("")) {
                id = "tagUI_lineChart" + new Date().getTime();
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
                Map lineData = new HashMap();
                Map lineOptions = new HashMap();

                lineData.put("labels", chartBean.getLabels());

                List datasets = new ArrayList();
                List<Map<String, Integer[]>> datas = chartBean.getDatas();
                if (datas != null) {
                    for (int i = 0; i < datas.size(); i++) {
                        Map<String, Integer[]> mapSet = datas.get(i);
                        Map dataset = new HashMap();
                        for (String key : mapSet.keySet()) {
                            dataset.put("label", key);
                            dataset.put("fillColor", "rgba(" + colors[i % colors.length] + ",0.5)");
                            dataset.put("strokeColor", "rgba(" + colors[i % colors.length] + ",1)");
                            dataset.put("pointColor", "rgba(" + colors[i % colors.length] + ",1)");
                            dataset.put("pointStrokeColor", "#fff");
                            dataset.put("pointHighlightFill", "#fff");
                            dataset.put("pointHighlightStroke", "rgba(" + colors[i % colors.length] + ",1)");
                            dataset.put("data", mapSet.get(key));
                        }
                        datasets.add(dataset);
                    }
                }

                lineData.put("datasets", datasets);
                //lineOptions
                lineOptions.put("scaleShowGridLines", true);
                lineOptions.put("scaleGridLineColor", "rgba(0,0,0,.05)");
                lineOptions.put("scaleGridLineWidth", 1);
                lineOptions.put("bezierCurve", true);
                lineOptions.put("bezierCurveTension", 0.4);
                lineOptions.put("pointDot", true);
                lineOptions.put("pointDotRadius", 4);
                lineOptions.put("pointDotStrokeWidth", 1);
                lineOptions.put("pointHitDetectionRadius", 20);
                lineOptions.put("datasetStroke", true);
                lineOptions.put("datasetStrokeWidth", 2);
                if (datasetFill == null || datasetFill.trim().equals("")) {
                    lineOptions.put("datasetFill", false);
                } else {
                    lineOptions.put("datasetFill", true);
                }
                lineOptions.put("responsive", true);

                html.append("<script type=\"application/javascript\">");
                html.append("function linechart_" + id + "() {\n");
                html.append("var lineData_" + id + "=" + JSON.toJSONString(lineData) + "; \n ");
                html.append("var lineOptions_" + id + " = " + JSON.toJSONString(lineOptions) + ";\n ");
                html.append("var ctx_" + id + " = document.getElementById(\"" + id + "\").getContext(\"2d\");\n");
                html.append("new Chart(ctx_" + id + ").Line(lineData_" + id + ", lineOptions_" + id + ");\n");
                html.append("}\n");
                html.append("$(function () {\n");
                html.append("linechart_" + id + "();\n");
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

    public String getDatasetFill() {
        return datasetFill;
    }

    public void setDatasetFill(String datasetFill) {
        this.datasetFill = datasetFill;
    }
}
