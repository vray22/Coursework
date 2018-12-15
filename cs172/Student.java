// CS 172
// Student
// Lab11
// Written by: Victor Lozoya
// NOv. 7, 2016
// ************************************************************
// Student.java
//
// Define a student class that stores name, score on test 1, and
// score on test 2. Methods prompt for and read in grades,
// compute the average, and return a string containing student's info.
// ************************************************************
import java.util.Scanner;//allows input scanner 
public class Student//title of class 
{
   double scoreTestOne, scoreTestTwo;//declare instance data
   String Name; 
   Scanner scan = new Scanner(System.in);//allows new scanner 
// ---------------------------------------------
//constructor
// ---------------------------------------------
   public Student(String studentName)
  {
    Name = studentName; //add body of constructor
  }//end of constructor 
// ---------------------------------------------
//inputGrades: prompt for and read in student's grades for test1 and test2.
//Use name in prompts, e.g., "Enter's Joe's score for test1".
// ---------------------------------------------
   public void inputGrades()
   {
   
       System.out.println("Enter " + Name +"'s" +" grade for test one ");//add body of inputGrades
       scoreTestOne = scan.nextInt(); 
   
      System.out.println("Enter " + Name +"'s" +" grade for test two ");//ask user to input grades for test one and two 
      scoreTestTwo = scan.nextInt();  
   }//end of input grades 
// ---------------------------------------------
//getAverage: compute and return the student's test average// ---------------------------------------------
    public double getAverage()//add header for getAverage
    {
       double average; 
       average = (scoreTestOne + scoreTestTwo) / 2; //add body of getAverage
       System.out.println("The average for " + getName() + " is " + average);//prints average is plus uses getName() method to display average 
       return average; 
    }//end of getAverage 
// ---------------------------------------------
//getName: return the student's name
// ---------------------------------------------
   public String getName()//add header for getName
    {
       return Name; //add body of getName
    }//end of getName

   public String toString()//toString method which prints in this form everytime system.out.print if found in java 
    {
      return (Name + " Test1: " + scoreTestOne + " Test2: " + scoreTestTwo); 
    }//end of toString 
}// end of class student 