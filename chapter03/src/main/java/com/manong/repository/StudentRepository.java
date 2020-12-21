package com.manong.repository;

import com.manong.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    //默认使用JPGL作为查询语句，JPQL查询语句与HQL查询语句一致，查询的类名和属性名（严格区分大小写）
    @Query("from Student where studentName like %?1%")
    List<Student> findStudentByName(String studentName);


    //根据学生名字和地址模糊查询
    @Query("from Student where studentName like %?1% and address like %?2%")
    List<Student> findStudentByStudentNameAndAddress(String studentName,String address);

    @Query(value = "select * from student where student_name like %?1% and address like %?2% ",nativeQuery = true)
    List<Student> findStudentList(String studentName,String address);

    /**
     * 根据姓名和地址模糊查询
     * @param studentName
     * @param address
     * @return
     */
    @Query("from Student where studentName like %:name% and address like %:address%")
    List<Student> findStudent(@Param("name") String studentName, @Param("address") String address);

    /**
     * 标记方法是一个修改方法
     * @param studentName
     * @param id
     * @return
     */
    @Modifying
    @Query("update Student set studentName = ?1 where id = ?2")
    int updateStudent(String studentName,Integer id);

    /**
     * 标记方法为一个删除方法
     * @param id
     * @return
     */
    @Modifying
    @Query("delete from Student where id = ?1")
    int deleteStudent(Integer id);
}
