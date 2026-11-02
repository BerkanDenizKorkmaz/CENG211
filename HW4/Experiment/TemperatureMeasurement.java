package Experiment;

import Equipment.ResearchEquipment.ResearchEquipment;


public class TemperatureMeasurement extends Experiment {
    
    public TemperatureMeasurement(ResearchEquipment researchRequirement) {
        super(researchRequirement);
    }

    public void temperatureMeasurement() {
    }

    public void displayExperimentResults() {
    }

    @Override
    public String toString() {
        return "Temperature Measurement";
    }
}
