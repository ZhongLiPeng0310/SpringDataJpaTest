package com.manong.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data  //lombok注释 可以不用写getter and setter
@Entity  //标记该类时一个持久化类（与数据库的表进行关联）
public class User {
    @Id //标记该属性时一个逐渐字段
    @GeneratedValue(strategy = GenerationType.IDENTITY) //指定主键生成策略
    private Integer id;
    private String userName;
    private Integer age;
    private String address;
}
