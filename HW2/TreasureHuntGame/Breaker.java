package TreasureHuntGame;

import java.util.ArrayList;

public class Breaker extends MapItem {

    public Breaker(MapPosition position, char symbol)
    {
        super(position, symbol); // 'X' symbol represents Breaker
    }

    @Override
    public void interact(Player player)
    {
        Frog frog = new Frog(this.getPosition(), 'F');
        Mushroom mushroom = new Mushroom(this.getPosition(), 'M');
        frog.interact(player);
        mushroom.interact(player);
    }
}

