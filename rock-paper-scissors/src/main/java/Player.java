
class Player {
	
    int wins;      // # of wins
	protected Choice choice;
	private String name;
	
	
	public Player(String name) {
		this.name = name;
	}
	
    /**
     * Randomly choose rock, paper, or scissors
     */
    public Choice choose() {
    	choice = null;
        int c = (int)(Math.random()*3);
        switch(c) {
            case 0:
                choice = Choice.rock;
                break;
            case 1:
                choice = Choice.paper;
                break;
            case 2:
                choice = Choice.scissors;
                break;
        }
        return choice;
    }
    
    public void addWin() {
    	wins++;
    }
    
    public int getWins() {
        return wins;
    }
    
    public Choice getChoice() {
    	return choice;
    }

	public String getName() {
		return name;
	}
}