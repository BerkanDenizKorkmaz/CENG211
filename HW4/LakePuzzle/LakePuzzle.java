package LakePuzzle;

import Equipment.Equipment;
import Experiment.Experiment;
import Researcher.Researcher;
import Equipment.EquipmentStorage;
import Equipment.ResearchEquipment.Camera;
import Equipment.ResearchEquipment.ChisellingEquipment;
import Equipment.ResearchEquipment.TemperatureDetector;
import Equipment.ResearchEquipment.WindSpeedDetector;
import Experiment.CameraPlacement;
import Experiment.GlacialSampling;
import Experiment.TemperatureMeasurement;
import Experiment.WindSpeedMeasurement;
import FrozenLake.FrozenLake;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

public class LakePuzzle {

    private Queue<Researcher> researcherQueue;
    private Set<Experiment> goalExperiments;
    private EquipmentStorage equipmentStorage;
    private FrozenLake frozenLake;

    class MenuOperations {
        public void StartText(int numberOfResearchers, int numberOfExperiments, Set<Experiment> goalExperiments) {
            System.out.printf("Welcome to Frozen Lake Puzzle App. There are %d researchers waiting at the lake entrance.\n\n", numberOfResearchers);
            System.out.printf("There are %d experiment(s) that must be completed:\n", numberOfExperiments);
            for (Experiment experiment : goalExperiments) {
                System.out.println("- " + experiment.toString());
            }
        }
        public String getEquipmentChoice() {}
        public String getDirectionInput() {}
        public int getActionChoice() {}
        public String getEquipmentInput() {}
        public void printResearcherStopped() {}
        public void printSuccessfull() {}
        public void printResearcherInjuered() {}
        public void printExperimentGoalNotMet() {}
    }

    public static void main(String[] args) {
        EquipmentStorage equipmentStorage = new EquipmentStorage();
        FrozenLake frozenLake = new FrozenLake();
        Queue<Researcher> researcherQueue = new LinkedList<Researcher>();
        
        // Crating the researchers and updating the researcher queue

        Random rnd = new Random();
        int numberOfResearchers = rnd.nextInt(2,5 );
        for (int i = 0; i < numberOfResearchers; i++) {
            Researcher researcher = new Researcher(i);
            researcherQueue.add(researcher);
        }

        // Handling selecting goal experiments

        Set<Experiment> goalExperiments = new HashSet<Experiment>();
        int numberOfExperiments = rnd.nextInt(numberOfResearchers-1,numberOfResearchers+1);
        // List of all possible experiment types
        List<Experiment> allExperiments = Arrays.asList(
            new CameraPlacement(new Camera()),
            new GlacialSampling(new ChisellingEquipment()),
            new TemperatureMeasurement(new TemperatureDetector()),
            new WindSpeedMeasurement(new WindSpeedDetector())
        );
        // If the number of experiments is 4, directly add all types
        if (numberOfExperiments == 4) {
            goalExperiments.addAll(allExperiments);
        } else {
            // Shuffle the list to randomize experiment selection
            Collections.shuffle(allExperiments, rnd);
            // Add a random subset of experiments to the set
            for (int i = 0; i < numberOfExperiments; i++) {
                goalExperiments.add(allExperiments.get(i));
            }
        }

        LakePuzzle.MenuOperations menu = new LakePuzzle().new MenuOperations();
        menu.StartText(numberOfResearchers, numberOfExperiments, goalExperiments);

        // Place researcher 1 to the lake



    }
    
}
