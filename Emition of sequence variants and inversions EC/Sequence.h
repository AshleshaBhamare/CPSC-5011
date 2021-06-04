/**
 * Author: Ashlesha Bhamare
 * File name: Sequence.h
 * Version: 1.0
 * References: none
 * Description:  A class that encapsulates a word (at least 3 characters
 *               long), and responds to inquiries
 * Dependencies: A Sequence is a base class.
 * (List any additional dependencies. Are all behaviors and
 * attributes inherited? Is anything suppressed?)
 * State: Any state changes observed in the Variator.
 * (should align with the pre/postconditions)
 * Assumptions:
 *              If a word is less than 3 characters long, then we dont
 *              initialize the word in the Sequence constructor. States is
 *              defined as an enum with ACTIVE and INACTIVE members.
 *              Initially all the objects created are treated as ACTIVE
*/
#ifndef ABHAMARE_HW7_SEQUENCE_H
#define ABHAMARE_HW7_SEQUENCE_H

#include <iostream>

using namespace std;

enum State { ACTIVE, INACTIVE };

class Sequence
{
public:
    // This is the default constructor.
    // Precondition: State is set to ACTIVE & word is set to null
    // Postconditon: State is guaranteed to be set to ACTIVE
    //               after calling this function
    Sequence();

    // This is the parametrised constructor.
    // Precondition: State is set to state provided in parameter & word is set
    //               to string provided in the parameter
    // Postconditon: State is guaranteed to have some state and word is set to
    //               a value greater than or equal to 3 after calling this
    //               function
    Sequence(string, State);

    // This is the validateTheWord function
    // Precondition: word length should not be zero
    // Postconditon: word length is greater than three
    //               after calling this function
    bool validateTheWord(string);

    // This is the setWord function
    // Precondition: word length should be greater than or equal to zero
    // Postconditon: word is set to the parameter passed
    //               after calling this function
    void setWord(string);

    // This is the getWord function
    // Precondition: no parameter should be passed
    // Postconditon: State is guaranteed to be set to ACTIVE
    //               after calling this function
    string getWord();

    // This is the getState function
    // Precondition: State should not be changed
    // Postconditon: State is returned after calling this function
    State getState();

    // This is the emit which emits the word.
    // Precondition:
    // Postconditon:
    // As this method is not implemented in Sequence class, no pre post
    // conditions are applicable.
    virtual string emitWord() = 0;

private:

    State state;                 // State of the word

    string word;                // the word to be set for encapsulation

};


#endif //ABHAMARE_HW7_SEQUENCE_H
