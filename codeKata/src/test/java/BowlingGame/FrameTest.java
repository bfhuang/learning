package BowlingGame;

import org.junit.Test;

public class FrameTest {

	private Frame frame;


	@Test
	public void should_got_the_sum_of_first_hit_and_second_hit() {

		frame = new Frame(2,3);

	}

	@Test
	public void should_got_the_first_hit_and_second_hit_and_the_next_frame_first_hit_if_the_first_and_second_hit_sum_is_10(){
       frame = new Frame(4,6);
	   Frame nextFrame = new Frame(3,4);



	}
}
