/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import File.FileHandler;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Marta og Jeanette
 */
public class ControlEngine implements WordPairControlInterface
{

    private ArrayList<WordPair> wordArray = new ArrayList<WordPair>();
    private ArrayList<WordPair> wordArray2 = new ArrayList<WordPair>();
    private ArrayList<WordPair> wordArray3 = new ArrayList<WordPair>();
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

    public String getRandomQuestion() throws GameOverException
    {
        try
        {
            if (wordArray2.size() > 0 || wordArray3.size() > 0)
            {
                tal = random.nextInt(20);

                if (tal <= 12)
                {
                    randomNumber = random.nextInt(wordArray.size());
                    question = wordArray.get(randomNumber);
                    return question.getQuestion();
                } else if (tal >= 12 && tal <= 18)
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
            } else
            {
                randomNumber = random.nextInt(wordArray.size());
                question = wordArray.get(randomNumber);
                return question.getQuestion();
            }
        } catch (IllegalArgumentException ex)
        {
            System.out.print("no more words in wordarray" + "\n");
            throw new GameOverException();
        }   
    }

    public boolean checkGuess(String question, String guess)
    {
        WordPair temp = null;
        for (WordPair wpObject : wordArray)
        {
            if (wpObject.getQuestion().equalsIgnoreCase(question))
            {
                temp = wpObject;
            }
        }
        for (WordPair wpObject : wordArray2)
        {
            if (wpObject.getQuestion().equalsIgnoreCase(question))
            {
                temp = wpObject;
            }
        }
        for (WordPair wpObject : wordArray3)
        {
            if (wpObject.getQuestion().equalsIgnoreCase(question))
            {
                temp = wpObject;
            }
        }

        if (temp == null)
        {
            return false;
        }

        if (temp.getGuess().equalsIgnoreCase(guess))
        {
            temp.setValue(temp.getValue() + 1);
            System.out.println(temp.getValue());

            if (temp.getValue() == 4)
            {
                wordArray2.add(temp);
                wordArray.remove(temp);

            }
            if (temp.getValue() == 7)
            {
                wordArray3.add(temp);
                wordArray2.remove(temp);
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
