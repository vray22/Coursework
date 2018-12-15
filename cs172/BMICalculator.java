//CS172
//body mass index 
//Lab3
//Written by: Victor Lozoya 
//August 31, 2016
//Calculate body mass index using weight in pounds and height in inches 

import java.util.Scanner;

public class BMICalculator 
{
public static void main(String[] args) 
 { 
      int WeightInPounds=0;//intialize weightinpounds
      int HeightInInches=0;//intialize heightininches 
      int BMI; 
      
      Scanner scnr = new Scanner(System.in);
      System.out.println(" Enter WeightInPounds ");//ask user to enter weight 
      WeightInPounds = scnr.nextInt();
      
      Scanner scnr2 = new Scanner(System.in);
      System.out.println(" Enter HeightInInches ");//ask user to enter height 
      HeightInInches = scnr.nextInt();
      
      BMI = ((WeightInPounds * 703)/(HeightInInches * HeightInInches));//calculates BMI 
      System.out.println(" The BMI of a person weighing " + WeightInPounds + " pounds " + " with a height of " + HeightInInches + " inches is " + BMI) ; // prints out the calculations depending on weight and height 
      
      System.out.println(" BMI Values ");//prints out BMI values and different sections based on BMI
      System.out.println(" Underweight: less than 18.5 ");
      System.out.println(" Normal: between 18.5 and 24.9 "); 
      System.out.println(" Overweight: between 25 and 29.9 "); 
      System.out.println(" Obese: 30 or greater ");       
  }
 }   
      
      
