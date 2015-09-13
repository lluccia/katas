
public class StringGamePrinter implements GamePrinter {

	private String gameReport = "";
	
	public String getGameReport() {
		return gameReport;
	}

	public void printBlankLine() {
		gameReport += "\n";
	}

	public void printRoundInfo(Player player1, Player player2) {
		gameReport += "***** Round: " + Game.roundsPlayed + " *********************\n";
		gameReport += "\n";
		gameReport += "Number of Draws: " + Game.draw + "\n";
		gameReport += "\n";
		gameReport += "Player " + player1.getName() + ": " + player1.getChoice() + "\t Player " + player1.getName() + " Total Wins: " + player1.getWins();
		gameReport += "\n";
		gameReport += "Player " + player2.getName() + ": " + player2.getChoice()+ "\t Player " + player2.getName() + " Total Wins: " + player2.getWins();
		gameReport += "\n";
	}

	public void printGameWon() {
		gameReport += "GAME WON";
		gameReport += "\n";
	}

	public void printDraw() {
		gameReport += "\n\t\t\t Draw \n";
		gameReport += "\n";
	}

	public void printRoundWinner(Player roundWinner) {
		gameReport += "Player " + roundWinner.getName() + " Wins";
		gameReport += "\n";
	}

}
