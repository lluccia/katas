package output;

import dev.conca.rps.Game;
import dev.conca.rps.Player;

public class ConsoleGamePrinter implements GamePrinter {

    public void printBlankLine() {
        System.out.println();
    }

    public void printRoundInfo(Game game, Player player1, Player player2) {
        System.out.println("***** Round: " + game.getRoundsPlayed() + " *********************\n");
        System.out.println("Number of Draws: " + game.getDrawCount() + "\n");
        System.out.println("Player " + player1.getName() + ": " + player1.getChoice() + "\t Player " + player1.getName() + " Total Wins: " + player1.getWins());
        System.out.println("Player " + player2.getName() + ": " + player2.getChoice()+ "\t Player " + player2.getName() + " Total Wins: " + player2.getWins());
    }

    public void printGameWon() {
        System.out.println("GAME WON");
    }

    public void printDraw() {
        System.out.println("\n\t\t\t Draw \n");
    }

    public void printRoundWinner(Player roundWinner) {
        System.out.println("Player " + roundWinner.getName() + " Wins");
    }

}
