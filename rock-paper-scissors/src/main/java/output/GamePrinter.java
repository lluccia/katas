package output;

import dev.conca.rps.Game;
import dev.conca.rps.Player;

public interface GamePrinter {

	public abstract void printBlankLine();

	public abstract void printRoundInfo(Game game, Player player1, Player player2);

	public abstract void printGameWon();

	public abstract void printDraw();

	public abstract void printRoundWinner(Player roundWinner);

}