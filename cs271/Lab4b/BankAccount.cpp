// BankAccount.cpp 
// Function definitions file for the BankAccount class

// this is a C++ program

#include <iostream>
#include <string>
#include "BankAccount.h"

using namespace std;

// Implementation of the BankAccount class 
//
// contains member function definitions

   //Adding default constructor
   BankAccount::BankAccount(){
     setFirstName(" "); 
     setFirstName(" "); 
     setAccountNumber(0); 
   }//end default constructor 
   
   BankAccount::BankAccount( string f, string l, int n ){
     setFirstName(f);
     setLastName(l);
     setAccountNumber(n);

   } // end constructor

   void BankAccount::setFirstName( string f ) {
     firstName = f;
   }

   void BankAccount::setLastName( string l ) {
     lastName = l;
   }

   void BankAccount::setAccountNumber ( int n ) {
     accountNumber = n;
   }
   string BankAccount::getFirstName( ) {
      return firstName;
   }

   string BankAccount::getLastName( ) {
      return lastName;
   }

   int BankAccount::getAccountNumber ( ) {
      return accountNumber;
   }
   //create display function which will show fist name, last name, and account number in specified format 
   void BankAccount::display(){
     cout << "Customer:   "<< firstName << " " << lastName <<endl;
     cout << "Account:    "<< accountNumber << endl; 
   }

