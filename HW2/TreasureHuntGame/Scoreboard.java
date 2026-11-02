package TreasureHuntGame;

import java.util.ArrayList;

public class Scoreboard
{
    private ArrayList<Score> scores;
    private int highestScore;

    public Scoreboard()
    {
        scores = new ArrayList<>();
        this.highestScore = Integer.MIN_VALUE;
    }

    public int getHighestScore() { return this.highestScore; }

    public void addScore(Score score)
    {
        this.scores.add(score);
        this.highestScore = Math.max(score.getScore(), this.highestScore);
    }

    public Score getLatestScore()
    {
        if(scores.size() == 0)
        {
            return new Score();
        }
        else
        {
        Score latestScore = scores.get(scores.size()-1);
        return latestScore;
        }
    }

    @Override
    public String toString()
    {
        String content = "";
        for(Score score : this.scores) {
            content += String.format("Departed Position: (%d, %d)\t Landed Position: (%d, %d)\t\t  Updated Points: %d\n",
                    score.getDepartedPosition().getX(),
                    score.getDepartedPosition().getY(),
                    score.getLandedPosition().getX(),
                    score.getLandedPosition().getY(),
                    score.getScore());             
        }
        return content;
    }
}
