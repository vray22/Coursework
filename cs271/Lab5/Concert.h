#ifndef CONCERT_H
#define CONCERT_H
#include <string>
#include <iostream>
#include <iomanip>
#include "Time.h"
using namespace std;

class Concert{

friend ostream &operator<<( ostream &, const Concert & c);
friend istream &operator>>( istream &, Concert & c); 

public:
  	//default constructor 
	Concert();
	//accessor functions 
	string getArtistGroup() const;  
	Time getLength() const; 
	float getAdmission() const; 
	//mutator functions 
	Concert & setArtistGroup(const string &);
	Concert & setLength(const Time &); 
	Concert & setAdmission(float a);
private:
	string artistGroup;//composition member object 
	Time length;//composition memeber object 
	float admission;
};
#endif
 
