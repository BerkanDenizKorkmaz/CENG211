package FileIO;

import GardenApp.Bush;
import GardenApp.Color;
import GardenApp.Flower;
import GardenApp.GardenObject;
import GardenApp.LargeLamp;
import GardenApp.Pollen;
import GardenApp.PollenCloud;
import GardenApp.SmallLamp;
import GardenApp.Spotlight;
import GardenApp.Tree;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileIO {

    public FileIO() {

    }

    // Read the contents of the file and store them in an ArrayList
    public List<GardenObject> readGardenObjectsToArrayList()
    {   
        String path = "..\\GardenPuzzleGame\\src\\storage_contents.csv";
        BufferedReader reader = null;
        String line = "";
        int numberOfRows = countRows(path);

        List<GardenObject> gardenObjectInfo_ArrayList = new ArrayList<GardenObject>();

        try {
            reader = new BufferedReader(new FileReader(path));   
            for (int i = 0; i < numberOfRows; i++ ) {
                line = reader.readLine();
                String[] infoArray = line.split(",");
                
                // Attributes of the GardenObject 
                String type = infoArray[0];
                String ID = infoArray[1];
                String name = infoArray[2];
                int range = Integer.parseInt(infoArray[3]);
                PollenCloud pollenCloud = new PollenCloud();

                // Create the GardenObject based on the type
                GardenObject gardenObject;
                switch (type) {
                    case "flower":
                        pollenCloud.addPollen(Pollen.FLOWER);
                        gardenObject = new Flower(ID, name, range, pollenCloud);
                        gardenObjectInfo_ArrayList.add(gardenObject);
                        break;
                    case "tree":
                        pollenCloud.addPollen(Pollen.TREE);
                        gardenObject = new Tree(ID, name, range, pollenCloud);
                        gardenObjectInfo_ArrayList.add(gardenObject);
                        break;
                    case "bush":
                        pollenCloud.addPollen(Pollen.BUSH);
                        gardenObject = new Bush(ID, name, range, pollenCloud);
                        gardenObjectInfo_ArrayList.add(gardenObject);
                        break;

                    case "small_lamp":
                        Color color = Color.valueOf(name.toUpperCase());
                        gardenObject = new SmallLamp(ID, color, range);
                        gardenObjectInfo_ArrayList.add(gardenObject);
                        break;
                    case "large_lamp":
                        color = Color.valueOf(name.toUpperCase());
                        gardenObject = new LargeLamp(ID, color, range);
                        gardenObjectInfo_ArrayList.add(gardenObject);
                        break;
                    case "spotlight":
                        color = Color.valueOf(name.toUpperCase());
                        gardenObject = new Spotlight(ID, color, range);
                        gardenObjectInfo_ArrayList.add(gardenObject);
                        break;
                }
            }                
        } 
        
        catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }

        finally {
            if(reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.err.println("An error occurred: " + e.getMessage());
                    System.exit(0);
                }
            }
        }
        return gardenObjectInfo_ArrayList;
    }

    
    private static int countRows(String path)
    {
        BufferedReader reader = null;
        int numberOfRows = 0;
        try {
            // count the rows of the file
            reader = new BufferedReader(new FileReader(path));
            while (reader.readLine() != null) {
                numberOfRows++;
            }
        } 
        catch (IOException e) {
                System.err.println("An error occurred: " + e.getMessage());
                System.exit(1);
        }
        finally {
            if(reader != null) {
                try {
                    reader.close();
                } 
                catch (IOException e) {
                    System.err.println("An error occurred: " + e.getMessage());
                    System.exit(1);

                }
            }
        }
        return numberOfRows;
    }   
}
