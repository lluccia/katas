package dev.conca.rps;
import dev.conca.rps.Choice;
import dev.conca.rps.ChoiceStrategy;



public class FixedChoicesStrategy implements ChoiceStrategy {
    
    private Choice[] choices;
    public int turnCount = 0;

    public Choice choose() {
        return getChoices()[turnCount++];
    }

    public Choice[] getChoices() {
        return choices;
    }

    public void setChoices(Choice[] choices) {
        this.choices = choices;
    }

}
