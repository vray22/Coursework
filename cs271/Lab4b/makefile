all: Lab4B
Lab4B: BankAccount.o lab4b.o
	g++ -o Lab4B BankAccount.o lab4b.o
lab4b.o: lab4b.cpp BankAccount.h
	g++ -c lab4b.cpp
BankAccount.o: BankAccount.cpp BankAccount.h
	g++ -c BankAccount.cpp
clean: 
	rm -rf *.o