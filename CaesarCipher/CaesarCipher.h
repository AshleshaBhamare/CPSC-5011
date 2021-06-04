// Ashlesha Bhamare
// CaesarCipher.h
// 02/26/2021
// Specification file for the CaesarCipher class.

#ifndef ABHAMARE_HW6_CAESARCIPHER_H
#define ABHAMARE_HW6_CAESARCIPHER_H

#include <string>
using namespace std;

class CaesarCipher {
public:
    // Constructor
    CaesarCipher();

    // Constructor with argument
    CaesarCipher (int);

    // Copy constructor
    CaesarCipher(const CaesarCipher &);

    //  To encrypt the text
    string encrypt(string);

    // To decrypt the text
    string decrypt(string);

    // Overloaded assignment operator
    CaesarCipher& operator = (const CaesarCipher &);

    // To add two CaesarCipher objects
    CaesarCipher operator + (const CaesarCipher &);

    // To compare two CaesarCipher objects
    bool operator == (const CaesarCipher &);

    // To compare two CaesarCipher objects
    bool operator < (const CaesarCipher &);

    // To compare two CaesarCipher objects
    bool operator > (const CaesarCipher &);

    // To increment two CaesarCipher objects
    CaesarCipher& operator ++ ();

    // To increment two CaesarCipher objects
    CaesarCipher operator ++ (int);

private:
    int shift;                                     // To hold shift
    const int OFFSET_MIN = 32;                     // To hold OFFSET_MIN
    const int OFFSET_MAX = 126;                    // To hold OFFSET_MAX

    int getShift();
    string encryptDecrypt(string, bool);
    bool isPositionInRange(int);

    static bool isSeeded;                           // To hold isSeeded
};

#endif //ABHAMARE_HW6_CAESARCIPHER_H
