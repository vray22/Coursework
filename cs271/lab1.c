//CS271 
//Program name: lab1
//Author:       Victor Lozoya 
//Date:         January 26th, 2017 
//Purpose:      program will ask for input of scores for exams and print out the scores,
//              average, and letter grade              

#include <stdio.h>
#include <math.h>

int main (void) {
   //declaration of variables 
   float score1, score2, score3, score4, average; 
   char letterGrade;

   //input the scores for exams 
   
   do{
      
      //ask for input from user to enter the score for exams
      printf("Enter the score for exam one\n"); 
      scanf("%f", &score1); 
      printf("\nEnter the score for exam two\n"); 
      scanf("%f", &score2); 
      printf("\nEnter the score for exam three\n"); 
      scanf("%f", &score3); 
      printf("\nEnter the score for exam four\n"); 
      scanf("%f", &score4); 
   
    if(!(score1 == -1 && score2 == 0 && score3 == 0 && score4 == 0)){
	
       //print exam scores 
       printf("Exam scores:  %.0f %.0f %.0f %.0f\n", score1, score2, score3, score4); 
	
       //calculate average 
       average = ((score1 + score2 + score3 + score4) / 4);
	
       //print average 
       printf("Average:      %.2f\n", average); 
	
	//if statements to figure out the letter grade for average   
	  if((average >= 0) && (average < 60)){
	    letterGrade = 'F';  
	  }
	  else if((average >= 60) && (average < 70)){
	    letterGrade = 'D';
	  }
	  else if((average >= 70) && (average < 80)){
	    letterGrade = 'C'; 
	  }
	  else if((average >= 80) && (average < 90)){
	    letterGrade = 'B';
	  }
	  else
	     letterGrade = 'A'; 
	  
       //print out the letter grade
       printf("Letter Grade: %c\n", letterGrade); 
       
     }//end of if statement 
	
   }while(!(score1 == -1 && score2 == 0 && score3 == 0 && score4 == 0));//end of loop 
    
   
}//end of main fucntion 