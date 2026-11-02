package FrozenLake;

import Hazard.IceBlock;
import java.util.*;

public class FrozenLake {

    private ArrayList<ArrayList<LakeSquare>> frozenLake = new ArrayList<>();
    private Set<Position> iceBlocks = new HashSet<>();
    private static final int ROWS = 8;
    private static final int COLUMNS = 11;
    private String cliffSide; // Stores which side is the cliff edge ("left", "right", "bottom")

    public FrozenLake() throws IllegalObjectException {
        initializeLake();
    }

    private void initializeLake() throws IllegalObjectException {
        Random rnd = new Random();
        List<String> sides = Arrays.asList("left", "right", "bottom");
        cliffSide = sides.get(new Random().nextInt(sides.size()));

        while (true) {
            // Reset lake and ice blocks
            frozenLake.clear();
            iceBlocks.clear();

            // Initialize the lake grid
            for (int i = 0; i < ROWS; i++) {
                ArrayList<LakeSquare> row = new ArrayList<>();
                for (int j = 0; j < COLUMNS; j++) {
                    Position position = new Position(i, j);
                    LakeSquare square = new LakeSquare(position);

                    // Mark cliff edges
                    if (isCliffEdge(i, j)) {
                        square.setCliffEdge(true);
                    }
                    row.add(square);
                }
                frozenLake.add(row);
            }

            // Place 8 ice blocks, one in each row
            for (int i = 0; i < ROWS; i++) {
                while (true) {
                    int randomColumn = rnd.nextInt(COLUMNS);

                    // Prevent placing an ice block in the middle of the first row
                    if (i == 0 && randomColumn == 5) {
                        continue;
                    }

                    Position iceBlockPosition = new Position(i, randomColumn);

                    // Place the ice block and break out of the loop
                    if (!iceBlocks.contains(iceBlockPosition)) {
                        frozenLake.get(i).get(randomColumn).setItem(new IceBlock());
                        iceBlocks.add(iceBlockPosition);
                        break;
                    }
                }
            }

            // Check for cliff edge conditions
            if (cliffSide.equals("left") || cliffSide.equals("right")) {
                int cliffColumn = cliffSide.equals("left") ? 0 : COLUMNS - 1;
                long cliffEdgeIceBlocks = iceBlocks.stream()
                        .filter(pos -> pos.getColumn() == cliffColumn)
                        .count();
                if (cliffEdgeIceBlocks >= 2) {
                    break; // Condition satisfied
                }
            } else if (cliffSide.equals("bottom")) {
                // For bottom, ensure an additional ice block in the last row
                while (true) {
                    int randomColumn = rnd.nextInt(COLUMNS);
                    Position bottomCliffPosition = new Position(ROWS - 1, randomColumn);
                    if (!iceBlocks.contains(bottomCliffPosition)) {
                        frozenLake.get(ROWS - 1).get(randomColumn).setItem(new IceBlock());
                        iceBlocks.add(bottomCliffPosition);
                        break;
                    }
                }
                break; // Condition satisfied
            }
        }
    }

    // Check if a position is on the cliff edge
    private boolean isCliffEdge(int row, int column) {
        switch (cliffSide) {
            case "left":
                return column == 0;
            case "right":
                return column == COLUMNS - 1;
            case "bottom":
                return row == ROWS - 1;
            default:
                return false;
        }
    }

    // Display the lake in a grid format
    public void display() {
        System.out.println("Frozen Lake Layout:");
        if (cliffSide.equals("left")) {
            System.out.print(" CE  ");
        }
        System.out.println("-------------------------------     -------------------------------");
        for (int i = 0; i < ROWS; i++) {
            if (cliffSide.equals("left")) {
                System.out.print(" CE  ");
            }
            System.out.print("|");
            for (int j = 0; j < COLUMNS; j++) {
                LakeSquare square = frozenLake.get(i).get(j);

                System.out.print(square.toString() + "|");
                if (square.isCliffEdge() && cliffSide.equals("right")) {
                    System.out.print(" CE  ");
                }
            }
            if (cliffSide.equals("left")) {
                System.out.println("\n     -------------------------------------------------------------------");
            } else {
                System.out.println("\n-------------------------------------------------------------------");
            }
        }
        if (cliffSide.equals("bottom")) {
            System.out.println("  CE  ".repeat(COLUMNS));
        }
        // Print the side chosen as the cliff edge
        System.out.println("Cliff edge is on the " + cliffSide + " side of the lake.");
    }

    public static void main(String[] args) throws IllegalObjectException {
        FrozenLake lake = new FrozenLake();
        lake.display();
    }
}
