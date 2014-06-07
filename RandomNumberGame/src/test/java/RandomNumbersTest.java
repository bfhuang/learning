import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class RandomNumbersTest {

	@Test
	public void should_generate_four_different_random_numbers(){
		RandomNumbers randomNumbers = new RandomNumbers();

		List<Integer> numbers = randomNumbers.getRandomNumbers();

		assertThat(numbers.size(), is(4));
		assertTrue(numberBetween0And9(numbers.get(0)));
		assertTrue(numberBetween0And9(numbers.get(1)));
		assertTrue(numberBetween0And9(numbers.get(2)));
		assertTrue(numberBetween0And9(numbers.get(3)));
	}

	private boolean numberBetween0And9(Integer number) {
		return number<=9 && number>=0;
	}
}
