package com.manong.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //自增
    private Integer id;
    private String projectName;


    /**
     * 配置项目到员工的多对多关系
     * 配置多对多的映射关系
     * 1.声明表关系的配置
     * @ManyToMany(targetEntity = Employee.class) //多对多
     * targetEntity：代表对方的实体类字节码
     */
    //一对多
    @ManyToMany(targetEntity =Employee.class ,cascade = CascadeType.ALL)
    private Set<Employee> employees = new HashSet<>();

    /*
     * 2.配置中间表（包含两个外键）
     * @JoinTable
     * name : 中间表的名称
     * joinColumns：配置当前对象在中间表的外键
     * @JoinColumn的数组
     * name：外键名
     * referencedColumnName：参照的主表的主键名
     * inverseJoinColumns：配置对方对象在中间表的外键
     */
    //第三张表（外键关系表、中间表）
    //name属性：第三张表的表名称
    @JoinTable(name = "t_employee_project",
            //joinColumns：当前对象在中间表中的外键
            joinColumns = @JoinColumn(name = "project_id",referencedColumnName = "id"),
            //inverseJoinColumns:对方对象在中间表的外键
            inverseJoinColumns = @JoinColumn(name = "employee_id",referencedColumnName = "id"))



    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
