// CS172 
// type of egg grade 
// Lab5
// Written by: Victor Lozoya 
// Sept. 19, 2016 
// prints out type of egg grade 

import java.util.Scanner;//allows me to input scanner 
public class EggGrade//title of class
{
   public static void main(String[] args)
   {
         String eggGrade;//initializes eggGrade
         
         Scanner scnr = new Scanner(System.in);
         System.out.println(" Please enter a grade for eggs ");//prompts user to enter grade of eggs 
         eggGrade = scnr.nextLine();//eggGrade becomes input
         
         switch (eggGrade)//switch statement that prints out grade A if user enters a or A and prints out grade C if user enters C or c
            {
               case "A": System.out.println("Grade A");
                break;
                
               case "a": System.out.println("Grade A");
                break; 
               
               case "C": System.out.println("Grade C");
                break;
                
               case "c": System.out.println("Grade C");
                break;
               
               default: System.out.println("We only offer grade A and grade C");//if user enters something other than a, A, C, or c prints out we only offer grade A and C
                break;
            }//end of switch statement 
   }//end of main 
}//end of class
               
