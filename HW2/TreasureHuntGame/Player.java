package TreasureHuntGame;

import java.util.Random;

public class Player extends MapItem
{
    private int points;
    private int lives;

    public Player(MapPosition position)
    {
        super(position, 'P');
        this.points = 100;
        this.lives = 2;
    }

    public void move(Map map)
    {
        Random rand = new Random();
        int newX = rand.nextInt(20);
        int newY = rand.nextInt(20);
        this.getPosition().setX(newX);
        this.getPosition().setY(newY);
    }

    public void addPoints(int points)
    {
        this.points += points;
        if (this.points < 0) this.points = 0; // Points cannot go negative
    }

    public void addLives(int lives)
    {
        this.lives += lives;
        if (this.lives < 0) this.lives = 0; // Lives cannot go negative
    }

    public boolean isAlive()
    {
        return points > 0 && lives > 0;
    }

    // Getters
    public int getPoints() { return points; }
    public int getLives() { return lives; }
}


