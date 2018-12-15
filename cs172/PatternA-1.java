// CS172 
// uses for loops to create a pattern     
// Lab7
// Written by: Victor Lozoya 
// Sept.28, 2016 
// prints out number of occurance and sum of all digits  
 
public class PatternA//title of class
{
   public static void main(String[] args)
   {
      for(int row = 1 ; row <= 10; row = row +1) //for loop that initializes row at 1 and checks if it is less than ten after it adds one to row 
      {
         for(int star = 10; star >= row; star--)//nested for loop that initializes star to ten and checks if it is greater than row after it subtracts 1 from star
           {
               System.out.print("*");//prints out star 
           }
           
           System.out.println();//jumps to next line
       }//end of outer loop 
   }//end of main 
}//end of class 