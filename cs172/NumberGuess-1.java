// CS172 
// guess random number  
// Lab6
// Written by: Victor Lozoya 
// Sept.21, 2016 
// prints out if guess is right or not until it is 

import java.util.Scanner;//allows me to input scanner 
import java.util.Random;//allows random class
public class NumberGuess//title of class
{
   public static void main(String[] args)
   {
         
         
         int guessNum = 1;//initialize guessNum and count 
         int count = 0;
         Random randNum = new Random(); //creates randNum 
         Scanner scnr = new Scanner(System.in);//creates new scnr
         int ran_Num = randNum.nextInt(100) + 1;// chooses number between 1 and 100
         
         
         
         while (guessNum != 0){//while loop that checks if number is 0, less, higher, or equal to ran_Num
            System.out.println(" Please enter your guess ");//prompts user to guess number 
            guessNum = scnr.nextInt();//guessNum becomes input  
            count++;
            
            if ( guessNum == 0){
               System.out.println("Good-bye");//exits loop 
               }
            else if (guessNum < ran_Num){
               System.out.println("Higher");//prints higher guess
               }
            else if (guessNum > ran_Num){
               System.out.println("Lower");//prints lower guess
               }
            else if (guessNum == ran_Num){
               System.out.println("Correct!");//prints correct 
               guessNum = 0;
               System.out.println("It took you " + count + " guesses ");//tells you how many guesses it took 
               }
               
            
             }
               
               
            
            
            
            
          
        
        
         
         

         
   }//end of main 
}// end of class 
         
      
         
   
         
