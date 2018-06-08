package dev.conca.rps;

public enum Choice {
    rock,
    paper,
    scissors;

    public boolean beats(Choice choice) {
        boolean beats = false;
        switch (this) {
        case scissors:
            beats = choice.equals(paper);
            break;
        case paper:
            beats = choice.equals(rock);
            break;
        case rock:
            beats = choice.equals(scissors);
            break;
        default:
            break;
        }
        return beats;
    }
}
