package Equipment.ResearchEquipment;
import FrozenLake.FrozenLake;
import FrozenLake.Position;
import java.util.Random;

public class TemperatureDetector extends ResearchEquipment {
    
    private int temperature;

    public TemperatureDetector() {
        super("td");
        Random rnd = new Random();
        this.temperature = rnd.nextInt(-30,1);
    }

    public boolean validatePosition(FrozenLake frozenLake, Position position) {
        // Add validation logic specific to TemperatureDetector
        return true;
    }

    public void simulate() {
    }

    public int getTemperature() {
        return temperature;
    }
}