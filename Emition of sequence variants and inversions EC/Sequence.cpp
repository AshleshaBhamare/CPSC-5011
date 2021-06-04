//
//

#include "Sequence.h"
#include "Inverter.h"

using namespace std;

bool Inverter ::isSeeded = false;

bool Sequence ::validateTheWord(string word)
{
    return word.length() >= 3;
}

Sequence ::Sequence(string word, State state)
{
    if (validateTheWord(word))
    {
        this->word = word;
        this->state = state;
    }
}

Sequence ::Sequence()
{
    this->word = "";
    this->state = ACTIVE;
}

void Sequence ::setWord(string word)
{
    if(validateTheWord(word))
    {
        this->word = word;
    }
}

string Sequence ::getWord()
{
    return this->word;
}

State Sequence ::getState()
{
    return state;
}

Inverter ::Inverter(Sequence *sequence)
{
    this->sequence = sequence;
    this ->index = generateRandomNumber(sequence->getWord().length() - 1);
}

Inverter ::Inverter()
{
    this->index = 0;
}

int Inverter ::generateRandomNumber(int maximumRange)
{
    if (!Inverter ::isSeeded)
    {
        srand(time(NULL));
        Inverter ::isSeeded = true;
    }

    int randomNumber;
    randomNumber = rand() % maximumRange;
    return randomNumber;
}
string Inverter ::invertElements()
{
    srand(time(NULL));
    char temp;
    string word = sequence ->getWord();
    int size = word.length();

    if (checkWordSizeValidity(index, word))
    {
        char *wordsArray = new char[size] ;
        for (int i = 0; i < size; i++)
        {
            wordsArray[i] = word[i];
        }

        temp = wordsArray[index];
        wordsArray[index] = wordsArray[index + 1];
        wordsArray[index + 1] = temp;

        word = convertIntoString(wordsArray, size);
    }
    return word;
}

bool Inverter ::checkWordSizeValidity(int index, string word)
{
    int size;
    size = word.length();
    if (index < 0 || index >= size - 1)
    {
        return false;
    }
    return true;
}

 string Inverter ::convertIntoString(char* a, int size)
{
    string word = "";
    for (int i = 0; i < size; i++)
    {
        word = word + a[i];
    }
    return word;
}