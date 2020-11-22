package cn.zp.PageBean;

import cn.zp.JDBCTest.Bean.Info;
import cn.zp.JDBCTest.Utils.JDBCUtils;
import cn.zp.JDBCTest.dao.InfoDAOimp;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class fenpage1 {
    public int findallPage1()  {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection3();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        InfoDAOimp dao = new InfoDAOimp();
        int count=Integer.parseInt(String.valueOf(dao.getpartCount(conn)));
        return count;
    }

}
