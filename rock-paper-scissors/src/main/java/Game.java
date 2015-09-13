public class Game 
{
    private static Player p1;
	private static Player p2;
	private static String p1Choice;
	private static String p2Choice;
	static int roundsPlayed;
	static int draw;

	private static GamePrinter gamePrinter = new ConsoleGamePrinter();
	
	public static void setPlayers(Player p1, Player p2) {
		Game.p1 = p1;
		Game.p2 = p2;
	}
	
	public static void setGameReportPrinter(GamePrinter gamePrinter) {
		Game.gamePrinter = gamePrinter;
	}
	
	public static void main(String args[]) {
		playGame();
    }
	
	public static void playGame() {
        roundsPlayed = 0;
        draw = 0;
        // Game Loop
        do {
            playRound();
            gamePrinter.printRoundInfo(p1, p2);
            checkRoundWin();
            roundsPlayed++;
            if(gameEnded()) {
            	gamePrinter.printGameWon();
            }
            gamePrinter.printBlankLine();
        } while(!gameEnded());
    }

	private static void playRound() {
		p1Choice = p1.choose();
		p2Choice = p2.choose();
	}

	private static void checkRoundWin() {
		Player roundWinner = getRoundWinner(p1, p2);
		
		if (roundWinner == null) {
		    draw++;
		    gamePrinter.printDraw();
		} else {
			roundWinner.addWin();
			gamePrinter.printRoundWinner(roundWinner);
		}
	}

	private static Player getRoundWinner(Player p1, Player p2) {
		if((p2Choice.equals("rock")) && (p1Choice.equals("scissors"))
				|| (p2Choice.equals("paper")) && (p1Choice.equals("rock"))
				|| (p2Choice.equals("scissors")) && (p1Choice.equals("paper"))) {
		    return p2;
		} else if((p1Choice.equals("rock")) && (p2Choice.equals("scissors"))
				|| (p1Choice.equals("paper")) && (p2Choice.equals("rock"))
				|| (p1Choice.equals("scissors")) && (p2Choice.equals("paper"))) {
			return p1;
		}
		return null;
	}
	
	private static boolean gameEnded() {
		return (p1.getWins()>=3) || (p2.getWins()>=3);
	}
}