package com.github.nyc.bootDemo.demo.student.controller;

import com.github.nyc.bootDemo.demo.student.domain.Student;
import com.github.nyc.bootDemo.demo.student.service.StudentService;
import com.github.nyc.bootDemo.demo.user.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 18:20 2019/3/20
 * @Description
 **/

@RestController
@RequestMapping("/student")
public class StudentController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentService studentService;

    @RequestMapping("/getStudentList")
    public List<Student> getStudentList() {
        List<Student> studentList=studentService.getStudentList();
        return studentList;
    }

}
