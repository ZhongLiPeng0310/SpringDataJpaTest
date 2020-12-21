package com.manong;

import com.manong.dao.StudentRepository;
import com.manong.entity.Grade;
import com.manong.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class OneToOneApplicationTests {

    @Resource
    private StudentRepository studentRepository;

    @Test
    void contextLoads() {

        //创建年级对象
        Grade grade = new Grade();
        grade.setGradeName("一年级");

        //创建学生对象
        Student student1 = new Student();
        student1.setStudentName("张三");
        student1.setGrade(grade);

        //保存学生信息
        studentRepository.save(student1);
    }

}
