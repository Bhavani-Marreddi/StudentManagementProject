package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;

@RestController
public class ExampleController {



	@GetMapping("/tellHi")
	public String sayHi() {
		return "hi everyone";
	}

	//http status  http message converters


	@GetMapping("/returnObject")
	public Student getEmployee() {
		return new Student("Seetha","K","seetha@gmail.com","2000-12-1","8759836541",865);
	}


	@GetMapping("/returnObjects")
	public List<Student> getEmployees() {
		List<Student> empList = new ArrayList<>();
		empList.add(new Student("Seetha","K","seetha@gmail.com","2000-12-1","8759836541",865));
		empList.add(new Student("Seema","Roy","seema123@gmail.com","1998-08-17","9856741258",965));
		empList.add(new Student("Ravi","L","ravi@gmail.com","2003-05-28","8745865124",658));
		empList.add(new Student("Raju","J","raju@gmail.com","2002-12-10","2564718569",555));
		empList.add(new Student("Geethika","K","geetha@gmail.com","2008-05-02","7584965214",957));
		return empList;
	}
	@GetMapping("{firstName}/{lastName}")
	public Student getEMpValues(@PathVariable("firstName") String fname,
			@PathVariable("lastName")	String lname) {
		return new Student(fname, lname);
	}
	
}

