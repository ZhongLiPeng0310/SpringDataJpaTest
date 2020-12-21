package com.manong;

import com.manong.Repository.RoleRepository;
import com.manong.entity.Role;
import com.manong.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class OneToManyApplicationTests {

    @Resource
    private RoleRepository roleRepository;

    @Test
    void contextLoads() {

        //添加角色的同时添加用户
        Role role = new Role();
        role.setRoleName("系统管理员");

        //添加用户
        User user1 = new User();
        user1.setUserName("张三");
        user1.setRole(role);
        User user2 = new User();
        user2.setUserName("李四");
        user2.setRole(role);

        //设置关系
        role.getUsers().add(user1);
        role.getUsers().add(user2);

        //保存角色
        roleRepository.save(role);
    }

}
