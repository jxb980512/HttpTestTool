package cn.zp.JDBCTest.dao;

import cn.zp.JDBCTest.Bean.Info;
import cn.zp.PageBean.PageBean;

import java.sql.Connection;
import java.util.List;

public interface InfoDAO {
    /**
     *
     * @Description 将cust对象添加到数据库�?
     * @author shkstart
     * @date 上午11:00:27
     * @param conn
     * @param info
     */
    void insert(Connection conn, Info info);
    /**
     *
     * @Description 针对指定的id，删除表中的�?条记�?
     * @author shkstart
     * @date 上午11:01:07
     * @param conn
     * @param id
     */
    void deleteById(Connection conn, int id);
    /**
     *
     * @Description 针对内存中的cust对象，去修改数据表中指定的记�?
     * @author shkstart
     * @date 上午11:02:14
     * @param conn
     * @param info
     */
    void update(Connection conn, Info info);
    /**
     *
     * @Description 针对指定的id查询得到对应的Customer对象
     * @author shkstart
     * @date 上午11:02:59
     * @param conn
     * @param url
     */
    Info getCustomerById(Connection conn, String url);
    /**
     *
     * @Description 查询表中的所有记录构成的集合
     * @author shkstart
     * @date 上午11:03:50
     * @param conn
     * @return
     */
    List<Info> getAll(Connection conn);
    Long getCount(Connection conn);
    Long getpartCount(Connection conn);
    List<Info> findBypage(Connection conn,int start,int rows);
    List<Info> findpartBypage(Connection conn,int start,int rows);
}
