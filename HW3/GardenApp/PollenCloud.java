package GardenApp;

import static GardenApp.Pollen.TREE;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PollenCloud implements Occupant { 

    private List<Pollen> pollens;
    private List<Color> colors;

    // No arg constructor
    public PollenCloud() {
        this.pollens = new ArrayList<Pollen>();
        this.colors = new ArrayList<Color>();
    }

    public PollenCloud(List<Pollen> pollens, List<Color> colors) {
        this.pollens = pollens;
        this.colors = colors;
    }

    // Getters and Setters and Mutators
    public List<Pollen> getPollens() { return pollens; }
    public List<Color> getColors() { return colors; }

    public void setPollens(List<Pollen> pollens) { this.pollens = pollens; }
    public void setColors(List<Color> colors) { this.colors = colors; }
    public void setRandomPollenCloud() {
        Random rnd = new Random();
        int num = rnd.nextInt(0,7);
        switch ( num ) {
            case 0:
                this.pollens.add(Pollen.FLOWER);
                break;
            case 1:
                this.pollens.add(Pollen.TREE);
                break;
            case 2:
                this.pollens.add(Pollen.BUSH);
                break;
            case 3:
                this.pollens.add(Pollen.FLOWER); 
                this.pollens.add(Pollen.TREE); 
                break;
            case 4:
                this.pollens.add(Pollen.FLOWER); 
                this.pollens.add(Pollen.BUSH); 
                break;
            case 5:
                this.pollens.add(Pollen.TREE); 
                this.pollens.add(Pollen.BUSH); 
                break;
            case 6:
                this.pollens.add(Pollen.FLOWER);
                this.pollens.add(Pollen.TREE); 
                this.pollens.add(Pollen.BUSH); 
                break;
        }
        num = rnd.nextInt(0,8);
        switch ( num ) {
            case 0:
                this.colors.add(Color.RED);
                break;
            case 1:
                this.colors.add(Color.BLUE);
                break;
            case 2:
                this.colors.add(Color.BLUE);
                break;
            case 3:
                this.colors.add(Color.RED); 
                this.colors.add(Color.BLUE);
                break;
            case 4:
                this.colors.add(Color.RED); 
                this.colors.add(Color.GREEN); 
                break;
            case 5:
                this.colors.add(Color.BLUE);
                this.colors.add(Color.GREEN); 
                break;
            case 6:
                this.colors.add(Color.RED); 
                this.colors.add(Color.BLUE); 
                this.colors.add(Color.GREEN); 
                break;
            case 7:
                break;
        }
    }
    public void setTestCasePollenCloud() {
        this.pollens.add(Pollen.BUSH);
        this.colors.add(Color.GREEN);
    }

    public void addPollen(Pollen pollen) { 
        if (!this.pollens.contains(pollen)) {
            pollens.add(pollen); 
        }
    }
    public void addColor(Color color) { 
        if (!this.colors.contains(color)) {
            colors.add(color); 
        }
    } 


    @Override
    public String toString() {
        char[] output = new char[6];

        for (int i = 0; i < 6; i++) { output[i] = '.'; } 

        for (Pollen element : pollens) {
            switch (element) {
                case FLOWER:
                    output[0] = element.getLegend();
                    break;
                case TREE:
                    output[1] = element.getLegend();
                    break;
                case BUSH:
                    output[2] = element.getLegend();
                    break;
            } 
        } 
        for (Color element : colors) {
            switch (element) {
                case RED:
                    output[3] = element.getLegend();
                    break;
                case GREEN:
                    output[4] = element.getLegend();
                    break;
                case BLUE:
                    output[5] = element.getLegend();
                    break;
            } 
        }

        String output_str = "";
        for (char element : output) {
            output_str += element;
        }

        return output_str;
    }



}
