// CS 172
// Grades 
// Lab11
// Written by: Victor Lozoya
// Nov. 7, 2016
//uses method from student class to print out students grades on two exams plus the average 


public class Grades //class grades 
{
   public static void main (String[] args)//start of main method 
   {
       Student student1 = new Student("Mary"); //create student 1 
       Student student2 = new Student("Mike");//create student 2
       
       student1.inputGrades();//calls inputgrades method for student 1 
       System.out.println("Student 1: " + student1);//prints student 1 plus the name 
       student1.getAverage();//calls getAverage method for student1 
       
       System.out.println(); //prints out line 
       
       student2.inputGrades();//calls input grades method for student 2 
       System.out.println("Student 2: " + student2); //prints student 2 plus name 
       student2.getAverage();//calls getAverage method for student 2
         
   }//end of main 
}//end of class