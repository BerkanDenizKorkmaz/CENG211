package GardenApp;

public class Spotlight extends LightSource {

    public Spotlight(String ID, Color color, int range) {
        super(ID, color, range);
    }

    // Copy Constructor
    public Spotlight(Spotlight another) {
        super(another);
    }

    // Method to light up the light source and update the garden map
    @Override
    public void lightUp(Garden garden) {
        int range = this.getAreaOfLightReach();
        Color color = this.getColor();

        Position position = garden.findPositionOfGardenObjectByID(this.getID());

        int down_square_rowindex = position.getRowByIndex() +1;
        int down_square_columnindex = position.getColumnByIndex();

        // Checking the square position is in the range of the area of light reach
        for (int i = 0; i < range; i++) {
            // Checking the square position is in the range of the map
            if (0<= down_square_rowindex && down_square_rowindex <=5 && 0<= down_square_columnindex && down_square_columnindex <= 7) {
                GardenSquare down_square = garden.getGardenMap().get(down_square_rowindex).get(down_square_columnindex);
                Position down_square_position = down_square.getPosition();
                if (down_square.getOccupant() == null) {
                    Occupant occupant = new PollenCloud();
                    PollenCloud pollenCloud = (PollenCloud) occupant;
                    pollenCloud.addColor(color);
    
                    down_square.setOccupant(pollenCloud);
                    garden.setGardenSquareByPosition(down_square, down_square_position);
                }
                else if (down_square.getOccupant() instanceof PollenCloud) {
                    PollenCloud pollenCloud = (PollenCloud) down_square.getOccupant();
                    pollenCloud.addColor(color);
    
                    down_square.setOccupant(pollenCloud);
                    garden.setGardenSquareByPosition(down_square, down_square_position);
                }
                // down_square.getOccupant == GardenObject
                else {
                    if (down_square.getOccupant() instanceof GardenPlant) {
                        GardenPlant gardenPlant = (GardenPlant) down_square.getOccupant();
                        gardenPlant.getPollenCloud().addColor(color);
                        Occupant occupant = gardenPlant;
    
                        garden.setGardenSquareByPosition(new GardenSquare(occupant, down_square_position), down_square_position);
                        break;
                    }
                    else {
                        break;
                    }
                }
                down_square_rowindex += 1;  
            }
            else {
                break;
            }
        }
    }
}
