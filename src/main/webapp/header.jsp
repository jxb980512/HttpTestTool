<%--
  Created by IntelliJ IDEA.
  User: 10902
  Date: 2020/9/21
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>Title</title>
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
<xmp>
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
</xmp>
</body>
</html>
