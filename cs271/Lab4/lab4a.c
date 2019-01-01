/*
 * Victor Lozoya 
 * program will test my printSequences and splitAlpha functions 
 * lab4a 
 * CS271 
 * Date: March 14th 2017 
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "functions4a.h"

int main (void){
   //will create array of strings and test splitalpha 
   char array[] = "TESt iiYO";
   size_t size = strlen(array);
   char lower[10];
   char upper[10];
   splitAlpha(array, lower,  upper);
   printf("String is: "); 
   printf("%s \n", array); 
   printf("lower: %s \n", lower);
   printf("upper: %s \n", upper);
   
   //will create another array of strings and test splitAlpha
   char array4[] = "This is Another Test"; 
   char lower2[21];
   char upper2[21]; 
   splitAlpha(array4, lower2, upper2); 
   printf("String is: %s \n", array4); 
   printf("lower: %s \n", lower2); 
   printf("upper: %s \n", upper2);
   
   //will create new array of strings and test printSequences
   char array2[] = "abck123@XYZ";
   printf("String is: %s \n", array2);
   printf("Sequence is: \n"); 
   printSequences(array2); 
   
   //will create new array of strings and test printSequences
   char array3[] = "aBcD345";
   printf("String is: %s \n", array3); 
   printf("Sequence is: \n"); 
   printSequences(array3); 
   
}//end class 
