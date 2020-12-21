package com.manong.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
@NoArgsConstructor  //自动生成无参数构造函数。
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String studentName;


    //一对一 ：一个学生对应一个班级
    @OneToOne(cascade = CascadeType.PERSIST)  //标记一对一关联,cascade属性：设置级联操作
    @JoinColumn(name = "grade_id")  //外键列
    private Grade grade;


}
