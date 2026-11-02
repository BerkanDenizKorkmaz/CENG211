package GardenApp;

public class LargeLamp extends LightSource {
    
    public LargeLamp(String ID, Color color, int range) {
        super(ID, color, range);
    }

    // Copy Constructor
    public LargeLamp(LargeLamp another) {
        super(another);
    }
    
    // Method to light up the light source and update the garden map
    @Override
    public void lightUp(Garden garden) {
        int range = this.getAreaOfLightReach();
        Color color = this.getColor();

        Position position = garden.findPositionOfGardenObjectByID(this.getID());

        int left_square_rowindex = position.getRowByIndex();
        int left_square_columnindex = position.getColumnByIndex() - 1;

        // Checking the square position is in the range of the area of light reach
        for (int i = 0; i < range; i++) {
            // Checking the square position is in the range of the map
            if (0<= left_square_rowindex && left_square_rowindex <=5 && 0<= left_square_columnindex && left_square_columnindex <= 7) {
                GardenSquare left_square = garden.getGardenMap().get(left_square_rowindex).get(left_square_columnindex);
                Position left_square_position = left_square.getPosition();
                if (left_square.getOccupant() == null) {
                    Occupant occupant = new PollenCloud();
                    PollenCloud pollenCloud = (PollenCloud) occupant;
                    pollenCloud.addColor(color);
    
                    left_square.setOccupant(pollenCloud);
                    garden.setGardenSquareByPosition(left_square, left_square_position);
                }
                else if (left_square.getOccupant() instanceof PollenCloud) {
                    PollenCloud pollenCloud = (PollenCloud) left_square.getOccupant();
                    pollenCloud.addColor(color);
    
                    left_square.setOccupant(pollenCloud);
                    garden.setGardenSquareByPosition(left_square, left_square_position);
                }
                // left_square.getOccupant == GardenObject
                else {
                    if (left_square.getOccupant() instanceof GardenPlant) {
                        GardenPlant gardenPlant = (GardenPlant) left_square.getOccupant();
                        gardenPlant.getPollenCloud().addColor(color);
                        Occupant occupant = gardenPlant;
    
                        garden.setGardenSquareByPosition(new GardenSquare(occupant, left_square_position), left_square_position);
                        break;
                    }
                    else {
                        break;
                    }
                }
                left_square_columnindex -= 1;
            }
            else {
                break;
            }
        }
    }
}
