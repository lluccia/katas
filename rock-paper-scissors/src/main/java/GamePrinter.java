public interface GamePrinter {

	public abstract void printBlankLine();

	public abstract void printRoundInfo(Player player1, Player player2);

	public abstract void printGameWon();

	public abstract void printDraw();

	public abstract void printRoundWinner(Player roundWinner);

}