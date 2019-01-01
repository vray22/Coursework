//CS271 
//Program name: lab2
//Author:       Victor Lozoya 
//Date:         Feb 14th, 2017 
//Purpose:      program that creates functions that will be called in a main function 
              

#include "lab2functions.h"
#include <stdio.h>
#include <ctype.h>

//function that takes in two parameters of an array and the size
//prints the elements of the array right aligned and 10 per line
void printIntarray(int array[], int size){
int p;
for(p = 0; p < size; p++){
     if(p > 0 && p % 10 == 0){
     printf("\n");
    }
  printf("%5d ", array[p]);
  }
  printf("\n");
}

//function that takes in two parameters of a char array and its size
//then it prints the elements with a space between and 10 per line 
void printCharArray(char array[], int size){
int p;

for(p = 0; p < size; p++){
  if(p > 0 && p % 10 == 0){
    printf("\n");
   }
   printf("%c ", array[p]);
  }
  printf("\n");
}

//function that takes in an array of type int and size
//prints out the minimum value of the array 
int arrayMin(int array[], int size){
  int minVal = array[0]; 
  int p; 
  int count; 
  for(p = 1; p < size; p++){//for loop to go through array 
    if(array[p] < minVal)
      minVal = array[p];
  }//end for
  printf("The smallest value is %d ", minVal);
  printf("\n");
  return minVal; 
  
}
 //function that takes an character array and its size as parameters
 //prints out how many letters are stored in the array 
int countLetters(char array[], int size){
  int p; 
  int count = 0; 
  for(p = 0; p < size; p++){//use for loop to go through array 
    if (isalpha(array[p])){//use isalpha to check if element at array of index is a letter 
      count++; 
    }//end of for 
  }
  printf("The number of letters in array is %d ", count);
  printf("\n\n");
  return count; 
}

//function that takes in 2 integer arrays and their size
//prints out how many elements match in the arrays 
//must be arrays of same size 
int numMatches(int array[], int array2[], int size){
  int p, c;
  int count = 0;
  for(p = 0; p < size; p++){
      for(c = 0; c < size; c++){
	if(array[p] == array2[c])
	  count++;
      }
  }
  printf("Elements that match are %d ", count);
  printf("\n");
  return count; 
}


