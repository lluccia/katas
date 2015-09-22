package bowling;

public class Game {
	
	private int[] rolls = new int[20];
	private int currentRoll = 0;

	private static final String SPACE = " ";
	private static final String STRIKE_SYMBOL = "#";
	private static final String SPARE_SYMBOL = "/";
	private static final String FRAME_SEPARATOR = "|";
	
	public void roll(int pins) {
		rolls[currentRoll++] = pins;
	}

	public int getScore() {
		return getScore(10);
	}
	
	public int getScore(int lastFrame) {
		int score = 0;
		int firstBallInFrame = 0;
		for (int frame = 1; frame <= lastFrame; frame++) {
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

	public String score() {
		String score = printFirstLine() + "\n" +
	                   printSecondLine();
		return score;
	}

	private String printFirstLine() {
		String line = "";
		
		int firstBallInFrame = 0;
		for (int frame = 1; frame <= 9; frame++) {
			line += FRAME_SEPARATOR; 
			line += SPACE;
			if (isStrike(firstBallInFrame)) {
				line += SPACE;
				line += SPACE;
				line += STRIKE_SYMBOL;
				firstBallInFrame++;
			} else {
				line += rolls[firstBallInFrame];
				line += SPACE;
				line += isSpare(firstBallInFrame) ? SPARE_SYMBOL : rolls[firstBallInFrame + 1];
				firstBallInFrame += 2;
			}
			line += SPACE;
		}
		line += FRAME_SEPARATOR; 
		line += SPACE;
		if (isStrike(firstBallInFrame)|| isSpare(firstBallInFrame)) {
			line += isStrike(firstBallInFrame) ? STRIKE_SYMBOL : rolls[firstBallInFrame];
			line += SPACE;
			line += isStrike(firstBallInFrame+1) ? STRIKE_SYMBOL : isSpare(firstBallInFrame) ? SPARE_SYMBOL : rolls[firstBallInFrame+1];
			line += SPACE;
			line += isStrike(firstBallInFrame+2) ? STRIKE_SYMBOL : rolls[firstBallInFrame+2];
			line += SPACE;
		} else {
			line += rolls[firstBallInFrame];
			line += SPACE;
			line += rolls[firstBallInFrame+1];
			line += SPACE;
			line += "-";
			line += SPACE;
		}
		line += FRAME_SEPARATOR;
		
		return line;
	}
	
	private String printSecondLine() {
		String line = "";
		for (int frame = 1; frame <= 10; frame++) {
			line += FRAME_SEPARATOR;
			line += SPACE;
			line += String.format("%3d", getScore(frame));
			line += SPACE;
		}
		
		line += SPACE + SPACE;
		line += FRAME_SEPARATOR;
				
		return line;
	}

}
