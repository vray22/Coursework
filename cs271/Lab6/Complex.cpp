//Victor Lozoya 
// insert your header comments here
//Lab6
//4/27/17
//will create function definitions for prototypes in Complex.h file 
//will overload these operators and test memenber funtion in main 

#include <iostream>
#include "Complex.h"
using namespace std;

   ostream& operator<<( ostream& output, const Complex& obj ) {

     //  your statements should display the number in the form a + bi  (if b is positive)
     if(obj.imaginary > 0){
	output << obj.real << " + " << obj.imaginary << "i";
	return output;
     }
     else
	output << obj.real << " - " << obj.imaginary << "i";
	return output;
 //  or a - bi (if b is negative)


 } // end operator<<
 
 istream& operator>>( istream& input, Complex& obj) {

     // your statements should input the real and imaginary values
     // don't display prompts
	input >> obj.real >> obj.imaginary; 
	return input; 


 

   } // end operator>>

// member functions

     Complex::Complex( double r , double i ) {

       real = r;
       imaginary = i;

     } // end constructor
 
     double Complex::getReal( ) const {

        return real;
     }

     double Complex::getImaginary ( ) const {

        return imaginary;
     }

     Complex& Complex::setReal ( double r ) {

        real = r;

     }

     Complex& Complex::setImaginary ( double i ) {

        imaginary = i;

     }

     Complex Complex::operator+( const Complex& x ) const {

        Complex sum( real + x.real, imaginary + x.imaginary );
        return sum;

     } // end operator+

     // your code for the subtraction operator goes here
     Complex Complex::operator-( const Complex& x ) const {
	Complex answer; 
	answer.real = real - x.real;
	answer.imaginary = imaginary - x.imaginary; 
	
	return answer;
    }//end operator-

     // your code for the multiplication operator goes here
    Complex Complex::operator*( const Complex& x) const {
	Complex answer; 
	answer.real = real * x.real - imaginary * x.imaginary; 
	answer.imaginary = real * x.imaginary + imaginary * x.real;
	return answer; 

    }//end operator*

     // your code for the division operator goes here
    Complex Complex::operator/( const Complex& x) const {
 	Complex answer; 
	double denom = x.real * x.real + x.imaginary * x.imaginary;
	answer.real = real * x.real + imaginary * x.imaginary; 
	answer.imaginary = imaginary * x.real - real * x.imaginary; 
	answer.real = answer.real / denom;
	answer.imaginary = answer.imaginary / denom;
	
	return answer;
   }//end operator/
 














