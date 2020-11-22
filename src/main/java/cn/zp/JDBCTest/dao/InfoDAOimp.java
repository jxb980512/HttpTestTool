package cn.zp.JDBCTest.dao;

import cn.zp.JDBCTest.Bean.Info;
import cn.zp.PageBean.PageBean;

import java.sql.Connection;
import java.util.List;

public class InfoDAOimp extends BaseDAO implements InfoDAO {
    @Override
    public void insert(Connection conn, Info info) {
        String sql = "insert into info(url,ke,val,da,ti,method,co)values(?,?,?,?,?,?,?)";
        update(conn, sql,info.getUrl(),info.getKe(),info.getVal(),info.getDa(),info.getTi(),info.getMethod(),info.getCo());
    }

    @Override
    public void deleteById(Connection conn, int id) {
        String sql = "delete from info where id = ?";
        update(conn, sql, id);
    }

    @Override
    public void update(Connection conn, Info info) {

    }

    @Override
    public Info getCustomerById(Connection conn, String url) {
        String sql = "select id,url,ke,val,da,ti,method,co from info where url = ?";
        Info info = getInstance(conn,Info.class, sql,url);
        return info;
    }

    @Override
    public List<Info> getAll(Connection conn) {
        String sql = "select id,url,ke,val,da,ti,method,co from info";
        List<Info> list = getForList(conn, Info.class, sql);
        return list;
    }

    @Override
    public Long getCount(Connection conn) {
        String sql = "select count(*) from info";
        return getValue(conn, sql);
    }

    @Override
    public Long getpartCount(Connection conn) {
        String sql = "select count(*) from info where co=200";
        return getValue(conn, sql);
    }

    @Override
    public List<Info> findBypage(Connection conn, int start, int rows) {
        String sql="select id,url,ke,val,da,ti,method,co from info limit "+start+","+rows;
        List<Info> forList = getForList(conn, Info.class, sql);
        return forList;
    }

    @Override
    public List<Info> findpartBypage(Connection conn, int start, int rows) {
        String sql="select id,url,ke,val,da,ti,method,co from info where co=200 limit "+start+","+rows;
        List<Info> forList1 = getForList(conn, Info.class, sql);
        return forList1;
    }


}
