import static org.junit.Assert.*;

import org.junit.Test;


public class ChoiceTest {
	
	@Test
	public void choiceToString() {
		assertEquals("paper", Choice.paper.toString());
	}
	
	@Test
	public void choiceFromString() {
		assertEquals(Choice.paper, Choice.valueOf("paper"));
	}
	
	@Test
	public void scissorsBeatsPaper() {
		assertTrue(Choice.scissors.beats(Choice.paper));
	}
	
	@Test
	public void scissorsDoNotBeatRock() {
		assertFalse(Choice.scissors.beats(Choice.rock));
	}
	
	@Test
	public void paperBeatsRock() {
		assertTrue(Choice.paper.beats(Choice.rock));
	}
	
	@Test
	public void paperDoNotBeatScissors() {
		assertFalse(Choice.paper.beats(Choice.scissors));
	}
	
	@Test
	public void rockBeatsScissors() {
		assertTrue(Choice.rock.beats(Choice.scissors));
	}
	
	@Test
	public void rockDoNotBeatPaper() {
		assertFalse(Choice.rock.beats(Choice.paper));
	}

}
