package com.example.howtodoinjava.springbootsoapservice;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;

import firstsoap.anton.Address;
import firstsoap.anton.Student;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;


@Component
public class StudentRepository {
	private static final Map<String, Student> students = new HashMap<>();

	@PostConstruct
	public void initData() {
		Address address1=new Address("Mogilev","Kosmonavtov","8-52");
		Student student = new Student();
		student.setName("Anton");
		student.setStandard(5);
		student.setAddress(address1);
		students.put(student.getName(), student);

		Address address2=new Address("Minsk","Budenogo","3-65");
		student = new Student();
		student.setName("Andrey");
		student.setStandard(5);
		student.setAddress(address2);
		students.put(student.getName(), student);

		Address address3=new Address("Gomel","Chentralnaya","2-8");
		student = new Student();
		student.setName("Mikhail");
		student.setStandard(6);
		student.setAddress(address3);
		students.put(student.getName(), student);

	}

	public Student findStudent(String name) {
		Assert.notNull(name, "The Student's name must not be null");
		return students.get(name);
	}
}