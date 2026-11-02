package FrozenLake;

import Equipment.Equipment;
import Hazard.Hazard;
import Researcher.Researcher;

public class LakeSquare {
    private Researcher containedResearcher;
    private Equipment containedEquipment;
    private Hazard containedHazard;
    private boolean isCliffEdge;

    private Position position;

    public LakeSquare(Position position) {
        this.position = position;
        this.containedResearcher = null;
        this.containedEquipment = null;
        this.containedHazard = null;
        this.isCliffEdge = false;
    }

    public void display() {
    }

    public boolean isOcupiedByHazard() { return containedHazard != null; }
    public boolean isOcupiedByResearcher() { return containedResearcher != null; }
    public boolean isOcupiedByEquipment() { return containedEquipment != null; }
    public boolean isCliffEdge() { return isCliffEdge; }

    public void setItem(Object object) throws IllegalObjectException {
        try {
            if (object instanceof Hazard) {
                Hazard hazard = (Hazard) object;
                this.containedHazard = hazard;
            }
            else if (object instanceof Equipment) {
                Equipment equipment = (Equipment) object;
                this.containedEquipment = equipment;
            }
            else if (object instanceof Researcher){
                Researcher researcher = (Researcher) object;
                this.containedResearcher = researcher;
            }
            else {
                throw new IllegalObjectException("You can not set any other class rather tahn researcher, hazard or equipment.");
            }
        }
        catch(IllegalObjectException e) {
            System.out.println(e.getMessage());
        }
    }
    public void setCliffEdge(boolean isCliffEdge) { this.isCliffEdge = isCliffEdge; }
    public void setPosition(Position position) { this.position = position; }

    public Position getPosition() { return position; }

    @Override
    public String toString() {
        String output = " ";
        if (containedResearcher != null) {
            output += containedResearcher.toString()+"  ";
        }
        else if (containedEquipment != null) {
            output += containedEquipment.toString()+"  ";
        }
        else if (containedHazard != null) {
            output += containedHazard.toString()+"  ";
        }
        else {
            output = "     ";
        }
        return output;
    }
}
