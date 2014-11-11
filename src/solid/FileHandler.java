package solid;

import java.io.File;
import java.io.FileNotFoundException;
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
            String danishWord = sc.next();
            String englishWord = sc.next();
            
            
             Word w = new Word(danishWord, englishWord);
            System.out.println(w);
            WordArray.add(w);  //Reading in a single line and saving in the ArrayList
        }

        file_scanner.close();  //Closing the file
        return WordArray;
    }
}
