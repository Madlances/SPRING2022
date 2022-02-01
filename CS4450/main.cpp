// Kassandra Madsen
// Module 2 HW - Extra Problem
// CS 4450 Section 001
#include <iostream>

using namespace std;

int main() {
    union readStuff { // this is our union with a nested bit-field structure
        unsigned long long x;
        struct {
            // little endian - reverse the order of the bit-fields
            unsigned int li:32;
            unsigned int rreg:6;
            unsigned int lreg:6;
            unsigned int si:7;
            unsigned int radrm:4;
            unsigned int ladrm:4;
            unsigned int code:5;
        };
    }; 
    readStuff y; // making a variable out of type readStuff
    // We can then print out the output as shown in the instructions of the homework
    cout << "Instruction: ";
    cin >> hex >> y.x;
    cout << dec; // convert back to decimal
    cout << endl;
    cout<< "rreg = " << y.rreg << "\n";
    cout<< "lreg = " << y.lreg << "\n";
    cout<<"si = " << y.si << "\n";
    cout<<"radrm = " << y.radrm << "\n";
    cout<<"ladrm = " << y.ladrm << "\n";
    cout<<"code = " << y.code << "\n";
    cout<<"li = " << y.li << "\n";
}