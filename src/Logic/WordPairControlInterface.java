/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

/**
 *
 * @author Jeanette og Marta
 */
public interface WordPairControlInterface
{
    void add(String question, String guess);

    /**
     * Pre: Post: Returns the number of wordpairs in the collection (not the file).
     */
    int size();

    /**
     * Pre: At least one word pair must be present Post: Returns a question
     * randomly selected from the collection of word pairs.
     */
    String getRandomQuestion() throws GameOverException;

    /**
     * Pre: Post: Returns true if (question, quess) exists as a word pair in the
     * collection, otherwise false.
     */
    boolean checkGuess(String question, String guess);

    /**
     * Pre: Post: Returns the answer corresponding to the question if this
     * exists in the collection. Otherwise it returns null.
     */
    String lookup(String question);

    /**
     * Pre: Post: Word pairs are read from the file "filename" and added to the
     * collection of word pairs. Returns true if successfully done. Otherwise it
     * returns false.
     */
    boolean load(String filename);

    /**
     * Pre: Post: All word pairs from the collection has been written to the
     * file "filename" Returns true if successfully done. Otherwise false.
     */
    boolean save(String filename);

    /**
     * Pre: Post: The existing collection of word pairs is cleared
     */
    void clear();
}
