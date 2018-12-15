//CS172
//Multiplication 
//lab9
//written by: Victor Lozoya
//Oct.12
//creates multiplication card using a 2d array  

import java.util.Scanner; //allows to input scanner
public class Multiplication // title of class
{ 
   public static void main(String[] args) 
   {
           Scanner scnr = new Scanner(System.in);//reads new scanner
          
           
           System.out.println("Enter the number of rows (1-15) ");//ask user to enter number of rows which becomes lengthofrows
           int lengthOfRows = scnr.nextInt(); 
           System.out.println("Enter number of columns (1-15) "); //ask user to enter number of columns which becomes lengthofcolumns
           int lengthOfColumns = scnr.nextInt();
           
           int[][] array = new int [lengthOfRows][lengthOfColumns]; //creates new integer type 2 dimensional array using lengthofrows and columns  
           
           for(int row = 0; row < lengthOfRows; row++)//uses nested for loop to create array 
           {
              for(int column = 0; column < lengthOfColumns; column++)
              {
                 array[row][column] = (row + 1)*(column + 1); 
                 
              }//end of inner loop 
           }//end of outer loop 
           
            
           System.out.printf("    ");//prints out the top column numbers with 4 spaces 
           for(int i = 1; i <= lengthOfColumns;i++){ 
           System.out.printf("%4d", i);
           }//end of loop
           
           for(int row = 0; row < lengthOfRows; row++)//nested for loop to create the inside of the array with the number of rows along the right  
           {
                System.out.println();
                System.out.printf("%4d", row+1);
              for(int column = 0; column < lengthOfColumns; column++)
              {
                 System.out.printf("%4d", array[row][column]);
                  
               }//end of inner 
              
           } //end of outer 
           
   }//end of main
}//end of class 
            