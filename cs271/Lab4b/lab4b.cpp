/*
*Victor Lozoya 
*Lab4B
*will test my default constructor that I created and my display function 
*Date: March 14th 2017
*CS271
*/


#include <iostream>
#include <iomanip>
#include "BankAccount.h"

int main (void){
   //test display with Constructor 
   BankAccount VicsChecking("Vic", "Ray", 1234); 
   VicsChecking.display();
   BankAccount GregsChecking("Greg", "Llamas", 3456);
   GregsChecking.display();//test display call using .display()
   
   //test display with default constructor 
   BankAccount MelsChecking;//create default no parameters 
   MelsChecking.display();
   BankAccount HecsChecking;
   HecsChecking;  
   HecsChecking.display(); 
}
