package ohtu;

public class Player {
    private String name;
    private int score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public void addScore() {
        score += 1;
    }

    public int getScore() {
        return score;
    }
}
