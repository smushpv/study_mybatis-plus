package com.mpdemo.demo;

import com.mpdemo.demo.entity.User;
import com.mpdemo.demo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private UserMapper userMapper;

    /*查询所有*/
    @Test
    void testQueryUser() {
        List<User> users = userMapper.selectList(null);
        users.forEach(user -> {
            System.out.println(user);
        });
    }

    /*新增用户*/
    @Test
    void testSaveUser() {
        User user = new User();
        user.setName("大美女");
        user.setAge(23);
        user.setEmail("12365@163.com");
        //影响的行数
        int flag = userMapper.insert(user);
        System.out.println(flag);
    }

    /*修改用户
    * 1 先查
    * 2 在改
    * */
    @Test
    void testUpdateUser() {
        User user = new User();
        user.setId(1264968540612108290L);
        user.setName("邵舒");
        //影响的行数
        int flag = userMapper.updateById(user);
        System.out.println(flag);
    }


}
