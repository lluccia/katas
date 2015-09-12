

public class PlayerWithFixedChoices extends Player {
	
	public String[] choices;
	public int turnCount = 0;
	
	@Override
	public String playerChoice() {
		return choices[turnCount++];
	}

}
