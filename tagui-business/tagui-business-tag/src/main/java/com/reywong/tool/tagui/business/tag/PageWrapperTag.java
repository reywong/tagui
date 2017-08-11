package com.reywong.tool.tagui.business.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: wangrui
 * Date: 13-10-15
 * Time: 上午9:58
 * To change this template use File | Settings | File Templates.
 */
public class PageWrapperTag extends TagSupport {
    /**
     * div css
     */
    private String css;

    @Override
    public int doStartTag() {
        JspWriter out = this.pageContext.getOut();
        try {
            if (css == null || css.trim().equals("")) {
                css = "gray-bg";
            }
            out.println("<div id=\"page-wrapper\" class=\"" + css + "\">");
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return EVAL_BODY_INCLUDE;
    }

    @Override
    public int doEndTag() throws JspException {
        JspWriter out = this.pageContext.getOut();
        try {
            out.println("</div>\n");
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return EVAL_PAGE;

    }

    public String getCss() {
        return css;
    }

    public void setCss(String css) {
        this.css = css;
    }
}
