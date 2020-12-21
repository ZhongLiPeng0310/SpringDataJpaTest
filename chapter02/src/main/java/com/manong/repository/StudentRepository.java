package com.manong.repository;

import com.manong.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * JpaRepository接口：用于增删改查操作，该接口是最常用的接口
 * JpaSpecificationExecutor接口：用于实现动态条件查询，其中 T是值泛型类
 */
public interface StudentRepository extends JpaRepository<Student,Integer>, JpaSpecificationExecutor<Student> {
}
