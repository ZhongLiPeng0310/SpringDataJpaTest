package com.manong.repository;

import com.manong.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRespository extends JpaRepository<User,Integer> {

    //注意：方法的名称必须要遵循驼峰式命名规则。xxxBy(关键字)+属性名称(首字母大写)+查询条件关键字(首字母大写)

    //根据用户名模糊查询
    List<User> findByUserNameLike(String userName);

    //根据年龄查询（查询大于等于指定年龄的用户信息，例如：查询>=20岁的用户）
    List<User> findByAgeGreaterThanEqual(Integer age);

    //根据用户名，年龄查询(并且关系）
    List<User> findByUserNameLikeAndAgeGreaterThan(String userName,Integer age);


}
