package com.manong.repository;

import com.manong.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * 自定义数据访问层需要继承JPA提供的七大接口任意一个
 * CrudRepository<T,ID>是JPA提供的用于实现增删改查的接口
 *   其中 ， T是指泛型，ID是该泛型中主键的数据类型
 */
public interface UserRespository extends CrudRepository<User,Integer> {
}
