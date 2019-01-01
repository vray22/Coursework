all: Lab7
Lab7: Time-1.o TimeTest.o PreciseTime.o
	g++ Time-1.o TimeTest.o PreciseTime.o -o timetest
Time-1.o: Time-1.cpp Time-1.h
	g++ -c Time-1.cpp
TimeTest.o: Time-1.h TimeTest.cpp
	g++ -c TimeTest.cpp 
PreciseTime.o: Time-1.h PreciseTime.cpp
	g++ -c PreciseTime.cpp

