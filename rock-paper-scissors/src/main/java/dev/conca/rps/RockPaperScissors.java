package dev.conca.rps;

public class RockPaperScissors {

	private static Game game;

	public static void main(String[] args) {
		game = new Game();

		Player p1 = new Player("1");
		Player p2 = new Player("2");
		
		game.setPlayers(p1, p2);
		
		game.playGame();
	}
}
