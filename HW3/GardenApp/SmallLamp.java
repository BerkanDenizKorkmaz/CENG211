package GardenApp;

public class SmallLamp extends LightSource {

    public SmallLamp(String ID, Color color, int range) {
        super(ID, color, range);
    }

    // Copy Constructor
    public SmallLamp(SmallLamp another) {
        super(another);
    }

    // Method to light up the light source and update the garden map
    @Override
    public void lightUp(Garden garden) {
        int range = this.getAreaOfLightReach();
        Color color = this.getColor();

        Position position = garden.findPositionOfGardenObjectByID(this.getID());

        int right_square_rowindex = position.getRowByIndex();
        int right_square_columnindex = position.getColumnByIndex() + 1;

        // Checking the square position is in the range of the area of light reach
        for (int i = 0; i < range; i++) {
            // Checking the square position is in the range of the map
            if (0<= right_square_rowindex && right_square_rowindex <=5 && 0<= right_square_columnindex && right_square_columnindex <= 7) {
                GardenSquare right_square = garden.getGardenMap().get(right_square_rowindex).get(right_square_columnindex);
                Position right_square_position = right_square.getPosition();
                if (right_square.getOccupant() == null) {
                    Occupant occupant = new PollenCloud();
                    PollenCloud pollenCloud = (PollenCloud) occupant;
                    pollenCloud.addColor(color);
    
                    right_square.setOccupant(pollenCloud);
                    garden.setGardenSquareByPosition(right_square, right_square_position);
                }
                else if (right_square.getOccupant() instanceof PollenCloud) {
                    PollenCloud pollenCloud = (PollenCloud) right_square.getOccupant();
                    pollenCloud.addColor(color);
    
                    right_square.setOccupant(pollenCloud);
                    garden.setGardenSquareByPosition(right_square, right_square_position);
                }
                // right_square.getOccupant == GardenObject
                else {
                    if (right_square.getOccupant() instanceof GardenPlant) {
                        GardenPlant gardenPlant = (GardenPlant) right_square.getOccupant();
                        gardenPlant.getPollenCloud().addColor(color);
                        Occupant occupant = gardenPlant;
    
                        garden.setGardenSquareByPosition(new GardenSquare(occupant, right_square_position), right_square_position);
                        break;
                    }
                    else {
                        break;
                    }
                }
                right_square_columnindex += 1; 
            }
            else {
                break;
            }
        }
    }  
}
