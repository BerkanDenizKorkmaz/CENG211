package GardenApp;

public enum Pollen {
    FLOWER('f'), TREE('t'), BUSH('u');
    private char  legend;
    Pollen(char legend) { this.legend = legend; }

    public char getLegend() { return legend; }
}
