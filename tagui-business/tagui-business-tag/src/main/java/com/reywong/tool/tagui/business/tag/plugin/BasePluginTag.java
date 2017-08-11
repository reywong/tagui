package com.reywong.tool.tagui.business.tag.plugin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * Created by wangrui on 2017/8/2.
 */
public class BasePluginTag extends TagSupport {
    private String basePath;
    private String title;

    public int doStartTag() {
        JspWriter out = this.pageContext.getOut();
        try {
            StringBuffer html = new StringBuffer();
            String path = ((HttpServletRequest) this.pageContext.getRequest()).getContextPath();
            if (basePath == null || basePath.trim().equals("")) {
                basePath = "/pages";
            } else {
                basePath = basePath.startsWith("/") ? basePath : "/" + basePath;
                basePath = basePath.endsWith("/") ? basePath.substring(0, basePath.length() - 1) : basePath;
            }
            path += basePath;
            html.append("" +
                    "<meta charset=\"utf-8\">\n" +
                    "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                    "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                    "\n" +
                    "<title>" + title + "</title>" +
                    "<!--jq-->\n" +
                    "<script src=\"" + path + "/js/jquery-2.1.1.js\"></script>\n" +
                    "<!--bootstrap-->\n" +
                    "<link href=\"" + path + "/css/bootstrap.min.css\" rel=\"stylesheet\">\n" +
                    "<script src=\"" + path + "/js/bootstrap.min.js\"></script>\n" +
                    "\n" +
                    "<link href=\"" + path + "/font-awesome/css/font-awesome.css\" rel=\"stylesheet\">\n" +
                    "<link href=\"" + path + "/css/animate.css\" rel=\"stylesheet\">\n" +
                    "<link href=\"" + path + "/css/style.css\" rel=\"stylesheet\">\n" +
                    "\n" +
                    "\n" +
                    "<script src=\"" + path + "/js/plugins/metisMenu/jquery.metisMenu.js\"></script>\n" +
                    "<script src=\"" + path + "/js/plugins/slimscroll/jquery.slimscroll.min.js\"></script>\n" +
                    "<script src=\"" + path + "/js/inspinia.js\"></script>\n");
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
