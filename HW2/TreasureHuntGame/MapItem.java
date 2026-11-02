package TreasureHuntGame;

public class MapItem
{
    private MapPosition position;
    private char symbol;

    public MapItem(MapPosition position, char symbol)
    {
        this.position = position;
        this.symbol = symbol;
    }

    // Default interaction has no effect
    public void interact(Player player)
    {
        return;
    }

    // Getters
    public MapPosition getPosition() { return position; }
    public char getSymbol() { return symbol; }
}



