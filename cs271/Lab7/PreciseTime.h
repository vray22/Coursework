//Victor Lozoya 
//Lab7
//5/4/17
//practice inhertience 


#ifndef PRECISETIME_H
#define PRECISETIME_H
#include "Time-1.h"
#include <iostream>
using namespace std; 

class PreciseTime : public Time {
friend ostream & operator << (ostream& out, const PreciseTime & p );
friend istream & operator >> (istream& in, PreciseTime & p);
	private: 
          int milliseconds;
	public:
	  PreciseTime(int h, int m, int s, int ms);
	  int getMilliseconds();
	  PreciseTime & setMilliseconds(int);
};
#endif
