//CS172
//randomNumbers
//lab8
//written by: Victor Lozoya
//Oct.10
//generates random numbers and puts them in an array 

public class randomNumbers//title of class 
{
      public static void main(String[] args) 
      {
               int[] nums = new int [100];//creates array of 100 in doubles 
               
               for(int i = 0; i < 100; i++){//for loop that creates random number between 1 and 1000 using Math.random 
               nums[i]= (int) Math.floor(Math.random()*((1001) + 1));
               }
               
               
               
               for(int i = 0; i < 10; i++){//these next for loops help print numbers out in ten rows with then digits in each line 
               System.out.printf("%5d ", nums[i]);
               }
               System.out.println();
               
               for(int i = 10; i < 20; i++){
               System.out.printf("%5d ", nums[i]);
               
               }
               System.out.println();
               
               for(int i = 20; i < 30; i++){
               System.out.printf("%5d ", nums[i]); 
               }
               System.out.println();
               
               for(int i = 30; i < 40; i++){
               System.out.printf("%5d ", nums[i]);
               }
               System.out.println(); 
               
               for(int i = 40; i < 50; i++){
               System.out.printf("%5d ", nums[i]); 
               }
               System.out.println(); 
               
               for(int i = 50; i < 60; i++){
               System.out.printf("%5d ", nums[i]);
               }
               System.out.println();
               
               for(int i = 60; i < 70; i++){
               System.out.printf("%5d ", nums[i]);
               }
               System.out.println();
               
               for(int i = 70; i < 80; i++){
               System.out.printf("%5d ", nums[i]);
               }
               System.out.println();
               
               for(int i = 80; i < 90; i++){
               System.out.printf("%5d ", nums[i]);
               }
               System.out.println();
               
               for(int i = 90; i < 100; i++){
               System.out.printf("%5d ", nums[i]);
               }
               
              
             
               
               
      }//end of main 
}//end of class
