/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solid;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Marta og Jeanette
 */
public class ControlEngine implements WordPairControlInterface
{
    ArrayList<WordPair> wordArray;
    Random random = new Random();

    public void add(String question, String answer)
    {
    }

    public int size()
    {
        return 0;
    }

    public String getRandomQuestion()
    {
        load("WordList.txt");
        
        WordPair question = wordArray.get(random.nextInt(3));
        System.out.println(random);
        return question.getQuestion();
    }

    public boolean checkGuess(String question, String quess)
    {
        return false;
    }

    public String lookup(String question)
    {
        return null;
    }

    public boolean load(String WordList)
    {
        wordArray = FileHandler.load("WordList.txt");

        if (wordArray == null)
        {
            System.out.println("der er intet i arraylisten");
            return false; 
        } 
        else
        {
            return true;
        }
    }

    public boolean save(String filename)
    {
        return false;
    }

    public void clear()
    {

    }
}
