package GardenApp;

public class Tree extends GardenPlant {

    public Tree(String ID, String name, int range, PollenCloud pollenCloud) {
        super(ID, name, range, pollenCloud);
    }

    // Copy Constructor
    public Tree(Tree another) {
        super(another);
    }

    // Main bloom method for Bush that updates the garden map
    @Override
    public void bloom(Garden garden) {
        int range = this.getAreaOfPollenSpread();
        PollenCloud plantPollenCloud = this.getPollenCloud();

        Position position = garden.findPositionOfGardenObjectByID(this.getID());

        int current_row_index = position.getRowByIndex();
        int left_square_columnindex = position.getColumnByIndex() - 1;
        int right_square_columnindex = position.getColumnByIndex() + 1;

        // Checking the square position is in the range of the area of pollen spread of the plant
        for (int i = 0; i < range; i++) {
            // Checking the square position is in the range of the map
            if (0 <= current_row_index && current_row_index <= 5 && 0 <= left_square_columnindex && left_square_columnindex <= 7) {
                GardenSquare left_square = garden.getGardenMap().get(current_row_index).get(left_square_columnindex);
                Position left_square_position = left_square.getPosition();

                if (left_square.getOccupant() == null) {
                    PollenCloud pollenCloud = new PollenCloud();
                    for (Pollen pollen : plantPollenCloud.getPollens()) {
                        pollenCloud.addPollen(pollen);
                    }
                    for (Color color : plantPollenCloud.getColors() ) {
                        pollenCloud.addColor(color);
                    }

                    left_square.setOccupant(pollenCloud);
                    garden.setGardenSquareByPosition(left_square, left_square_position);
                } else if (left_square.getOccupant() instanceof PollenCloud) {
                    PollenCloud pollenCloud = (PollenCloud) left_square.getOccupant();
                    for (Pollen pollen : plantPollenCloud.getPollens()) {
                        pollenCloud.addPollen(pollen);
                    }
                    for (Color color : plantPollenCloud.getColors() ) {
                        pollenCloud.addColor(color);
                    }

                    left_square.setOccupant(pollenCloud);
                    garden.setGardenSquareByPosition(left_square, left_square_position);
                } 
                // left_square.getOccupant == GardenObject
                else {
                    break;
                }
                left_square_columnindex -= 1;
            }
            else {
                break;
            }
        }

        // Checking the square position is in the range of the area of pollen spread of the plant
        for (int j = 0; j < range; j++) {
            // Checking the square position is in the range of the map
            if (0 <= current_row_index && current_row_index <= 5 && 0 <= right_square_columnindex && right_square_columnindex <= 7) {
                GardenSquare right_square = garden.getGardenMap().get(current_row_index).get(right_square_columnindex);
                Position right_square_position = right_square.getPosition();

                if (right_square.getOccupant() == null) {
                    PollenCloud pollenCloud = new PollenCloud();
                    for (Pollen pollen : plantPollenCloud.getPollens()) {
                        pollenCloud.addPollen(pollen);
                    }
                    for (Color color : plantPollenCloud.getColors() ) {
                        pollenCloud.addColor(color);
                    }

                    right_square.setOccupant(pollenCloud);
                    garden.setGardenSquareByPosition(right_square, right_square_position);
                } else if (right_square.getOccupant() instanceof PollenCloud) {
                    PollenCloud pollenCloud = (PollenCloud) right_square.getOccupant();
                    for (Pollen pollen : plantPollenCloud.getPollens()) {
                        pollenCloud.addPollen(pollen);
                    }
                    for (Color color : plantPollenCloud.getColors() ) {
                        pollenCloud.addColor(color);
                    }

                    right_square.setOccupant(pollenCloud);
                    garden.setGardenSquareByPosition(right_square, right_square_position);
                }
                // right_square.getOccupant == GardenObject
                else {
                    break;
                }
                right_square_columnindex += 1;
            } else {
                break;
            }
        }
    }

    // A pseudo bloom method for Tree that updates the gardenPlant's pollen cloud
    @Override
    public void pseudoBloom(Garden garden) {
        int range = this.getAreaOfPollenSpread();
        PollenCloud plantPollenCloud = this.getPollenCloud();

        Position position = garden.findPositionOfGardenObjectByID(this.getID());

        int current_row_index = position.getRowByIndex();
        int left_square_columnindex = position.getColumnByIndex() - 1;
        int right_square_columnindex = position.getColumnByIndex() + 1;

        // Checking the square position is in the range of the area of pollen spread of the plant
        for (int j = 0; j < range; j++) {
            // Checking the square position is in the range of the map
            if (0 <= current_row_index && current_row_index <= 5 && 0 <= left_square_columnindex && left_square_columnindex <= 7) {
                GardenSquare left_square = garden.getGardenMap().get(current_row_index).get(left_square_columnindex);
                Position left_square_position = left_square.getPosition();

                if (left_square.getOccupant() instanceof GardenPlant) {
                    GardenPlant infusedGardenPlant = (GardenPlant) left_square.getOccupant();
                    PollenCloud pollenCloud = (PollenCloud) left_square.getOccupant();
                    for (Pollen pollen : plantPollenCloud.getPollens()) {
                        pollenCloud.addPollen(pollen);
                    }
                    for (Color color : plantPollenCloud.getColors() ) {
                        pollenCloud.addColor(color);
                    }
                    infusedGardenPlant.setPollenCloud(pollenCloud);

                    left_square.setOccupant(infusedGardenPlant);
                    garden.setGardenSquareByPosition(left_square, left_square_position);
                    break;
                } else if (left_square.getOccupant() instanceof LightSource || left_square.getOccupant() instanceof Statue) {
                    break;
                }
                // up_square.getOccupant == PollenCloud or null
                else {

                }
                left_square_columnindex -= 1;
            } else {
                break;
            }
        }

        // Checking the square position is in the range of the area of pollen spread of the plant
        for (int j = 0; j < range; j++) {
            // Checking the square position is in the range of the map
            if (0 <= current_row_index && current_row_index <= 5 && 0 <= right_square_columnindex && right_square_columnindex <= 7) {
                GardenSquare right_square = garden.getGardenMap().get(current_row_index).get(right_square_columnindex);
                Position right_square_position = right_square.getPosition();

                if (right_square.getOccupant() instanceof GardenPlant) {
                    GardenPlant infusedGardenPlant = (GardenPlant) right_square.getOccupant();
                    PollenCloud pollenCloud = (PollenCloud) right_square.getOccupant(); 
                    for (Pollen pollen : plantPollenCloud.getPollens()) {
                        pollenCloud.addPollen(pollen);
                    }
                    for (Color color : plantPollenCloud.getColors() ) {
                        pollenCloud.addColor(color);
                    }
                    infusedGardenPlant.setPollenCloud(pollenCloud);

                    right_square.setOccupant(infusedGardenPlant);
                    garden.setGardenSquareByPosition(right_square, right_square_position);
                    break;
                } else if (right_square.getOccupant() instanceof LightSource || right_square.getOccupant() instanceof Statue) {
                    break;
                }
                // up_square.getOccupant == PollenCloud or null
                else {

                }

                right_square_columnindex += 1;
            } else {
                break;
            }
        }
    }
}
