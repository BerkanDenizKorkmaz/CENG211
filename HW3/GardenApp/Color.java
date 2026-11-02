package GardenApp;

public enum  Color {
    RED('r'), GREEN('g'), BLUE('b');
    private char legend;
    Color(char legend) { this.legend = legend; }

    public char getLegend() { return legend; }
    
}
