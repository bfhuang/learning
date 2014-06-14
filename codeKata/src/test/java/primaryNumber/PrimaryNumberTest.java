package primaryNumber;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class PrimaryNumberTest {

	private List<Integer> primaryNumbers;

	@Test
	public void should_return_null_if_the_input_is_less_than_2(){
		primaryNumbers = PrimaryNumber.generatePrimaryNumbers(-1);

		assertThat(primaryNumbers, nullValue());
	}

	@Test
	public void should_return_primary_number_list_when_the_input_contains_primary_number() {
		primaryNumbers = PrimaryNumber.generatePrimaryNumbers(42);

		assertThat(primaryNumbers, is(Arrays.asList(2, 3, 7)));
	}



}
