package solid;

/**
 * @author Jeanette og Marta
 */

class WordPair
{
  private String question;
  private String guess;
  private int value;
  
  public WordPair(String question, String guess)
  {
      this.question = question;
      this.guess = guess;
      value = 0;
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

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString()
    {
        return "" + question + "," + guess + "" + value;
    }
}
