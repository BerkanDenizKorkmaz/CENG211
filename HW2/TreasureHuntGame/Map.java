package TreasureHuntGame;

import java.util.ArrayList;
import java.util.Random;

public class Map
{
    private ArrayList<ArrayList<MapItem>> map;

    public Map()
    {
        this.map = new ArrayList<>();
        for (int i = 0; i < 20; i++)
        {
            ArrayList<MapItem> row = new ArrayList<>(20);
            for (int j = 0; j < 20; j++)
            {
                row.add(new MapItem(new MapPosition(i, j, false), '_'));
            }
            map.add(row);
        }
        placeItems();
    }

    public void placeItems()
    {
        placeSpecificItem(new Booster(null, 'O'), 1);
        placeSpecificItem(new Coin(null, 'C'), 10);
        placeSpecificItem(new Diamond(null, 'D'), 5);
        placeSpecificItem(new Treasure(null, 'T'), 2);
        placeSpecificItem(new Breaker(null, 'X'), 1);
        placeSpecificItem(new Mushroom(null, 'M'), 5);
        placeSpecificItem(new Frog(null, 'F'), 2);
        placeSpecificItem(new Player(null), 1);
    }

    private void placeSpecificItem(MapItem itemTemplate, int quantity)
    {
        Random rand = new Random();
        int placed = 0;

        while (placed < quantity)
        {
            int x = rand.nextInt(20);
            int y = rand.nextInt(20);

            MapPosition position = map.get(x).get(y).getPosition();

            if (!position.isOccupied())
            {
                position.setOccupied(true);
                MapItem item;

                if (itemTemplate instanceof Coin)
                {
                    item = new Coin(position, 'C');
                } 
                else if (itemTemplate instanceof Diamond)
                {
                    item = new Diamond(position, 'D');
                } 
                else if (itemTemplate instanceof Treasure)
                {
                    item = new Treasure(position, 'T');
                } 
                else if (itemTemplate instanceof Mushroom)
                {
                    item = new Mushroom(position, 'M');
                } 
                else if (itemTemplate instanceof Frog)
                {
                    item = new Frog(position, 'F');
                } 
                else if (itemTemplate instanceof Player)
                {
                    item = new Player(position);
                }
                else if (itemTemplate instanceof Booster)
                {
                    item = new Booster(position, 'O');
                }
                else if (itemTemplate instanceof Breaker)
                {
                    item = new Breaker(position, 'X');
                } 
                else 
                {
                    continue;
                }

                this.setMapItem(position, item);
                placed++;
            }
        }
    }

    public Player getPlayer()
    {
        for (ArrayList<MapItem> row : this.map)
        {
            for (MapItem item : row)
            {
                if (item instanceof Player)
                {
                    return (Player) item;
                }
            }
        }
        return null;
    }

    public void printMap()
    {
        for (ArrayList<MapItem> row : map)
        {
            for (MapItem item : row)
            {
                System.out.print(item.getSymbol() + " ");
            }
            System.out.println();
        }
        System.err.println("");
    }

    public void clearMapItem(MapPosition mapPosition)
    {
        this.setMapItem(mapPosition, new MapItem(new MapPosition(mapPosition.getX(), mapPosition.getY(), false), '_'));
    }

    public void setMapItem(MapPosition mapPosition, MapItem item)
    {
        map.get(mapPosition.getX()).set(mapPosition.getY(), item);
    }

    public MapItem getMapItem(MapPosition position)
    {
        return map.get(position.getX()).get(position.getY());
    }

    public boolean hasCollectibleItems()
    {
        for (int i = 0; i < map.size(); i++)
        {
            for (int j = 0; j < map.get(i).size(); j++)
            {
                MapItem item = getMapItem(new MapPosition(i, j));
                if (item instanceof Booster || item instanceof Breaker)
                {
                    return true;
                }
            }
        }
        return false;
    }
}

