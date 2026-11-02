package TreasureHuntGame;

public class MapPosition {
    private int x, y;
    private boolean occupied;

    public MapPosition(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.occupied = false;
    }

    public MapPosition(int x, int y, boolean occupied)
    {
        this.x = x;
        this.y = y;
        this.occupied = occupied;
    }

    // Setters and Getters
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    public int getX() { return x; }
    public int getY() { return y; }
    public boolean isOccupied() { return occupied; }
    public void setOccupied(boolean occupied) { this.occupied = occupied; }
}


