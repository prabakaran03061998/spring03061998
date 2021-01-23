package com.as.web;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abytz.model.Student;
import com.abytz.model.User;


@RestController
public class StudentController {
	
	List<Student> st=new ArrayList<Student>();
	
	@RequestMapping(value="/getstudent")
	public List<Student> getSingleUsers() {
		if(st == null)
			st =  new ArrayList<Student>();
			return st;
	}
	
	@PostMapping(value="/createstudent")
	public List<Student> getStudent(@RequestBody Student stu)
	{
		if(st!=null)
		 st =new ArrayList<Student>();
		 st.add(stu);
		 return st;		
	}
		
	@RequestMapping(value="/data")
	public Student studentData()
	{
		return new Student("S001", "prabakaran", "tony@gmail.com","Tony@1122");		
		 

	 }
}
		