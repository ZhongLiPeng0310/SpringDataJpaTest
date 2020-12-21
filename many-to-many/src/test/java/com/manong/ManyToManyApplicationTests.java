package com.manong;

import com.manong.Repository.ProjectRepository;
import com.manong.entity.Employee;
import com.manong.entity.Project;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@SpringBootTest
class ManyToManyApplicationTests {

    @Resource
    private ProjectRepository projectRepository;

    @Test
    //一下两个注解必须提供
    @Transactional//开启事务
    @Rollback(value = false)//取消回滚
    void contextLoads() {
        //创建员工
        Employee employee1 = new Employee();
        employee1.setEmpName("张三");

        Employee employee2 = new Employee();
        employee2.setEmpName("李四");

        Employee employee3 = new Employee();
        employee3.setEmpName("王五");

        //创建项目
        Project project1 = new Project();
        project1.setProjectName("超市管理系统");

        Project project2 = new Project();
        project2.setProjectName("酒店管理系统");

        project1.getEmployees().add(employee1);//张三负责超市管理系统
        project1.getEmployees().add(employee2);//李四负责超市管理系统
        project1.getEmployees().add(employee3);//王五负责超市管理系统

        project2.getEmployees().add(employee1);//张三负责酒店管理系统
        project2.getEmployees().add(employee2);//李四负责酒店管理系统
        project2.getEmployees().add(employee3);

        projectRepository.save(project1);
        projectRepository.save(project2);
    }

}
