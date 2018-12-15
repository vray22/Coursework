// CS172 
// count number occurance for certain digits in a integer    
// Lab6
// Written by: Victor Lozoya 
// Sept.21, 2016 
// prints out number of occurance and sum of all digits  

import java.util.Scanner;//allows me to input scanner 
public class CountNumber//title of class
{
   public static void main(String[] args)
   {
         int num5 = 0 ;// intitializes my variables 
         int num7 = 0 ;
         int numValue = 0 ;
         int digit = 0;
         int sum = 0;
         Scanner scnr = new Scanner(System.in);//creates new scnr
         System.out.println("Enter an integer value");
         numValue = scnr.nextInt();// numValue becomes input
         
         
         
         while (numValue != 0){//while loop that checks if numValue is equal to zero
               digit = numValue % 10; //digit becomes last digit 
               numValue = numValue / 10;//numValue becomes numValue without last digit 
                
               if (digit == 5 || digit == -5)//if statements that add 1 to num5 and num7 if digit equals 5 or 7
                 { 
                  num5++;
                 }
               else if (digit == 7 || digit ==-7)
               {
                 num7++;
               }
               
                 
                   sum = sum + digit;//adds digit to sum  
                 
               
              }
              
              if (sum < 0)//if sum is less than zero multiplies it by -1 to get positive sum 
                {
                  sum = -(sum); 
                }
               
               
               System.out.println("Occurance of number 5: " + num5 );//prints occurance of num7 and num5
               System.out.println("Occurance of number 7: " + num7);
               System.out.println("Sum of all digits: " + sum);//prints out sum
              
                  
                  
                
               
               
                  
                 
                  
               
            }//end of main 
    }//end of class
                  
         
         
