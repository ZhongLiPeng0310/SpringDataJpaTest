package com.manong;

import com.manong.entity.User;
import com.manong.repository.UserRespository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class Chapter03ApplicationTests {

    @Resource
    private UserRespository userRespository;

    //根据用户名模糊查询
    @Test
    void contextLoads() {
        List<User> users = userRespository.findByUserNameLike("%李%");
        for (User user : users){
            System.out.println(user);
        }
    }

    //根据年龄查询（查询大于等于指定年龄的用户信息，例如：查询>=20岁的用户）
    @Test
    public void test1(){
        List<User> users = userRespository.findByAgeGreaterThanEqual(20);
        for (User user : users){
            System.out.println(user);
        }
    }

    //根据用户名，年龄查询(并且关系）
    @Test
    public void test2(){
        List<User> users = userRespository.findByUserNameLikeAndAgeGreaterThan("%李%", 20);
        for (User user : users){
            System.out.println(user);
        }
    }
}
