package GardenApp;

public interface Searchable {
    public boolean searchByType(GardenObject gardObject);
    public boolean searchByID(String ID);
    public boolean searchByName(String name);
    public boolean searchByColor(Color color);
    public boolean searchByAreaOfReach(int areaOfReach);
}
