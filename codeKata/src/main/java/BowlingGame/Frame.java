package BowlingGame;

public class Frame {
	private final int firstHit;
	private final int secondHit;
	int score = 0;

	public Frame(int firstHit, int secondHit) {
		this.firstHit = firstHit;
		this.secondHit = secondHit;
	}

	public int score() {
		score = firstHit + secondHit == 10 ? 0 : firstHit + secondHit;
		return score;
	}
}
