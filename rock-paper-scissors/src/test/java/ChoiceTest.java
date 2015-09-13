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

}
