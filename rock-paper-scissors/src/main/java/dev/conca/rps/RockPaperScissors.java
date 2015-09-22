package dev.conca.rps;

public class RockPaperScissors {

	private static Game game;

	public static void main(String[] args) {
		game = new Game();

		Player p1 = new Player("1");
		Player p2 = new Player("2");
		
		p1.setChoiceStrategy(new ConsoleChoiceStrategy());
		p2.setChoiceStrategy(new RandomChoiceStrategy());
		
		game.setPlayers(p1, p2);
		
		game.playGame();
	}
}
