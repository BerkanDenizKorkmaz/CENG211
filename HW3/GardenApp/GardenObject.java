package GardenApp;

public abstract class GardenObject implements Occupant{

    private String ID;

    public GardenObject() {}

    public GardenObject(String ID) {
        this.ID = ID;
    }

    // Copy Constructor
    public GardenObject(GardenObject another) {
        this.ID = another.ID;
    }

    // Getter and Setters
    public String getID() { return ID; }

    public void setID( String ID ) { this.ID = ID; }

    public abstract void displayInfo();

    @Override
    public String toString() {
        if (ID.length() == 2) {
            return "  " + ID + "  ";
        }
        else {
            return "  " + ID + " ";
        }
    }
 
}
