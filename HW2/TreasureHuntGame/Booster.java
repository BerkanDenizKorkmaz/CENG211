package TreasureHuntGame;

import java.util.ArrayList;

public class Booster extends MapItem
{

    public Booster(MapPosition position, char symbol)
    {
        super(position, symbol); // 'O' symbol represents Booster
    }

    @Override
    public void interact(Player player)
    {
        Coin coin = new Coin(this.getPosition(), 'C');
        Diamond diamond = new Diamond(this.getPosition(), 'D');
        Treasure treasure = new Treasure(this.getPosition(), 'T');
        coin.interact(player);
        diamond.interact(player);
        treasure.interact(player);
    }
}
