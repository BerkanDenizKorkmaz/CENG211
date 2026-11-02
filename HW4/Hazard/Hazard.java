package Hazard;

public abstract class Hazard {
    
    private String hazardSymbol;

    public Hazard(String hazardSymbol) {
        this.hazardSymbol = hazardSymbol;
    }

    public String getHazardSymbol() {
        return hazardSymbol;
    }

    public String toString() {
        return hazardSymbol;
    }
}
