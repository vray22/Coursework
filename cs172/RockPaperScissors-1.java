// CS172 
// uses for loops to play game    
// Lab7
// Written by: Victor Lozoya 
// Sept.28, 2016 
// plays game with computer printing out results 

import java.util.Scanner;//allows me to input scanner 
import java.util.Random;//allows random class   
 
public class RockPaperScissors//title of class
{
   public static void main(String[] args)
   {
            int choice = 0;//initializes my multiple variables 
            int win = 0;
            int loss = 0;
            int tie = 0;
            String ans = "";
            String ans1 = "";
            String ans2 = "";
            String quit = "n";
            String play = "y";
           
            
            Random randNum = new Random();
            int ran_Choice = randNum.nextInt(3) + 1;//initializes random number 
            Scanner scnr = new Scanner(System.in);//creates new scnr
         
             
            do//do statement that has computer play game with user 
            {
            System.out.println("Enter your choice 1 for rock, 2 for paper, 3 for scissors ");//ask user to chose rock paper or scissors 
            choice = scnr.nextInt();// choice becomes input
            
           if (ran_Choice == 1)//ans1 becomes either paper rock or scissors depending on number 
               ans1 = "rock";
            else if (ran_Choice == 2)
               ans1 = "paper";
            else 
               ans1 = "scissors"; 
               
           if (choice == 1)//choice becomes either rock paper or scissors depending on number 
               ans = "rock";
              else if (choice == 2)
                 ans = "paper";
              else 
                ans = "scissors"; 
               
           
           if(ran_Choice == choice){//checks if ran_Choice is the same as choice adds one to tie 
               System.out.println("We tied " + "we both guessed " + ans);
               tie++;
               }
            else if(choice == 1){//compares choice if it is rock adds one to loss and win 
                  if(ran_Choice == 2)
                  {
                     System.out.print("I won , my choice was " + ans1);
                  loss++;
                  }
                 else 
                  {
                    System.out.println("you won my choice was " + ans1);
                  win++;
                  }
               }
           else if(choice == 2){//compares choice if it is paper and adds one to loss and win
                  if(ran_Choice == 1)  
               {
               System.out.println("you won my choice was " + ans1);
               win++;
               }
                 else
                  {
                   System.out.println("I won my choice was " + ans1);
                   loss++;
                   }
              }
            else if (choice == 3){//compares choice if it is scissors to ran_Choice adds one to loss or win
                  if(ran_Choice == 1){
                  System.out.println("I won my choice was " + ans1);
                  loss++;
                  }
                  else 
                  {
                  System.out.println("you won my choice was " + ans1);
                  win++;
                  }
              }
              
              Scanner scnr2 = new Scanner(System.in); 
              System.out.println("Play again y/n ");//ask user if he wants to play again 
              scnr.nextLine();
              ans2 = scnr.nextLine();
              
              
              
              
                }while(!ans2.equals(quit));//condition expression while ans2 doesn't equal quit
                
                System.out.println("You won " + win + " times ");//prints out how many times you lost, won, and tied
                System.out.println("We tied " + tie + " times ");
                System.out.println("You lost " + loss + " times ");
                
                
                
  }//end of class
}//end of main 