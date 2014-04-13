package com.springapp.mvc;

import org.junit.Test;
import org.springframework.ui.ModelMap;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HelloControllerTest {

	@Test
	public void shouldRenderHelloPageAndContainTheMessageValue() throws Exception {
		//given
		ModelMap model = new ModelMap();
		//when
		String returnView = new HelloController().printWelcome(model);
		//then
		assertThat(returnView, is("hello"));
		assertThat(model.get("message").toString(), is("Hello"));

	}
}
