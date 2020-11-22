<%@ page import="java.util.Set" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<title>测试HeaderTest</title>
<body>
<form action="/ServletT" method="post">
<input type="text" name="link1">
    <input type="submit" value="提交">
    <div>
             <% Map<String ,String>map = (Map<String, String>) request.getAttribute("map");
             if (map!=null) {
                 for (Map.Entry<String, String> entry : map.entrySet()) {
                     String mapKey = entry.getKey();
                     String mapValue = entry.getValue();
                     out.write(mapKey + ":" +mapValue);
                     out.write("<br>");
                 }
             }

             %>
    </div>
</form>
</body>
</html>
