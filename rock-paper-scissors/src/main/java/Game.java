public class Game {
	
    private Player p1;
	private Player p2;
	static int roundsPlayed;
	static int draw;

	private GamePrinter gamePrinter = new ConsoleGamePrinter();
	
	public void setPlayers(Player p1, Player p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	
	public void setGameReportPrinter(GamePrinter gamePrinter) {
		this.gamePrinter = gamePrinter;
	}
	
	public static void main(String args[]) {
		Game game = new Game();
		game.playGame();
    }
	
	public void playGame() {
        roundsPlayed = 0;
        draw = 0;
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

	private void playRound() {
		p1.choose();
		p2.choose();
	}

	private void checkRoundWin() {
		if (isDraw(p1, p2)) {
		    draw++;
		    gamePrinter.printDraw();
		} else {
			Player roundWinner = getRoundWinner(p1, p2);
			roundWinner.addWin();
			gamePrinter.printRoundWinner(roundWinner);
		}
	}

	private boolean isDraw(Player p1, Player p2) {
		return p1.getChoice().equals(p2.getChoice());
	}

	private Player getRoundWinner(Player p1, Player p2) {
		return p1.getChoice().beats(p2.getChoice()) ? p1 : p2;
	}
	
	private boolean gameEnded() {
		return (p1.getWins()>=3) || (p2.getWins()>=3);
	}
}