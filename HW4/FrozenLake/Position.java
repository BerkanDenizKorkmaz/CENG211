package FrozenLake;

public class Position {

    private int row, column;

    public Position() {
        this(0, 0);
    }

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    // Preconditions needed for the following methods
    public Position getPositionAbove() {
        return new Position(row - 1, column);
    }

    public Position getPositionBelow() {
        return new Position(row + 1, column);
    }

    public Position getPositionLeft() {
        return new Position(row, column - 1);
    }

    public Position getPositionRight() {
        return new Position(row, column + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        else if (o instanceof Position) {
            Position position = (Position) o;
            return this.row == position.getRow() && this.column == position.getColumn();
        }
        else {
            return false;
        }
    }
}
