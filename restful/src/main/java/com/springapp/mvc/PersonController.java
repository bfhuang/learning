package com.springapp.mvc;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import person.Person;

import java.util.Arrays;

@Controller
@RequestMapping(value = "/person")
public class PersonController {


	@RequestMapping(method = RequestMethod.GET, produces = {MediaType.TEXT_HTML_VALUE})
	public String getPerson(ModelMap model) {
		model.addAttribute("people", Arrays.asList(createPerson()));
		return "person";
	}

	private Person createPerson() {
		Person person = new Person();
		person.setId(1);
		person.setFirstName("firstName");
		person.setLastName("lastName");
		return person;
	}

	@RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public Person getPerson() {
		return createPerson();
	}


//	@RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
//	@ResponseBody
//	public List<Person> getPerson() {
//		return Arrays.asList(createPerson());
//	}

}