//CS172
//HammingDistance
//lab9
//written by: Victor Lozoya
//Oct.12
//computes hamming distance between two arrays 

import java.util.Scanner;

public class HammingDistance// title of class 
{

   public static void main(String[] args)
   {
            
            Scanner scnr = new Scanner(System.in);//allows input from user 
            System.out.println("Enter size of arrays ");//prompts user to enter size of arrays and int sizeArray because input 
            int sizeArray = scnr.nextInt();
            int count = 0; 
            
            int[] array1 = new int [sizeArray];//creates both array one and 2
            int[] array2 = new int [sizeArray];
            
            
            
            System.out.println("Enter elements of 1st array ");//ask user to enter elements of array and stores into array 
            for(int i = 0; i < sizeArray; i++){ 
               array1[i] = scnr.nextInt(); 
            }
            
            System.out.println("Enter elements of 2nd array "); //ask user to enter elements of second array and stores into array 
            for(int i = 0; i < sizeArray; i++){
               array2[i] = scnr.nextInt(); 
            }
            
            for(int i = 0; i < sizeArray; i++){//checks if the elements in array are the same if not it increments count 
               if(array1[i] != array2[i]){
                  count++;
              }
             }
             
          System.out.println("The hamming distance is " + count); //prints out the hamming distance  
             
  }//end of main 
} //end of class
            
         