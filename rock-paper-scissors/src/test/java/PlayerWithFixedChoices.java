

public class PlayerWithFixedChoices extends Player {
	
	public Choice[] choices;
	public int turnCount = 0;

	public PlayerWithFixedChoices(String name) {
		super(name);
	}
	
	@Override
	public Choice choose() {
		super.choice = choices[turnCount++];
		return choice;
	}

}
