import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RulesTest {
	private List<Integer> randomNumbers = Arrays.asList(2,4,5,6);
	private List<Integer> guessNumbers;

	@Test
	public void should_get_empty_string_if_no_number_is_same_at_the_same_position() {
		 guessNumbers = Arrays.asList(1,3,7,9);

		String score = Rules.getScore(randomNumbers, guessNumbers);

		assertThat(score, is(""));
	}

	@Test
	public void should_get_1A_if_the_1_number_is_same_at_the_same_position() {
		 guessNumbers = Arrays.asList(2,3,7,9);

		String score = Rules.getScore(randomNumbers, guessNumbers);

		assertThat(score, is("1A"));
	}

	@Test
	public void should_get_2A_if_the_2_number_is_same_at_the_same_position() {
		 guessNumbers = Arrays.asList(2,3,5,9);

		String score = Rules.getScore(randomNumbers, guessNumbers);

		assertThat(score, is("2A"));
	}

	@Test
	public void should_get_3A_if_the_3_number_is_same_at_the_same_position() {
		 guessNumbers = Arrays.asList(2,4,5,9);

		String score = Rules.getScore(randomNumbers, guessNumbers);

		assertThat(score, is("3A"));
	}


	@Test
	public void should_get_4A_if_the_4_number_is_same_at_the_same_position() {
		guessNumbers = Arrays.asList(2, 4, 5, 6);

		String score = Rules.getScore(randomNumbers, guessNumbers);

		assertThat(score, is("4A"));
	}

	@Test
	public void should_get_1B_if_1_number_is_same_at_different_position() {
         guessNumbers = Arrays.asList(1,2,9,8);

		String score = Rules.getScore(randomNumbers, guessNumbers);

		assertThat(score, is("1B"));
	}

	@Test
	public void should_get_2B_if_2_number_is_same_at_different_position() {
		guessNumbers = Arrays.asList(1,2,6,8);

		String score = Rules.getScore(randomNumbers, guessNumbers);

		assertThat(score, is("2B"));
	}

	@Test
	public void should_get_3B_if_3_number_is_same_at_different_position() {
		guessNumbers = Arrays.asList(8,5,4,2);

		String score = Rules.getScore(randomNumbers, guessNumbers);

		assertThat(score, is("3B"));
	}

	@Test
	public void should_get_4B_if_4_number_is_same_at_different_position() {
		guessNumbers = Arrays.asList(6,5,4,2);

		String score = Rules.getScore(randomNumbers, guessNumbers);

		assertThat(score, is("4B"));
	}


	@Test
	public void should_get_2A2B_if_2_number_is_same_at_same_position_and_2_number_is_same_at_different_position() {
		guessNumbers = Arrays.asList(2,4,6,5);

		String score = Rules.getScore(randomNumbers, guessNumbers);

		assertThat(score, is("2A2B"));
	}

}
