package tennis;

public class Game {

    private String score[] = {"0", "0"}; 
            
    public String getScore(int player) {
        return score[player];
    }

    public String getScore() {
        return score[0] + "-" + score[1];
    }

    public void point(int player) {
        if(score[player].equals("0"))
            score[player] = "15";
        else if (score[player].equals("15"))
            score[player] = "30";
        else if (score[player].equals("30"))
            score[player] = "40";
        else if (score[player].equals("40"))
            score[player] = "Game";
        else if(score[0].equals("Deuce") && score[1].equals("Deuce"))
            score[player] = "Advantage";
        else if(score[player].equals("Advantage"))
            score[player] = "Game";
        else if(score[otherPlayer(player)].equals("Advantage"))
            score[otherPlayer(player)] = "Deuce";
        
        checkDeuce();
    }

    private void checkDeuce() {
        if(score[0].equals("40") && score[1].equals("40")) {
            score[0] = "Deuce";
            score[1] = "Deuce";
        }
    }

    private int otherPlayer(int player) {
        return 1-player;
    }

}
