//Victor Lozoya 
//Concert.cpp
//will create accessors and mutators of concert class
//also will create friend functions ostream and istream 

#include <stdexcept>
#include <string>
#include <iomanip>
#include <iostream>
#include <cstdlib>
#include "Time.h"
#include "Concert.h"
using namespace std; 

Concert::Concert(){//default constructor 
	artistGroup = " ";//empty string set for artistGroup 
	Time l;  //create time object 
	length = l; //set length to this default time object 
	admission = 0.0;//admission price set to 0
}

string Concert::getArtistGroup()const {//accessor method for artistGroup 
	return artistGroup;
} 
Time Concert::getLength() const {//accessor method for length 
	return length; 
}
float Concert::getAdmission() const {//accessor method for admission 
	return admission; 
}
Concert & Concert::setArtistGroup(const string &n){//will set artistGroup to string param
	artistGroup = n; 
	return *this; 
}
Concert & Concert::setLength(const Time &l){//will set length to time param 
	 length = l; 
	 return *this; 
}
Concert & Concert::setAdmission(float a){//will set admission to param a 
	if(a > 0){//checks if admisson is positive 
	   admission = a;
	}
	else{
	   throw invalid_argument("Admission must be greater than 0 ");
	} 
	return *this; 
}
ostream &operator<<( ostream &out, const Concert &c){//friend ostream function 
	out << "Artist/Group: " << c.getArtistGroup() << endl;
	out << "Length of Concert: ";
	c.getLength().printUniversal();
	out << endl;
	out << "Admission: $" << setw(3) << setprecision(2) << fixed << c.admission;//will print out artistGroup, length, and admission in specified format 

	return out; 
}
istream &operator>>( istream &in, Concert &c){//friend istream function 
	//promts user for artist/group name, length of concert ask for hour, minute, and second 
	//will also ask for admission price 
	cout << "Input artist/group name: ";
	string n; 
	getline(in, n); 
	c.setArtistGroup(n);
	cout << "Input hour length of concert: ";
	int h;
	in >> h;
	c.length.setHour(h);
	cout << "Input minute length of concert: ";
	int m;
	in >> m;
	c.length.setMinute(m);
	cout << "Input second length of concert: ";
	int s; 
	in >> s;
	c.length.setSecond(s); 
	cout<<"Input admission price: ";
	float a;
	in >> a;
	c.setAdmission(a);
	
	return in;
} 
