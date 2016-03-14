<%--
  Created by IntelliJ IDEA.
  User: huang
  Date: 2016/3/14 0014
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
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
