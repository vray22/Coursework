//Victor Lozoya 
//Lab5Test
//4/18/2017
//will test my ostream, istream, and mutator functions from my concert class 

#include <iomanip>
#include <iostream>
#include <stdexcept>
#include <string>
#include "Time.h"
#include "Concert.h"
using namespace std;

int main (void){
	//test constructor 	
	Concert c; 
	cin >> c;//test istream operator 
	cout << c;//test ostream operator 
	c.setArtistGroup("Swagg");//test setArtistGroup mutator 
	cout << endl;
	cout << ("After changing ArtistGroup: ");  
	cout << c; 
	//will test setLength mutator 
	Time test;
	test.setTime(1, 30, 00);
	c.setLength(test); 
	cout << endl;
	cout << ("After changing length of concert: ");
	cout << c;
	//will test my setAdmission mutator function 	
	float newAdmission = 200.00;
	c.setAdmission(newAdmission);
	cout << endl;
	cout << ("After changing admission of concert: ");
	cout << c << endl;

	//create another concert object 
	cout << "Test new second concert object: " << endl; 
	Concert c2;
	cout << c2 << endl; //test default constructor
	Time test2;
	test2.setTime(2, 35, 20);  
	c2.setArtistGroup("Big Poppa").setLength(test2).setAdmission(250.00);//test my mutators chained together taking advantage of the non void mutators
	cout << "After using my mutators on the default values: " << endl;
	cout << c2 << endl; 

}  
