package TreasureHuntGame;

public class Frog extends Breaker
{
    public Frog(MapPosition position, char symbol)
    {
        super(position, symbol); // 'F' symbol represents Frog
    }

    @Override
    public void interact(Player player)
    {
        player.addLives(-1);
    }
}
