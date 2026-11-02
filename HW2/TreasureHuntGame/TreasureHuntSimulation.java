package TreasureHuntGame;

import FileIO.FileIO;

public class TreasureHuntSimulation
{

    public TreasureHuntSimulation()
    {
        
    }

    public void run()
    {
        Map map = new Map();
        Player player = map.getPlayer();
        FileIO fileIO = new FileIO();

        map.setMapItem(player.getPosition(), player);
        Scoreboard scoreboard = new Scoreboard();

        // print map
        map.printMap();

        while(player.isAlive() && map.hasCollectibleItems())
        {
            // Store player's departed MapPosition
            MapPosition departedMapPosition = new MapPosition(player.getPosition().getX(), player.getPosition().getY(), true);

            // player moves
            player.move(map);

            // player interacts
            MapItem item = map.getMapItem(player.getPosition());
            item.interact(player);

            // update map
            map.clearMapItem(departedMapPosition);
            map.setMapItem(player.getPosition(), player);

            // print new map
            map.printMap();

            // update scores depending on change
            MapPosition landedMapPosition = new MapPosition(player.getPosition().getX(), player.getPosition().getY(), true);
            if(scoreboard.getLatestScore().getScore() != player.getPoints())
            {
            scoreboard.addScore(new Score(player.getPoints(), departedMapPosition, landedMapPosition));
            }
        }

        System.out.println("Game Over!\nHighest Score: " + scoreboard.getHighestScore());
        fileIO.writeToFile("scoreboard.txt", scoreboard.toString());
    }
}
