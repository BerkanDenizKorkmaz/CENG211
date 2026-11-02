package TreasureHuntGame;

public class Coin extends Booster
{
    public Coin(MapPosition position, char symbol)
    {
        super(position, symbol); // 'C' symbol represents Coin
    }

    @Override
    public void interact(Player player)
    {
        player.addPoints(5);
    }
}




