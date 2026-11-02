package Experiment;

import Equipment.ResearchEquipment.ResearchEquipment;


public abstract class Experiment {
    
    private ResearchEquipment researchEquipment;

    public Experiment(ResearchEquipment researchEquipment) {
        this.researchEquipment = researchEquipment;
    }

    public abstract void displayExperimentResults();
}
