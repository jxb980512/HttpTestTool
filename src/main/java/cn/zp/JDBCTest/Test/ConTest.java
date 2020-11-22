package cn.zp.JDBCTest.Test;

import cn.zp.JDBCTest.Bean.Info;
import cn.zp.JDBCTest.Utils.JDBCUtils;
import cn.zp.JDBCTest.dao.InfoDAOimp;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ConTest {
    private InfoDAOimp dao = new InfoDAOimp();
    @Test
    public void connTest(){
        Connection conn= null;
        try {
            conn = JDBCUtils.getConnection3();
            System.out.println(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(conn,null);
        }
    }
    @Test
    public void insertTest(){
        Connection conn=null;
        try {
            conn = JDBCUtils.getConnection3();
            Info info = new Info(1,"http://www.baidu.com","uers","password","2020-9-20","20Ms","get","200");
            dao.insert(conn,info);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(conn,null);
        }
    }
    @Test
    public void Test2(){
        Connection conn=null;
        try {
            conn = JDBCUtils.getConnection3();
            Info info = new Info(1,"http://www.baidu.com","uers","password","2020-9-20","20Ms","get","200");
            dao.deleteById(conn,1);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(conn,null);
        }
    }
    @Test
    public void Test3(){
        Connection conn=null;
        try {
            conn = JDBCUtils.getConnection3();
            Info info = new Info(1,"http://www.baidu.com","uers","password","2020-9-20","20Ms","get","200");
            Info info1 = dao.getCustomerById(conn, "http://www.baidu.com");
            System.out.println(info1);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(conn,null);
        }
    }
    @Test
    public void Test4(){
        Connection conn=null;
        try {
            conn = JDBCUtils.getConnection3();
            Info info = new Info(1,"http://www.baidu.com","uers","password","2020-9-20","20Ms","get","200");
            List<Info> all = dao.getAll(conn);
            for (Info str:all) {
                System.out.println(str);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(conn,null);
        }
    }
//    @Test
//    public void Test56(){
//        Connection conn= null;
//        try {
//            conn = JDBCUtils.getConnection3();
//            Long count = dao.getpartCount(conn, "http://localhost:8080/ServletTest1");
//            System.out.println(count);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            JDBCUtils.closeResource(conn,null);
//        }
//    }

}
