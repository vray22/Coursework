// CS172 
// Angles of triangle  
// Lab4
// Written by: Victor Lozoya 
// Sept. 7, 2016 
// prints out type of triangle based on angles

import java.util.Scanner;//allows me to input scanner 
public class Angles//title of class
{
public static void main(String[] args)
   {
         double angle1 = 0;//initialize angle1
         double angle2 = 0;//initialize angle2
         double angle3 = 0;//initialize angle3
         
         Scanner scnr = new Scanner(System.in);
         System.out.println(" Enter angle1 ");//ask user to enter angle1 
         angle1 = scnr.nextInt();//angle1 becomes what user inputs
         
         Scanner scnr2 = new Scanner(System.in);
         System.out.println(" Enter angle2 ");//ask user to enter angle2
         angle2 = scnr.nextInt();//angle2 becomes input 
         
         Scanner scnr3 = new Scanner(System.in);
         System.out.println(" Enter angle3 ");//ask user to enter side3
         angle3 = scnr.nextInt();//angle3 becomes input 
         
         if (angle1 + angle2 +angle3 > 180){//adds angle1, angle2, and angle3 and checks if sum is greater than 180
            
            System.out.println(" There is no such triangle ");//prints out there is no such triangle 
             }
            else if((angle1 == angle2) && (angle1 == angle3)){//checks if angle1 equals angle2 and angle3
         
            System.out.println(" The triangle is an acute angle triangle ");//prints type of triangle 
             }  
             
               else if (angle1 == angle2){//checks if angle1 equals angle2
         
            System.out.println(" The triangle is a right angle triangle ");//prints triangle is a right triangle 
             }   
             
                  else {
         
            System.out.println(" The triangle is an obtuse angle triangle ");//prints triangle is obtuse angle triangle 
             } 
             
      }
  } 
