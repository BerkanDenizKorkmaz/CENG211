package TreasureHuntGame;

public class Treasure extends Booster
{
    public Treasure(MapPosition position, char symbol)
    {
        super(position, symbol); // 'T' symbol represents Treasure
    }

    @Override
    public void interact(Player player)
    {
        player.addLives(1);
    }
}
