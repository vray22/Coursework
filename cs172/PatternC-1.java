// CS172 
// uses for loops to create a pattern     
// Lab7
// Written by: Victor Lozoya 
// Sept.28, 2016 
// prints pattern of star using for loops   
 
public class PatternC//title of class
{
   public static void main(String[] args)
   {
      for(int row = 1 ; row <= 10; row = row +1) //for loop that initializes row at 1 and checks if it is less than ten after it adds one to row 
      {
            for(int spc = 0; spc < row; spc++)//for loop initializes spc at zero and checks if spc is less than row after it adds one to spc
            {
               System.out.print(" ");//prints out space if true
            }
            
          {
                  for(int star = 10; star >= row; star--)//nested loop which initializes star at ten and checks if it is greater or equal to row than after subtracts one from star  
                  {
                     System.out.print("*");//prints out star 
                  }
          }//end of inner loop 
          
        System.out.println(); // jumps to new line 
      }//end of outer loop 
   }//end of main 
}//end of class 