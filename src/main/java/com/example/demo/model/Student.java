package com.example.demo.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table (name = "Student")
@DynamicUpdate
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	private String lastName;
	private String email;
	private String studentDateOfJoning;
	private String studentPhoneNo;
	private Float studentTotalMarks;
	public Student() {}
	
	public Student(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public Student(String firstName, String lastName, String email, String studentDateOfJoning, String studentPhoneNo, float studentTotalMarks) {
		this(firstName, lastName);
		this.email = email;
		this.studentDateOfJoning=studentDateOfJoning;
		this.studentPhoneNo=studentPhoneNo;
		this.studentTotalMarks=studentTotalMarks;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getStudentDateOfJoning() {
		return studentDateOfJoning;
	}

	public void setStudentDateOfJoning(String studentDateOfJoning) {
		this.studentDateOfJoning = studentDateOfJoning;
	}

	public String getStudentPhoneNo() {
		return studentPhoneNo;
	}

	public void setStudentPhoneNo(String studentPhoneNo) {
		this.studentPhoneNo = studentPhoneNo;
	}

	public Float getStudentTotalMarks() {
		return studentTotalMarks;
	}

	public void setStudentTotalMarks(Float studentTotalMarks) {
		this.studentTotalMarks = studentTotalMarks;
	}
}

