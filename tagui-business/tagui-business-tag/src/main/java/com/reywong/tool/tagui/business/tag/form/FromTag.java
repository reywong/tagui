package com.reywong.tool.tagui.business.tag.form;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * Created by wangrui on 2017/8/2.
 */
public class FromTag extends TagSupport {
    @Override
    public int doStartTag() {
        JspWriter out = this.pageContext.getOut();
        try {
            out.println("<div class=\"wrapper wrapper-content animated fadeInRight\">");
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
}
