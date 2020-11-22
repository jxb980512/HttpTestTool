package cn.zp.Servlet;


import cn.zp.JDBCTest.Utils.JDBCUtils;
import cn.zp.JDBCTest.dao.InfoDAOimp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/ServletDeleteJDBC")
public class ServletDeleteJDBC extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        InfoDAOimp dao = new InfoDAOimp();
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection3();
            dao.deleteById(conn,Integer.parseInt(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(conn,null);
        }
        request.getRequestDispatcher("/FindAllbyPageServlet?currentPage=1&rows=8").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
