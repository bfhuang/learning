package com.springapp.mvc;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import student.Student;
import student.StudentService;

import java.util.List;

@Controller
@RequestMapping(value = "/students")
public class StudentController {

	private StudentService studentService = new StudentService();


	@RequestMapping(method = RequestMethod.GET, produces = {MediaType.TEXT_HTML_VALUE})
	public String getStudents(ModelMap model) {
		model.addAttribute("students", studentService.getAllStudent());
		return "students";
	}

	@RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public List<Student> getJson() {
		return studentService.getAllStudent();
	}
}