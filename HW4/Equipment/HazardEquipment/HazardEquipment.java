package Equipment.HazardEquipment;
import Equipment.Equipment;

abstract class HazardEquipment implements Equipment {
    
    private String equipmentSymbol;

    public HazardEquipment(String equipmentSymbol) {
        this.equipmentSymbol = equipmentSymbol;
    }

    public String getEquipmentSymbol() {
        return equipmentSymbol;
    }
}