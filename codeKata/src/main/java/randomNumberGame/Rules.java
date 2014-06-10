package randomNumberGame;

import java.util.List;

public class Rules {
	public static String getScore(List<Integer> randomNumbers, List<Integer> guessNumbers) {
		String result = "";
		result += getAScores(randomNumbers, guessNumbers);
		result += getBScores(randomNumbers, guessNumbers);
		return result;
	}

	private static String getBScores(List<Integer> randomNumbers, List<Integer> guessNumbers) {
		int rightNumbers = 0;
		for(int i = 0; i<randomNumbers.size(); i++){
			for(int j =0; j< guessNumbers.size();j++){
				if(j!=i && randomNumbers.get(i) == guessNumbers.get(j)){
					rightNumbers++;
				}
			}
		}
		return rightNumbers>0?rightNumbers+"B":"";
	}

	private static String getAScores(List<Integer> randomNumbers, List<Integer> guessNumbers) {
		int rightNumbers = 0;
		for (int i = 0; i < randomNumbers.size(); i++) {
			if (randomNumbers.get(i) == guessNumbers.get(i)) {
				rightNumbers++;
			}
		}
		return rightNumbers > 0?rightNumbers+"A":"";
	}
}
