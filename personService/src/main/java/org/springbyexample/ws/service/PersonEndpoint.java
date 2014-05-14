package org.springbyexample.ws.service;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import person.GetPersonRequest;
import person.GetPersonResponse;
import person.Person;

import java.util.Arrays;

@Endpoint
public class PersonEndpoint {
	public final static String NAMESPACE = "http://www.springbyexample.org/person/schema/beans";

	@ResponsePayload
	@PayloadRoot(localPart="GetPersonRequest", namespace=NAMESPACE)
	public GetPersonResponse getPerson(@RequestPayload GetPersonRequest request) {
		GetPersonResponse response = new GetPersonResponse();
		Person person = new Person();
		person.setId(1);
		person.setFirstName("firstName");
		person.setLastName("lastName");
		response.getPerson().addAll(Arrays.asList(person));
		return response;
	}
}
