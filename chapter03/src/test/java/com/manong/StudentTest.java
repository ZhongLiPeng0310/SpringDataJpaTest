package com.manong;

import com.manong.entity.Student;
import com.manong.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
public class StudentTest {

    @Resource
    private StudentRepository studentRepository;

    @Test
    public void test(){
        //调用根据学生姓名查询的方法
        List<Student> studentList = studentRepository.findStudentByName("李");
        for (Student student : studentList){
            System.out.println(student);
        }
    }

    @Test
    public void test1(){
        //调用根据学生名字和地址模糊查询
        List<Student> studentList = studentRepository.findStudentByStudentNameAndAddress("李","黄埔区");
        for (Student student : studentList){
            System.out.println(student);
        }
    }

    @Test
    public void test2(){
        //调用根据学生名字和地址模糊查询
        List<Student> studentList = studentRepository.findStudentList("李","黄埔区");
        for (Student student : studentList){
            System.out.println(student);
        }
    }

    @Test
    public void test3(){
        //调用根据学生名字和地址模糊查询
        List<Student> studentList = studentRepository.findStudent("李","黄埔区");
        for (Student student : studentList){
            System.out.println(student);
        }
    }

    @Transactional  //开启事务
//    @Rollback(value = false)  //默认回滚  改为false禁止回滚事务
    @Commit  // 默认禁止回滚
    @Test
    public void test4(){
        //修改名称
        studentRepository.updateStudent("王五",2);
    }

    @Transactional  //开启事务
//    @Rollback(value = false)  //默认回滚  改为false禁止回滚事务
    @Commit  // 默认禁止回滚
    @Test
    public void test5(){
        //修改名称
        studentRepository.deleteStudent(2);
    }
}
