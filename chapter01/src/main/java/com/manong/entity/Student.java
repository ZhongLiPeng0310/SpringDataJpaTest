package com.manong.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * @author 12533
 */
@Data  //lombok注释 可以不用写getter and setter
@Entity  //标记该类时一个持久化类（与数据库的表进行关联）
// @Table(name = "t_user") //指定表名，当类名与表名一致时，可省略不写
public class Student {
    @Id //标记该属性时一个逐渐字段
    @GeneratedValue(strategy = GenerationType.IDENTITY) //指定主键生成策略
    private Integer id;
    private String studentName;
    private Integer age;
    private String address;

    //  Transient 标明该属性不会自动匹配到数据库表中
    @Transient
    private String sex;
}
