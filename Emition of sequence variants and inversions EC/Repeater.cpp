//
//

#include "Repeater.h"
#include "Sequence.h"
using namespace std;

Repeater ::Repeater(string word, State state) : Sequence(word, state)
{

}

string Repeater ::emitWord()
{
    string word;
    word = getWord();
    if (isActive())
    {
        int size = word.length() + 1;

        char *letters = new char[size];

        for (long unsigned int i = 0; i < word.length(); i++)
        {
            letters[i] = word[i];
        }
        srand(time(NULL));

        int randIndex = rand() % (size + 1);

        char charAtRandomIndex = word[randIndex];

        letters[size - 1] = charAtRandomIndex;

        string variant = convertIntoString(letters, size);

        return variant;
    }
    return word;
}


bool Repeater ::isActive()
{
    if (getState() == ACTIVE)
    {
        return true;
    }
    return false;
}

string Repeater ::convertIntoString(char* a, int size)
{
    string word = "";
    for (int i = 0; i < size; i++)
    {
        word = word + a[i];
    }
    return word;
}