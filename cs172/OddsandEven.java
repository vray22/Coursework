// CS 172 
// OddsandEven  
// lab8 
// Written by: Victor 
// Oct.5
// input integers and sort them in an array print out even and odds

import java.util.Scanner//allows me to enter scanner 
public class OddsandEven//title of class
{
   public static void main(String[] args)
   {
   
         Scanner scnr = new Scanner(System.in);//allows new scanner to be inputted 
         int evenNums;
         int[] nums = new int[10];//creates array of 10 elements 
         
         for(int i = 0; i < 10; i++){//for loop that assigns user input to array indexes 
         System.out.println("Enter a number ");
         nums[i] = scnr.nextInt();
         }
         
         System.out.print("Odd Numbers: "); //prints out odd numbers
         
         for(int i = 0; i < 10; i++){//for loop to check if numbers are odd
         
            if(nums[i] % 2 != 0){
            System.out.print(nums[i] + " " + " ");
            }
            
         }
         
         System.out.println();
         
         System.out.print("Even Numbers: ");//prints out even numbers
         
         for(int i = 0; i < 10; i++){//for loop to check if number is even and prints it out 
         
            if(nums[i] % 2 == 0){
            System.out.print(nums[i] + " " + " " ); 
            }
         }
            
          
         
         
   }//end of main 
}//end of class
   
            
