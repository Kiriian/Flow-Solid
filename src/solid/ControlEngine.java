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
        WordPair question = wordArray.get(random.nextInt(wordArray.size()));
        return question.getQuestion();
    }

    public boolean checkGuess(String question, String quess)
    {
        load("WordList.txt");
        
        WordPair guess = wordArray;
        
        return guess.getGuess();
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
