import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import org.apache.commons.io.IOUtils;
import org.junit.Test;


public class GameTest {

	@Test
	public void testGame1() throws IOException {
		PlayerWithFixedChoices p1 = new PlayerWithFixedChoices();
		PlayerWithFixedChoices p2 = new PlayerWithFixedChoices();
		p1.choices = new String[] {"rock", "rock", "scissors", "paper", "paper", "rock", "paper", "rock", "scissors"};
		p2.choices = new String[] {"scissors", "rock", "rock", "rock", "rock", "scissors", "paper", "rock", "paper"};
		
		Game.setPlayers(p1, p2);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(baos);
	    System.setOut(ps);
	    
	    Game.main(null);
	    
	    System.out.flush();
	    
	    InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("expectedOutputForGame1.txt");
	    String expectedOutput = IOUtils.toString(inputStream, "UTF-8");
	    
		assertEquals(expectedOutput, baos.toString());
	}
	
	@Test
	public void testGame2() throws IOException {
		PlayerWithFixedChoices p1 = new PlayerWithFixedChoices();
		PlayerWithFixedChoices p2 = new PlayerWithFixedChoices();
		p1.choices = new String[] {"paper", "scissors", "paper", "rock", "scissors"};
		p2.choices = new String[] {"rock", "rock", "scissors", "paper", "rock"};
		
		Game.setPlayers(p1, p2);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
		
		Game.main(null);
		
		System.out.flush();
		
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("expectedOutputForGame2.txt");
		String expectedOutput = IOUtils.toString(inputStream, "UTF-8");
		
		assertEquals(expectedOutput, baos.toString());
	}
	
}
