package Taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * Created by huang on 2016/3/12 0012.
 */
public class ImportECharts extends TagSupport {
    String scriptPath;
    boolean autoRestore;
    @Override
    public int doStartTag() throws JspException {
        String html="<script src='"+scriptPath+"'></script>\n<script src='js/common.js'></script>\n";
        html+="<script>\nvar autoRestore="+autoRestore+";\nwindow.onload=function(){" +
                "    var top=document.body.scrollTop;\n" +
                "    var clientHeight=document.body.clientHeight+top;\n" +
                "    for(var id in options){\n" +
                "        var offsetTop=document.getElementById(id).offsetTop;\n" +
                "        var offsetHeight=document.getElementById(id).offsetHeight;\n" +
                "        var bottom=top+clientHeight;\n" +
                "        var offsetBottom=offsetTop+offsetHeight;\n" +
                "        if(top<=offsetTop&&bottom>=offsetBottom)initializeChart(id);\n" +
                "    }};\n</script>";
        try {
            pageContext.getOut().println(html);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.doStartTag();
    }

    public void setScriptPath(String scriptPath) {
        this.scriptPath = scriptPath;
    }

    public void setAutoRestore(boolean autoRestore) {
        this.autoRestore = autoRestore;
    }
}
