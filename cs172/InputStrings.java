//CS172
//InputStrings
//lab8
//written by: Victor Lozoya
//Oct.10
//creates array of strings 25 elements and assigns user input to them

import java.util.Scanner; // allows for input from user  

public class InputStrings//title of class 
{ 
   public static void main(String[] args)
   {
         int count = 0; 
          
         Scanner scnr = new Scanner(System.in);//allows new scanner to be inputted
         String input = "";
         String[] array  = new String [25];//creates array of strings with 25 elements
         
         for(int i = 0; i < 25; i++){//for loop that goes throughout array 
            System.out.println("Enter a string ");//ask user to enter string  
            input = scnr.nextLine();
            if(input.equals("quit")){//if input is quit breaks loop 
              break;
            }
            array[i] = input;//adds input to array 
            count++;//increments count 
           }
        
        for(int i = count -1; i >= 0; i--){//for loop that prints strings entered stored in array 
            System.out.print(array[i] + " ");
       }
  }//end of main 
}//end of class 
   
         