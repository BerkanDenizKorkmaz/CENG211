package Equipment;

import java.util.ArrayList;
import java.util.List;

public class EquipmentBag<T extends Equipment>{
    private List<Equipment> equipmentBag;
    
    public EquipmentBag() {
        this.equipmentBag = new ArrayList<Equipment>();
    }
    
    public void display() {
        for (Equipment equipment : equipmentBag) {
           // complete here
        }
    }

    public void addEquipment(Equipment equipment) {
        equipmentBag.add(equipment);
    }
    
    public Equipment getEquipment(String equipmentSymbol) {
        int index = 0;
        for (Equipment equipment : equipmentBag) {
            if (equipment.getEquipmentSymbol() == equipmentSymbol ) {
                break;
            }
            else {
                index +=1;
            }
        }
        return equipmentBag.get(index);
    }
}
