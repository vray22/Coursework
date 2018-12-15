//Lab2.java
//CS172-MO3
//written by Victor Lozoya 
//date written: August 24, 2016
//This program calculates the area of a rectangle 
//Input: Height and Width
//Output: area 

import java.util.Scanner;
 

public class Lab2
{
public static void main(String[] args) 
 { 
    int height=0;
    int width=0;
    int area;
     Scanner scnr = new Scanner(System.in);
     System.out.println(" Enter height ");
     height= scnr.nextInt();
     
     System.out.println(" Enter width " );
     width= scnr.nextInt();
    area= height*width;
    System.out.println(" The area of a rectangle with height "+ height + " and width " + width + " is " + area);
     }
   }