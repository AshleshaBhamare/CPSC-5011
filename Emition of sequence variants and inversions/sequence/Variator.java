package abhamare_hw7EC.sequence;

import java.util.Random;

public class Variator extends Sequence
{
    private static boolean isSeeded = false;

    public Variator(String word, State state)
    {
        super(word, state);
    }

    public String emitWord()
    {

        int randomNumber;
        String word = getWord();
        int selection = 2;
        int lengthOfWord = word.length();

        if (isActive())
        {
            randomNumber = generateRandomNumber(selection);

            int startingIndex = 0;
            int endIndex = 0;

            while ((startingIndex == 0 && endIndex == lengthOfWord - 1) ||
                    (startingIndex >= endIndex))
            {
                startingIndex = generateRandomNumber(lengthOfWord);
                endIndex = generateRandomNumber(lengthOfWord);
            }

            if (randomNumber == 0)
            {
                return concatenateOrTruncateString(startingIndex, endIndex, true);
            }
            else
            {
                return concatenateOrTruncateString(startingIndex, endIndex, false);
            }
        }
        return word;
    }

    public boolean isActive()
    {
        if (getState() == State.ACTIVE)
        {
            return true;
        }
        return false;
    }

    public int generateRandomNumber(int maxRange)
    {
        Random random = new Random();
        if (!isSeeded)
        {
            random.ints();
            isSeeded = true;
        }

        int randomNumber;
        randomNumber = random.nextInt() % maxRange;
        return randomNumber;
    }

    private String concatenateOrTruncateString(int startingIndex, int endIndex,
                                                                boolean flag)
    {
        String word = "";
        String variant;
        int i;
        long j;

        if (flag == true)
        {
            for (i = startingIndex; i < endIndex; i++)
            {
                word = word + getWord().charAt(i);
            }
            variant = getWord();
        }
        else
        {
            for (i = 0; i < startingIndex; i++)
            {
                word = word + getWord().charAt(i);

            }
            for (j = endIndex + 1; j < getWord().length(); j++)
            {
                word = word + getWord().charAt(i);
            }
            variant = word;
        }
        return variant;
    }
}
