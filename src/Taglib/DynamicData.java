package Taglib;

import cn.edu.gdut.zaoying.Charts.LineChart;
import cn.edu.gdut.zaoying.EChartsAnnotationProcessor;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by huang on 2016/3/14 0014.
 */
public class DynamicData extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LineChart lineChart=new LineChart();
        lineChart.setData(new double[]{3,6,8,9});
        lineChart.setName("动态更新的图表");
        String json= JSON.toJSONString(EChartsAnnotationProcessor.parseChart(lineChart));
        resp.getOutputStream().write(json.getBytes("UTF-8"));//防止乱码
    }
}
