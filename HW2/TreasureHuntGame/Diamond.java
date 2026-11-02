package TreasureHuntGame;

public class Diamond extends Booster
{
    public Diamond(MapPosition position, char symbol)
    {
        super(position, symbol); // 'D' symbol represents Diamond
    }

    @Override
    public void interact(Player player)
    {
        player.addPoints(10);
    }
}

