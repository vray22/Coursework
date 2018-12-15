// CS172 
// Sides of triangle  
// Lab4
// Written by: Victor Lozoya 
// Sept. 7, 2016 
// prints out type of triangle based on sides

import java.util.Scanner;//allows me to input scanner 
public class Sides
{
public static void main(String[] args)
   {
         double side1 = 0;//initialize side1
         double side2 = 0;//initialize side2
         double side3 = 0;//initialize side3
         
         Scanner scnr = new Scanner(System.in);
         System.out.println(" Enter side1 ");//ask user to enter side1 
         side1 = scnr.nextInt();//side1 becomes what user inputs
         
         Scanner scnr2 = new Scanner(System.in);
         System.out.println(" Enter side2 ");//ask user to enter side2
         side2 = scnr.nextInt();//side2 becomes input 
         
         Scanner scnr3 = new Scanner(System.in);
         System.out.println(" Enter side3 ");//ask user to enter side3
         side3 = scnr.nextInt();//side3 becomes input 
         
         
         if ((side1 == side2) && (side1 == side3)) {//compares side1 to side2 and side3
               
              System.out.println(" Triangle is a equilateral triangle ");//if side1 equals side2 and side3 prints triangle is equilateral
               }
               
         else if (side1 == side3) {// if firststatement isn't true compares side1 to side3
         
               System.out.println(" Triangle is a isosceles triangle ");//if side1 equals side3 prints triangle is isosceles 
                } 
                
         else {
               System.out.println(" Triangle is a scalene triangle ");//if both statements fail then prints triangle is scalene
                } 
       }
  }  
