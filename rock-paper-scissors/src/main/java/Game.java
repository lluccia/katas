public class Game {
	
    private Player p1;
	private Player p2;
	private Choice p1Choice;
	private Choice p2Choice;
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
		p1Choice = p1.choose();
		p2Choice = p2.choose();
	}

	private void checkRoundWin() {
		Player roundWinner = getRoundWinner(p1, p2);
		
		if (roundWinner == null) {
		    draw++;
		    gamePrinter.printDraw();
		} else {
			roundWinner.addWin();
			gamePrinter.printRoundWinner(roundWinner);
		}
	}

	private Player getRoundWinner(Player p1, Player p2) {
		if((p2Choice.equals(Choice.rock)) && (p1Choice.equals(Choice.scissors))
				|| (p2Choice.equals(Choice.paper)) && (p1Choice.equals(Choice.rock))
				|| (p2Choice.equals(Choice.scissors)) && (p1Choice.equals(Choice.paper))) {
		    return p2;
		} else if((p1Choice.equals(Choice.rock)) && (p2Choice.equals(Choice.scissors))
				|| (p1Choice.equals(Choice.paper)) && (p2Choice.equals(Choice.rock))
				|| (p1Choice.equals(Choice.scissors)) && (p2Choice.equals(Choice.paper))) {
			return p1;
		}
		return null;
	}
	
	private boolean gameEnded() {
		return (p1.getWins()>=3) || (p2.getWins()>=3);
	}
}