package Taglib;

import cn.edu.gdut.zaoying.EChartsAnnotationProcessor;
import com.alibaba.fastjson.JSON;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * Created by huang on 2016/3/12 0012.
 */
public class NormalChart extends TagSupport {
    private Object chart;
    private String id;
    private String style;
    private boolean delayLoad=true;
    @Override
    public int doStartTag() throws JspException {
        String html="<div id='"+id+"' style='"+style+"'></div>\n";
        html+="<script>\nvar option="+JSON.toJSONString(EChartsAnnotationProcessor.parseChart(chart))+";\n";
        html+="options['"+id+"']=option;\n";
        if(!delayLoad)html+="echarts.init(document.getElementById('"+id+"')).setOption(option);\n";
        html+="</script>";
        try {
            pageContext.getOut().println(html);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.doStartTag();
    }

    @Override
    public int doEndTag() throws JspException {
        return super.doEndTag();
    }

    public void setDelayLoad(boolean delayLoad) {
        this.delayLoad = delayLoad;
    }

    public void setChart(Object chart) {
        this.chart = chart;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
}
