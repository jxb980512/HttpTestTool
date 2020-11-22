package cn.zp.Servlet;

import cn.zp.JDBCTest.Bean.Info;
import cn.zp.JDBCTest.dao.InfoDAOimp;
import cn.zp.PageBean.PageBean;
import cn.zp.PageBean.fenpage;
import cn.zp.PageBean.fenpage1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/FindAllbyPageServlet")
public class FindAllbyPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //获取参数
        String kind = request.getParameter("kind");
        System.out.println(kind);
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");
        PageBean<Info> pb=null;
        if(currentPage==null||"".equals(currentPage)){
            currentPage="1";
        }
        if (rows==null||"".equals(rows)){
            rows="8";
        }
        fenpage fenpage = new fenpage();
        fenpage1 fenpage1 = new fenpage1();
        int i = fenpage1.findallPage1();
        pb = fenpage.findallPage(currentPage, rows);


        request.setAttribute("pb",pb);
        request.setAttribute("count",i);
        request.getRequestDispatcher("find.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
