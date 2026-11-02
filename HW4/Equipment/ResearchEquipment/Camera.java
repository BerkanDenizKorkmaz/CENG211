package Equipment.ResearchEquipment;

import FrozenLake.FrozenLake;
import FrozenLake.Position;

public class Camera extends ResearchEquipment{

    private boolean isStartedWorking;

    public Camera() {
        super("cm");
        this.isStartedWorking = false;
    }

    public boolean validatePosition(FrozenLake frozenLake, Position position) {
        // Add validation logic specific to Camera
        return true;
    }

    public void simulate() {
    }

    public boolean isWorking() {
        return isStartedWorking;
    }
}
