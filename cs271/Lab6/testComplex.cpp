//Victor Lozoya  
// insert your header comments here
//Lab6
//main method to test my function in Complex.h 
//4/27/17

#include <iostream>
#include "Complex.h"
using namespace std;

int main ( ) {

   // create two complex objects

   Complex num1 ( 3, 4 );
   Complex num2 ( 1, 3 );

   // test the addition operator

   Complex sum = num1 + num2;

   cout << "The result of adding 3 + 4i to 1 + 3i is " << sum.getReal() << " + " << sum.getImaginary() << "i" << endl;

   // test the output stream operator
    cout << "Will test my output stream operator: " << endl;
    cout << num1 << endl;
    cout << num2 << endl; 
  
    //Test input stream operator
	Complex test;
	cout << "Enter two integers for the complex number: ";
        cin >> test;
        cout << test << endl;//see if input works correctly 
  
 // test the subtraction operator
   Complex sum2 = num1 - num2; 
   cout << "The result of subtracting 1 + 3i from 3 + 4i is " << sum2.getReal() << " + " << sum2.getImaginary() << "i" << endl; // display the results


   // test the multiplication operator
   Complex sum3 = num1 * num2;
   cout << "The result of multiplying 3 + 4i and 1 + 3i is " << sum3.getReal() << " + " << sum.getImaginary() << "i" << endl; // display the results


   // test the division operator
   Complex sum4 = num1 / num2;
   cout << "The result of dividing 3 + 4i by 1 +3i is " << sum4.getReal() << " + " << sum.getImaginary() << "i" << endl; // display the results

} // end main
   
