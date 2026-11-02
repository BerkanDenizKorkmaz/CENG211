package GardenApp;

public class Statue extends GardenObject {

    public Statue(String ID) {
        super(ID);
    }

    @Override
    public void displayInfo() {
        System.out.print("- Type: " + this.getClass().getSimpleName());
        System.out.print(", Id: " + this.getID());
    }
}
