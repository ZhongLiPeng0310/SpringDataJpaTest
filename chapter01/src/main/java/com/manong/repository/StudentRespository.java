package com.manong.repository;

import com.manong.entity.Student;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * PagingAndSortingRepository接口  主要用于分页和排序操作，该接口继承的是
 */
public interface StudentRespository extends PagingAndSortingRepository<Student,Integer> {

}
