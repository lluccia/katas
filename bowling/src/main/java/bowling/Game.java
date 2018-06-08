package bowling;

public class Game {
    
    private int[] rolls = new int[21];
    private int currentRoll = 0;

    private static final String SPACE = " ";
    private static final String STRIKE_SYMBOL = "#";
    private static final String SPARE_SYMBOL = "/";
    private static final String FRAME_SEPARATOR = "|";
    private String line;
    
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
            
            if (isStrike(firstBallInFrame))
                score += 10 + nextTwoBalls(firstBallInFrame);
            else if (isSpare(firstBallInFrame))
                score += 10 + nextBallForSpare(firstBallInFrame);
            else
                score += sumBallsInFrame(firstBallInFrame);
            
            firstBallInFrame = incrementFrame(firstBallInFrame);

        }
        return score;
    }

    private int sumBallsInFrame(int firstBallInFrame) {
        return rolls[firstBallInFrame] + rolls[firstBallInFrame + 1];
    }

    private int nextBallForSpare(int firstBallInFrame) {
        return rolls[firstBallInFrame + 2];
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

    private int incrementFrame(int firstBallInFrame) {
        if (isStrike(firstBallInFrame))
            firstBallInFrame++;
        else
            firstBallInFrame += 2;
        return firstBallInFrame;
    }

    public String printScore() {
        String score = printFirstLine() + "\n" +
                       printSecondLine();
        return score;
    }

    private String printFirstLine() {
        line = "";
        int firstBallInFrame = 0;
        for (int frame = 1; frame <= 9; frame++) {
            
            line += FRAME_SEPARATOR;
            line += printNormalFrame(firstBallInFrame);
                
            firstBallInFrame = incrementFrame(firstBallInFrame);
        }
        
        
        line += FRAME_SEPARATOR; 
        if (isStrike(firstBallInFrame) || isSpare(firstBallInFrame)) {
            line += SPACE;
            line += isStrike(firstBallInFrame) ? STRIKE_SYMBOL : rolls[firstBallInFrame];
            line += SPACE;
            line += isStrike(firstBallInFrame+1) ? STRIKE_SYMBOL : isSpare(firstBallInFrame) ? SPARE_SYMBOL : rolls[firstBallInFrame+1];
            line += SPACE;
            line += isStrike(firstBallInFrame+2) ? STRIKE_SYMBOL : rolls[firstBallInFrame+2];
            line += SPACE;
        } else {
            line += SPACE;
            line += rolls[firstBallInFrame];
            line += SPACE;
            line += rolls[firstBallInFrame+1];
            line += SPACE;
            line += (isStrike(firstBallInFrame) || isSpare(firstBallInFrame)) ? rolls[firstBallInFrame+2] : "-";
            line += SPACE;
        }
        line += FRAME_SEPARATOR;
        
        return line;
    }

    private String printNormalFrame(int firstBallInFrame) {
        return SPACE + frameFirstRow(firstBallInFrame) + SPACE + printFrameSecondRoll(firstBallInFrame) + SPACE;
    }

    private String printFrameSecondRoll(int firstBallInFrame) {
        String roll = "" + (
                isStrike(firstBallInFrame) ? 
                        STRIKE_SYMBOL :
                        isSpare(firstBallInFrame) ?
                                SPARE_SYMBOL :
                                rolls[firstBallInFrame+1]); 
        return roll;
    }

    private Object frameFirstRow(int firstBallInFrame) {
        return isStrike(firstBallInFrame) ?
                SPACE :
                rolls[firstBallInFrame];
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
