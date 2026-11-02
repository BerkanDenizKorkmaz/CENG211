package TreasureHuntGame;

public class Mushroom extends Breaker {
    public Mushroom(MapPosition position, char symbol)
    {
        super(position, symbol); // 'M' symbol represents Mushroom
    }

    @Override
    public void interact(Player player)
    {
        player.addPoints(-20);
    }
}
