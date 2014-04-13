package com.springapp.mvc;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.ui.ModelMap;
import org.springframework.web.client.RestTemplate;
import student.Student;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StudentControllerTest {

	private StudentController studentController = new StudentController();

	@Test
	@Ignore
	public void shouldRenderStudentsPageAndReturnAllPassedStudentsList() {
		ModelMap modelMap = new ModelMap();

		List<Student> expectedStudents = Arrays.asList(
				new Student("studentTwo", 60),
				new Student("studentThree", 70));

		assertThat(studentController.getStudents(modelMap), is("students"));
		assertThat((List<Student>) modelMap.get("students"), is(expectedStudents));

	}

	@Test
	@Ignore
	public void shouldGetJson() {

		RestTemplate restTemplate = new RestTemplate();

		Student forObject =  restTemplate.getForObject("http://localhost:8080/SpringMVC/passedStudents/student",
				Student.class);
		System.out.println(forObject.getName());
		System.out.println(forObject.toString());
	}




}
