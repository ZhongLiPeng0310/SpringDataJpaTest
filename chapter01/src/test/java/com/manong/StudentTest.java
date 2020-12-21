package com.manong;

import com.manong.entity.Student;
import com.manong.repository.StudentRespository;
import javassist.runtime.Desc;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;

@SpringBootTest
public class StudentTest {
    @Resource
    private StudentRespository studentRespository;

    @Test
    public void makeData(){
        Student student = new Student();
        student.setStudentName("小八");
        student.setAddress("广州市番禺区市桥");
        student.setAge(20);
        //调用方法
        studentRespository.save(student);
    }

    /**
     * 排序
     */
    @Test
    public void testPageAndSort(){
        //创建排序的对象
        Sort sort = Sort.by(Sort.Direction.DESC, "id","age");
        //调用查询的方法
        Iterator<Student> iterator = studentRespository.findAll(sort).iterator();
        //循环遍历
        while (iterator.hasNext()){
            //获取每一个对象
            Student student = iterator.next();
            System.out.println(student);
        }
    }

    @Test
    public void testPage(){
        int pageNo = 1; //当前页
        int pageSize = 3;//每页显示的数量
        //设置分页信息
//        PageRequest pageRequest = PageRequest.of(pageNo-1, pageSize);//当前页码从0开始（0是第一页）
        PageRequest pageRequest = PageRequest.of(pageNo-1, pageSize, Sort.Direction.DESC,"age");
        //调用分页查询方法
        Page<Student> page = studentRespository.findAll(pageRequest);
        System.out.println("当前页码："+ (page.getNumber()+1));
        System.out.println("每页显示数量："+ page.getSize());
        System.out.println("总数量:"+page.getTotalElements());
        System.out.println("总页数："+page.getTotalPages());
        //获取数据列表
        List<Student> studentList = page.getContent();
        for(Student student:studentList){
            System.out.println(student);
        }

    }
}
