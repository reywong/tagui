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
public class TopTag extends TagSupport {
    private String loginOutUrl;
    private String welcome;

    @Override
    public int doStartTag() {
        JspWriter out = this.pageContext.getOut();
        try {

            StringBuffer html = new StringBuffer();
            String loginHtml = "";
            if (loginOutUrl != null && !loginOutUrl.trim().equals("")) {
                loginHtml = "<li>\n" +
                        "     <a href=\"" + loginOutUrl + "\">\n" +
                        "       <i class=\"fa fa-sign-out\"></i> 退出\n" +
                        "     </a>\n" +
                        "   </li>\n";
            }
            html.append("<div class=\"row border-bottom gray-bg\">\n" +
                    "    <nav class=\"navbar navbar-static-top\" role=\"navigation\" style=\"margin-bottom: 0\">\n" +
                    "        <div class=\"navbar-header\">\n" +
                    "            <a class=\"navbar-minimalize minimalize-styl-2 btn btn-primary \" href=\"index.jsp#\"><i\n" +
                    "                    class=\"fa fa-bars\"></i> </a>\n" +
                    "        </div>\n" +
                    "        <ul id=\"tagUI-top\" class=\"nav navbar-top-links navbar-right\">\n" +
                    "            <li>\n" +
                    "                <span class=\"m-r-sm text-muted welcome-message\">" + welcome + "</span>\n" +
                    "            </li>\n" +
                    "\n" + loginHtml +
                    "        </ul>\n" +
                    "\n" +
                    "    </nav>\n" +
                    "</div>");
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

    public String getLoginOutUrl() {
        return loginOutUrl;
    }

    public void setLoginOutUrl(String loginOutUrl) {
        this.loginOutUrl = loginOutUrl;
    }

    public String getWelcome() {
        return welcome;
    }

    public void setWelcome(String welcome) {
        this.welcome = welcome;
    }
}
