public class Game 
{
    private static Player p1;
	private static Player p2;
	private static String p1Choice;
	private static String p2Choice;
	private static int roundsPlayed;
	private static int draw;

	public static void setPlayers(Player p1, Player p2) {
		Game.p1 = p1;
		Game.p2 = p2;
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
            printRoundInfo();
            checkRoundWin();
            roundsPlayed++;
            if(gameEnded()) {
                System.out.println("GAME WON");
            }
            System.out.println();
        } while(!gameEnded());
    }

	private static void playRound() {
		p1Choice = p1.choose();
		p2Choice = p2.choose();
	}

	private static void printRoundInfo() {
		System.out.println("***** Round: " + roundsPlayed + " *********************\n");
		System.out.println("Number of Draws: " + draw + "\n");
		System.out.println("Player " + p1.getName() + ": " + p1.getChoice() + "\t Player " + p1.getName() + " Total Wins: " + p1.getWins());
		System.out.println("Player " + p2.getName() + ": " + p2.getChoice()+ "\t Player " + p2.getName() + " Total Wins: " + p2.getWins());
	}

	private static void checkRoundWin() {
		Player roundWinner = getRoundWinner(p1, p2);
		
		if (roundWinner == null) {
		    draw++;
		    System.out.println("\n\t\t\t Draw \n");
		} else {
			roundWinner.addWin();
			System.out.println("Player " + roundWinner.getName() + " Wins");
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