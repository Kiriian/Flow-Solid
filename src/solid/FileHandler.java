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
    public static ArrayList<Word> load(String WordList) 
    {
        Scanner file_scanner = null;
        ArrayList<Word> WordArray = new ArrayList<Word>();

        try
        {
            file_scanner = new Scanner(new File(WordList));  //Connection to the file using the Scanner object
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
            
            
             Word w = new Word(question, guess);
            System.out.println(w);
            WordArray.add(w);  //Reading in a single line and saving in the ArrayList
        }

        file_scanner.close();  //Closing the file
        return WordArray;
    }
    
    public static boolean save(ArrayList<Word> WordArray, String WordList) 
    {
        if (WordArray == null)
        {
            return false;
        }  //Checking parameter for null.
        FileWriter output;  //Creating reference for filewriter.

        try 
        {
            output = new FileWriter(new File(WordList));  //Opening connection to file.
            for (Word word : WordArray) 
            {   //running through the ArrayList.                    
                output.write(word.toString() + "\n");  //Each String object is written as a line in file.
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
