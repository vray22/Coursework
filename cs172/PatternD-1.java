// CS172 
// uses for loops to create a pattern     
// Lab7
// Written by: Victor Lozoya 
// Sept.28, 2016 
// prints pattern of star using for loops   
 
public class PatternD//title of class
{
   public static void main(String[] args)
   {
   
         for(int row = 1; row < 10; row += 2)//initializes row at 1 
         {
            for(int spc = 3; spc < 9 - row / 2; spc++)//for loop initializes spc at zero and checks if spc is less than row after it adds one to spc
            {
               System.out.print(" ");//prints out space if true
            }
            
          {
                  for(int spc = 0; spc < row; spc++)//nested loop which initializes star at ten and checks if it is greater or equal to row than after subtracts one from star  
                  {
                     System.out.print("*");//prints out star 
                  }
          }//end of inner loop 
          
        System.out.println(); // jumps to new line 
      }//end of outer loop 
      
      
   
         for(int row = 1; row < 10 ; row += 2){//initializes row at 1
         
            for(int spc = 10; spc >= 9 - row / 2; spc--)//creates bottom part of diamond initializes space at 10 and decriments for loop prints out spaces  
            {
               System.out.print(" ");
            }
            
                for(int spc = 10; spc > row; spc--)//for loop to print out stars 
              {
               System.out.print("*");
              }//end of inner loop 
           
          System.out.println();
       } //end of outer 
         
    }//end of main 
}//end of class  
          
