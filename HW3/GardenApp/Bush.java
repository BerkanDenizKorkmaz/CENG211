package GardenApp;

public class Bush extends GardenPlant{

    public Bush(String ID, String name, int range, PollenCloud pollenCloud) {
        super(ID, name, range, pollenCloud);
    }

    // Copy Constructor
    public Bush(Bush another) {
        super(another);
    }

    // Main bloom method for Bush that updates the garden map
    @Override
    public void bloom(Garden garden) {
        int range = this.getAreaOfPollenSpread();
        PollenCloud plantPollenCloud = this.getPollenCloud();

        Position position = garden.findPositionOfGardenObjectByID(this.getID());

        int next_square_columnindex = position.getColumnByIndex();
        int up_square_rowindex = position.getRowByIndex() - 1;
        int down_square_rowindex = position.getRowByIndex() + 1;

        // Checking the square position is in the range of the area of pollen spread of the plant
        for (int i = 0; i < range; i++) {
            // Checking the square position is in the range of the map
            if (0<= up_square_rowindex && up_square_rowindex <=5 && 0<= next_square_columnindex && next_square_columnindex <= 7) {
                GardenSquare up_square = garden.getGardenMap().get(up_square_rowindex).get(next_square_columnindex);
                Position up_square_position = up_square.getPosition();
                if (up_square.getOccupant() == null) {
                    Occupant occupant = new PollenCloud();
                    PollenCloud pollenCloud = (PollenCloud) occupant;
                    for (Pollen pollen : plantPollenCloud.getPollens() ) {
                        pollenCloud.addPollen(pollen);
                    }
                    for (Color color : plantPollenCloud.getColors() ) {
                        pollenCloud.addColor(color);
                    }
                    
                    up_square.setOccupant(pollenCloud);
                    garden.setGardenSquareByPosition(up_square, up_square_position);
                }
                else if (up_square.getOccupant() instanceof PollenCloud) {
                    PollenCloud pollenCloud = (PollenCloud) up_square.getOccupant();
                    for (Pollen pollen : plantPollenCloud.getPollens() ) {
                        pollenCloud.addPollen(pollen);
                    }
                    for (Color color : plantPollenCloud.getColors() ) {
                        pollenCloud.addColor(color);
                    }
                    
                    up_square.setOccupant(pollenCloud);
                    garden.setGardenSquareByPosition(up_square, up_square_position);
                }
                // right_square.getOccupant == GardenObject
                else {
                    break;
                }
                up_square_rowindex -= 1;
                
            }
            else {
                break;
            }
        }

        // Checking the square position is in the range of the area of pollen spread of the plant
        for (int j = 0; j < range; j++) {
            // Checking the square position is in the range of the map
            if (0<= down_square_rowindex && down_square_rowindex <=5 && 0<= next_square_columnindex && next_square_columnindex <= 7) {
                GardenSquare down_square = garden.getGardenMap().get(down_square_rowindex).get(next_square_columnindex);
                Position down_square_position = down_square.getPosition();
                if (down_square.getOccupant() == null) {
                    Occupant occupant = new PollenCloud();
                    PollenCloud pollenCloud = (PollenCloud) occupant;
                    for (Pollen pollen : plantPollenCloud.getPollens() ) {
                        pollenCloud.addPollen(pollen);
                    }
                    for (Color color : plantPollenCloud.getColors() ) {
                        pollenCloud.addColor(color);
                    }
                    
                    down_square.setOccupant(pollenCloud);
                    garden.setGardenSquareByPosition(down_square, down_square_position);
                }
                else if (down_square.getOccupant() instanceof PollenCloud) {
                    PollenCloud pollenCloud = (PollenCloud) down_square.getOccupant();
                    for (Pollen pollen : plantPollenCloud.getPollens() ) {
                        pollenCloud.addPollen(pollen);
                    }
                    for (Color color : plantPollenCloud.getColors() ) {
                        pollenCloud.addColor(color);
                    }
                    
                    down_square.setOccupant(pollenCloud);
                    garden.setGardenSquareByPosition(down_square, down_square_position);
                }
                // right_square.getOccupant == GardenObject
                else {
                    break;
                }
                down_square_rowindex += 1;
            }
            else {
                break;
            }
        }
    }


    // A pseudo bloom method for Bush that updates the gardenPlant's pollen cloud
    @Override
    public void pseudoBloom(Garden garden) {
        int range = this.getAreaOfPollenSpread();
        PollenCloud plantPollenCloud = this.getPollenCloud();

        Position position = garden.findPositionOfGardenObjectByID(this.getID());

        int next_square_columnindex = position.getColumnByIndex();
        int up_square_rowindex = position.getRowByIndex() - 1;
        int down_square_rowindex = position.getRowByIndex() + 1;

        // Checking the square position is in the range of the area of pollen spread of the plant
        for (int j = 0; j < range; j++) {
            // Checking the square position is in the range of the map
            if (0<= up_square_rowindex && up_square_rowindex <=5 && 0<= next_square_columnindex && next_square_columnindex <= 7) {
                GardenSquare up_square = garden.getGardenMap().get(up_square_rowindex).get(next_square_columnindex);
                Position up_square_position = up_square.getPosition();

                if (up_square.getOccupant() instanceof GardenPlant) {
                    GardenPlant infusedGardenPlant = (GardenPlant) up_square.getOccupant(); 
                    PollenCloud pollenCloud = (PollenCloud) up_square.getOccupant();
                    for (Pollen pollen : plantPollenCloud.getPollens() ) {
                        pollenCloud.addPollen(pollen);                    
                    }
                    for (Color color : plantPollenCloud.getColors() ) {
                        pollenCloud.addColor(color);
                    }
                    infusedGardenPlant.setPollenCloud(pollenCloud);

                    up_square.setOccupant(infusedGardenPlant);
                    garden.setGardenSquareByPosition(up_square, up_square_position);
                    break;
                }
                else if (up_square.getOccupant() instanceof LightSource || up_square.getOccupant() instanceof Statue) {
                    break;
                }
                // up_square.getOccupant == PollenCloud or null
                else {
                }
                up_square_rowindex -= 1;
            }
            else {
                break;
            }
        }

        // Checking the square position is in the range of the area of pollen spread of the plant
        for (int j = 0; j < range; j++) {
            // Checking the square position is in the range of the map
            if (0<= down_square_rowindex && down_square_rowindex <=5 && 0<= next_square_columnindex && next_square_columnindex <= 7) {
                GardenSquare down_square = garden.getGardenMap().get(down_square_rowindex).get(next_square_columnindex);
                Position down_square_position = down_square.getPosition();

                if (down_square.getOccupant() instanceof GardenPlant) {
                    GardenPlant infusedGardenPlant = (GardenPlant) down_square.getOccupant(); 
                    PollenCloud pollenCloud = (PollenCloud) down_square.getOccupant();
                    for (Pollen pollen : plantPollenCloud.getPollens() ) {
                        pollenCloud.addPollen(pollen);                    
                    }
                    for (Color color : plantPollenCloud.getColors() ) {
                        pollenCloud.addColor(color);
                    }
                    infusedGardenPlant.setPollenCloud(pollenCloud);

                    down_square.setOccupant(infusedGardenPlant);
                    garden.setGardenSquareByPosition(down_square, down_square_position);
                    break;
                }
                else if (down_square.getOccupant() instanceof LightSource || down_square.getOccupant() instanceof Statue) {
                    break;
                }
                // down_square.getOccupant == PollenCloud or null
                else {

                }
                down_square_rowindex += 1;
            }
            else {
                break;
            }
        }
    }
}
