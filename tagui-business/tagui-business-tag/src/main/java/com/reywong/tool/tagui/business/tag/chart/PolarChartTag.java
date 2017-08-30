package com.reywong.tool.tagui.business.tag.chart;

import com.alibaba.fastjson.JSON;
import com.reywong.tool.tagui.business.bean.chart.ChartBean;
import com.reywong.tool.tagui.business.bean.chart.PolarCharSet;
import com.reywong.tool.tagui.business.bean.chart.PolarChartBean;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.*;

public class PolarChartTag extends TagSupport {
    private String id;
    private String height;
    private String json;


    public int doStartTag() {
        JspWriter out = this.pageContext.getOut();
        try {
            StringBuffer html = new StringBuffer();
            if (id == null || id.trim().equals("")) {
                id = "tagUI_polarChart" + new Date().getTime();
            }
            if (height == null || height.trim().equals("")) {
                height = "140";
            }
            //添加控件
            html.append("<div>\n" +
                    "<canvas id=\"" + id + "\" height=\"" + height + "\"></canvas>\n" +
                    "</div>\n");
            String[] colors = {"#a3e1d4", "#dedede", "#b5b8cf"};
            //添加数据
            if (json != null && !json.trim().equals("")) {
                PolarChartBean polarChartBean = JSON.parseObject(json, PolarChartBean.class);
                Map polarOptions = new HashMap();

                List polarData = new ArrayList();
                List<PolarCharSet> datas = polarChartBean.getDatas();
                if (datas != null) {
                    for (int i = 0; i < datas.size(); i++) {
                        PolarCharSet polarCharSet = datas.get(i);
                        Map dataset = new HashMap();
                        dataset.put("value", polarCharSet.getValue());
                        dataset.put("color", polarCharSet.getColor() == null ? colors[i % colors.length] : polarCharSet.getColor());
                        dataset.put("highlight", "#1ab394");
                        dataset.put("label", polarCharSet.getLabel());
                        polarData.add(dataset);
                    }
                }

                //polarOptions
                polarOptions.put("scaleShowLabelBackdrop", true);
                polarOptions.put("scaleBackdropColor", "rgba(255,255,255,0.75)");
                polarOptions.put("scaleBeginAtZero", true);
                polarOptions.put("scaleBackdropPaddingY", 1);
                polarOptions.put("scaleBackdropPaddingX", 1);
                polarOptions.put("scaleShowLine", true);
                polarOptions.put("segmentShowStroke", true);
                polarOptions.put("segmentStrokeColor", "#fff");
                polarOptions.put("segmentStrokeWidth", 2);
                polarOptions.put("animationSteps", 100);
                polarOptions.put("animationEasing", "easeOutBounce");
                polarOptions.put("animateRotate", true);
                polarOptions.put("animateScale", false);
                polarOptions.put("responsive", true);

                html.append("<script type=\"application/javascript\">");
                html.append("function polarchart_" + id + "() {\n");
                html.append("var polarData_" + id + "=" + JSON.toJSONString(polarData) + "; \n ");
                html.append("var polarOptions_" + id + " = " + JSON.toJSONString(polarOptions) + ";\n ");
                html.append("var ctx_" + id + " = document.getElementById(\"" + id + "\").getContext(\"2d\");\n");
                html.append("new Chart(ctx_" + id + ").PolarArea(polarData_" + id + ", polarOptions_" + id + ");\n");
                html.append("}\n");
                html.append("$(function () {\n");
                html.append("polarchart_" + id + "();\n");
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
