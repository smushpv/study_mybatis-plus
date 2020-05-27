package com.mpdemo.demo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mpdemo.demo.entity.User;
import com.mpdemo.demo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private UserMapper userMapper;


    /*新增用户*/
    @Test
    void testSaveUser() {
        User user = new User();
        user.setName("胡馨月");
        user.setAge(28);
        user.setEmail("12365@qq.com");
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
        User user = userMapper.selectById(1265265538632413185L);
        user.setName("暗黑者");
        user.setAge(90);
        //影响的行数
        int flag = userMapper.updateById(user);
        System.out.println(flag);
    }

    /*查询所有*/
    @Test
    void testQueryUser() {
        List<User> users = userMapper.selectList(null);
        users.forEach(user -> {
            System.out.println(user);
        });
    }

    /*根据id,批量查询*/
    @Test
    void testQueryMany() {
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1,2));
        users.forEach(user -> {
            System.out.println(user);
        });
    }

    /*简单条件查询*/
    @Test
    void testQueryCondition() {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("age","23");
        List<User> users = userMapper.selectByMap(map);
        users.forEach(user -> {
            System.out.println(user);
        });
    }

    /*分页查询*/
    @Test
    void testQueryPages() {
        Page<User> userPage = new Page<>(1,3);
        userMapper.selectPage(userPage,null);
        List<User> users = userPage.getRecords();
        users.forEach(user -> {
            System.out.println(user);
        });
    }

    /*逻辑删除*/
    @Test
    void testDelete() {
        userMapper.deleteById(1265299321645563906L);
    }

}
