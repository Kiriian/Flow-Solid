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
        
        WordPair w = new WordPair (question, guess);
        wordArray.add(w);
        System.out.println("word pair has been saved");
        save("WordList.txt");
    }

    public int size()
    {
        int size = wordArray.size();
        return size;
    }

    public String getRandomQuestion()
    {
        
        randomNumber = random.nextInt(wordArray.size()); 
        question = wordArray.get(randomNumber);
        return question.getQuestion();
    }

    public boolean checkGuess(String question, String guess)
    {
       if (this.question.getGuess().equalsIgnoreCase(guess))
       {
           return true;
       }
       else
       {
           return false;
       }
    }

    public String lookup(String question)
    {
        for (WordPair i : wordArray)
        {
           if (question.equals(i.getQuestion()))
           {
               return i.getGuess();
           }
           else 
               if (question.equals(i.getGuess()))
           {
               return i.getQuestion();
           }
        }
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
       wordArray.removeAll(wordArray);
       
    }
}
