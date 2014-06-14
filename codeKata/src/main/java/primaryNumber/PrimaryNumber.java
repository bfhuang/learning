package primaryNumber;

import java.util.ArrayList;
import java.util.List;

public class PrimaryNumber {

	public static List<Integer> generatePrimaryNumbers(int input) {
		if (input < 2)
			return null;
		return doGenerate(input);
	}

	private static List<Integer> doGenerate(int input) {
		ArrayList<Integer> results = new ArrayList<Integer>();

		int baseNumber = 2;
		while (input >= baseNumber) {
			while (input % baseNumber == 0) {
				input /= baseNumber;
				results.add(baseNumber);
			}
			baseNumber++;
		}
		return results;
	}


}
