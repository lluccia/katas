package dev.conca.rps;

import output.ConsoleGamePrinter;
import output.GamePrinter;

public class Game {
	
    private Player p1;
	private Player p2;
	private int roundsPlayed;
	private int drawCount;

	private GamePrinter gamePrinter = new ConsoleGamePrinter();
	
	public void setPlayers(Player p1, Player p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	
	public void setGameReportPrinter(GamePrinter gamePrinter) {
		this.gamePrinter = gamePrinter;
	}
	
	public void playGame() {
        setRoundsPlayed(0);
        setDrawCount(0);
        do {
            playRound();
            Player roundWinner = checkRoundWin();
            gamePrinter.printRoundInfo(this, p1, p2);
            if (roundWinner == null)
            	gamePrinter.printDraw();
            else
            	gamePrinter.printRoundWinner(roundWinner);
            setRoundsPlayed(getRoundsPlayed() + 1);
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

	private Player checkRoundWin() {
		Player roundWinner = null;
		if (isDraw(p1, p2)) {
		    setDrawCount(getDrawCount() + 1);
		} else {
			roundWinner = getRoundWinner(p1, p2);
			roundWinner.addWin();
		}
		return roundWinner;
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

	public int getRoundsPlayed() {
		return roundsPlayed;
	}

	public void setRoundsPlayed(int roundsPlayed) {
		this.roundsPlayed = roundsPlayed;
	}

	public int getDrawCount() {
		return drawCount;
	}

	public void setDrawCount(int drawCount) {
		this.drawCount = drawCount;
	}
}