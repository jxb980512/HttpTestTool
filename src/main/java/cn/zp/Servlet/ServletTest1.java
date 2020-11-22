package cn.zp.Servlet;

import cn.zp.JDBCTest.Bean.User;
import cn.zp.JDBCTest.Utils.JDBCUtils;
import cn.zp.JDBCTest.dao.UserDAOimp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/ServletTest1")
public class ServletTest1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("username");
        String password = request.getParameter("password");
        UserDAOimp dao = new UserDAOimp();
        if (user!=null&&password!=null){
            Connection conn = null;
            try {
                conn = JDBCUtils.getConnection3();
                User user1 = new User(1, user, password);
                dao.insert(conn,user1);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            JDBCUtils.closeResource(conn,null);
        }
        request.getRequestDispatcher("/suc.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("username");
        UserDAOimp dao = new UserDAOimp();
        User user1=null;
        if (user!=null){
            Connection conn = null;
            try {
                conn = JDBCUtils.getConnection3();
                user1 = dao.getUserById(conn, user);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            JDBCUtils.closeResource(conn,null);
        }
        request.setAttribute("user",user1);
        request.getRequestDispatcher("/suc.jsp").forward(request,response);
    }
}
