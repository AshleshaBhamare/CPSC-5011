// AUTHOR:  Ashlesha Bhamare
// PROGRAM: hw6.cpp
// DATE:    02/26/2021
// PURPOSE: This program demonstrates the CaesarCipher class'
//          Big 4 operations and overloaded operators
// INPUT:   CaesarCipher.h and CaesarCipherList.h
// PROCESS: Runs all the functions.
// OUTPUT:  Prints the encrypted and decrypted text.

#include <iostream>
#include "CaesarCipher.h"
#include "CaesarCipherList.h"
#include <string>

using namespace std;

// To print the encrypted and decrypted text
void printTheText(CaesarCipher);

int main()
{
    const int SIZE = 3;
    for (int i = 1; i < SIZE; i ++)
    {
        cout << "\n***** RUN " << i <<" : *****" << endl;

        cout << "\ntest constructor : cc" << endl;
        CaesarCipher cc;
        printTheText(cc);

        cout << "\ntest constructor : cc2" << endl;
        CaesarCipher cc2;
        printTheText(cc2);

        cout << "\n*** testing copy constructor and overloaded assignment ***"
        << endl;
        cout << "\ntest copy constructor : cc3(cc2)" << endl;
        CaesarCipher cc3(cc2);
        printTheText(cc3);

        cout << "\ntest overloaded assignment operator : cc2 = cc" << endl;
        cc2 = cc;
        printTheText(cc2);

        cout << "\n*** printing cc, cc2, and cc3 ***" << endl;

        cout << "\ntest constructor : cc" << endl;
        printTheText(cc);

        cout << "\ntest constructor : cc2" << endl;
        printTheText(cc2);

        cout << "\ntest constructor : cc3" << endl;
        printTheText(cc3);

        cout << "\n*** testing comparators ***" << endl;

        cout << "\ntest comparators" << endl;

        cout << boolalpha << "\ncc == c3 is " << cc.operator==(cc3) << endl;
        cout << "cc < c3 is " << cc.operator<(cc3) << endl;
        cout << "cc > c3 is " << cc.operator>(cc3) << endl;

        cout << "\n*** testing add ***" << endl;

        cout << "\ntest add : cc2 = cc + cc3" << endl;
        cc2 = cc + cc3;
        printTheText(cc2);

        cout << "\n*** testing increment ***" << endl;

        cout << "\ntest increment (postfix) : cc4 = cc++" << endl;
        CaesarCipher cc4 = cc++;
        printTheText(cc);

        cout << "\nresult of cc4 after postfix :" << endl;
        printTheText(cc4);

        cout << "\ntest increment (prefix) : cc4 = ++cc" << endl;
        cc4 = ++cc;
        printTheText(cc);

        cout << "\nresult of cc4 after prefix :" << endl;
        printTheText(cc4);

        cout << "\ntest increment (postfix) : cc4 = cc2++" << endl;
        cc4 = cc2++;
        printTheText(cc2);

        cout << "\nresult of cc4 after postfix :" << endl;
        printTheText(cc4);

        cout << "\ntest increment (prefix) : cc4 = ++cc2" << endl;
        cc4 = ++cc2;
        printTheText(cc2);

        cout << "\nresult of cc4 after prefix :" << endl;
        printTheText(cc4);

        cout << "\ntest increment (postfix) : cc4 = cc3++" << endl;
        cc4 = cc3++;
        printTheText(cc3);

        cout << "\nresult of cc4 after postfix :" << endl;
        printTheText(cc4);

        cout << "\ntest increment (prefix) : cc4 = ++cc3" << endl;
        cc4 = ++cc3;
        printTheText(cc3);

        cout << "\nresult of cc4 after prefix :" << endl;
        printTheText(cc4);

        cout << "\n----------------------------" << endl;

        cout << "\n*** testing list ***" << endl;

        cout << "\ntest list : add cc, cc2, cc3" << endl;


        CaesarCipherList list(3);
        CaesarCipherList ccList = CaesarCipherList(list);
        ccList.addElement(cc);
        ccList.addElement(cc2);
        ccList.addElement(cc3);

        for (int i = 0; i < ccList.size(); i ++)
        {
            cout << "\ntest print list[" << i <<"] :" << endl;
            printTheText(ccList.getElement(i));
        }
    }
    return 0;
}

void printTheText(CaesarCipher cc)
{
    string encryptedWord = cc.encrypt("Hello, world!");
    cout << "Encrypted: " << encryptedWord << endl;
    string decryptedWord = cc.decrypt(encryptedWord);
    cout << "Decrypted: " << decryptedWord << endl;
}