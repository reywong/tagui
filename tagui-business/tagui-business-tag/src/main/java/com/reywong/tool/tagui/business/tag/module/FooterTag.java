package com.reywong.tool.tagui.business.tag.module;

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
public class FooterTag extends TagSupport {
    private String title;
    private String content;

    @Override
    public int doStartTag() {
        JspWriter out = this.pageContext.getOut();
        try {
            if (title == null) {
                title = "";
            }
            if (content == null) {
                content = "";
            }
            out.println("<div class=\"footer\">\n" +
                    "    <div class=\"pull-right\">\n" +
                    "         <strong>" + title + "</strong> " + content + "\n" +
                    "    </div>\n" +
                    "    <div>\n" +
                    "        <strong>Copyright</strong> Wirte by Reywong &copy; 2017-2018\n" +
                    "    </div>\n" +
                    "</div>");
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        return SKIP_BODY;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
