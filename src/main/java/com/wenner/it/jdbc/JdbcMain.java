package com.wenner.it.jdbc;

import com.alibaba.fastjson.JSONObject;
import com.wenner.it.jdbc.entity.User;
import com.wenner.it.jdbc.service.UserService;

import java.sql.SQLException;
import java.util.List;

public class JdbcMain {

    public static void main(String[] args) throws SQLException {
        UserService userService = new UserService();
        User user = new User();
        user.setUserName("jdbcWenner");
        user.setPassword("aqer");
        //int result = userService.insert(user);
        //System.out.println("result: " + result);

        List<User> userList = userService.list();
        System.out.println(JSONObject.toJSONString(userList));
    }
}
