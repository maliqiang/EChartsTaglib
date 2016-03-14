package Taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * Created by huang on 2016/3/13 0013.
 */
public class DynamicChart extends TagSupport {
    private String id;
    private String url,style;
    private long interval;
    @Override
    public int doStartTag() throws JspException {
        String html="<div id='"+id+"' style='"+style+"'></div>\n"+
                "<script>window.setInterval(\"load('"+id+"','"+url+"')\","+interval+")</script>";
        try {
            pageContext.getOut().println(html);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.doStartTag();
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setInterval(long interval) {
        this.interval = interval;
    }
}
