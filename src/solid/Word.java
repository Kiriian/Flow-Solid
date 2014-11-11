package solid;

/**
 * @author Jeanette og Marta
 */

class Word
{
  String danishWord;
  String englishWord;
  
  public Word(String danishWord, String englishWord)
  {
      this.danishWord = danishWord;
      this.englishWord = englishWord;
  }

    @Override
    public String toString()
    {
        return "" + danishWord + "," + englishWord + "";
    }
  
}
