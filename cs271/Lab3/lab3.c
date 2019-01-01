#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "textfunctions.h"

int main (void){

  char line[80];
  int count;
  FILE *cfPtr;
  if ( (cfPtr = fopen( "lines.dat", "r" )) == NULL) {
     puts( "File could not be opened\n");
  }
  else {
     fgets( line, 80, cfPtr );
     
     while ( !feof( cfPtr ) ) {
       size_t size = strlen(line); 
       line[size-1] = '\0';
       
       printf( "Line Read: %s\n\n", line );
       //removePunctuation(line);
       stringSort(line); 
       printf("%s \n", line);
       fgets( line, 80, cfPtr );
       
     } // end while
     
     fclose ( cfPtr );
  } // end else
}
  
  /*char array[] = "V!CT!Rso!fr?esh";
  removePunctuation(array);  
  printf("%s", array);
  printf("\n");
  
  char array2[] = "Yo I am me!"; 
  wordPrint(array2); 
  printf("\n");
  
  char array3[] = "Java Programming";
  blockPrint(array3); 
  printf("\n"); 
  
  char array4[] = "bbb rrr aaa";
  stringSort(array4);
  printf("%s", array4); 
  printf("\n");

} // end main
*/

