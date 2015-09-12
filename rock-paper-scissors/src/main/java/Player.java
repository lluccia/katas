
class Player {
	
    int wins;      // # of wins
	protected String choice;
	private String name;
	
	
	public Player(String name) {
		this.name = name;
	}
	
    /**
     * Randomly choose rock, paper, or scissors
     */
    public String choose() {
        choice = "";
        int c = (int)(Math.random()*3);
        switch(c) {
            case 0:
                choice = ("rock");
                break;
            case 1:
                choice = ("paper");
                break;
            case 2:
                choice = ("scissors");
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
    
    public String getChoice() {
    	return choice;
    }

	public String getName() {
		return name;
	}
}