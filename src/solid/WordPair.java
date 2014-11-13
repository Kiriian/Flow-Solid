package solid;
import java.util.Collections;

/**
 * @author Jeanette og Marta
 */

class WordPair
{
  String question;
  String guess;
  
  public WordPair(String question, String guess)
  {
      this.question = question;
      this.guess = guess;
  }

    @Override
    public String toString()
    {
        return "" + question + "," + guess + "";
    }
}
