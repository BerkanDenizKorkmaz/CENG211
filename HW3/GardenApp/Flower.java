package GardenApp;

public class Flower extends GardenPlant {
        
    public Flower(String ID, String name, int range, PollenCloud pollenCloud) {
        super(ID, name, range, pollenCloud);
    }

    // Copy Constructor
    public Flower(Flower another) {
        super(another);
    }

    // Main bloom method for Bush that updates the garden map
    @Override
    public void bloom(Garden garden) {
        int range = this.getAreaOfPollenSpread();
        PollenCloud plantPollenCloud = this.getPollenCloud();

        Position position = garden.findPositionOfGardenObjectByID(this.getID());

        int current_row_index = position.getRowByIndex();
        int current_column_index = position.getColumnByIndex();

        // Spread diagonally up-left
        // Check if the square is within the range of the area of pollen spread of the plant
        for (int i = 1; i < range+1; i++) {
            int up_left_row = current_row_index - i;
            int up_left_column = current_column_index - i;
            // Check if the square is within the range of the map
            if (0 <= up_left_row && up_left_row <= 5 && 0 <= up_left_column && up_left_column <= 7) {
                GardenSquare up_left_square = garden.getGardenMap().get(up_left_row).get(up_left_column);
                Position up_left_position = up_left_square.getPosition();

                if (up_left_square.getOccupant() == null) {
                    PollenCloud pollenCloud = new PollenCloud();
                    for (Pollen pollen : plantPollenCloud.getPollens()) {
                        pollenCloud.addPollen(pollen);
                    }
                    for (Color color : plantPollenCloud.getColors() ) {
                        pollenCloud.addColor(color);
                    }

                    up_left_square.setOccupant(pollenCloud);
                    garden.setGardenSquareByPosition(up_left_square, up_left_position);
                }
                else if (up_left_square.getOccupant() instanceof PollenCloud) {
                    PollenCloud pollenCloud = (PollenCloud) up_left_square.getOccupant();
                    for (Pollen pollen : plantPollenCloud.getPollens()) {
                        pollenCloud.addPollen(pollen);
                    }
                    for (Color color : plantPollenCloud.getColors() ) {
                        pollenCloud.addColor(color);
                    }

                    up_left_square.setOccupant(pollenCloud);
                    garden.setGardenSquareByPosition(up_left_square, up_left_position);
                }
                // up_left_square.getOccupant == GardenObject
                else {
                    break;
                }
            }
            else {
                break;
            }
        }

        // Spread diagonally up-right
        // Check if the square is within the range of the area of pollen spread of the plant
        for (int i = 1; i < range+1; i++) {
            int up_right_row = current_row_index - i;
            int up_right_column = current_column_index + i;
            // Check if the square is within the range of the map
            if (0 <= up_right_row && up_right_row <= 5 && 0 <= up_right_column && up_right_column <= 7) {
                GardenSquare up_right_square = garden.getGardenMap().get(up_right_row).get(up_right_column);
                Position up_right_position = up_right_square.getPosition();

                if (up_right_square.getOccupant() == null) {
                    PollenCloud pollenCloud = new PollenCloud();
                    for (Pollen pollen : plantPollenCloud.getPollens()) {
                        pollenCloud.addPollen(pollen);
                    }
                    for (Color color : plantPollenCloud.getColors() ) {
                        pollenCloud.addColor(color);
                    }

                    up_right_square.setOccupant(pollenCloud);
                    garden.setGardenSquareByPosition(up_right_square, up_right_position);
                }
                else if (up_right_square.getOccupant() instanceof PollenCloud) {
                    PollenCloud pollenCloud = (PollenCloud) up_right_square.getOccupant();
                    for (Pollen pollen : plantPollenCloud.getPollens()) {
                        pollenCloud.addPollen(pollen);
                    }
                    for (Color color : plantPollenCloud.getColors() ) {
                        pollenCloud.addColor(color);
                    }

                    up_right_square.setOccupant(pollenCloud);
                    garden.setGardenSquareByPosition(up_right_square, up_right_position);
                }
                // up_right_square.getOccupant == GardenObject
                else {
                    break;
                }
            } else {
                break;
            }
        }

        // Spread diagonally down-left
        // Check if the square is within the range of the area of pollen spread of the plant
        for (int i = 1; i < range+1; i++) {
            int down_left_row = current_row_index + i;
            int down_left_column = current_column_index - i;
            // Check if the square is within the range of the map
            if (0 <= down_left_row && down_left_row <= 5 && 0 <= down_left_column && down_left_column <= 7) {
                GardenSquare down_left_square = garden.getGardenMap().get(down_left_row).get(down_left_column);
                Position down_left_position = down_left_square.getPosition();

                if (down_left_square.getOccupant() == null) {
                    PollenCloud pollenCloud = new PollenCloud();
                    for (Pollen pollen : plantPollenCloud.getPollens()) {
                        pollenCloud.addPollen(pollen);
                    }
                    for (Color color : plantPollenCloud.getColors() ) {
                        pollenCloud.addColor(color);
                    }

                    down_left_square.setOccupant(pollenCloud);
                    garden.setGardenSquareByPosition(down_left_square, down_left_position);
                }
                else if (down_left_square.getOccupant() instanceof PollenCloud) {
                    PollenCloud pollenCloud = (PollenCloud) down_left_square.getOccupant();
                    for (Pollen pollen : plantPollenCloud.getPollens()) {
                        pollenCloud.addPollen(pollen);
                    }
                    for (Color color : plantPollenCloud.getColors() ) {
                        pollenCloud.addColor(color);
                    }

                    down_left_square.setOccupant(pollenCloud);
                    garden.setGardenSquareByPosition(down_left_square, down_left_position);
                }
                // down_left_square.getOccupant == GardenObject
                else {
                    break;
                }
            }
            else {
                break;
            }
        }

        // Spread diagonally down-right
        // Check if the square is within the range of the area of pollen spread of the plant
        for (int i = 1; i < range+1; i++) {
            int down_right_row = current_row_index + i;
            int down_right_column = current_column_index + i;
            // Check if the square is within the range of the map
            if (0 <= down_right_row && down_right_row <= 5 && 0 <= down_right_column && down_right_column <= 7) {
                GardenSquare down_right_square = garden.getGardenMap().get(down_right_row).get(down_right_column);
                Position down_right_position = down_right_square.getPosition();

                if (down_right_square.getOccupant() == null) {
                    PollenCloud pollenCloud = new PollenCloud();
                    for (Pollen pollen : plantPollenCloud.getPollens()) {
                        pollenCloud.addPollen(pollen);
                    }
                    for (Color color : plantPollenCloud.getColors() ) {
                        pollenCloud.addColor(color);
                    }

                    down_right_square.setOccupant(pollenCloud);
                    garden.setGardenSquareByPosition(down_right_square, down_right_position);
                }
                else if (down_right_square.getOccupant() instanceof PollenCloud) {
                    PollenCloud pollenCloud = (PollenCloud) down_right_square.getOccupant();
                    for (Pollen pollen : plantPollenCloud.getPollens()) {
                        pollenCloud.addPollen(pollen);
                    }
                    for (Color color : plantPollenCloud.getColors() ) {
                        pollenCloud.addColor(color);
                    }

                    down_right_square.setOccupant(pollenCloud);
                    garden.setGardenSquareByPosition(down_right_square, down_right_position);
                }
                // down_right_square.getOccupant == GardenObject
                else {
                    break;
                }
            } else {
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

        int current_row_index = position.getRowByIndex();
        int current_column_index = position.getColumnByIndex();

        // Infuse diagonally up-left
        for (int i = 1; i < range+1; i++) {
            int up_left_row = current_row_index - i;
            int up_left_column = current_column_index - i;
            if (0 <= up_left_row && up_left_row <= 5 && 0 <= up_left_column && up_left_column <= 7) {
                GardenSquare up_left_square = garden.getGardenMap().get(up_left_row).get(up_left_column);
                Position up_left_position = up_left_square.getPosition();

                if (up_left_square.getOccupant() instanceof GardenPlant) {
                    GardenPlant infusedGardenPlant = (GardenPlant) up_left_square.getOccupant();
                    PollenCloud pollenCloud = (PollenCloud) up_left_square.getOccupant();
                    for (Pollen pollen : plantPollenCloud.getPollens()) {
                        pollenCloud.addPollen(pollen);
                    }
                    for (Color color : plantPollenCloud.getColors() ) {
                        pollenCloud.addColor(color);
                    }
                    infusedGardenPlant.setPollenCloud(pollenCloud);


                    up_left_square.setOccupant(infusedGardenPlant);
                    garden.setGardenSquareByPosition(up_left_square, up_left_position);
                    break;
                }
            } else {
                break;
            }
        }

        // Infuse diagonally up-right
        for (int i = 1; i < range+1; i++) {
            int up_right_row = current_row_index - i;
            int up_right_column = current_column_index + i;
            if (0 <= up_right_row && up_right_row <= 5 && 0 <= up_right_column && up_right_column <= 7) {
                GardenSquare up_right_square = garden.getGardenMap().get(up_right_row).get(up_right_column);
                Position up_right_position = up_right_square.getPosition();

                if (up_right_square.getOccupant() instanceof GardenPlant) {
                    GardenPlant infusedGardenPlant = (GardenPlant) up_right_square.getOccupant();
                    PollenCloud pollenCloud = (PollenCloud) up_right_square.getOccupant();
                    for (Pollen pollen : plantPollenCloud.getPollens()) {
                        pollenCloud.addPollen(pollen);
                    }
                    for (Color color : plantPollenCloud.getColors() ) {
                        pollenCloud.addColor(color);
                    }
                    infusedGardenPlant.setPollenCloud(pollenCloud);

                    up_right_square.setOccupant(infusedGardenPlant);
                    garden.setGardenSquareByPosition(up_right_square, up_right_position);
                    break;
                }
            } else {
                break;
            }
        }

        // Infuse diagonally down-left
        for (int i = 1; i < range+1; i++) {
            int down_left_row = current_row_index + i;
            int down_left_column = current_column_index - i;
            if (0 <= down_left_row && down_left_row <= 5 && 0 <= down_left_column && down_left_column <= 7) {
                GardenSquare down_left_square = garden.getGardenMap().get(down_left_row).get(down_left_column);
                Position down_left_position = down_left_square.getPosition();

                if (down_left_square.getOccupant() instanceof GardenPlant) {
                    GardenPlant infusedGardenPlant = (GardenPlant) down_left_square.getOccupant();
                    PollenCloud pollenCloud = (PollenCloud) down_left_square.getOccupant();
                    for (Pollen pollen : plantPollenCloud.getPollens()) {
                        pollenCloud.addPollen(pollen);
                    }
                    for (Color color : plantPollenCloud.getColors() ) {
                        pollenCloud.addColor(color);
                    }
                    infusedGardenPlant.setPollenCloud(pollenCloud);

                    down_left_square.setOccupant(infusedGardenPlant);
                    garden.setGardenSquareByPosition(down_left_square, down_left_position);
                    break;
                }
            } else {
                break;
            }
        }

        // Infuse diagonally down-right
        for (int i = 1; i < range+1; i++) {
            int down_right_row = current_row_index + i;
            int down_right_column = current_column_index + i;
            if (0 <= down_right_row && down_right_row <= 5 && 0 <= down_right_column && down_right_column <= 7) {
                GardenSquare down_right_square = garden.getGardenMap().get(down_right_row).get(down_right_column);
                Position down_right_position = down_right_square.getPosition();

                if (down_right_square.getOccupant() instanceof GardenPlant) {
                    GardenPlant infusedGardenPlant = (GardenPlant) down_right_square.getOccupant();
                    PollenCloud pollenCloud = (PollenCloud) down_right_square.getOccupant();
                    for (Pollen pollen : plantPollenCloud.getPollens()) {
                        pollenCloud.addPollen(pollen);
                    }
                    for (Color color : plantPollenCloud.getColors() ) {
                        pollenCloud.addColor(color);
                    }
                    infusedGardenPlant.setPollenCloud(pollenCloud);
                    
                    down_right_square.setOccupant(infusedGardenPlant);
                    garden.setGardenSquareByPosition(down_right_square, down_right_position);
                    break;
                }
            } else {
                break;
            }
        }
    }     
}
