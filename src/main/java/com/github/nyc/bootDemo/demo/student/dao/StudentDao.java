package com.github.nyc.bootDemo.demo.student.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.github.nyc.bootDemo.demo.student.domain.Student;

//@Mapper
public interface StudentDao {

	public List<Student> getStudentList();

    public Student getStudentById(String id);

    public void addStudent(Student student);

    public void updateStudentById(Student student);

    public void deleteStudentById(String id);

    public int  getStudentCount();

    }