//Victor Lozoya
//4/25/17
//Lab6
//class to solve equations with complex number
//will overload operator for <<,>>,+,-,*,- 

#ifndef COMPLEX_H

#define COMPLEX_H

#include <iostream>
using namespace std;

class Complex {
 friend ostream& operator<<( ostream& , const Complex& );
 friend istream& operator>>( istream& , Complex& );

   public:
     Complex( double = 0.0, double = 0.0 );
       Complex operator+( const Complex& ) const;
     Complex operator-( const Complex& ) const;
     Complex operator*( const Complex& ) const;
     Complex operator/( const Complex& ) const;

       Complex& setReal( double );
       Complex& setImaginary ( double );
       double getReal ( ) const;
       double getImaginary ( ) const;
     
   private:
     double real;
     double imaginary;

}; // end class

#endif
