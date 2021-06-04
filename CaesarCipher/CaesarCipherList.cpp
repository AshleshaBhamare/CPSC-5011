//AUTHOR:   Ashlesha Bhamare
//FILENAME: CaesarCipherList.cpp
//DATE:     02/26/2021
//PURPOSE:  This program implements the functionality of CaesarCipherList class
//          includes Constructor, destructor, copy constructor, overloaded
//          assignment operator, addElements, size and resize

#include "CaesarCipherList.h"

using namespace std;

CaesarCipherList ::CaesarCipherList(int cap)
{
    capacity = cap;
    numElements = 0;
    list = new CaesarCipher[capacity];
}

CaesarCipherList ::~CaesarCipherList()
{
    delete []list;
}

CaesarCipherList ::CaesarCipherList(const CaesarCipherList &object)
{
    capacity = object.capacity;
    numElements = object.numElements;
    list = new CaesarCipher[capacity];

    for (int i = 0; i < numElements; i++)
    {
        list[i] = object.list[i];
    }
}

CaesarCipherList &CaesarCipherList ::operator=(const CaesarCipherList &object)
{
    if (this != &object)
    {
        delete []list;
        capacity = object.capacity;
        numElements = object.numElements;
        list = new CaesarCipher[capacity];
        for (int i = 0; i < numElements; i++)
        {
            list[i] = object.list[i];
        }
    }
    return *this;
}

void CaesarCipherList ::addElement(CaesarCipher cc)
{
    if (numElements >= capacity)
    {
        resize();
    }
    list[numElements] = cc;
    numElements++;
}

CaesarCipher CaesarCipherList ::getElement(int element) const
{
    for (int i = 0; i < capacity; i++)
    {
        if (i == element)
        {
            return list[i];
        }
    }
    return CaesarCipher();
}

int CaesarCipherList ::size() const
{
    return numElements;
}

void CaesarCipherList ::resize()
{
    capacity = capacity * 2;
    CaesarCipher *caesarCipher = new CaesarCipher[capacity];

    for (int i = 0; i < numElements; i ++)
    {
        caesarCipher[i] = list[i];
    }
    delete[] list;
    list = caesarCipher;
}