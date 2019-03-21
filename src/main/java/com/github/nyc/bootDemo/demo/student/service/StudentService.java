package com.github.nyc.bootDemo.demo.student.service;

import com.github.nyc.bootDemo.annotation.Master;
import com.github.nyc.bootDemo.demo.student.dao.StudentDao;
import com.github.nyc.bootDemo.demo.student.domain.Student;
import com.github.nyc.bootDemo.demo.user.dao.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 18:16 2019/3/20
 * @Description
 **/
@Service
public class StudentService {

    @Resource
    private StudentDao studentDao;

    @Master
    public List<Student> getStudentList() {
        return  studentDao.getStudentList();
    }


    public  Student getStudentById(String id) {
        return  studentDao.getStudentById(id);
    }


    public void addStudent(Student student) {
        studentDao.addStudent(student);
    }


    public void updateStudent(Student student) {
        studentDao.updateStudentById(student);
    }


    public void deleteStudentById(String id) {
        studentDao.deleteStudentById(id);
    }


    public int  getStudentCount() {
        return  studentDao.getStudentCount();
    }


}
