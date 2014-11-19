package solid;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Jeanette og Marta
 */
public class FileHandler
{
    public static ArrayList<WordPair> load(String filename) 
    {
        Scanner file_scanner = null;
        ArrayList<WordPair> WordArray = new ArrayList<WordPair>();

        try
        {
            file_scanner = new Scanner(new File(filename));  //Connection to the file using the Scanner object
        } 
        
        catch (FileNotFoundException ex)
        {
            System.out.println("Could not find the file to load from! Returning null.");
            ex.printStackTrace();
            return null;  //If something goes wrong the method returns null
        }

        System.out.println("File has been found");

        while (file_scanner.hasNextLine()) 
        {  //File found. Reading one line. 
            String linje = file_scanner.nextLine();
            Scanner sc = new Scanner(linje).useDelimiter(",");
            String question = sc.next();
            String guess = sc.next();
            
            
            WordPair w = new WordPair(question, guess);
            WordArray.add(w);  //Reading in a single line and saving in the ArrayList
        }

        file_scanner.close();  //Closing the file
        return WordArray;
    }
    
    public static boolean save(ArrayList<WordPair> WordArray, String filename) 
    {
        if (WordArray == null)
        {
            return false;
        }  //Checking parameter for null.
        FileWriter output;  //Creating reference for filewriter.

        try 
        {
            output = new FileWriter(new File(filename));  //Opening connection to file.
            for (WordPair word : WordArray) 
            {   //running through the ArrayList.                    
                output.write(word.toString() + "\r\n");  //Each String object is written as a line in file.
            }
            output.close();  //Closing the file
        } 
        
        catch (Exception ex) 
        {  //If something goes wrong everything is send to system out.
            System.out.println("Could not save to file!");
            System.out.println(ex.toString());
            ex.printStackTrace();
            return false;  //If something goes wrong false is returned!
        }
        return true;
    }
}
