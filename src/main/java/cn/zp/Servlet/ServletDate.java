package cn.zp.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@WebServlet("/ServletDate")
public class ServletDate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getParameter("get");
        String keys1 = request.getParameter("keys");
        String values1 = request.getParameter("values");
        String tijiao = request.getParameter("Options");
        String[] keys2 = keys1.split(",");
        String[] values2 = values1.split(",");
        String[][] keys=new String[10][20];
        String[][] values=new String[10][20];
        for(int m=0;m<keys2.length;m++){
            keys[m] = keys2[m].split("\\.");
            values[m]=values2[m].split("\\.");
        }
        String[] uri = url.split(",");
        HashMap<String,HashMap<String,String>> map=new HashMap();
        for(int i=0;i<keys.length;i++){
            HashMap<String, String> map1 = new HashMap<>();
            for(int j=0;j<keys[i].length;j++){
                map1.put(keys[i][j],values[i][j]);
            }
            map.put(String.valueOf(i),map1);
        }
        request.setAttribute("url",uri);
        request.setAttribute("Date",map);
        if (Objects.equals(tijiao, "get")){
            request.getRequestDispatcher("/ServletGet").forward(request,response);
        } else if(Objects.equals(tijiao, "post")){
            request.getRequestDispatcher("/ServletPost").forward(request,response);
        } else if(Objects.equals(tijiao, "put")){
            request.getRequestDispatcher("/ServletPut").forward(request,response);
        }
        else if(Objects.equals(tijiao, "delete")){
            request.getRequestDispatcher("/ServletDelete").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doPost(request,response);
    }
}
