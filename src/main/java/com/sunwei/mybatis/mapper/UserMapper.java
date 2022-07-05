package com.sunwei.mybatis.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    User findById(int id);

    void save(User suer);

    int updateUser(User user);

    int deleteUserById(int id);

    List<User> findAgeById(int age);

    //  方式一：  分页查询丶
        //首先确定总条数
        int countAllInfo();
        //分页  两个参数
        List<User> limtUser(@Param("index") int index,
                            @Param("size") int size);
    //方式二：插件分页
        Page<User> limitUserTwo();

    //where if sql查询
    List<User> findByAgeWhere(int age);

    //foreach
    List<User> findUserListByIds(@Param("userIdList") List<Integer> userlist);
}
