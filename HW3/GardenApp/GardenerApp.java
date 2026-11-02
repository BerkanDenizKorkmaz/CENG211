package GardenApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// GardenerApp class is responsible for handling the gardener's actions in the game
public class GardenerApp {

    private StorageShed storageShed;

    public GardenerApp(StorageShed storageShed) {
        this.storageShed = storageShed;
    }

    public List<GardenObject> handleGardenObjectSelection() {
        Scanner sc = new Scanner(System.in);
        List<GardenObject> selectedObjects = new ArrayList<>();

        while (selectedObjects.size() < 7) {
            System.out.println("==> Please search for Garden Objects from the Storage Shed. You can take up to " +
                    (7 - selectedObjects.size()) + " object(s).\n");
            System.out.print("Please select the type of object ([1] Plant, [2] Light): ");
            int objectType = sc.nextInt();
            System.out.println();

            while (objectType != 1 && objectType != 2) {
                System.out.println("Invalid selection. Please try again.\n");
                System.out.print("Please select the type of object ([1] Plant, [2] Light): ");
                objectType = sc.nextInt();
                System.out.println();
            }

            if (objectType == 1) {
                handleGardenPlantSelection(sc, selectedObjects);
            } 
            else if (objectType == 2) {
                handleLightSourceSelection(sc, selectedObjects);
            } 

            System.out.print("You have taken " + selectedObjects.size() + " Garden Object(s). Would you like to select another one? ([1] Yes, [2] No): ");
            int continueSelection = sc.nextInt();
            System.out.println();

            while (continueSelection != 1 && continueSelection != 2) {
                System.out.println("Invalid selection. Please try again.\n");
                continueSelection = sc.nextInt();
                System.out.println();
            }

            if (continueSelection == 2) {
                break;
            }
        }
        System.out.println("==> The gardener carries selected objects to the Garden.\n");
        return selectedObjects;
    }

    private void handleGardenPlantSelection(Scanner sc, List<GardenObject> selectedObjects) {
        List<GardenPlant> results = new ArrayList<>();
        
        System.out.print("Please select search filter for Plants ([1] Plant type, [2] Plant name, [3] id, [4] Area of Spread): ");
        int filterType = sc.nextInt();
        System.out.println();

        while (filterType != 1 && filterType != 2 && filterType != 3 && filterType != 4) {
            System.out.println("Invalid selection. Please try again.\n");
            System.out.print("Please select search filter for Plants ([1] Plant type, [2] Plant name, [3] Plant id, [4] Area of Spread): ");
            filterType = sc.nextInt();
            System.out.println();
        }

        // Search for plants based on the selected filter
        switch (filterType) {
            case 1:
                System.out.print("Please enter a plant type ([1] Flower, [2] Tree, [3] Bush): ");
                int objectType = sc.nextInt();
                System.out.println();

                while (objectType != 1 && objectType != 2 && objectType != 3) {
                    System.out.println("Invalid selection. Please try again.\n");
                    System.out.print("Please enter a plant type ([1] Flower, [2] Tree, [3] Bush): ");
                    objectType = sc.nextInt();
                    System.out.println();
                }
                switch (objectType) {
                    case 1:
                        for (GardenObject gardenObject : storageShed.getGardenObjects()) {
                            if (gardenObject instanceof GardenPlant) {
                                GardenPlant gardenPlant = (GardenPlant) gardenObject;
                                if (gardenPlant.searchByType(new Flower(null, null, 0, null))) {
                                    results.add(gardenPlant);
                                }
                            }
                        }
                        break;
                    case 2:
                        for (GardenObject gardenObject : storageShed.getGardenObjects()) {
                            if ( gardenObject instanceof GardenPlant) {
                                GardenPlant gardenPlant = (GardenPlant) gardenObject;
                                if (gardenPlant.searchByType(new Tree(null, null, 0, null))) {
                                    results.add(gardenPlant);
                                }
                            }
                        }
                        break;
                    case 3:
                        for (GardenObject gardenObject : storageShed.getGardenObjects()) {
                            if ( gardenObject instanceof GardenPlant) {
                                GardenPlant gardenPlant = (GardenPlant) gardenObject;
                                if (gardenPlant.searchByType(new Bush(null, null, 0, null))) {
                                    results.add(gardenPlant);
                                }
                            }
                        }
                        break;
                }
                break;

            case 2:
                System.out.print("Please enter a plant name: ");
                String objectName = sc.next().toUpperCase();
                for (GardenObject gardenObject : storageShed.getGardenObjects()) {
                    if ( gardenObject instanceof GardenPlant) {
                        GardenPlant gardenPlant = (GardenPlant) gardenObject;
                        if (gardenPlant.searchByName(objectName)) {
                            results.add(gardenPlant);
                        }
                    }
                }
                break;

            case 3:
                System.out.print("Please enter a plant id in the format of [PX or PXX]: ");
                String objectID = sc.next().toUpperCase();
                for (GardenObject gardenObject : storageShed.getGardenObjects()) {
                    if ( gardenObject instanceof GardenPlant) {
                        GardenPlant gardenPlant = (GardenPlant) gardenObject;
                        if ( gardenPlant.searchByID(objectID) ) {
                            results.add(gardenPlant);
                        }
                    }
                }
                break;
            
            case 4:
                System.out.print("Please enter a area of pollen spread value between 1 and 5: ");
                int objectSpread = sc.nextInt();
                System.out.println();

                while (objectSpread != 1 && objectSpread != 2 && objectSpread != 3 && objectSpread != 4 && objectSpread != 5) {
                    System.out.println("Invalid selection. Please try again.\n");
                    System.out.print("Please enter a area of pollen spread value between 1 and 5: ");
                    objectSpread = sc.nextInt();
                    System.out.println();
                }
                for (GardenObject gardenObject : storageShed.getGardenObjects()) {
                    if ( gardenObject instanceof GardenPlant) {
                        GardenPlant gardenPlant = (GardenPlant) gardenObject;
                        if ( gardenPlant.searchByAreaOfReach(objectSpread) ) {
                            results.add(gardenPlant);
                        }
                    }
                }
                break;
        }

        // No result warning
        if (results.isEmpty()) {
            System.out.println("No objects found with the given criteria.\n");
            return;
        }

        // Display the search results and let the gardener select the object to take
        boolean found = false;
        while ( !found ) {
            System.out.println("The Plants that fit the given criteria:");
            for (GardenPlant gardenPlant : results) {
                gardenPlant.displayInfo();
                System.out.println();
            }
            System.out.print("--> Please enter the id of the Garden Plant you would like to take: ");
            String selectedPlantID = sc.next().toUpperCase();
            System.out.println();

            for (GardenPlant selectedPlant : results) {
                if ( selectedPlant.searchByID(selectedPlantID) ) {
                    selectedObjects.add(selectedPlant); 
                    this.storageShed.removeGardenObject(selectedPlantID);
                    found = true;           
                }
            }
            if ( !found ) {
                System.out.println("Invalid selection. Please try again.\n");
            }
        }
    }

    private void handleLightSourceSelection(Scanner sc, List<GardenObject> selectedObjects) {
        List<LightSource> results = new ArrayList<>();
        
        System.out.print("Please select search filter for Light Sources ([1] Light type, [2] Light id, [3] Light Color, [4] Area of reach): ");
        int filterType = sc.nextInt();
        System.out.println();

        // Check if the input is valid
        while (filterType != 1 && filterType != 2 && filterType != 3 && filterType != 4) {
            System.out.println("Invalid selection. Please try again.\n");
            System.out.print("Please select search filter for Light Sources ([1] Light type, [2] Light id, [3] Light Color, [4] Area of reach): ");
            filterType = sc.nextInt();
            System.out.println();
        }

        // Search for light sources based on the selected filter
        switch (filterType) {
            case 1:
                System.out.print("Please enter a light type ([1] Small Lamp, [2] Large Lamp, [3] Spotlight): ");
                int objectType = sc.nextInt();
                System.out.println();

                // Check if the input is valid
                while (objectType != 1 && objectType != 2 && objectType != 3) {
                    System.out.println("Invalid selection. Please try again.\n");
                    System.out.print("Please enter a light type ([1] Small Lamp, [2] Large Lamp, [3] Spotlight): ");
                    objectType = sc.nextInt();
                    System.out.println();
                }

                // Search for light sources based on the selected type
                switch (objectType) {
                    case 1:
                        for (GardenObject gardenObject : storageShed.getGardenObjects()) {
                            if ( gardenObject instanceof LightSource) {
                                LightSource lightSource = (LightSource) gardenObject;
                                if (lightSource.searchByType(new SmallLamp(null, null, 0))) {
                                    results.add(lightSource);
                                }
                            }
                        }
                        break;
                    case 2:
                        for (GardenObject gardenObject : storageShed.getGardenObjects()) {
                            if ( gardenObject instanceof LightSource) {
                                LightSource lightSource = (LightSource) gardenObject;
                                if (lightSource.searchByType(new LargeLamp(null, null, 0))) {
                                    results.add(lightSource);
                                }
                            }
                        }
                        break;
                    case 3:
                        for (GardenObject gardenObject : storageShed.getGardenObjects()) {
                            if ( gardenObject instanceof LightSource) {
                                LightSource lightSource = (LightSource) gardenObject;
                                if (lightSource.searchByType(new Spotlight(null, null, 0))) {
                                    results.add(lightSource);
                                }
                            }
                        }
                        break;
                }
                break;
            
            case 2:
                System.out.print("Please enter a light id in the format of [LX or LXX]: ");
                String objectID = sc.next().toUpperCase();
                System.out.println();

                for (GardenObject gardenObject : storageShed.getGardenObjects()) {
                    if ( gardenObject instanceof LightSource) {
                        LightSource lightSource = (LightSource) gardenObject;
                        if ( lightSource.searchByID(objectID) ) {
                            results.add(lightSource);
                        }
                    }
                }
                break;

            case 3:
                System.out.print("Please enter a light color ([1] Red, [2] Green, [3] Blue): ");
                int objectColor = sc.nextInt();
                System.out.println();

                while (objectColor != 1 && objectColor != 2 && objectColor != 3) {
                    System.out.println("Invalid selection. Please try again.\n");
                    System.out.print("Please enter a light type ([1] Small Lamp, [2] Large Lamp, [3] Spotlight): ");
                    objectColor = sc.nextInt();
                    System.out.println();
                }
                Color color;
                switch (objectColor) {
                    case 1:
                        color = Color.RED;
                        for (GardenObject gardenObject : storageShed.getGardenObjects()) {
                            if ( gardenObject instanceof LightSource) {
                                LightSource lightSource = (LightSource) gardenObject;
                                if ( lightSource.searchByColor(color) ) {
                                    results.add(lightSource);
                                }
                            }
                        }
                        break;
                    case 2:
                        color = Color.GREEN;
                        for (GardenObject gardenObject : storageShed.getGardenObjects()) {
                            if ( gardenObject instanceof LightSource) {
                                LightSource lightSource = (LightSource) gardenObject;
                                if ( lightSource.searchByColor(color) ) {
                                    results.add(lightSource);
                                }
                            }
                        }
                        break;
                    case 3:
                        color = Color.BLUE;
                        for (GardenObject gardenObject : storageShed.getGardenObjects()) {
                            if ( gardenObject instanceof LightSource) {
                                LightSource lightSource = (LightSource) gardenObject;
                                if ( lightSource.searchByColor(color) ) {
                                    results.add(lightSource);
                                }
                            }
                        }
                        break;
                }
                break;
            
            case 4:
                System.out.print("Please enter a light area of reach value between 1 and 5: ");
                int objectReach = sc.nextInt();
                System.out.println();

                while (objectReach != 1 && objectReach != 2 && objectReach != 3 && objectReach != 4 && objectReach != 5) {
                    System.out.println("Invalid selection. Please try again.\n");
                    System.out.print("Please enter a light area of reach value between 1 and 5: ");
                    objectReach = sc.nextInt();
                    System.out.println();
                }
                for (GardenObject gardenObject : storageShed.getGardenObjects()) {
                    if ( gardenObject instanceof LightSource) {
                        LightSource lightSource = (LightSource) gardenObject;
                        if ( lightSource.searchByAreaOfReach(objectReach) ) {
                            results.add(lightSource);
                        }
                    }
                }
                break;
        }

        // No result warning
        if (results.isEmpty()) {
            System.out.println("No objects found with the given criteria.\n");
            return;
        }

        // Display the search results and let the gardener select the object to take
        boolean found = false;
        while ( !found ) {
            System.out.println("The Light Sources that fit the given criteria:");
            for (LightSource lightSource : results) {
                lightSource.displayInfo();
                System.out.println();
            }
            System.out.print("--> Please enter the id of the Light Source you would like to take: ");
            String selectedLightID = sc.next().toUpperCase();
            System.out.println();

            for (LightSource selectedLight : results) {
                if ( selectedLight.searchByID(selectedLightID) ) {
                    selectedObjects.add(selectedLight); 
                    this.storageShed.removeGardenObject(selectedLightID);
                    found = true;           
                }
            }
            if ( !found ) {
                System.out.println("Invalid selection. Please try again.\n");
                System.out.println();
            }
        }
    }

    public void placeObjectsInGarden(List<GardenObject> selectedObjects, Garden garden, GardenSquare goalSquare) {
        Scanner scanner = new Scanner(System.in);
    
        List<GardenObject> selectedObjectsCopy = new ArrayList<>();
        
        // Create a copy of the selected objects to be able to both keep the original list and remove the placed objects
        for (GardenObject gardenObject : selectedObjects) {
            if (gardenObject instanceof GardenPlant) {
                GardenPlant gardenPlant = (GardenPlant) gardenObject;
                if (gardenPlant instanceof Flower) {
                    Flower flower = (Flower) gardenPlant;
                    selectedObjectsCopy.add(new Flower(flower));
                } else if (gardenPlant instanceof Tree) {
                    Tree tree = (Tree) gardenPlant;
                    selectedObjectsCopy.add(new Tree(tree));
                } else if (gardenPlant instanceof Bush) {
                    Bush bush = (Bush) gardenPlant;
                    selectedObjectsCopy.add(new Bush(bush));
                }
            } else if (gardenObject instanceof LightSource) {
                LightSource lightSource = (LightSource) gardenObject;
                if (lightSource instanceof SmallLamp) {
                    SmallLamp smallLamp = (SmallLamp) lightSource;
                    selectedObjectsCopy.add(new SmallLamp(smallLamp));
                } else if (lightSource instanceof LargeLamp) {
                    LargeLamp largeLamp = (LargeLamp) lightSource;
                    selectedObjectsCopy.add(new LargeLamp(largeLamp));
                } else if (lightSource instanceof Spotlight) {
                    Spotlight spotlight = (Spotlight) lightSource;
                    selectedObjectsCopy.add(new Spotlight(spotlight));
                }
            }
        }
    
        // Display the selected objects and let the gardener place them in the garden
        boolean isContinue = true;
        while (isContinue) {
            displaySelectedObjects(selectedObjectsCopy);
    
            System.out.print("Enter the id corresponding to the Garden Object you would like to place: ");
            String selectedID = scanner.next().toUpperCase();
            System.out.println();
    
            boolean isAvailable = false;
            while (!isAvailable) {
                for (GardenObject obj : selectedObjectsCopy) {
                    if (obj.getID().equals(selectedID)) {
                        isAvailable = true;
                        break;
                    }
                }
                if (!isAvailable) {
                    System.out.println("Invalid selection. Please try again.\n");
                    System.out.print("Enter the id corresponding to the Garden Object you would like to place: ");
                    selectedID = scanner.next().toUpperCase();
                    System.out.println();
                }
            }
    
            System.out.print("Enter the location you would like to place the selected Garden Object: ");
            String selectedSquare = scanner.next().toUpperCase();
            System.out.println();
            Position position = new Position(selectedSquare.charAt(0), selectedSquare.charAt(1));
    
            boolean isPlaced = false;
            while (!isPlaced) {
                // Check if the position is within garden boundaries
                if (position.getRowByIndex() < 0 || position.getRowByIndex() > 5 || position.getColumnByIndex() < 0 || position.getColumnByIndex() > 7) {
                    System.out.println("Invalid location! The selected position is outside the garden boundaries. Please choose a valid location within the garden.");
                    System.out.print("Enter the location you would like to place the selected Garden Object: ");
                    selectedSquare = scanner.next().toUpperCase();
                    System.out.println();
                    position = new Position(selectedSquare.charAt(0), selectedSquare.charAt(1));
                } 

                else {
                    GardenSquare targetSquare = garden.getSquareByPosition(position);

                    // Check if the square is occupied before placing the object
                    if (targetSquare.isOccupied()) {
                        System.out.println("This location is already occupied. Please choose another location.\n");
                        System.out.print("Enter the location you would like to place the selected Garden Object: ");
                        selectedSquare = scanner.next().toUpperCase();
                        System.out.println();
                        position = new Position(selectedSquare.charAt(0), selectedSquare.charAt(1));
                    }
                    else {
                        // Place the object if the square is not occupied and within bounds
                        for (GardenObject obj : selectedObjectsCopy) {
                            if (obj.getID().equals(selectedID)) {
                                garden.placeObject(obj, selectedSquare);
                                selectedObjectsCopy.remove(obj);
                                isPlaced = true;
                                break;
                            }
                        }
                    }
                }
            }
    
            if (selectedObjectsCopy.isEmpty()) {
                System.out.println("==> You have run out of objects to place.\n");
                isContinue = false;
            } 
            else {
                System.out.print("Would you like to place another object? ([1] Yes, [2] No): ");
                int continuePlacement = scanner.nextInt();
                while (continuePlacement != 1 && continuePlacement != 2) {
                    System.out.println("Invalid selection. Please try again.\n");
                    System.out.print("Would you like to place another object? ([1] Yes, [2] No): ");
                    continuePlacement = scanner.nextInt();
                    System.out.println();
                }
                if (continuePlacement == 2) {
                    isContinue = false;
                }
            }
        }
    }
    
    private static void displaySelectedObjects(List<GardenObject> selectedObjects) {
        System.out.println("--> Your chosen Garden Objects:");
        for (GardenObject gardenObject : selectedObjects) {
            gardenObject.displayInfo();
            System.out.println();
        }
        System.out.println();
    }
       
    // Gardener waits for the lights to lightUp and plants to bloom
    public void gardenerWait(Garden garden, List<GardenObject> selectedObjects) {
        System.out.println("==> The gardener starts waiting. All lights are lit up. All plants start blooming.\n");

        List<String> gardenPlantIDS = new ArrayList<>();

        // lightUp() all the lights and wait for pollen infusion
        for (GardenObject gardenObject : selectedObjects) {
            if (gardenObject instanceof LightSource) {
                LightSource lightSource = (LightSource) gardenObject;
                lightSource.lightUp(garden);
            }
            else if (gardenObject instanceof GardenPlant) {
                GardenPlant gardenPlant = (GardenPlant) gardenObject;
                gardenPlantIDS.add(gardenPlant.getID());
            }
        }

        // Pseudo Bloom for all plants in the garden
        for (String ID : gardenPlantIDS) {
            for (int row = 0; row < 6; row++) {
                for (int column = 0; column < 8; column++) {
                    GardenSquare gardenSquare = garden.getGardenMap().get(row).get(column);
                    if (gardenSquare.getOccupant() instanceof GardenPlant) {
                        GardenPlant gardenPlant = (GardenPlant) gardenSquare.getOccupant();
                        if (gardenPlant.getID().equals(ID)) {
                            gardenPlant.pseudoBloom(garden);
                        }
                    }
                }
            }
        }
        // Bloom for all plants in the garden
        for (String ID : gardenPlantIDS) {
            for (int row = 0; row < 6; row++) {
                for (int column = 0; column < 8; column++) {
                    GardenSquare gardenSquare = garden.getGardenMap().get(row).get(column);
                    if (gardenSquare.getOccupant() instanceof GardenPlant) {
                        GardenPlant gardenPlant = (GardenPlant) gardenSquare.getOccupant();
                        if (gardenPlant.getID().equals(ID)) {
                            gardenPlant.bloom(garden);
                        }
                    }
                }
            }
        }
    }
}
