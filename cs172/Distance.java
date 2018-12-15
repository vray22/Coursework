//CS172
//distance between two coordinate points 
//Lab3
//Written by: Victor Lozoya 
//August 31, 2016
//Calculate distance of two points 

import java.util.Scanner;
import java.lang.Math;

public class Distance // Class of distance 
{
public static void main(String[] args) 
 { 
         int x1;// initialize x1
         int y1;// initialize y1
         int x2;// initialize x2
         int y2;// initialize y2
         double distance;// initialize distance as a floating number 
         
         Scanner scnr = new Scanner(System.in);
         System.out.println(" Enter x1 ");// ask user to enter x1
         x1 = scnr.nextInt();// x1 becomes what user enters 
         
         Scanner scnr2 = new Scanner(System.in);
         System.out.println(" Enter y1 "); // ask user to enter y1
         y1 = scnr.nextInt(); //y1 becomes what user enters 
       
         Scanner scnr3 = new Scanner(System.in); 
         System.out.println(" Enter x2 ");//ask user to enter x2
         x2 = scnr.nextInt();//x2 becomes what user enters 
         
         Scanner scnr4 = new Scanner(System.in);
         System.out.println(" Enter y2 ");//ask user to enter y2
         y2 = scnr.nextInt();//y2 becomes what user enters
         
         distance = Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));// Formula that calculates the distance of the two points 
         System.out.println(" The distance between " + "(" + x1 + "," + y1 + ") and " + "(" + x2 + "," + y2 + " ) is " + distance ) ;// finally statement giving distance of the two points    
         
         
         
      }
}         
         
         
         