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
public class ColTag extends TagSupport {
    private String colNum;
    private String title;

    @Override
    public int doStartTag() {
        JspWriter out = this.pageContext.getOut();
        try {
            if (colNum == null || colNum.trim().equals("")) {
                colNum = "12";
            }

            String titleHtml = "";
            if (title != null && !title.trim().equals("")) {
                titleHtml = "    <div class=\"ibox-title\">\n" +
                        "            <h5>" + title + "</h5>\n" +
                        "            <div class=\"ibox-tools\">\n" +
                        "                <a class=\"collapse-link\">\n" +
                        "                    <i class=\"fa fa-chevron-up\"></i>\n" +
                        "                </a>\n" +
                        "            </div>\n" +
                        "        </div>\n";
            }
            StringBuffer html = new StringBuffer();
            html.append("<div class=\"col-lg-" + colNum + "\">\n" +
                            "    <div class=\"ibox float-e-margins\">\n" +
                            titleHtml +
                            "        <div class=\"ibox-content\">\n"
            );
            out.println(html);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return EVAL_BODY_INCLUDE;
    }

    @Override
    public int doEndTag() throws JspException {
        JspWriter out = this.pageContext.getOut();
        try {
            out.println("        </div>\n" +
                    "    </div>\n" +
                    "</div>");
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return EVAL_PAGE;

    }

    public String getColNum() {
        return colNum;
    }

    public void setColNum(String colNum) {
        this.colNum = colNum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
