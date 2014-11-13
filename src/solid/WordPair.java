package solid;

/**
 * @author Jeanette og Marta
 */

class WordPair
{
  private String question;
  private String guess;
  
  public WordPair(String question, String guess)
  {
      this.question = question;
      this.guess = guess;
  }

    public String getQuestion()
    {
        return question;
    }

    public void setQuestion(String question)
    {
        this.question = question;
    }

    public String getGuess()
    {
        return guess;
    }

    public void setGuess(String guess)
    {
        this.guess = guess;
    }

    @Override
    public String toString()
    {
        return "" + question + "," + guess + "";
    }
}
