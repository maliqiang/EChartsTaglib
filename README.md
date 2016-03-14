# EChartsTaglib
结合EChartsAnnotation实践的数据可视化项目
##如何使用Get Started
`1`把out\artifacts\EChartsTaglib_war_exploded目录下的文件全部拷贝到一个空文件夹
`2`把dynamic.jsp、index.jsp和\WEB-INF\web.xml 三个文件删掉
`3`往你的WEB-INF目录下的web.xml文件里面添加以下代码：
```XML
    <jsp-config>
        <taglib>
            <taglib-uri>/WEB-INF/EChartTaglib.tld</taglib-uri>
            <taglib-location>/WEB-INF/EChartTaglib.tld</taglib-location>
        </taglib>
    </jsp-config>
    <servlet>
        <description>动态数据</description>
        <display-name>DynamicData</display-name>
        <servlet-name>getData</servlet-name>
        <servlet-class>servlet.DynamicData</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>getData</servlet-name>
        <url-pattern>/getData</url-pattern>
    </servlet-mapping>
```
`4`把刚才复制的文件粘贴到你的webRoot文件下
`5`编写index.jsp
```JSP

<%@ page import="cn.edu.gdut.zaoying.Charts.LineChart" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/EChartTaglib.tld" prefix="e"%>
<html>
  <head>
    <title>EChartTaglib</title>
      <e:InitializeChart scriptPath="js/echarts.min.js"/>
  </head>
  <body>
  <%
      LineChart lineChart=new LineChart();
      lineChart.setData(new double[]{1,2,3,4});
      lineChart.setName("折线图");
  %>
  <e:NormalChart chart="<%=lineChart%>" id="lineChart" style="height:480px" delayLoad="false"/>
  <%
      LineChart lineChart1=new LineChart();
      lineChart1.setData(new double[]{2,4,8,6});
      lineChart1.setName("折线图");
  %>
  <e:NormalChart chart="<%=lineChart1%>" id="lineChart1" style="height:480px"/>
  <%
      LineChart lineChart2=new LineChart();
      lineChart2.setData(new double[]{1,2,4,8});
      lineChart2.setName("折线图");
  %>
  <e:NormalChart chart="<%=lineChart2%>" id="lineChart2" style="height:480px"/>
  </body>
</html>
```
`6`编写DynamicData.java文件servlet
```JSP
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
```
`7`编写dynamic.jsp
```JSP
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/EChartTaglib.tld" prefix="e"%>
<html>
<head>
    <title>动态更新的图表</title>
    <e:InitializeChart scriptPath="js/echarts.min.js"/>
</head>
<body>
<e:DynamicChart id="dynamic" url="/getData" interval="1000" style="height:480px"/>
</body>
</html>
```
