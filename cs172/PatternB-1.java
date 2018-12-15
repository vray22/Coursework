// CS172 
// uses for loops to create a pattern     
// Lab7
// Written by: Victor Lozoya 
// Sept.28, 2016 
// prints out number of occurance and sum of all digits  
 
public class PatternB//title of class
{
   public static void main(String[] args)
   {
      for(int row = 1 ; row <= 10; row = row +1) //for loop that initializes row at 1 and checks if it is less than ten after it adds one to row 
      {
            for(int spc = 10; spc > row; spc--)//for loop initializes spc at ten and checks if spc is greater than row after it subtracts one from spc
            {
               System.out.print(" ");//prints out space if true
            }
            
          {
                  for(int star = 1; star <= row; star++)//nested loop which initializes star at one and checks if it is less or equal to row than after adds one to star  
                  {
                     System.out.print("*");//prints out star 
                  }
          }//end of inner loop 
          
        System.out.println(); // jumps to new line 
      }//end of outer loop 
   }//end of main 
}//end of class 
                  
         
