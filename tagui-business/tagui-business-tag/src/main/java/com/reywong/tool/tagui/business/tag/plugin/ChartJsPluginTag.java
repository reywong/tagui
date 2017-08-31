package com.reywong.tool.tagui.business.tag.plugin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * Created by wangrui on 2017/8/2.
 */
public class ChartJsPluginTag extends TagSupport {
    private String basePath;
    private String title;

    public int doStartTag() {
        JspWriter out = this.pageContext.getOut();
        try {
            StringBuffer html = new StringBuffer();
            String path = ((HttpServletRequest) this.pageContext.getRequest()).getContextPath();
            if (basePath == null || basePath.trim().equals("")) {
                basePath = "/resources";
            } else {
                basePath = basePath.startsWith("/") ? basePath : "/" + basePath;
                basePath = basePath.endsWith("/") ? basePath.substring(0, basePath.length() - 1) : basePath;
            }
            path += basePath;
            html.append("<script src=\"" + path + "/js/plugins/chartJs/Chart.min.js\"></script>\n");
            html.append("<script src=\"" + path + "/tagui/tagui_chartjs.js\"></script>\n");
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

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
