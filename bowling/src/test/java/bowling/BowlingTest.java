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

}
