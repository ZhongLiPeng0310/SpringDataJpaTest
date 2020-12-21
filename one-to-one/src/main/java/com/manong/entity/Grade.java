package com.manong.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@NoArgsConstructor //自动生成无参数构造函数。
@Entity
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String gradeName;

    //指定学生对象
    @OneToOne(mappedBy = "grade")  //mappedBy属性：设置维护关系者，grade是Student中的属性名
   private Student student;

}
