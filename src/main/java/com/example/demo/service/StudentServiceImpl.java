package com.example.demo.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.StuservInter.StudentServ;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepo;

@Service
public class StudentServiceImpl implements StudentServ{

	StudentRepo stuRepo;

	public StudentServiceImpl(StudentRepo stuRepo) {
		this.stuRepo = stuRepo;
	}

	public Student saveStu(Student stu) {
		return stuRepo.save(stu);
	}

	@Override
	public List<Student> getStuFromDb() {
		return stuRepo.findAll();
	}

	@Override
	public Student  getStudentById(int stuId) {
		Optional<Student> stu = stuRepo.findById(stuId);
		if(stu.isPresent()) {
			return stu.get();
		}
		else {
			return null;
		}
	}

	@Override
	public Student updateStuDetails(Student newVal, int stuId) {
		Optional<Student> stu = stuRepo.findById(stuId);
		if(stu.isPresent()) {
			Student existingStu = stu.get();  

			existingStu.setFirstName(newVal.getFirstName());
			existingStu.setLastName(newVal.getLastName());
			existingStu.setEmail(newVal.getEmail());
			existingStu.setStudentDateOfJoning(newVal.getStudentDateOfJoning());
			existingStu.setStudentPhoneNo(newVal.getStudentPhoneNo());
			existingStu.setStudentTotalMarks(newVal.getStudentTotalMarks());
			stuRepo.save(existingStu);
			return existingStu;
		}
		else {
			return null;
		}
	}

	@Override
	public void deleteStuById(int stuId) {
		Optional<Student> stu = stuRepo.findById(stuId);
		if(stu.isPresent()) {
			stuRepo.deleteById(stuId);
		}	
	}
}