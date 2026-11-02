package GardenApp;

import java.util.ArrayList;
import java.util.List;

// Garden class will be responsible for creating the garden, initializing the garden with random statues,
public class Garden {
    private ArrayList<List<GardenSquare>> gardenMap;

    // Initially a Garden of size 6 x 8 ( 6 rows & 8 columns ) should be created
    public Garden() {
        ArrayList< List<GardenSquare> > temp = new ArrayList< List<GardenSquare> >(); 
        for (int row = 0; row < 6; row++ ) {
            List<GardenSquare> row_List = new ArrayList<GardenSquare>();
            for (int column = 0; column < 8; column++) {
                    row_List.add( new GardenSquare(null, new Position(row, column)) );
            }
            temp.add(row_List);
        }
        this.gardenMap = temp;
    }

    // Initialize the garden with random statues
    public void initializeRandomGarden(GardenSquare goal) {
        Position randomPosition = new Position();
        randomPosition.setRandomPosition();

        int i = 1;
        while ( i < 9) {
            GardenSquare selected = this.gardenMap.get( randomPosition.getRowByIndex() ).get( randomPosition.getColumnByIndex() );
            if ( randomPosition.equals(goal.getPosition()) || selected.getOccupant() != null ) {

            }
            else {
                String ID = "S" + String.valueOf(i);
                this.gardenMap.get( randomPosition.getRowByIndex() ).get( randomPosition.getColumnByIndex() ).setOccupant( new Statue(ID) );
                i += 1;
            }
            randomPosition.setRandomPosition();
        } 
    }

    // Initialize the garden with test case statues
    public void initializeTestCaseGarden() {
        this.gardenMap.get(0).set(0, new GardenSquare(new Statue("S1"), new Position(0, 0)));
        this.gardenMap.get(2).set(3, new GardenSquare(new Statue("S2"), new Position(2, 3)));
        this.gardenMap.get(1).set(4, new GardenSquare(new Statue("S3"), new Position(1, 4)));
        this.gardenMap.get(5).set(1, new GardenSquare(new Statue("S4"), new Position(5, 1)));
        this.gardenMap.get(5).set(6, new GardenSquare(new Statue("S5"), new Position(5, 6)));
        this.gardenMap.get(2).set(7, new GardenSquare(new Statue("S6"), new Position(2, 7)));
        this.gardenMap.get(3).set(1, new GardenSquare(new Statue("S7"), new Position(3, 1)));
    }

    public GardenSquare getSquareByPosition(Position position) {
        int row_int = position.getRowByIndex();
        int column_int = position.getColumnByIndex();
        return this.gardenMap.get(row_int).get(column_int);
    }

    public void setGardenSquareByPosition(GardenSquare gardenSquare, Position position) {
        int row_int = position.getRowByIndex();
        int column_int = position.getColumnByIndex();
        this.gardenMap.get(row_int).set(column_int, gardenSquare);
    }

    public void placeObject(GardenObject object, String position_String) {
        Position position = new Position(String.valueOf(position_String.charAt(0)), String.valueOf(position_String.charAt(1)));
        this.getSquareByPosition(position).setOccupant(object);
    }

    public void placeObject(GardenObject object, Position position) {
        this.getSquareByPosition(position).setOccupant(object);
    }

    // Will display the garden depending on the display rules
    /*Initial Garden Map:
    
           1      2      3      4      5      6     7       8   
        --------------------------------------------------------
    A  |  S1  |      |      |      |      |      |      |      |
        --------------------------------------------------------
    B  |      |      |      |      |  S3  |      |      |      |
        --------------------------------------------------------
    C  |      |      |      |  S2  |Target|      |      |  S6  |
        --------------------------------------------------------
    D  |      |  S7  |      |      |      |      |      |      |
        --------------------------------------------------------
    E  |      |      |      |      |      |      |      |      |
        --------------------------------------------------------
    F  |      |  S4  |      |      |      |      |  S5  |      |
        --------------------------------------------------------

    */
    public void Initialdisplay(GardenSquare goal) {
        System.out.println("Initial Garden Map:\n");
        System.out.println("       1      2      3      4      5      6     7       8   ");
        System.out.println("    --------------------------------------------------------");
        for (int row = 0; row < 6; row++) {
            List<GardenSquare> row_list = this.gardenMap.get(row);
            String row_s = row_list.get(0).getPosition().getRow() + "  |";
            for (int column = 0; column < 8; column++) { 
                if (row_list.get(column).getPosition().equals(goal.getPosition())) {
                    row_s += "Target|";
                }
                else {
                    row_s += row_list.get(column).toString() + "|";
                }
            }
            System.out.println(row_s);
            System.out.println("    --------------------------------------------------------");
        }
        System.out.println();

    }

    // Will display the garden depending on the final display rules
    public void display(List<GardenObject> selectedObjects) {
        System.out.println("Final Garden Map:\n");
        System.out.println("       1      2      3      4      5      6     7       8   ");
        System.out.println("    --------------------------------------------------------");
        for (int row = 0; row < 6; row++) {
            List<GardenSquare> row_list = this.gardenMap.get(row);
            String row_s = row_list.get(0).getPosition().getRow() + "  |";
            for (int column = 0; column < 8; column++) { 
                row_s += row_list.get(column).toString() + "|";
            }
            System.out.println(row_s);
            System.out.println("    --------------------------------------------------------");
        }
        System.out.println();

        for (GardenObject object : selectedObjects) {
            if (object instanceof LightSource) {
                LightSource lightSource = (LightSource) object;
                System.out.printf("-- %s: %s with %s color", lightSource.getID(), lightSource.getClass().getSimpleName(), lightSource.getColor().toString().toLowerCase());
            }
            else {
                GardenPlant gardenPlant = (GardenPlant) object;
                System.out.printf("-- %s: %s %s", gardenPlant.getID(), gardenPlant.getName(), gardenPlant.getClass().getSimpleName());
            }
            System.out.println();
        }
        System.out.println();  
    }

    public void checkGoal(GardenSquare goal) {
        GardenSquare target = gardenMap.get(goal.getPosition().getRowByIndex()).get(goal.getPosition().getColumnByIndex());
        if (target.getOccupant() == null) {
            System.out.println("====>> UNSUCCESSFUL");
        }
        else {
            if (goal.getOccupant().toString().equalsIgnoreCase(target.getOccupant().toString())) {
                System.out.println("====>> SUCCESSFUL");
            }
            else {
                System.out.println("====>> UNSUCCESSFUL");
            }
        }
    }

    public Position findPositionOfGardenObjectByID( String ID ) {
        Position position = new Position();
        for (List<GardenSquare> row : this.gardenMap) {
            for (GardenSquare square : row) {
                Occupant occupant = square.getOccupant();
                if (occupant instanceof GardenObject) {
                    GardenObject gardenObject = (GardenObject) square.getOccupant();
                    if (gardenObject.getID().equalsIgnoreCase(ID)) {
                        position = square.getPosition();
                    }
                }
                
            }
        }
        return position;
    }

    // Getters and Setters
    public ArrayList<List<GardenSquare>> getGardenMap() { return gardenMap; }
    public void setGardenMap(ArrayList<List<GardenSquare>> gardenMap) { this.gardenMap = gardenMap; }
}
