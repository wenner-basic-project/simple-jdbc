package com.wenner.it.jdbc.service;

import com.wenner.it.jdbc.entity.User;
import com.wenner.it.jdbc.utils.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    public int insert(User user) throws SQLException {
        String sql = "INSERT INTO `test`.`tb_user` (`user_name`, `password`) VALUES (?, ?)";
        Connection connection = DBUtils.getConnection();
        PreparedStatement pdst = connection.prepareStatement(sql);
        pdst.setString(1, user.getUserName());
        pdst.setString(2, user.getPassword());
        return pdst.executeUpdate();
    }

    public List<User> list() throws SQLException {
        String sql = "select user_name, password from tb_user";
        Connection connection = DBUtils.getConnection();
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql);
        List<User> userList = new ArrayList<>();
        while (rs.next()){
            User user = new User();
            user.setUserName(rs.getString(1));
            user.setPassword(rs.getString(2));
            userList.add(user);
        }
        return userList;
    }
}
