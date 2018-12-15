// CS172 
// Leap year or not  
// Lab4
// Written by: Victor Lozoya 
// Sept. 7, 2016 
// prints out if year is leap year or not 

import java.util.Scanner;//allows me to input scanner 
public class LeapYear//title of class
{
   public static void main(String[] args)
   {
   
        int year=0;//initialize 
        
        Scanner scnr = new Scanner(System.in);
        System.out.println(" Enter year ");//prompts user to enter year 
        year = scnr.nextInt();//year becomes input 
        
        if(year < 1582)//checks if year is less than 1582
            System.out.println(" ERROR: not valid in Gregorian calendar ");//prints ERROR if year is less than 1582
             
        else if(year % 100 ==0){//check if year is evenly divisable by 100
            if(year % 400==0)//checks if year is also evely divisable by 400
                  System.out.println( year + " is a leap year");//prints year is a leap year 
      
            else
                  System.out.println( year + " is not a leap year");//states year isn't a leap year            
        }
             
           
        else if(year % 4 == 0)//checks if year is evenly divisable by 4 
            System.out.println( year + " is a leap year");//prints year is a leap year  
        
            else
               System.out.println( year + " is not a leap year");//prints leap year is not a leap year 
  
  
            
        
             
    
   }
}       