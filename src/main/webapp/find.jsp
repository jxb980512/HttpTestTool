<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="cn.zp.JDBCTest.Bean.Info" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 10902
  Date: 2020/9/20
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>查找信息</title>
</head>
<body style="background: url(/img/bg.jpg)" onload="she()">
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
<script>
    function jump(){
        window.location.href="/1.jsp";
    }

</script>
<div style="background-color: #ffffff;height: 600px;"  >
<h1 class="text-center">数 据 显 示</h1>
<table class="table table-hover" id="table_report">
    <tr>
        <th>编号</th>
        <th>链接</th>
        <th>参数</th>
        <th>参数值</th>
        <th>日期</th>
        <th>请求方式</th>
        <th>响应代码</th>
        <th>操作</th>
    </tr>
    <%!
    int j=1;
    %>
    <%
        j=1;
    %>
    <c:forEach items="${pb.lsit}" var="all" varStatus="s">

        <tr id=${all.id} class="success">
            <th><%=j++%></th>
            <th>${all.url}</th>
            <th>${all.ke}</th>
            <th>${all.val}</th>
            <th>${all.da}</th>
            <th>${all.method}</th>
            <th>${all.co}</th>
            <th><a href="${pageContext.request.contextPath}/ServletDeleteJDBC?id=${all.id}">删除</a></th>
            <script>
                var code = ${all.co};
                var rs=document.getElementById(${all.id});
                if(code!="200"){
                    rs.setAttribute("class","danger");
                }
            </script>
        </tr>
    </c:forEach>
</table>
    <nav aria-label="Page navigation">
        <ul class="pagination">

             <C:forEach begin="1" end="${pb.totpage}" var="i">
                 <li><a href="${pageContext.request.contextPath}/FindAllbyPageServlet?currentPage=${i}&rows=8">${i}</a></li>
             </C:forEach>
            <li>
                <a href="${pageContext.request.contextPath}/FindAllbyPageServlet?currentPage=1&rows=8" aria-label="Next">
                    <span aria-hidden="true">返回首页</span>
                </a>
            </li>
            <li>总共${pb.totCount}条记录，共${pb.totpage}页，当前为第${pb.currentPage}页；</li>
            <li>成功请求条数：<%=request.getAttribute("count")%>条</li>
        </ul>
    </nav>
<form action="/FindAllbyPageServlet" method="post">
    <button type="button" class="btn btn-default" aria-label="Left Align">
        <span class="glyphicon glyphicon-log-out" aria-hidden="true" onclick="jump()">返回上一页</span>
    </button>
    <button type="submit" class="btn btn-default" aria-label="Left Align">
        <span class="glyphicon glyphicon-refresh" aria-hidden="true">刷新</span>
    </button>
</form>
    </div>
</body>
</html>
