

public class PlayerWithFixedChoices extends Player {
	
	public String[] choices;
	public int turnCount = 0;
	
	@Override
	public String choose() {
		super.choice = choices[turnCount++];
		return choice;
	}

}
