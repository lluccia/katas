package bowling;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BowlingTest {

    private Game game;

    private void rollMany(int rolls, int pins) {
        for (int i=0; i<rolls; i++)
            game.roll(pins);
    }

    private void rollSpare() {
        game.roll(5);
        game.roll(5);
    }

    private void rollStrike() {
        game.roll(10);
    }

    @Before
    public void setUp() {
        game = new Game();
    }
    
    @Test
    public void gutterGame() {
        rollMany(20, 0);
        
        assertEquals(0, game.getScore());
    }
    
    @Test
    public void allOnes() {
        rollMany(20, 1);
        
        assertEquals(20, game.getScore());
    }
    
    @Test
    public void oneSpare() {
        rollSpare();
        game.roll(5);
        rollMany(17, 0);
        
        assertEquals(20, game.getScore());
    }

    @Test
    public void oneStrike() {
        rollStrike(); //16
        game.roll(3);  //3
        game.roll(3);  //3
        rollMany(16, 0); 
        
        assertEquals(22, game.getScore());
    }

    @Test
    public void twoStrikes() {
        rollStrike();
        rollStrike();
        game.roll(3);  //3
        game.roll(3);  //3
        rollMany(14, 0);
        
        assertEquals(45, game.getScore());
    }

    @Test
    public void perfectGame() {
        rollMany(12, 10);
        
        assertEquals(300, game.getScore());
    }
    
    @Test
    public void printGutterGameScore() {
        rollMany(20, 0);
        String expectedScore = "| 0 0 | 0 0 | 0 0 | 0 0 | 0 0 | 0 0 | 0 0 | 0 0 | 0 0 | 0 0 - |\n" +
                               "|   0 |   0 |   0 |   0 |   0 |   0 |   0 |   0 |   0 |   0   |";
        
        assertEquals(expectedScore, game.printScore());
    }
    
    @Test
    public void printAllOnesGameScore() {
        rollMany(20, 1);
        String expectedScore = "| 1 1 | 1 1 | 1 1 | 1 1 | 1 1 | 1 1 | 1 1 | 1 1 | 1 1 | 1 1 - |\n" +
                               "|   2 |   4 |   6 |   8 |  10 |  12 |  14 |  16 |  18 |  20   |";
        
        assertEquals(expectedScore, game.printScore());
    }
    
    @Test
    public void printOneSpareGameScore() {
        rollSpare();
        game.roll(5);
        rollMany(17, 0);
        
        String expectedScore = "| 5 / | 5 0 | 0 0 | 0 0 | 0 0 | 0 0 | 0 0 | 0 0 | 0 0 | 0 0 - |\n" +
                               "|  15 |  20 |  20 |  20 |  20 |  20 |  20 |  20 |  20 |  20   |";
        
        assertEquals(expectedScore, game.printScore());
    }
    
    @Test
    public void printOneStrikeGameScore() {
        rollStrike(); //16
        game.roll(3);  //3
        game.roll(3);  //3
        rollMany(16, 0); 
        
        String expectedScore = "|   # | 3 3 | 0 0 | 0 0 | 0 0 | 0 0 | 0 0 | 0 0 | 0 0 | 0 0 - |\n" +
                               "|  16 |  22 |  22 |  22 |  22 |  22 |  22 |  22 |  22 |  22   |";
        
        assertEquals(expectedScore, game.printScore());
    }
    
    @Test
    public void printPerfectGameScore() {
        rollMany(12, 10);
        
        String expectedScore = "|   # |   # |   # |   # |   # |   # |   # |   # |   # | # # # |\n" +
                               "|  30 |  60 |  90 | 120 | 150 | 180 | 210 | 240 | 270 | 300   |";
        
        assertEquals(expectedScore, game.printScore());
    }
    
    @Test
    public void printSpareOnTenthFrameScore() {
        rollMany(18, 0);
        game.roll(3);
        game.roll(7);
        game.roll(5);
        
        String expectedScore = "| 0 0 | 0 0 | 0 0 | 0 0 | 0 0 | 0 0 | 0 0 | 0 0 | 0 0 | 3 / 5 |\n" +
                               "|   0 |   0 |   0 |   0 |   0 |   0 |   0 |   0 |   0 |  15   |";
        
        assertEquals(expectedScore, game.printScore());
    }
    
    @Test
    public void spareOnTenthFrame() {
        rollMany(18, 0);
        game.roll(3);
        game.roll(7);
        game.roll(5);
        
        assertEquals(15 ,game.getScore());
    }

}
