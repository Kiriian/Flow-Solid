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
    private ArrayList<WordPair> wordArray;
    Random random = new Random();
    private int randomNumber;
    private WordPair question;
    

    public void add(String question, String guess)
    {
        load("WordList.txt");
        
        WordPair w = new WordPair (question, guess);
        wordArray.add(w);
        save("WordList.txt");
    }

    public int size()
    {
        return 0;
    }

    public String getRandomQuestion()
    {
        load("WordList.txt");
        randomNumber = random.nextInt(wordArray.size()); 
        question = wordArray.get(randomNumber);
        return question.getQuestion();
    }

    public boolean checkGuess(String question, String guess)
    {
       if (this.question.getGuess().equals(guess))
       {
           System.out.println("correct");
           return true;
       }
       else
       {
           System.out.println("Wrong");
           return false;
       }
    }

    public String lookup(String question)
    {
        return null;
    }

    public boolean load(String filename)
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
        FileHandler.save(wordArray, "WordList.txt");
        
        if (wordArray == null)
        {
            return false; 
        } 
        else
        {
            return true;
        }
    }

    public void clear()
    {
        
    }
}
