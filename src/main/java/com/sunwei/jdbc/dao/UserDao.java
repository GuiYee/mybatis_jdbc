package com.sunwei.jdbc.dao;

import com.sunwei.jdbc.pojo.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserDao {
    public List<User> findUserByAge(int age) {
        String url = "jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8";
        String username = "root";
        String password = "root";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //1.装配驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2. 建立并获取连接
             connection = DriverManager.getConnection(url,username,password);
            //3.创建jdbc statements对象
            //4. sql语句
            String sql = "select * from user where age > ?";
             preparedStatement = connection.prepareStatement(sql);
             //传参
            preparedStatement.setInt(1,age);
            //5. 执行语句并返回结果
             resultSet = preparedStatement.executeQuery();
            //6、获取结果
            List<User> userList = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age1 = resultSet.getInt("age");
                String address = resultSet.getString("address");
                User user = new User();
                user.setId(id);
                user.setName(name);
                user.setAge(age1);
                user.setAddress(address);
                userList.add(user);
            }
            return userList;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //释放资源
            try {
                if (connection != null) {
                    connection.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return Collections.emptyList();
    }
}
