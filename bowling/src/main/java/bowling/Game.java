package bowling;

public class Game {

	private int[] rolls = new int[20];
	private int currentRoll = 0;

	public void roll(int pins) {
		rolls[currentRoll++] = pins;
	}

	public int getScore() {
		int score = 0;
		int firstBallInFrame = 0;
		for (int frame = 0; frame < 10; frame++) {
			if (isStrike(firstBallInFrame)) {
				score += 10 + nextTwoBalls(firstBallInFrame);
				firstBallInFrame++;
			} else if (isSpare(firstBallInFrame)) {
				score += 10 + nextBall(firstBallInFrame);
				firstBallInFrame += 2;
			} else {
				score += sumBallsInFrame(firstBallInFrame);
				firstBallInFrame += 2;
			}
		}
		return score;
	}

	private int sumBallsInFrame(int firstBallInFrame) {
		return rolls[firstBallInFrame] + rolls[firstBallInFrame + 1];
	}

	private int nextBall(int firstBallInFrame) {
		return rolls[firstBallInFrame + 1];
	}
	
	private int nextTwoBalls(int firstBallInFrame) {
		return rolls[firstBallInFrame + 1] + rolls[firstBallInFrame + 2];
	}
	
	private boolean isStrike(int firstBallInFrame) {
		return rolls[firstBallInFrame] == 10;
	}

	private boolean isSpare(int firstBallInFrame) {
		return sumBallsInFrame(firstBallInFrame) == 10;
	}

}
