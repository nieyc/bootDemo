package com.github.nyc.bootDemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.github.nyc.bootDemo.annotation.Master;
import com.github.nyc.bootDemo.demo.student.domain.Student;
import com.github.nyc.bootDemo.demo.student.service.StudentService;
import com.github.nyc.bootDemo.demo.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootDemoApplicationTests {

	@Autowired
	UserService userService;

	@Autowired
	StudentService studentService;

	@Test
	public  void getUserList(){
		userService.getUserList();
	}

    @Test
    public  void getUser(){
        userService.getUser();
    }

	//@Test
	public  void addStudent(){
		Student student=new Student();
		student.setName("zhangsan1");
		student.setScore("102");
		studentService.addStudent(student);
	}

	//@Test
	public void   getStudentList(){
		studentService.getStudentList();
	}
	


}
