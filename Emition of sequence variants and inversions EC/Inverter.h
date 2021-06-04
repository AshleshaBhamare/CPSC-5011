/**
 * Author: Ashlesha Bhamare
 * File name: Inverter.h
 * Version: 1.0
 * References: none
 * Description: a class that based on index i and, according to state, supports the inversion of
 *              two elements (or characters) of a given sequence at indices i and i+1.
 * Dependencies: A Inverter has a sequence
 * (List any additional dependencies. Are all behaviors and
 * attributes inherited? Is anything suppressed?)
 * State: Any state changes observed in the DerivedClass.
 * (should align with the pre/postconditions)
*/

#ifndef ABHAMARE_HW7_INVERTER_H
#define ABHAMARE_HW7_INVERTER_H

#include <iostream>
#include "Sequence.h"

using namespace std;

class Inverter
{
public:
    // This is the constructor of the inverter
    // Index is set to zero
    // Precondition: no pre conditions
    // Postconditon: no post conditions
    Inverter();

    // This is the constructor of the inverter with sequence object as parameter
    // Index is set to random number
    // Precondition: word should be of 3 or more letters
    // Postconditon: State of the word is active and word is not changed
    Inverter(Sequence*);

    // This is the invertElement function that based on index i and, according
    // to state, supports the inversion of two elements
    // Precondition: Status of word should be active, word length must be
    //               greater than or equal to 3
    // Postconditon: word length is not chnaged and state of the word is
    //               maintained after calling this method.
    string invertElements();

private:
    int index;                       // To hold Index used for inversion of
                                     // letters

    static bool isSeeded;            // To generate new random number everytime rand() is called

    Sequence* sequence;              // Sequence object

    // To check the validity of word size
    // Precondition: word and index should be pass
    // Postconditon: returns true if index is greater than zero otherwise
    //               returns false
    bool checkWordSizeValidity(int, string);

    // This is the generateRandomNumber function to generate random numbers
    // Precondition: The maxRange for numbers should be set
    // Postconditon: returns generated random numbers
    int generateRandomNumber(int);

    // This is a convertIntoString function, which converts a char to string
    // Precondition: array should contain char elements
    // Postconditon: string array is created from char array
    string convertIntoString(char* , int );

};


#endif //ABHAMARE_HW7_INVERTER_H
