/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solid;

import java.util.ArrayList;

/**
 *
 * @author martamiszczyk
 */
public class Engine
{
    ArrayList<Word> WordList ;
    
    public Engine()
    {
        WordList = FileHandler.load("WordList.txt");
    }
    public void makeNewPerson( String danishWord, String englishWord )
    {
        Word w = new Word(danishWord, englishWord);
        WordList.add(w);
        FileHandler.save(WordList, "WordList.txt");
    }
}
