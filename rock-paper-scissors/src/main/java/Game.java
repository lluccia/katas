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
        p1Wins = p1.wins;
        p2Wins = p2.wins;
        draw = 0;
        // Game Loop
        do {
            playRound();
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
		
		printRoundInfo();
	}

	private static void printRoundInfo() {
		System.out.println("***** Round: " + roundsPlayed + " *********************\n");
		System.out.println("Number of Draws: " + draw + "\n");
		System.out.println("Player 1: " + p1.getChoice() + "\t Player 1 Total Wins: " + p1Wins);
		System.out.println("Player 2: " + p2.getChoice()+ "\t Player 2 Total Wins: " + p2Wins);
	}

	private static void checkRoundWin() {
		if((p1Choice.equals("rock")) && (p2Choice.equals("paper"))) {
		    System.out.println("Player 2 Wins");
		    p2Wins++;
		} else if((p1Choice.equals("paper")) && (p2Choice.equals("scissors"))) {
			p2Wins = p2.setWins();
			System.out.println("Player 2 Wins");
		} else if((p1Choice.equals("scissors")) && (p2Choice.equals("rock"))) {
		    p2Wins = p2.setWins();
		    System.out.println("Player 2 Wins");
		} else if((p1Choice.equals("rock")) && (p2Choice.equals("scissors"))) {
			p1Wins = p1.setWins();
			System.out.println("Player 1 Wins");
		} else if((p1Choice.equals("paper")) && (p2Choice.equals("rock"))) {
		    p1Wins++;
		    System.out.println("Player 1 Wins");
		} else if((p1Choice.equals("scissors")) && (p2Choice.equals("paper"))) {
		    p1Wins = p1.setWins();
		    System.out.println("Player 1 Wins");
		}
		if(p1Choice==p2Choice) {
		    draw++;
		    System.out.println("\n\t\t\t Draw \n");
		}
	}
	
	private static boolean gameEnded() {
		return (p1.getWins()>=3) || (p2.getWins()>=3);
	}
}