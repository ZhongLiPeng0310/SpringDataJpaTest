package com.manong;

import com.manong.entity.User;
import com.manong.repository.UserRespository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.Optional;

@SpringBootTest
class Chapter01ApplicationTests {

    @Resource
    private UserRespository userRespository;
    @Test
    void contextLoads() {

    /**
     * 添加数据
     */
        //创建对象
        User user = new User();
        user.setUserName("王五");
        user.setAddress("广州市天河区");
        user.setAge(22);
//        user.setId(2);
        // 一但指定ID，isNew()方法返回false
        //调用保存的方法
        User flag = userRespository.save(user);
        if (flag != null){
            System.out.println("添加成功！");
        }else {
            System.out.println("添加失败！");
        }
    }

    /**
     * 根据主键查询数据
     */
    @Test
    public void testFindById(){
        Optional<User> user = userRespository.findById(3);
        System.out.println(user.get());
    }

    /**
     * 查询所有数据
     */
    @Test
    public void testFindAll(){
        //调用查询所有数据的方法
        Iterable<User> all = userRespository.findAll();
        //获取迭代器对象
        Iterator<User> iterator = all.iterator();
        //循环遍历
        while (iterator.hasNext()){
            //循环获取到每一个用户对象
            User user = iterator.next();
            System.out.println(user);
        }
    }

    /**
     * 统计数量
     */
    @Test
    public void testCount(){
        long count = userRespository.count();
        System.out.println(count);
    }

    /**
     * 根据主键删除
     */
    @Test
    public void testDeleteById(){
        userRespository.deleteById(2);
    }
}
