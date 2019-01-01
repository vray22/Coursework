//CS271 
//Program name: lab2
//Author:       Victor Lozoya 
//Date:         Feb 14th, 2017 
//Purpose:      program will call functions from lab2functions and test them passing in the needed parameters 
                 



#include "lab2functions.h"
#include <stdio.h>
int main (void){
  
  //this statements will call the printIntarray function 
  //declare three arrays of type int
  int myArray[] = {32, 45, 55, 67, 65};
  int myArray2[] = {45, 76, 88, 99, 23, 5, 7, 8, 8, 3, 4, 5, 5, 6, 7, 8, 5, 56, 45, 67};
  int myArray4[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22,
  23, 24, 25, 26, 27, 28, 29, 30};
  
  printf("This is first test for printIntarray \n");
  printIntarray(myArray2, 20);//this will print an array of 20 elements 
  printf("\n");
  int size = 5;
  printf("This is the second test for printIntarray \n");
  printIntarray(myArray, size);//this will print array of five elements
  printf("\n"); 
  printf("This is the third test for printIntarray \n"); 
  printIntarray(myArray4, 30);//this will print array of 30 elements 10 per line
  printf("\n\n"); 

  //these statements will test printCharArray 
  
  //create char arrays that will be used to call functions 
  char charArray[] = {'v', 'i', 'c', 't', 'o', 'r'};
  char charArray3[] = {'b', 'a', 'l', 'l', 'i', 'n', 'g', 's', 't', 'a', 't', 'u', 's', 'a', 'l', 'l', 'd', 'a', 'y',
    's', 'u', 'c', 'k', 'e', 'r'};
  char charArray4[] = {'s', 'o', 'f', 'r', 'e', 's', 'h','5'}; 
  int sizeChar = 6;
  
  //these statments call the printCharArray
  printf("This is the first test for printCharArray \n"); 
  printCharArray(charArray, sizeChar);
  printf("This is the second test for printCharArray\n");
  printCharArray(charArray3, 25);
  printf("This is the third test for printCharArray \n"); 
  printCharArray(charArray4, 8);
  printf("\n\n");
  
  //these next statements will call and test arrayMin function
  printf("First test call for arrayMin: \n");
  arrayMin(myArray, size); 
  printf("Second test call for arrayMin: \n");
  arrayMin(myArray2, 20);
  printf("Third test call for arrayMin: \n");
  arrayMin(myArray4, 30);
  printf("\n\n"); 
  
  //These statements will call and test countLetters function 
  char charArray2[] = {'v', '2', '3', 'i', 'c'};
  char charArray5[] = {'8', '3', 't', '$', 'v'};
  printf("First test call to countLetters: \n");
  countLetters(charArray2, size);
  printf("Second test call to countLetters: \n");
  countLetters(charArray4, 8);
  printf("Third test call to countLetters: \n"); 
  countLetters(charArray5, 5); 

  //These statements will call and test teh numMatches function 
  int myArray3[] = {32, 44, 55, 67, 60};
  int myArray5[] = {33, 44, 55, 67, 80};
  printf("First call to numMatches function: \n");
  numMatches(myArray, myArray3, size);
  printf("Second call to numMatches function: \n");
  numMatches(myArray3, myArray5, 5);
  printf("Third call to numMatches function: \n");
  numMatches(myArray, myArray5, 5);
  
}//end main 




