package Equipment.ResearchEquipment;

import Equipment.Equipment;
import FrozenLake.FrozenLake;
import FrozenLake.Position;

public abstract class ResearchEquipment implements Equipment {
    
    private String equipmentSymbol;

    public ResearchEquipment(String equipmentSymbol) {
        this.equipmentSymbol = equipmentSymbol;
    }

    // Abstract methods
    public abstract boolean validatePosition(FrozenLake frozenLake, Position position);
    public abstract void simulate();

    public String getEquipmentSymbol() {
        return equipmentSymbol;
    }
}
