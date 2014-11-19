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

    private ArrayList<WordPair> wordArray = new ArrayList <WordPair> ();
    private ArrayList<WordPair> wordArray2 = new ArrayList <WordPair> ();
    private ArrayList<WordPair> wordArray3 = new ArrayList <WordPair> ();
    private Random random = new Random();
    private int randomNumber;
    private WordPair question;
    private int tal;

    public void add(String question, String guess)
    {
        WordPair w = new WordPair(question, guess);
        wordArray.add(w);
        save("WordList.txt");
    }

    public int size()
    {
        int size = wordArray.size();
        return size;
    }

    public String getRandomQuestion()
    {
        if (wordArray2.size() < 0 || wordArray3.size() < 0 )
        {
            tal = random.nextInt(20);

            if (tal < 14)
            {
                randomNumber = random.nextInt(wordArray.size());
                question = wordArray.get(randomNumber);
                return question.getQuestion();
            } else if (tal > 14 && tal < 18)
            {
                randomNumber = random.nextInt(wordArray2.size());
                question = wordArray2.get(randomNumber);
                return question.getQuestion();
            } else
            {
                randomNumber = random.nextInt(wordArray3.size());
                question = wordArray3.get(randomNumber);
                return question.getQuestion();
            }
        }
        else
        {
            randomNumber = random.nextInt(wordArray.size());
            question = wordArray.get(randomNumber);
            return question.getQuestion();
        }
    }

    public boolean checkGuess(String question, String guess)
    {
        WordPair temp = null;
        for (WordPair wpObject : wordArray)
        {
            if( wpObject.getQuestion().equalsIgnoreCase(question))
                temp = wpObject;
        }
        for (WordPair wpObject : wordArray2)
        {
            if( wpObject.getQuestion().equalsIgnoreCase(question))
                temp = wpObject;
        }
        for (WordPair wpObject : wordArray3)
        {
            if( wpObject.getQuestion().equalsIgnoreCase(question))
                temp = wpObject;
        }
        
        if( temp == null ) {
            return false;
        }
        if (   temp.getGuess().equalsIgnoreCase(guess))
        {
            temp.setValue(temp.getValue() + 1);
            System.out.println(temp.getValue());

            if (temp.getValue() == 4)
            {
                WordPair w = new WordPair(question, guess);
                wordArray2.add(w);
                wordArray.remove(w);

            }
            if (temp.getValue() == 7)
            {
                WordPair w = new WordPair(temp.getQuestion(), temp.getGuess());
                wordArray3.add(w);
                wordArray2.remove(w);
            }
            return true;
        } else
        {
            temp.setValue(temp.getValue() - 1);
            System.out.println(temp.getValue());
            return false;
        }
    }

    public String lookup(String question)
    {
        System.out.println(question);
        for (WordPair i : wordArray)
        {
            if (question.equals(i.getQuestion()))
            {
                return i.getGuess();
            } else if (question.equals(i.getGuess()))
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
        } else
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
        } else
        {
            return true;
        }
    }

    public void clear()
    {
        wordArray.removeAll(wordArray);
    }
}
