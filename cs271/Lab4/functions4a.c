/*
 * Victor Lozoya 
 * lab4a
 * will create two functions splitAlpha and printSequences
 * Date: March 14th 2017
 */


#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include "functions4a.h"



//will take original string and take upper and lower case letters and put them 
//in correct lower or upper string 
void splitAlpha(const char *original, char *lower, char *upper){
  int i = 0;
  int j = 0; 
  int k = 0; 
  size_t size = strlen(original);
  
  while(i < size){
     if(isalpha(original[i])){
        if(original[i] >= 'A' && original[i] <= 'Z'){
             upper[j] = original[i];
             j++;
           }//end if 
        else{
             lower[k] = original[i];
	      k++;
	}//end else 
    }//end if 
   i++;   
 }//end while 
}//end splitAlpha 



/*
 * will take array of strings and print sequences 
 * only will do sequences of digits or numbers 
 * @param:
 *       const char * 
 * will modify string accordingly 
 */
void printSequences(const char  *text){
     int i;
     int num, num2,num3;  
     size_t size2 = strlen(text);
     int j,k=0; 
     
     
     for(i = 0, j = 1; j < size2; i++,j++){
       
        //checks if is letter 
        if(isalpha(text[i]) && isalpha(text[j])){
          num = text[i];
          num2 = text[j];
	  
          if(num2 == num +1){
             if(k > 0){
              printf("%c", text[j]);
             }//end if 
             
             else{
               printf("%c", text[i]);
               printf("%c", text[j]);
               k++;
             }//end else  
             
           if(text[i+2] != '\0'){
                num3 = text[i+2];
                if(num3 != num2 +1){
                  printf("\n");
                  k = 0; 
                 }//end if 
              }  //end if 
          }//end outer if 
          
        }//end outer outer if 
        
        
        //check if is digit 
        else if(isdigit(text[i]) && isdigit(text[j])){
             num = text[i];
             num2 = text[j];
	     
             if(num2 == num +1){
                if(k > 0){
                  printf("%c", text[j]);
                }//end if 
                
                else{
                  printf("%c", text[i]);
                  printf("%c", text[j]);
                  k++; 
                 }//end else 
                 
               if(text[i+2] != '\0'){
                 num3 = text[i+2];
                 if(num3 != num2 +1){
                   printf("\n");
                   k = 0; 
                  }//end if 
                  
                }//end outer if 
            }//end outer outer if 
        }//end else if 
      
     }//end for 
     printf("\n"); 
     
} //end printSequences
            
