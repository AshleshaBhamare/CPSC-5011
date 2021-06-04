//AUTHOR:   Ashlesha Bhamare
//FILENAME: CaesarCipher.cpp
//DATE:     02/26/2021
//PURPOSE:  This program implements the functionality of CaesarCipher.h class
//          includes Constructor, constructor with arguments, functions like
//          encrypt, decrypt, getShift, encryptDecrypt, isPositionInRange and
//          different operators to compare two objects

#include <iostream>
#include "CaesarCipher.h"

using namespace std;

CaesarCipher newCaesarCipher;
bool CaesarCipher::isSeeded = false;

CaesarCipher ::CaesarCipher() {
    shift = getShift() % 10;
    if (shift == 0)
    {
        shift = 1;
    }
}

CaesarCipher ::CaesarCipher(int shft)
{
    shift = shft;
}

CaesarCipher ::CaesarCipher(const CaesarCipher &cipher)
{
    shift = cipher.shift;
}

string CaesarCipher ::encrypt(string plainText)
{
    for (char const &temp: plainText)
    {
        int index = (int)temp;
        if (!isPositionInRange(index))
        {
            throw invalid_argument("String to be encrypted has unrecognized "
                                   "character " + temp);
        }
    }
    string textResult;
    textResult = encryptDecrypt(plainText, true);
    return textResult;
}

string CaesarCipher ::decrypt(string cipherText)
{
    string textResult;
    textResult = encryptDecrypt(cipherText, false);
    return textResult;
}

CaesarCipher& CaesarCipher ::operator=(const CaesarCipher &cipher)
{
    shift = cipher.shift;
    return *this;
}

CaesarCipher CaesarCipher ::operator+(const CaesarCipher &otherCipher)
{
    newCaesarCipher.shift = otherCipher.shift + shift;
    return newCaesarCipher;
}

bool CaesarCipher ::operator==(const CaesarCipher &cipher)
{
    if (shift == cipher.shift)
    {
        return true;
    }
    return false;
}

bool CaesarCipher ::operator<(const CaesarCipher &cipher)
{
    if (shift < cipher.shift)
    {
        return true;
    }
    return false;
}

bool CaesarCipher ::operator>(const CaesarCipher &cipher)
{
    if (shift > cipher.shift)
    {
        return true;
    }
    return false;
}

CaesarCipher& CaesarCipher ::operator++()
{
    ++shift;
    return *this;
}

CaesarCipher CaesarCipher ::operator++(int)
{
    const CaesarCipher previous(this -> shift);
    ++(*this);
    return previous;
}

int CaesarCipher ::getShift()
{
    if (!CaesarCipher :: isSeeded)
    {
        srand(time(NULL));
        CaesarCipher ::isSeeded = true;
    }
    return rand();
}

string CaesarCipher ::encryptDecrypt(string word, bool flagValue)
{
    string textResult;
    int defaultShift = 0;

    for (long unsigned int i = 0; i < word.length(); i ++)
    {
        if (isupper(word[i]))
        {
            if (flagValue == true)
            {
                textResult = textResult + char(int(word[i] + shift - 65) % 26
                        + 65);
            }
            else
            {
                defaultShift = 26 - shift;
                textResult = textResult + char(int(word[i] + defaultShift - 65) % 26
                        + 65);
            }
        }
        else if (islower(word[i]))
        {
            if (flagValue == true)
            {
                textResult = textResult + char(int(word[i] + shift - 97) % 26
                        + 97);
            }
            else
            {
                defaultShift = 26 - shift;
                textResult = textResult + char(int(word[i] + defaultShift -
                        97) % 26 + 97);
            }
        }
        else if (isdigit(word[i]))
        {
            if (flagValue == true)
            {
                textResult = textResult + char(int(word[i] + shift - 48) % 10
                        + 48);
            }
            else
            {
                defaultShift = 10 - shift;
                textResult = textResult + char(int(word[i] + defaultShift - 48)
                        % 10 + 48);
            }
        }
        else
        {
            if (flagValue == true)
            {
                textResult = textResult + char(int(word[i] + shift - 32) % 15
                        + 32);
            }
            else
            {
                defaultShift = 15 - shift;
                textResult = textResult + char(int(word[i] + defaultShift -32)
                        % 15 + 32);
            }
        }
    }
    return textResult;
}

bool CaesarCipher ::isPositionInRange(int index)
{
    if (index < OFFSET_MIN || index > OFFSET_MAX)
    {
        return false;
    }
    return true;
}