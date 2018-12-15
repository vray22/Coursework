// CS 172
// FirTree
// Lab10
// Written by: Victor Lozoya
// Oct 26. 2016
// Create a fir tree using a character and level entered by user 

import java.util.Scanner; //allows user input 
public class firTree//title of class
{
      public static void main(String[] args)
      {
               Scanner reader = new Scanner(System.in);//reads new scanner
               Scanner scnr = new Scanner (System.in);//reads new scanner  
               System.out.println("Enter a character you want to use: ");//ask user to enter character 
               char userChar = reader.next().charAt(0); //userChar becomes user input 
               
               System.out.println("Enter number of levels in tree ");//ask user to enter number of levels in tree and numLevels becomes input
               int numLevels = scnr.nextInt();
               
               for(int n = 1; n <= numLevels; n++){//for loop that calls for printLevel method
               printLevel(userChar, n);
               }//end of loop  
      }//end of main 
      public static void printLevel(char c, int n)// printLevel method 
      {
         for(int line = 1; line <= n + 1; line++){//nested for loops that print the line with spaces and the characer on each line
          for(int space= 0; space <= 31 -(line*2); space++){
           System.out.print(" ");
           }//end of inner 
            for(int chr = 0; chr < 4*(line - 1) + 1; chr++){
             System.out.print(c); 
            }//end of inner inner loop 
           System.out.println("");
          }//end of outer loop  
      }//end of main 
      
}//end of class