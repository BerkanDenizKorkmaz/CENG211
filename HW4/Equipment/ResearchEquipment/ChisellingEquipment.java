package Equipment.ResearchEquipment;
import FrozenLake.FrozenLake;
import FrozenLake.Position;
import java.util.Random;

public class ChisellingEquipment extends ResearchEquipment{

    private int sampleWeight;

    public ChisellingEquipment() {
        super("ch");
        Random rnd = new Random();
        this.sampleWeight = rnd.nextInt(1,21);
    }   

    public boolean validatePosition(FrozenLake frozenLake, Position position) {
        // Add validation logic specific to ChisellingEquipment
        return true;
    }

    public void simulate() {
    }

    public int getSampleWeight() {
        return sampleWeight;
    }
}
