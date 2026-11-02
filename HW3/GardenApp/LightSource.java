package GardenApp;

public abstract class LightSource extends GardenObject implements Searchable {

    private Color color;
    private int areaOfLightReach;

    public LightSource(String ID, Color color, int areaOfLightReach) {
        super(ID);
        this.color = color;
        this.areaOfLightReach = areaOfLightReach;
    }

    // Copy constructor
    public LightSource(LightSource another) {
        super(another);
        this.color = another.color;
        this.areaOfLightReach = another.areaOfLightReach;
    }

    // Getters and Setters
    public Color getColor() { return color; }
    public int getAreaOfLightReach() { return areaOfLightReach; }
    
    public void setColor(Color color) { this.color = color; }
    public void searchByAreaOfLightReach(int areaOfLightReach) { this.areaOfLightReach = areaOfLightReach; }

    // Searchable Interface methods
    public boolean searchByType(GardenObject gardenObject) {
        return gardenObject.getClass() == this.getClass();
    }
    public boolean searchByID(String ID) {
        return this.getID().equalsIgnoreCase(ID);
    }
    public boolean searchByColor( Color color) {
        return this.color == color;
    }
    public boolean searchByAreaOfReach(int areaOfReach) {
        return this.areaOfLightReach == areaOfReach;
    }
    public boolean searchByName(String name) {
        System.out.println("You can not search Light Source by name");
        return false;
    }

    public abstract void lightUp(Garden garden);

    @Override
    public void displayInfo() {
        System.out.print("- Type: " + this.getClass().getSimpleName());
        System.out.print(", Id: " + this.getID());
        System.out.print(", Color: " + this.color.toString().toLowerCase());
        System.out.print(", Area of reach: " + this.areaOfLightReach);
    }
}
