package GardenApp;

public abstract class GardenPlant extends GardenObject implements Searchable {

    private String name;
    private int areaOfPollenSpread;
    private PollenCloud pollenCloud;

    public GardenPlant(String ID, String name, int areaOfPollenSpread, PollenCloud pollenCloud) {
        super(ID);
        this.name = name;
        this.areaOfPollenSpread = areaOfPollenSpread;
        this.pollenCloud = pollenCloud;
    }

    // Copy Constructor 
    public GardenPlant(GardenPlant another) {
        super(another);
        this.name = another.name;
        this.areaOfPollenSpread = another.areaOfPollenSpread;
        this.pollenCloud = another.pollenCloud;
    }

    // Getter and Setters
    public String getName() { return name; }
    public int getAreaOfPollenSpread() { return areaOfPollenSpread; }
    public PollenCloud getPollenCloud() { return pollenCloud; }

    public void setName(String name) { this.name = name;}
    public void setAreaOfPollenSpread(int areaOfPollenSpread) { this.areaOfPollenSpread = areaOfPollenSpread; }
    public void setPollenCloud(PollenCloud pollenCloud) { this.pollenCloud = pollenCloud; }
    public void addPollen(Pollen pollen) { this.pollenCloud.addPollen(pollen); }

    // Searchable Interface methods
    public boolean searchByType(GardenObject gardenObject) {
        return gardenObject.getClass() == this.getClass();
    }
    public boolean searchByID(String ID) {
        return this.getID().equalsIgnoreCase(ID);
    }
    public boolean searchByName( String name) {
        return this.name.equalsIgnoreCase(name);
    }
    public boolean searchByAreaOfReach(int areaOfReach) {
        return this.areaOfPollenSpread == areaOfReach;
    }

    public boolean searchByColor(Color color) {
        System.out.println("You can not search plant by color");
        return false;
    }

    public abstract void pseudoBloom(Garden garden);
    public abstract void bloom(Garden garden);

    @Override
    public void displayInfo() {
        System.out.print("- Type: " + this.getClass().getSimpleName());
        System.out.print(", Id: " + this.getID());
        System.out.print(", Name: " + this.name);
        System.out.print(", Area of reach: " + this.areaOfPollenSpread);
    }

}
