//Victor lozoya
//Lab7
//may 4th 
//will test my Precisetime objects which inherited members from time class 

#include "Time-1.h"
#include <string>
#include <sstream>
#include "PreciseTime.h"

using namespace std;


int main ( ) {

   Time j ( 4, 5, 10);
   Time t;
   cout << "Input a time in the format hh:mm:ss ";
   cin >> t;
   cout << "j is " << j << endl;
   cout << "t is " << t << endl;
 //test my objects creating two
//test my mutators with both objects i created 
   PreciseTime p(4, 5, 12, 155);
   p.setMilliseconds(859);
  PreciseTime p2(9, 4, 34, 255);
  p2.setMilliseconds(750);

   
}
