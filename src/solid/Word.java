package solid;

/**
 * @author Jeanette og Marta
 */

class Word
{
  String question;
  String guess;
  
  public Word(String danishWord, String englishWord)
  {
      this.question = danishWord;
      this.guess = englishWord;
  }

    @Override
    public String toString()
    {
        return "" + question + "," + guess + "";
    }
  
}
