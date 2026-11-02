package FileIO;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileIO {
    public FileIO()
    {
        
    }
    
    public void writeToFile(String filename, String content)
    {
        
    try
    {
        FileOutputStream output_file = new FileOutputStream(filename);

        byte[] array = content.getBytes();
        output_file.write(array);
        output_file.close();

    } 
    
    catch (IOException ex)
    {
        System.out.println(ex.getMessage());
        System.exit(0);
    }

    }
}
