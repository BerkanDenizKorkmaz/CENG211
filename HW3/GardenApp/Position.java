package GardenApp;

import java.util.Random;
 
public class Position {
    private String row;
    private String column;

    // No arg constructor
    public Position() {}


    // Constructors
    public Position(int row_int, int column_int) {
        String row_s = "A";
        switch (row_int) {
            case 1 -> row_s = "B";
            case 2 -> row_s = "C";
            case 3 -> row_s = "D";
            case 4 -> row_s = "E";
            case 5 -> row_s = "F";
        }
        this.row = row_s;
        
        String column_s = "1";
        switch (column_int) {
            case 1 -> column_s = "2";
            case 2 -> column_s = "3";
            case 3 -> column_s = "4";
            case 4 -> column_s = "5";
            case 5 -> column_s = "6";
            case 6 -> column_s = "7";
            case 7 -> column_s = "8";
        }
        this.column = column_s; 

    }

    public Position(String row, String column) {
        this.row = row;
        this.column = column;
    }

    public Position(char row, char column) {
        this.row = Character.toString(row);
        this.column = Character.toString(column);
    }

    // Getters and Setters
    public String getRow() { return row; }
    public String getColumn() { return column; }
    public int getRowByIndex() {
        int index = -1;
        switch (this.row.toUpperCase()) {
            case "A" -> index = 0;
            case "B" -> index = 1;
            case "C" -> index = 2;
            case "D" -> index = 3;
            case "E" -> index = 4;
            case "F" -> index = 5;
        }
        return index;
    }
    public int getColumnByIndex() {
        int index = -1;
        switch (this.column) { 
            case "1" -> index = 0;
            case "2" -> index = 1;
            case "3" -> index = 2;
            case "4" -> index = 3;
            case "5" -> index = 4;
            case "6" -> index = 5;
            case "7" -> index = 6;
            case "8" -> index = 7;
        }
        return index;
    }

    public void setRow(String row) { this.row = row; }
    public void setColumn(String column) { this.column = column; }
    public void setRandomPosition() { 
        Random rnd = new Random();
        Position randomPosition = new Position( rnd.nextInt(0, 6) , rnd.nextInt(0, 8) );
        this.row = randomPosition.getRow();
        this.column = randomPosition.getColumn();
    }
    public void setTestCaseGoalPosition() {
        this.row = "C";
        this.column = "5";
    }

    public boolean equals( Position other_position ) {
        if (other_position != null) {
            if ( this.row == other_position.getRow() && this.column == other_position.getColumn() ) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return row + column;
    }
}
