<%@ page import="java.util.Set" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.Map" %>
<%@ page import="org.apache.http.Header" %>
<%@ page import="java.util.Objects" %>
<%@ page import="javax.print.DocFlavor" %><%--
  Created by IntelliJ IDEA.
  User: 10902
  Date: 2020/9/13
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>http测试主页面</title>
</head>
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
<script>
    function jump(){
        window.location.href="/find.jsp";
    }
</script>
<body>
<form action="/ServletDate" method="post">
    <div class="input-group input-group-lg">
        <span class="input-group-addon" id="sizing-addon1">Url</span>
        <input type="text" class="form-control" placeholder="请输入请求链接(多链接请用“,”隔开)"aria-describedby="sizing-addon1" name="get">
    </div>
    <div class="input-group input-group-lg">
        <span class="input-group-addon" id="sizing-addon2">Key</span>
        <input type="text" class="form-control" placeholder="请输入请求属性(多属性请用“.”隔开，每个链接属性请用“，”结束)" aria-describedby="sizing-addon1" name="keys">
    </div>
    <div class="input-group input-group-lg">
        <span class="input-group-addon" id="sizing-addon3">Val</span>
        <input type="text" class="form-control" placeholder="请输入请求属性值(多属性值请用“.”隔开，每个链接属性请用“，”结束)" aria-describedby="sizing-addon1" name="values">
    </div>
    <div class="btn-group" role="group" aria-label="...">
        <button type="submit" class="btn btn-default" name="tijiao" value="get">GET</button>
        <button type="submit" class="btn btn-default" name="tijiao" value="post">POST</button>
        <button type="submit" class="btn btn-default" name="tijiao" value="put">PUT</button>
        <button type="submit" class="btn btn-default" name="tijiao" value="delete">DELETE</button>
        <button type="button" class="btn btn-default" onclick="jump()">查询所有数据</button>
    </div>
</form>
测试结果代码为：
<label><%
     int[] code=(int[])request.getAttribute("code");
     if(code!=null){
         for(int a=0;code[a]!=0;a++){
             out.print(code[a]);
             out.write("&nbsp");
         }
     }
%></label><br>
<ul class="nav nav-tabs">
    <li role="presentation" class="active"><button onclick="showbody()">响应体</button></li>
    <li role="presentation" class="active"><button onclick="showhead()">响应头</button></li>
</ul>
<div margin:0 auto width:300px id="body" style="display:block">
    <textarea placeholder="响应体在这里显示" readonly="readonly" cols="200" rows="8">
        <%
            String[] body=(String[])request.getAttribute("body");
            if(body!=null){
                for(int b=0;body[b]!=null;b++){
                    out.write(body[b]);
                    out.write("\n");
                    out.write("--------------------------------------");
                    out.write("\n");
                }
            }
        %>
    </textarea>
</div>
<div margin:0 auto width:300px id="header" style="display: none">
    <textarea placeholder="响应体在这里显示" readonly="readonly" cols="200" rows="8">
  <%
      String[][] headers=(String[][]) request.getAttribute("headers");
      if(headers!=null){
          for(int i=0;headers[i][0]!=null;i++){
              for(int j=0;headers[i][j]!=null;j++){
                  out.write(headers[i][j]);
                  out.write("\n");
              }
              out.write("*******************************************");
              out.write("\n");
          }
      }
  %>
    </textarea>
</div>
<script>
    function showbody() {
        document.getElementById("body").style.display = "block"
        document.getElementById("header").style.display = "none"
    }
    function showhead() {
        document.getElementById("header").style.display = "block"
        document.getElementById("body").style.display = "none"
    }
</script>

<%--<div>--%>
    <%--<textarea readonly="readonly" cols="200" rows="8" placeholder="响应头在这里显示">--%>
    <%--<%--%>
    <%--String[][] headers=(String[][]) request.getAttribute("headers");--%>
    <%--if(headers!=null){--%>
        <%--for(int i=0;headers[i][0]!=null;i++){--%>
            <%--for(int j=0;headers[i][j]!=null;j++){--%>
                <%--out.write(headers[i][j]);--%>
                <%--out.write("\n");--%>
            <%--}--%>
            <%--out.write("*******************************************");--%>
            <%--out.write("\n");--%>
        <%--}--%>
    <%--}--%>
    <%--%>--%>
    <%--</textarea>--%>
<%--</div>--%>

</body>
</html>
