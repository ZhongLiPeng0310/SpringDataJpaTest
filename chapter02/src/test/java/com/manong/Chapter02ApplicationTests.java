package com.manong;

import com.manong.entity.Student;
import com.manong.repository.StudentRepository;
import com.manong.vo.StudentVo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@SpringBootTest
class Chapter02ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Resource
    private StudentRepository studentRepository;

    @Test
    public void testFindAll(){
        List<Student> studentList = studentRepository.findAll();
        for (Student student : studentList){
            System.out.println(student);
        }
    }

    //动态查询
    @Test
    public void test1(){
        //创建查询条件对象
        StudentVo studentVo = new StudentVo();
//        studentVo.setAge(25);
        studentVo.setAddress("番禺区");
        //调用动态查询方法
        List<Student> studentList = studentRepository.findAll(new Specification<Student>() {
            //在该方法内实现动态条件查询
            @Override
            public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                //获取条件对象
                Predicate predicate = criteriaBuilder.conjunction();
                //判断查询条件对象是否为空
                if (studentVo != null){
                    //按姓名模糊查询
                    if (!ObjectUtils.isEmpty(studentVo.getStudentName())){
                        //root.get("实体类的属性名称“）
                        predicate.getExpressions().add(criteriaBuilder.like(root.get("studentName"),"%"+studentVo.getStudentName()+"%"));
                    }
                    //查询大于指定年龄
                    if (!ObjectUtils.isEmpty(studentVo.getAge())){
                        predicate.getExpressions().add(criteriaBuilder.ge(root.get("age"),studentVo.getAge()));
                    }
                    //按地址模糊查询
                    if (!ObjectUtils.isEmpty(studentVo.getAddress())){
                        predicate.getExpressions().add(criteriaBuilder.like(root.get("address"),"%"+studentVo.getAddress()+"%"));
                    }
                }
                return predicate;
            }
        });
        //循环遍历
        for (Student student : studentList){
            System.out.println(student);
        }
    }

    //动态查询+分页查询
    @Test
    public void test2(){
        //创建查询条件对象
        StudentVo studentVo = new StudentVo();
        studentVo.setAge(25);
        studentVo.setAddress("番禺区");
        //创建分页对象
        PageRequest pageRequest = PageRequest.of(0, 3, Sort.Direction.DESC, "id");
        //分页动态查询
        Page<Student> page = studentRepository.findAll(new Specification<Student>() {
            //在该方法内实现动态条件查询
            @Override
            public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                //获取条件对象
                Predicate predicate = criteriaBuilder.conjunction();
                //判断查询条件对象是否为空
                if (studentVo != null){
                    //按姓名模糊查询
                    if (!ObjectUtils.isEmpty(studentVo.getStudentName())){
                        //root.get("实体类的属性名称“）
                        predicate.getExpressions().add(criteriaBuilder.like(root.get("studentName"),"%"+studentVo.getStudentName()+"%"));
                    }
                    //查询大于指定年龄
                    if (!ObjectUtils.isEmpty(studentVo.getAge())){
                        predicate.getExpressions().add(criteriaBuilder.ge(root.get("age"),studentVo.getAge()));
                    }
                    //按地址模糊查询
                    if (!ObjectUtils.isEmpty(studentVo.getAddress())){
                        predicate.getExpressions().add(criteriaBuilder.like(root.get("address"),"%"+studentVo.getAddress()+"%"));
                    }
                }
                return predicate;
            }
        },pageRequest);

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
