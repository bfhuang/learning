package randomNumberGame;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class RandomNumbers {

	public List<Integer> getRandomNumbers() {
		HashSet numbers = new HashSet();
		Random random = new Random();
		while(numbers.size()<4){
			numbers.add(random.nextInt(10));
		}
		return new ArrayList<Integer>(numbers);
	}
}
