package GardenerAppDemo;

import FileIO.FileIO;
import GardenApp.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 1 for Test Case or 2 for Random Case: ");
        int choice = sc.nextInt();
        while (choice != 1 && choice != 2) {
            System.out.print("Invalid choice. Enter 1 for Test Case or 2 for Random Case: ");
            choice = sc.nextInt();
        }
        if (choice == 1) {
            testCase();
        } 
        else {
            randomCase();
        }
    }

    private static void testCase() {
        List<GardenObject> selectedObjects = new ArrayList<>();
        FileIO fileIO = new FileIO();
        StorageShed storageShed = new StorageShed(fileIO.readGardenObjectsToArrayList());
        GardenerApp gardenerApp = new GardenerApp( storageShed );
        GardenSquare goal = new GardenSquare();
        
        goal = goal.generateTestCaseGoal();

        selectedObjects = gardenerApp.handleGardenObjectSelection();

        System.out.println("******************************************************************\n");
        
        Garden garden = new Garden();
        garden.initializeTestCaseGarden();
        
        garden.Initialdisplay(goal);
        gardenerApp.placeObjectsInGarden(selectedObjects, garden, goal);

        gardenerApp.gardenerWait(garden, selectedObjects);

        System.out.println("******************************************************************\n");

        garden.display(selectedObjects);
        garden.checkGoal(goal);
    } 

    private static void randomCase() {
        List<GardenObject> selectedObjects = new ArrayList<>();
        FileIO fileIO = new FileIO();
        StorageShed storageShed = new StorageShed(fileIO.readGardenObjectsToArrayList());
        GardenerApp gardenerApp = new GardenerApp( storageShed );
        GardenSquare goal = new GardenSquare();
        
        goal = goal.generateRandomGoal();

        selectedObjects = gardenerApp.handleGardenObjectSelection();

        System.out.println("******************************************************************\n");
        
        Garden garden = new Garden();
        garden.initializeRandomGarden(goal);
        garden.Initialdisplay(goal);

        gardenerApp.placeObjectsInGarden(selectedObjects, garden, goal);
        gardenerApp.gardenerWait(garden, selectedObjects);

        System.out.println("******************************************************************\n");

        garden.display(selectedObjects);
        garden.checkGoal(goal);
    }
}
