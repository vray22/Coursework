//Victor Lozoya 
//Lab7
//May 4th 2017 
//will create funciton definitions for my precisetime header file 

#include <iostream>
#include "PreciseTime.h"
using namespace std; 

ostream & operator << (ostream& out, const PreciseTime & p){

	out << (Time) p;//type cast precisetime to time object 
}

istream & operator >> (istream& in, PreciseTime & p){

	in >> (Time &) p;
}

PreciseTime::PreciseTime(int h, int m, int s, int ms):Time(h, m, s)
{

	setMilliseconds(ms);
}

int PreciseTime::getMilliseconds(){

	return milliseconds;
}

PreciseTime & PreciseTime::setMilliseconds(int ms){
     if(ms >= 0 && ms <= 999){//data validation 
	milliseconds = ms; 
     }
     else{
	milliseconds = 0;
    }
}

