//CS172
//MaxSum
//lab9
//written by: Victor Lozoya
//Oct.12
//finds the max sum in a 2d array 

import java.util.Scanner; //creates scanner 
public class MaxSum// title of class 
{

  public static void main(String[] args)
   {
            Scanner scnr = new Scanner(System.in);//reads new scanner 
            System.out.println("Enter the number of rows (1-15)? ");
            int lengthOfRows = scnr.nextInt();//ask user for number of rows and column and input becomes lenghtofrows and columns
            System.out.println("Enter the number of columns (1-15)? ");
            int lengthOfColumns = scnr.nextInt();//initialize my variables 
            int rowSum = 0;
            int colSum = 0;
            int maxRow = 0;
            int maxCol = 0;
            int maxSum = 0;
            
            int[][] array = new int [lengthOfRows][lengthOfColumns]; //creates new int array using lenghtOfRows and columns 
            System.out.println("Enter the elements of the array (row by row) ");//ask for elements of array
        
            
            for(int row = 0; row < lengthOfRows; row ++)//nested for loop that creates the 2d array with user input and stores the input into array 
            {
                       
                  
                  for(int column = 0; column < lengthOfColumns; column ++)
                  {
                    array[row][column] = scnr.nextInt();
                    System.out.print(array[row][column] + " " );
                  }//end of inner loop 
                  
                  System.out.println();
               
            }//end of outer 
            
            for(int row = 0; row < lengthOfRows; row++)//nested for loops with if statement that adds elements in row and checks if it  is the maxSum
            {
                rowSum = 0;
                 for(int column = 0; column < lengthOfColumns; column++)
                 {
                   
                        rowSum += array[row][column];
                 }//end of inner 
                 if(rowSum > maxSum)
                 {
                   maxSum = rowSum;
                   maxRow = row; 
                 }
            }//end of outer 
            
            for(int column = 0; column < lengthOfColumns; column++)//nested for loops that help add the elements of each column and checks if it is the max or not
            {
                 colSum = 0; 
                 for(int row = 0; row < lengthOfRows; row++)
                 {
                      colSum += array[row][column];
                 }//end of inner
                 if(colSum > maxSum)//if statement that checks if colSum is the maxSum
                 {
                    maxSum = colSum;
                    maxCol = column;
                 }
               

            }//end of outer 
            
                
          if(maxSum == rowSum)//prints out which row or column contains maximum sum using an if statement 
          {  
            System.out.println("R" +maxRow + "  contains maximum sum ");
          }
          else
            {
              System.out.println("C" +maxCol + " contains maximum sum ");
            }
            
            
          
    }//end of main 
}  //end of class