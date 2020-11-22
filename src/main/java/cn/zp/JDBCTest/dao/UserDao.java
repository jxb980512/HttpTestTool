package cn.zp.JDBCTest.dao;

import cn.zp.JDBCTest.Bean.Info;
import cn.zp.JDBCTest.Bean.User;

import java.sql.Connection;
import java.util.List;

public interface UserDao {
    void insert(Connection conn, User user);
    List<User> getAll(Connection conn);
    User getUserById(Connection conn, String url);
}
