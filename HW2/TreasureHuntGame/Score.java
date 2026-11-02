package TreasureHuntGame;

public class Score {
    private int score;
    private MapPosition departedPosition;
    private MapPosition landedPosition;

    public Score()
    {
        this.score = 0;
        this.departedPosition = null;
        this.landedPosition = null;
    }

    public Score(int score, MapPosition departedPosition, MapPosition landedPosition)
    {
        this.score = score;
        this.departedPosition = departedPosition;
        this.landedPosition = landedPosition;
    }

    // Getters
    public int getScore() { return score; }
    public MapPosition getDepartedPosition() { return departedPosition; }
    public MapPosition getLandedPosition() { return landedPosition; }
}

