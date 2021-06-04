package abhamare_hw7EC.sequence;

import static abhamare_hw7EC.sequence.State.ACTIVE;

public class Extractor extends Sequence{

    private String subsequence;

    public Extractor(String word, String subsequence, State state) {
        super(word, state);
        this.subsequence = subsequence;
    }

    public String emitWord()
    {
        if (isActive())
        {
            if (subsequence.isEmpty())
            {
                return "no subsequence is provided";
            }

            int sizeOfSubSequence = subsequence.length();
            int wordSize = getWord().length();

            if (sizeOfSubSequence > wordSize)
            {
                return "the provided subsequence is not found";
            }

            if ((subsequence.compareTo(getWord())) == 0)
            {
                return "the provided subsequence is equals to the encapsulated word";
            }

            int startIndex;
            startIndex = isSubsequence(subsequence, getWord());

            if (startIndex == -1)
            {
                return "the provided subsequence is not a part of word";
            }

            String remainedWord = "";
            if (startIndex == 0)
            {
                for (int i = sizeOfSubSequence; i < wordSize; i++)
                {
                    remainedWord = remainedWord + getWord().charAt(i);
                }
            }
            else
            {
                for (int i = 0; i < startIndex; i++)
                {
                    remainedWord = remainedWord + getWord().charAt(i);
                }

            }
            return remainedWord;
        }
        return getWord();
    }


    Boolean isActive()
    {
        if (getState() == ACTIVE)
        {
            return true;
        }
        return false;
    }


    public int isSubsequence(String subSequence,String word)
    {
        int word1 = subSequence.length();
        int word2 = word.length();

        for (int i = 0; i < word2 - word1; i++)
        {
            int j;
            for (j = 0; j < word1; j++)
            {
                if (word.charAt(i + j) != subSequence.charAt(j))
                    break;

            }
            if (j == word1)
            {
                return i;
            }
        }
        return -1;
    }
}
