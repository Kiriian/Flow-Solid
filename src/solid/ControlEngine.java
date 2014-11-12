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
public class ControlEngine implements WordPairControlInterface
{
    public void add(String question, String answer)
    {
    }
    
    public int size()
    {
        return 0;
    }
    
    public String getRandomQuestion()
    {
        return null;
    }
    
    public boolean checkGuess(String question, String quess)
    {
        return false;
    }
    
    public String lookup(String question)
    {
        return null;
    }
    
    public boolean load(String filename)
    {
        return false;
    }
    
    public boolean save(String filename)
    {
        return false;
    }
    
    public void clear()
    {
        
    }
}
