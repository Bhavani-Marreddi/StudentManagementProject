package com.example.demo.controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentServiceImpl;

public class StudentController {
public StudentServiceImpl stuServ;
	
	
	
	public StudentController(StudentServiceImpl stuServ) {
		this.stuServ = stuServ;
	}



	@PostMapping("/saveStu")
	public ResponseEntity<Student> saveStu(@RequestBody Student stu){
		return new ResponseEntity<Student>(stuServ.saveStu(stu), HttpStatus.CREATED);
	}
	
	
	@PutMapping("/updateStu/{stuId}")
	public ResponseEntity<Student> updateStuDetailsById(@PathVariable("stuId") int id,
			@RequestBody Student stu){
		return new ResponseEntity<Student>(stuServ.updateStuDetails(stu, id), HttpStatus.OK);
		
	}
	@GetMapping("/readAllStu")
	public List<Student> getAllStu(){
		return stuServ.getStuFromDb();
	}
	
	@GetMapping("/readStu/{id}")
	public ResponseEntity<Student>  getStudentById(@PathVariable("id")  int stuId){
		return new ResponseEntity<Student>(stuServ.getStudentById(stuId), HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteStu/{id}")
	public ResponseEntity<String> deleteStudentById(@PathVariable("id")  int stuId){
		stuServ.deleteStuById(stuId);
		return new ResponseEntity<String>("deleted successfully", HttpStatus.OK);
	}

}
