package cn.zp.Servlet;

import cn.zp.JDBCTest.Bean.Info;
import cn.zp.JDBCTest.Utils.JDBCUtils;
import cn.zp.JDBCTest.dao.InfoDAOimp;
import cn.zp.Utils.HttpHeaderUtils;
import cn.zp.Utils.HttpUtils;
import cn.zp.Utils.codeUtils;
import org.apache.http.Header;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Objects;

@WebServlet("/ServletPut2")
public class ServletPut2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keys = (String)request.getAttribute("kf");
        String[] key = keys.split(",");
        String values = (String) request.getAttribute("vf");
        String[] val = values.split(",");
        String[] url = (String[])request.getAttribute("url");
        String[] title=new String[10];
        String[] context=new String[20];
        int [] code=new int[10];
        String[] s=new String[10];
        String[][] head=new String[10][20];
        int c=0,a=0,b=0,d=0,f=0;
        HashMap<String,HashMap<String,String>> date = (HashMap<String,HashMap<String,String>>) request.getAttribute("Date");
        for (int j=0;j<url.length;j++) {
            codeUtils codeUtils = new codeUtils();
            try {
                code[c++] = codeUtils.codePut(url[j],date.get(String.valueOf(j)),Charset.forName("UTF-8"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            //获取body
            if (url[j]!= null) {
                try {
                    HttpUtils utils = new HttpUtils();//获取响应体
                    s[a++] = utils.doPut(url[j],date.get(String.valueOf(j)),Charset.forName("UTF-8"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //获取响应头信息
                HttpHeaderUtils headerUtils = new HttpHeaderUtils();
                Header[] headers = null;
                try {
                    headers = headerUtils.doPut(url[j], date.get(String.valueOf(j)),Charset.forName("UTF-8"));
                    for (Header str:headers){
                        String str1=String.valueOf(str);
                        head[d][f++]=str1;
                    }
                    d++;
                    f=0;
                } catch (Exception e) {
                    e.printStackTrace();
                }

            String data = null;
            String time=null;
            for (String str : head[j]) {
                String s1 = String.valueOf(str);
                String[] split = s1.split("\\:", 2);
                if (Objects.equals(split[0], "Date")) {
                    data = split[1];
                }
                if (Objects.equals(split[0], "Keep-Alive")) {
                    time = split[1];
                }
            }
            String co=String.valueOf(code[j]);
            InfoDAOimp dao = new InfoDAOimp();
            Connection conn=null;
            try {
                conn = JDBCUtils.getConnection3();
                Info info1 = new Info(2,url[j],key[j],val[j],data,time,"put",co);
                dao.insert(conn,info1);
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                JDBCUtils.closeResource(conn,null);
            }
            Document doc = Jsoup.parse(s[j]);
            try {
                    title[j]= doc.getElementsByTag("title").first().text();
                Elements span1 = doc.getElementsByTag("span");
                for (Element str:span1) {
                    context[b++]=str.text();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            }

        }
        request.setAttribute("context",context);
        request.setAttribute("title",title);
        request.setAttribute("code",code);
        request.setAttribute("body",s);
        request.setAttribute("headers",head);
        request.getRequestDispatcher("/1.jsp").forward(request,response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
