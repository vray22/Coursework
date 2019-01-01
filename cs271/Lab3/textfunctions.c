//Victor Lozoya 
//Lab3 working with strings 
//march 2nd 2017
//this program will do different things with strings depending on the function called


#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "textfunctions.h"
//will take the string and remove punctuation and shift all elements down 
void removePunctuation(char *s){
  int i; 
  int j;
  int k;
  
  size_t size = strlen(s); 
 
  
  for(i = 0; i <= size; i++){
    if(ispunct(s[i]))
      for(k = i; k <= strlen(s); k++){
        s[k] = s[k+1];
	
     }//end inner for
     
    
 }//end outer for 
  
}//end removePunctuation

//will print each word one new line depending on spaces
void wordPrint(const char *p){
  int i; 
  for(i = 0; p[i] != '\0'; i++){
    if(!isspace(p[i])){
      printf("%c", p[i]);
    }//end if
    else
      printf("\n"); 
  }//end for 
}//end wordPrint

//will print each character on new line and if the next one is the same 
//then it will print it along with the previous character 
void blockPrint(const char *p){
  int i; 
  for(i = 0; p[i] != '\0'; i++){
    printf("%c", p[i]); 
    if(p[i+1] != p[i]){
      printf("\n"); 
    }//end if
  }//end for 
}// end blockPrint 

//first I remove the spaces from this string 
//then I sort them in descending order 
void stringSort(char *q){
  int i, j, k; 
  char temp; 
  size_t size = strlen(q); 
  
   for(i = 0; i < size; i++){
    if(isspace(q[i]))
      for(k = i, j = i+1; j < size || q[j] == '\0'; k++, j++){
        q[k] = q[j];
     }//end inner for
    
 }//end outer for

 
  size_t size2 = strlen(q); 
  for(i = 0; i < size2; i++){
    for(j = i+1; j < size2; j++){
      if(q[i] > q[j]){
	temp = q[i]; 
	q[i] = q[j];
	q[j] = temp; 
      }//end if
    }//end inner for
  }//end outer for 
}//end stringSort 

  

