
/**
 * Author: Ashlesha Bhamare
 * File name: Variator.h
 * Version: 1.0
 * References: none
 * Description: A class that emits a variant of the encapsulated word, either
 *              concatenating or truncating an internal subsequence. If active,
 *              the object will arbitrarily concatenate or truncate an
 *              internal subsequence; otherwise, it will emit the word itself.
 * Dependencies: A Variator is-a Sequence.
 * (List any additional dependencies. Are all behaviors and
 * attributes inherited? Is anything suppressed?)
 * State: Any state changes observed in the Variator.
 * (should align with the pre/postconditions)
 * Assumptions:
 * - Assumption 1 for DerivedClass
 * - Assumption 2 for DerivedClass
*/

#ifndef ABHAMARE_HW7_VARIATOR_H
#define ABHAMARE_HW7_VARIATOR_H

#include <iostream>
#include "Sequence.h"

using namespace std;

class Variator : public Sequence
{
public:
    // This is the parametrised constructor which sets the word and state of
    // the word
    // Precondition: Status of word should be active, word length must be
    //               greater than or equal to 3
    // Postconditon: State is guaranteed to be set to ACTIVE
    //               after calling this function
    Variator(string, State);

    // This is the emitWord override function from sequence class
    // Precondition: Status of word should be active, word length must be
    //               greater than or equal to 3
    // Postconditon: State is guaranteed to be set to ACTIVE
    //               after calling this function
    string emitWord();

    // This is the isActive function to check the state of the word
    // Precondition: Word length must be greater than or equal to 3
    // Postconditon: State is maintained after calling this function
    bool isActive();

    // This is the generateRandomNumber function to generate random numbers
    // Precondition: The maxRange for numbers should be set
    // Postconditon: returns generated random numbers
    int generateRandomNumber(int);

private:
    // To generate new random number everytime a rand() function is called.
    static bool isSeeded;

    // This is the concatenateOrTruncateString function depends on the
    // starting and ending index either concatenates the string or truncates
    // the string
    // Precondition: random number generated should be in between the word size
    // Postconditon: string generated is a subsequence of the string
    string concatenateOrTruncateString(int, int, bool);

};

#endif //ABHAMARE_HW7_VARIATOR_H
