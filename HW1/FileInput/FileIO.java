package FileInput;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileIO
{
    // read customers.csv file into a 2D array of string    
    public String[][] readCustomerTicketsInfoInto2DArray()
    {   
        String path = "src\\customers.csv";
        BufferedReader reader = null;
        String line = "";
        int numberOfRows = countRows(path);

        String[][] customerTicketInfoArray = new String[numberOfRows][2];

        try {

            reader = new BufferedReader(new FileReader(path));   
            reader.readLine(); // skip the first line of the csv file      
            int index = 0; //first index for the 2D array
            
            while ((line = reader.readLine()) != null) {
                
                String[] row = line.split(","); // read a line in csv file and split it by comma
                
                customerTicketInfoArray[index] = row; // add the row to current index and increment the index
                index++; 
            }
            

        } catch (IOException e) {
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
        
        // return the 2D array
        return Arrays.copyOf(customerTicketInfoArray, numberOfRows);
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
           
        
        } catch (IOException e) {
                System.err.println("An error occurred: " + e.getMessage());
                System.exit(1);
        } finally {
            if(reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.err.println("An error occurred: " + e.getMessage());
                    System.exit(1);

                }
            }
        }


        // return the number of rows
        return numberOfRows;
    }   
}  