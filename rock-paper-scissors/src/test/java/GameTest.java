import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import org.apache.commons.io.IOUtils;
import org.junit.Test;


public class GameTest {
	
	private ByteArrayOutputStream setConsoleOutputToStream() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(baos);
	    System.setOut(ps);
		return baos;
	}

	private String readFileToString(String fileName) throws IOException {
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileName);
		return IOUtils.toString(inputStream, "UTF-8");
	}
	
	@Test
	public void testGame1() throws IOException {
		PlayerWithFixedChoices p1 = new PlayerWithFixedChoices("1");
		PlayerWithFixedChoices p2 = new PlayerWithFixedChoices("2");
		p1.choices = new Choice[] {Choice.rock, Choice.rock, Choice.scissors, Choice.paper, Choice.paper, Choice.rock, Choice.paper, Choice.rock, Choice.scissors};
		p2.choices = new Choice[] {Choice.scissors, Choice.rock, Choice.rock, Choice.rock, Choice.rock, Choice.scissors, Choice.paper, Choice.rock, Choice.paper};

		Game game = new Game();
		game.setGameReportPrinter(new ConsoleGamePrinter());
		game.setPlayers(p1, p2);
		
		ByteArrayOutputStream baos = setConsoleOutputToStream();
	    
		game.playGame();
	    
	    System.out.flush();
	    
		String expectedOutput = readFileToString("expectedOutputForGame1.txt");
	    
		assertEquals(expectedOutput, baos.toString());
	}

	@Test
	public void testGame2() throws IOException {
		PlayerWithFixedChoices p1 = new PlayerWithFixedChoices("1");
		PlayerWithFixedChoices p2 = new PlayerWithFixedChoices("2");
		p1.choices = new Choice[] {Choice.paper, Choice.scissors, Choice.paper, Choice.rock, Choice.scissors};
		p2.choices = new Choice[] {Choice.rock, Choice.rock, Choice.scissors, Choice.paper, Choice.rock};
		
		Game game = new Game();
		game.setGameReportPrinter(new ConsoleGamePrinter());
		game.setPlayers(p1, p2);
		
		ByteArrayOutputStream baos = setConsoleOutputToStream();
		
		game.playGame();
		
		System.out.flush();
		
		String expectedOutput = readFileToString("expectedOutputForGame2.txt");
		
		assertEquals(expectedOutput, baos.toString());
	}
	
	@Test
	public void testGameStringPrinter() throws IOException {
		PlayerWithFixedChoices p1 = new PlayerWithFixedChoices("1");
		PlayerWithFixedChoices p2 = new PlayerWithFixedChoices("2");
		p1.choices = new Choice[] {Choice.rock, Choice.rock, Choice.scissors, Choice.paper, Choice.paper, Choice.rock, Choice.paper, Choice.rock, Choice.scissors};
		p2.choices = new Choice[] {Choice.scissors, Choice.rock, Choice.rock, Choice.rock, Choice.rock, Choice.scissors, Choice.paper, Choice.rock, Choice.paper};
		
		Game game = new Game();
		game.setPlayers(p1, p2);
		
		StringGamePrinter gamePrinter = new StringGamePrinter();
		game.setGameReportPrinter(gamePrinter);
		
		game.playGame();
		
		System.out.flush();
		
		String expectedOutput = readFileToString("expectedOutputForGame1.txt");
		
		assertEquals(expectedOutput, gamePrinter.getGameReport());
	}
	
}
