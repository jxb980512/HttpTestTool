package cn.zp.JDBCTest.dao;

import cn.zp.JDBCTest.Bean.Info;
import cn.zp.JDBCTest.Bean.User;

import java.sql.Connection;
import java.util.List;

public class UserDAOimp extends BaseDAO implements UserDao {
    @Override
    public void insert(Connection conn, User user) {
        String sql="insert into user(username,password) values(?,?)";
        update(conn,sql,user.getUsername(),user.getPassword());
    }

    @Override
    public List<User> getAll(Connection conn) {
        String sql = "select * from user";
        List<User> list = getForList(conn, User.class, sql);
        return list;
    }

    @Override
    public User getUserById(Connection conn, String usernanme) {
        String sql = "select id,username,password from user where username=?";
        User user = getInstance(conn,User.class, sql,usernanme);
        return user;
    }

}
