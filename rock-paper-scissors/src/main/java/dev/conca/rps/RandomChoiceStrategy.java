package dev.conca.rps;

public class RandomChoiceStrategy implements ChoiceStrategy {

	public Choice choose() {
		Choice choice = null;
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

}
