package GardenApp;

public class GardenSquare {

    private Occupant occupant;
    private Position position;

    public GardenSquare() {}

    public GardenSquare(Occupant occupant, Position position) {
        this.occupant = occupant;
        this.position = position;
    }

    // Getters and Setters 
    public Occupant getOccupant() { return occupant; }
    public Position getPosition() { return position; }

    public void setOccupant( Occupant occupant ) { this.occupant = occupant; }
    public void setPosition( Position position ) { this.position = position; }

    public boolean isOccupied() { 
        if (this.occupant == null) {
            return false;
        }
        else {
            return (this.occupant instanceof GardenObject) ; 
        }
    }    

    // Generate a random GardenSquare which contains the goal as a PollenCloud
    public GardenSquare generateRandomGoal() {
        PollenCloud pollenCloud = new PollenCloud();
        pollenCloud.setRandomPollenCloud();

        Position position = new Position();
        position.setRandomPosition();

        GardenSquare goal = new GardenSquare(pollenCloud, position);

        String types = "";
        for(Pollen element : pollenCloud.getPollens() ) { types += element.toString() + " "; }
        String colors = "";
        for ( Color element : pollenCloud.getColors() ) { colors += element.toString() + " "; }
        System.out.printf("Welcome to Garden Puzzle App. Your goal Square needs %spollens infused with %scolor(s).\n\n", types, colors );
        return goal;
    }

    // Generate the test case GardenSquare which contains the goal as a PollenCloud
    public GardenSquare generateTestCaseGoal() {
        PollenCloud pollenCloud = new PollenCloud();
        pollenCloud.setTestCasePollenCloud();

        Position position = new Position();
        position.setTestCaseGoalPosition();

        GardenSquare goal = new GardenSquare(pollenCloud, position);

        String types = "";
        for(Pollen element : pollenCloud.getPollens() ) { types += element.toString() + " "; }
        String colors = "";
        for ( Color element : pollenCloud.getColors() ) { colors += element.toString() + " "; }
        System.out.printf("Welcome to Garden Puzzle App. Your goal Square needs %spollens infused with %scolor(s).\n\n", types, colors );
        return goal;
    }    

    @Override
    public String toString() {
        if ( this.occupant == null ) {
            return "      ";
        }
        else {
        return ( this.occupant.toString());
        }
    }
}
