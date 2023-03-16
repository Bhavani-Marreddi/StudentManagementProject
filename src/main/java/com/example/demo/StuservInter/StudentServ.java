package com.example.demo.StuservInter;

import java.util.List;

import com.example.demo.model.Student;

public interface StudentServ {

	Student saveStu(Student stu);
	 List<Student> getStuFromDb();
	 Student  getStudentById(int stuId);
	 Student updateStuDetails(Student newVal, int stuId);
	 void deleteStuById(int stuId);
}