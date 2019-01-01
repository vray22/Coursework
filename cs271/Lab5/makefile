all: Lab5
Lab5: Time.o Concert.o TestLab5.o
	g++ Time.o Concert.o TestLab5.o -o Lab5
Time.o: Time.cpp Time.h 
	g++ -c Time.cpp
Concert.o: Concert.cpp Concert.h Time.h
	g++ -c Concert.cpp
TestLab5.o: TestLab5.cpp Concert.h Time.h
	g++ -c TestLab5.cpp
clean: 
	rm -rf *.o 
