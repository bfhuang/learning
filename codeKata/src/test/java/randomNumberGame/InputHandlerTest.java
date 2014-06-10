package randomNumberGame;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class InputHandlerTest {

	@Test
	public void should_generate_four_numbers_from_input(){

		List<Integer> numbers = InputHandler.getNumbers("1234");

		assertThat(numbers.size(), is(4));
		assertThat(numbers.get(0), is(1));
		assertThat(numbers.get(1), is(2));
		assertThat(numbers.get(2), is(3));
		assertThat(numbers.get(3), is(4));


	}
}
