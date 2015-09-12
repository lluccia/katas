public class Game 
{
    private static Player p1;
	private static Player p2;
	private static String p1Choice;
	private static String p2Choice;
	private static int roundsPlayed;
	private static int p1Wins;
	private static int p2Wins;
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
		System.out.println("Player 1: " + p1.getChoice() + "\t Player 1 Total Wins: " + p1.getWins());
		System.out.println("Player 2: " + p2.getChoice()+ "\t Player 2 Total Wins: " + p2.getWins());
	}

	private static void checkRoundWin() {
		if(p1.getChoice().equals(p2.getChoice())) {
		    draw++;
		    System.out.println("\n\t\t\t Draw \n");
		} else if((p1Choice.equals("rock")) && (p2Choice.equals("paper"))) {
		    System.out.println("Player 2 Wins");
		    p2.addWin();
		} else if((p1Choice.equals("paper")) && (p2Choice.equals("scissors"))) {
			p2.addWin();
			System.out.println("Player 2 Wins");
		} else if((p1Choice.equals("scissors")) && (p2Choice.equals("rock"))) {
		    p2.addWin();
		    System.out.println("Player 2 Wins");
		} else if((p1Choice.equals("rock")) && (p2Choice.equals("scissors"))) {
			p1.addWin();
			System.out.println("Player 1 Wins");
		} else if((p1Choice.equals("paper")) && (p2Choice.equals("rock"))) {
		    p1.addWin();
		    System.out.println("Player 1 Wins");
		} else if((p1Choice.equals("scissors")) && (p2Choice.equals("paper"))) {
		    p1.addWin();
		    System.out.println("Player 1 Wins");
		}

	}
	
	private static boolean gameEnded() {
		return (p1.getWins()>=3) || (p2.getWins()>=3);
	}
}