package cn.zp.PageBean;

import cn.zp.JDBCTest.Bean.Info;
import cn.zp.JDBCTest.Utils.JDBCUtils;
import cn.zp.JDBCTest.dao.InfoDAOimp;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class fenpage {
    public PageBean<Info> findallPage(String _currentPage, String _rows)  {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection3();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        InfoDAOimp dao = new InfoDAOimp();
        int currentPage=Integer.parseInt(_currentPage);
        int rows=Integer.parseInt(_rows);
        //创建空的pagebean
        PageBean<Info> pb = new PageBean<Info>();
        //设置参数
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
        //调用dao查询总记录
        int count=Integer.parseInt(String.valueOf(dao.getCount(conn)));
        pb.setTotCount(count);
        //查询集合
        int start =(currentPage-1)*rows;
        List<Info> list =dao.findBypage(conn,start,rows);
        pb.setLsit(list);
        //计算总页码
        int totalPage=(count%rows)==0?count/rows:(count/rows)+1;
        pb.setTotpage(totalPage);
        JDBCUtils.closeResource(conn,null);
        return pb;
    }
}
