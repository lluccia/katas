import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;


public class GameTest {
	
	private Player p1;
	private Player p2;

	@Before
	public void setUp() {
		System.setProperty("line.separator", "\n");
	}
	
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
	
	private void createPlayers() {
		p1 = new Player("1");
		p2 = new Player("2");
	}

	@Test
	public void testGame1() throws IOException {
		createPlayers();
		
		FixedChoicesStrategy p1Strategy = new FixedChoicesStrategy();
		FixedChoicesStrategy p2Strategy = new FixedChoicesStrategy();
		
		p1Strategy.setChoices(new Choice[] {Choice.rock, Choice.rock, Choice.scissors, Choice.paper, Choice.paper, Choice.rock, Choice.paper, Choice.rock, Choice.scissors});
		p2Strategy.setChoices(new Choice[] {Choice.scissors, Choice.rock, Choice.rock, Choice.rock, Choice.rock, Choice.scissors, Choice.paper, Choice.rock, Choice.paper});

		p1.setChoiceStrategy(p1Strategy);
		p2.setChoiceStrategy(p2Strategy);
		
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
		createPlayers();
		
		FixedChoicesStrategy p1Strategy = new FixedChoicesStrategy();
		FixedChoicesStrategy p2Strategy = new FixedChoicesStrategy();
		
		p1Strategy.setChoices(new Choice[] {Choice.paper, Choice.scissors, Choice.paper, Choice.rock, Choice.scissors});
		p2Strategy.setChoices(new Choice[] {Choice.rock, Choice.rock, Choice.scissors, Choice.paper, Choice.rock});

		p1.setChoiceStrategy(p1Strategy);
		p2.setChoiceStrategy(p2Strategy);
		
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
		createPlayers();
		
		FixedChoicesStrategy p1Strategy = new FixedChoicesStrategy();
		FixedChoicesStrategy p2Strategy = new FixedChoicesStrategy();
		
		p1Strategy.setChoices(new Choice[] {Choice.rock, Choice.rock, Choice.scissors, Choice.paper, Choice.paper, Choice.rock, Choice.paper, Choice.rock, Choice.scissors});
		p2Strategy.setChoices(new Choice[] {Choice.scissors, Choice.rock, Choice.rock, Choice.rock, Choice.rock, Choice.scissors, Choice.paper, Choice.rock, Choice.paper});
		
		p1.setChoiceStrategy(p1Strategy);
		p2.setChoiceStrategy(p2Strategy);
		
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
