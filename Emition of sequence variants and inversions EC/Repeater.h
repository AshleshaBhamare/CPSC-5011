/**
 * Author: Ashlesha Bhamare
 * File name: Repeater.h
 * Version: 1.0
 * References: none
 * Description:  A class that emits a variant of the encapsulated word,
 *               repeating one or more characters. The object will only emit
 *               the variant if 'active'; otherwise, it will emit the word itself.
 * Dependencies: A Repeater class is a Sequence class .
 * (List any additional dependencies. Are all behaviors and
 * attributes inherited? Is anything suppressed?)
 * State: Any state changes observed in the DerivedClass.
 * (should align with the pre/postconditions)
 * Assumptions:
 * - Words are case sensitive that means Cat is not same like cat.
*/

#ifndef ABHAMARE_HW7_REPEATER_H
#define ABHAMARE_HW7_REPEATER_H

#include <iostream>
#include "Sequence.h"

using namespace std;

class Repeater : public Sequence
{
public:
    // This is the Repeater parametrised constructor
    // Precondition: word should be greater than 3
    // Postconditon: State and word are set according to the parameters passed
    Repeater(string, State);

    // This is the isActive function
    // Precondition: no parameter should be passed
    // Postconditon: State is guaranteed to be set to ACTIVE
    //               after calling this function
    bool isActive();

    // This is the emitWord override function from sequence class
    // Precondition: Status of word should be active, word length must be greater than or equal to 3
    // Postconditon: State is guaranteed to be set to ACTIVE
    //               after calling this function
    string emitWord();

    // This is a convertIntoString function, which converts a char to string
    // Precondition: array should contain char elements
    // Postconditon: string array is created from char array
    string convertIntoString(char*, int);

};

#endif //ABHAMARE_HW7_REPEATER_H
