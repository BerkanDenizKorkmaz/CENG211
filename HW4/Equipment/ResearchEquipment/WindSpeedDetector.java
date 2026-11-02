package Equipment.ResearchEquipment;

import FrozenLake.FrozenLake;
import FrozenLake.Position;
import java.util.Random;

public class WindSpeedDetector extends ResearchEquipment {
    
    private int windSpeed;
   
    public WindSpeedDetector() {
        super("wd");
        Random rnd = new Random();
        this.windSpeed = rnd.nextInt(0,31);
    }

    public boolean validatePosition(FrozenLake frozenLake, Position position) {
        // Add your specific validation logic
        return true;
    }

    public void simulate() {
    }

    public int getWindSpeed() {
        return windSpeed;
    }
}
