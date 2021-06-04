
#include "Extractor.h"

Extractor ::Extractor(string word, string subSequence, State state)
{
    this->setWord(word);
    this->subsequence = subSequence;
    this ->getState();
}

string Extractor ::emitWord()
{
    if (isActive())
    {
        if (subsequence.empty())
        {
            return "no subsequence is provided";
        }

        int sizeOfSubSequence = subsequence.length();
        int wordSize = getWord().length();

        // Checks if subsequence is bigger than word
        if (sizeOfSubSequence > wordSize)
        {
            return "the provided subsequence is not found";
        }

        // Checks if both are equal
        if ((subsequence.compare(getWord())) == 0)
        {
            return "the provided subsequence is equals to the encapsulated word";
        }

        int startIndex;
        startIndex = isSubsequence(subsequence, getWord());

        if (startIndex == -1)
        {
            return "the provided subsequence is not a part of word";
        }

        // if the startingIndex is 0 then returns the remaining word until the
        // end
        string remainedWord = "";
        if (startIndex == 0)
        {
            for (int i = sizeOfSubSequence; i < wordSize; i++)
            {
                remainedWord = remainedWord + getWord()[i];
            }
        }
        else
        {
            for (int i = 0; i < startIndex; i++)
            {
                remainedWord = remainedWord + getWord()[i];
            }

        }
        return remainedWord;
    }
    return getWord();
}

bool Extractor ::isActive()
{
    if (getState() == ACTIVE)
    {
        return true;
    }
    return false;
}

int Extractor ::isSubsequence(string subSequence, string word)
{
    int word1 = subSequence.length();
    int word2 = word.length();

    for (int i = 0; i < word2 - word1; i++)
    {
        int j;
        for (j = 0; j < word1; j++)
        {
            if (word[i + j] != subSequence[j])
                break;

        }
        if (j == word1)
        {
            return i;
        }
    }
    return -1;
}