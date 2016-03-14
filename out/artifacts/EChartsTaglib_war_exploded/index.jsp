<%@ page import="cn.edu.gdut.zaoying.Charts.LineChart" %>
<%--
  Created by IntelliJ IDEA.
  User: huang
  Date: 2016/3/12 0012
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
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
