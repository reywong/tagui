package com.reywong.tool.tagui.business.tag.chart;

import com.alibaba.fastjson.JSON;
import com.reywong.tool.tagui.business.bean.chart.ChartBean;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.*;

public class RadarChartTag extends TagSupport {
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
            String[] colors = {"220,220,220", "26,179,148", "26,179,148", "151,187,205", ""};
            //添加数据
            if (json != null && !json.trim().equals("")) {
                ChartBean chartBean = JSON.parseObject(json, ChartBean.class);
                Map radarData = new HashMap();
                Map radarOptions = new HashMap();

                radarData.put("labels", chartBean.getLabels());

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

                radarData.put("datasets", datasets);
                //radarOptions
                radarOptions.put("scaleShowLine", true);
                radarOptions.put("angleShowLineOut", true);
                radarOptions.put("scaleBeginAtZero", true);
                radarOptions.put("angleLineColor", "rgba(0,0,0,.1)");
                radarOptions.put("angleLineWidth", 1);
                radarOptions.put("pointLabelFontFamily", "'Arial'");
                radarOptions.put("pointLabelFontStyle", "normal");
                radarOptions.put("pointLabelFontSize", 10);
                radarOptions.put("pointLabelFontColor", "#666");
                radarOptions.put("pointDot", true);
                radarOptions.put("pointDotRadius", 3);
                radarOptions.put("pointDotStrokeWidth", 1);
                radarOptions.put("pointHitDetectionRadius", 20);
                radarOptions.put("datasetStroke", true);
                radarOptions.put("datasetStrokeWidth", 2);
                if (datasetFill == null || datasetFill.trim().equals("")) {
                    radarOptions.put("datasetFill", false);
                } else {
                    radarOptions.put("datasetFill", true);
                }
                radarOptions.put("responsive", true);

                html.append("<script type=\"application/javascript\">");
                html.append("function radarchart_" + id + "() {\n");
                html.append("var radarData_" + id + "=" + JSON.toJSONString(radarData) + "; \n ");
                html.append("var radarOptions_" + id + " = " + JSON.toJSONString(radarOptions) + ";\n ");
                html.append("var ctx_" + id + " = document.getElementById(\"" + id + "\").getContext(\"2d\");\n");
                html.append("new Chart(ctx_" + id + ").Radar(radarData_" + id + ", radarOptions_" + id + ");\n");
                html.append("}\n");
                html.append("$(function () {\n");
                html.append("radarchart_" + id + "();\n");
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
