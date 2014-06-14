package calculator;

import org.junit.Test;

import static calculator.Calculator.add;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {

	@Test
	public void should_return_0_if_input_is_null() {
		int sum = add("");

		assertThat(sum, is(0));
	}

	@Test
	public void should_return_the_number_if_input_is_just_contains_one_number(){
		assertThat(add("1"), is(1));

	}

	@Test
	public void should_return_the_sum_if_input_contains_more_than_one_number() {
		assertThat(add("1,2"), is(3));
		assertThat(add("1,2,3"), is(6));
	}

	@Test
	public void should_return_the_sum_if_split_char_is_line_break(){
		assertThat(add("1\n3"), is(4));
		assertThat(add("1\n3,5"), is(9));
	}


}
