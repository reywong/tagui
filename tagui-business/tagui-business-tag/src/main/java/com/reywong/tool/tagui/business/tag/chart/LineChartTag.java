package com.reywong.tool.tagui.business.tag.chart;

import com.alibaba.fastjson.JSON;
import com.reywong.tool.tagui.business.bean.chart.ChartBean;
import com.reywong.tool.tagui.business.bean.chart.ChartSetBean;

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
            if (height == null || height.trim().equals("")) {
                height = "140";
            }
            //添加控件
            html.append("<div>\n" +
                    "<canvas id=\"" + id + "\" height=\"" + height + "\"></canvas>\n" +
                    "</div>\n");
            html.append("<script type=\"application/javascript\">\n");
            html.append(" $(function () {\n");
            html.append(" tagUI_linechart('" + id + "'," + json + "," + datasetFill + ");\n");
            html.append(" })\n");
            html.append("</script>\n");
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
