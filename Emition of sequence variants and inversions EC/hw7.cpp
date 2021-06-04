/**
 * Author: Ashlesha Bhamare
 * File name: hw7.cpp
 * Version: 1.0
 * References: none
 * Description: A class that tests all the functionality of other classes
 * Dependencies: A main class which requires all header files for accessing
 * their functionality.
 * Emit behaviour of Sequence class is tested with invert method of Inverter
 * class
 * (List any additional dependencies. Are all behaviors and
 * attributes inherited? Is anything suppressed?)
 * State: Any state changes observed in the DerivedClass.
 * (should align with the pre/post conditions)
 * Assumptions:
 * - Assumption 1 for DerivedClass
 * - Assumption 2 for DerivedClass
*/

#include <iostream>
#include <fstream>

#include "Sequence.h"
#include "Repeater.h"
#include "Inverter.h"
#include "Variator.h"
#include "Extractor.h"

using namespace std;

static bool isSeeded = false;

// This is the fileReading function which reads random lines from the words.dat
// file
// Precondition: The file should not be empty
// Postconditon: The words array will be filled with random line word.
string fileReading();

// This is testAdditionalFunctionality function which tests additional
// functionality like provides subsequence
// Precondition: The lines of words should be pass
// Postconditon: provides subsequences and emits the word.
void testAdditionalFunctionality(string);

// This is the mainn function
// Precondition: The state should be ready to set
// Postconditon: The state is either set to Active or Inactive.
int main()
{
    string line;                                 // To hold line
    const int SIZE = 9;                          // To hold size
    Sequence *sequenceArray[SIZE];               // To hold sequenceArray
    const int wordLength = 3;                    // To hold wordLength
    string word[wordLength];                     // To hold array of word

    cout << "\nWelcome to the Sequence tester! " << endl;


    for (int i = 0; i < wordLength; i++)
    {
        line = fileReading();
        word[i] = line;
    }

    int count = 3;
    for (int i = 0; i < count; i++)
    {
        int j = 0;
        if (i > 0)
        {
            j = i * 3;
        }
        line = word[i];

        Repeater *repeater = new Repeater(line, ACTIVE);

        if (repeater ->getWord().empty())
        {
            cout << "A Word " << line << " length is less than 3 characters "
                                         "long ";
            count = count - 1;
            continue;
        }

        sequenceArray[j] = repeater;

        string subSequence = line.substr(0, line.length()/2);

        Extractor *extractor = new Extractor(line, subSequence, ACTIVE);
        sequenceArray[j + 1] = extractor;


        Variator *variator = new Variator(line, ACTIVE);
        sequenceArray[j + 2] = variator;

    }

    int i = 0;
    const int WORDS = 3;

    for (int j = 0 ; j < WORDS; j++) {
        cout << "\n----------" << endl;

        cout << "Testing word " << (j + 1) << ": " << endl;
        line = word[j];

        if (j > 0)
        {
            i = j * 3;
        }
        int limit = 0;
        // checks for limit and size
        while (limit < 3 && i < SIZE)
        {
            if (limit == 3)
            {
                break;
            }
            // emits the word
            cout << "\nemit: " << sequenceArray[i] ->emitWord() << endl;
            Inverter inverter(sequenceArray[i]);
            // Invert the word
            cout << "invert: " << inverter.invertElements() << endl;
            limit++;
            i++;
        }
        string answer;
        string response = "y";
        // checking for response
        while(response == "y" || response == "Y")
        {
            cout << "\nWhat is your guess? " ;
            cin >> answer;

            if (answer.compare(line) == 0)
            {
                cout << "That's correct!" << endl;
                break;
            }
            else
            {
                cout << "That is not correct." << endl;
                cout << "Guess again (y/n)? ";
                cin >> response;
            }
        }
    }

    cout << "\n----------" << endl;
    // calls testAdditionalFunctionality function
    testAdditionalFunctionality(line);

    cout << "\n----------" << endl;
    cout << "\nThanks for using the Sequence tester! \n" << endl;

    return 0;
}

string fileReading()
{
    int numberOfLines = 0;                        // To hold numberOfLines
    int randomNumber;                             // To hold randomNumber
    string line;                                  // to hold line
    ifstream inFile;

    // To open file
    inFile.open("words.dat");

    if (!inFile)
    {
        cout << "This file does not exists. Try again";
        exit(1);           // terminate with error
    }
    else
    {
        while (getline(inFile, line))
        {
            numberOfLines++;
        }

        if (!isSeeded)
        {
            srand(time(NULL));
            isSeeded = true;
        }

        randomNumber = rand() % numberOfLines + 1;
        int currentLine = 0;
        ifstream readFile;

        readFile.open("words.dat");
        while (getline(readFile, line))
        {
            if (currentLine == randomNumber)
            {
                break;
            }
            currentLine++;
        }
        inFile.close();                           // To close file
        readFile.close();                         // To close file
    }
    return line;
}

void testAdditionalFunctionality(string line)
{
    string input;
    string response;

    cout << "Testing word 4 (additional functionality): " << endl;
    cout << endl;

    do {
        response = "n";

        line = fileReading();

        Repeater repeater(line, ACTIVE);

        if (repeater.getWord().empty())
        {
            cout << "A Word " << line << " length is less than 3 characters "
                                         "long ";
            response = 'y';
            continue;
        }

        Inverter inverter(&repeater);
        cout << "Invert: " << inverter.invertElements() << endl;

        do {
            if (!isSeeded)
            {
                srand(time(NULL));
                isSeeded = true;
            }

            int endIndex = rand() % (line.length() - 2) + 1;

            string subSequence = line.substr(0, endIndex);
            cout << "\nprovide a subsequence: " << subSequence << endl;

            Extractor extractor(line, subSequence, ACTIVE);
            cout << "emit: " << extractor.emitWord() << endl;

            cout << "\nProvide another subsequence (y/n)? ";
            cin >> input;

        } while (input == "y" || input == "Y");

        do {
           cout << "\nWhat is your guess? ";
           cin >> response;

           if (response == line)
           {
               cout << "That's correct!" << endl;
           }
           else
           {
               cout << "That is not correct." << endl;
               cout << "Guess again (y/n)? ";
               cin >> response;
           }
        } while (response == "y" || response == "Y");

        cout << "\nWould you like to test another word (y/n)? ";
        cin >> response;

    } while (response == "y" || response == "Y");
}