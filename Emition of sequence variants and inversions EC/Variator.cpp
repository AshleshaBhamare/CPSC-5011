
#include "Variator.h"

using namespace std;

bool Variator ::isSeeded = false;

Variator ::Variator(string word, State state) : Sequence(word, state)
{

}

string Variator ::emitWord()
{
    int randomNumber;
    string word = getWord();
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

bool Variator ::isActive()
{
    if (getState() == ACTIVE)
    {
        return true;
    }
    return false;
}

int Variator ::generateRandomNumber(int maxRange)
{
    if (!Variator ::isSeeded)
    {
        srand(time(NULL));
        Variator ::isSeeded = true;
    }

    int randomNumber;
    randomNumber = rand() % maxRange;
    return randomNumber;
}

string Variator ::concatenateOrTruncateString(int startingIndex, int endIndex,
                                              bool flag)
{
    string word = "";
    string variant = "";
    int i;
    long unsigned int j;

    // To Concatenate
    if (flag == true)
    {
        for (i = startingIndex; i <= endIndex; i++)
        {
            word = word + getWord()[i];
        }
        variant = getWord()[i];
    }
    else
    {
        for (i = 0; i < startingIndex; i++)
        {
            word = word + getWord()[i];

        }
        for (j = endIndex + 1; j < getWord().length(); j++)
        {
            word = word + getWord()[i];
        }
        variant = word;
    }
    return variant;
}