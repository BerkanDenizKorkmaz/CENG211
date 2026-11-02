package GardenApp;

import java.util.List;

public class StorageShed {

    private List<GardenObject> gardenObjects_aList;

    public StorageShed(List<GardenObject> gardenObjects_aList) {
        this.gardenObjects_aList = gardenObjects_aList;
    }

    // Getters and Mutators
    public List<GardenObject> getGardenObjects() { return gardenObjects_aList; }

    public void addGardenObject( GardenObject gardenObject ) { this.gardenObjects_aList.add(gardenObject); }
    public GardenObject removeGardenObject( String ID ) {                                                  
        GardenObject gardenObject = null;
        for ( int i = 0; i < this.gardenObjects_aList.size(); i++ ) {
            if ( gardenObjects_aList.get(i).getID().equalsIgnoreCase(ID)) {
                gardenObject = this.gardenObjects_aList.remove(i);
            }
        }
        return gardenObject;
    }




}
