// Ashlesha Bhamare
// CaesarCipherList.h
// 02/26/2021
// Specification file for the CaesarCipherList class.

#ifndef ABHAMARE_HW6_CAESARCIPHERLIST_H
#define ABHAMARE_HW6_CAESARCIPHERLIST_H
#include "CaesarCipher.h"

class CaesarCipherList
{
public:
    // Constructor
    CaesarCipherList(int);

    // Destructor
    ~CaesarCipherList();

    // Copy constructor
    CaesarCipherList(const CaesarCipherList &);

    // Overloaded assignment operator
    CaesarCipherList& operator=(const CaesarCipherList &);

    // Add an element to the list
    void addElement(CaesarCipher);

    // Get element in the list at the provided index
    CaesarCipher getElement(int) const;

    // Get list size;
    int size() const;

private:
    CaesarCipher *list;
    int shift;                                  // To hold shift
    int capacity;	                            // Capacity of array
    int numElements;	                        // Number of elements in array
    void resize(); 	                            // Called to resize array
};

#endif //ABHAMARE_HW6_CAESARCIPHERLIST_H
