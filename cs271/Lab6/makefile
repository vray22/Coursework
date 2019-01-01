all: Lab6
Lab6: Complex.o testComplex.o
	g++ Complex.o testComplex.o -o Lab6
Complex.o: Complex.cpp Complex.h
	g++ -c Complex.cpp
testComplex.o: Complex.h testComplex.cpp
	g++ -c testComplex.cpp
