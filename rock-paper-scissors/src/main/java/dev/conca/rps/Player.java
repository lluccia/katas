package dev.conca.rps;

public class Player {
    
    int wins;
    protected Choice choice;
    private String name;
    
    private ChoiceStrategy choiceStrategy;
    
    public Player(String name) {
        this.name = name;
        this.setChoiceStrategy(new RandomChoiceStrategy());
    }
    
    public Choice choose() {
        choice = choiceStrategy.choose();
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

    public ChoiceStrategy getChoiceStrategy() {
        return choiceStrategy;
    }

    public void setChoiceStrategy(ChoiceStrategy choiceStrategy) {
        this.choiceStrategy = choiceStrategy;
    }
}