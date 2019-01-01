/**
 * Victor Lozoya 
 * Lab8 
 * will use a recursive method to play a guessing game with the user 
 * create one method and test in main 
 * Date: 4/20/17
 */

import java.util.Scanner;
public class guessingGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println("Guess a number between 1 and 1,000,000");
        Scanner scan = new Scanner(System.in);
        int l = 1;
        int h = 1000000;
        guessNum(l, h);
        }
	
	/**
	 * 
	 * @param low int value 
	 * @param high int value 
	 * guessing number has to be in range of low and high 
	 * if they are equal than method returns 
	 * if number is guessed than it is returned 
	 */
	
	public static void guessNum(int low, int high){
		Scanner scan2 = new Scanner(System.in);
		
		if(low == high){//base case 
			return; 
		}
		
		if(low < high){
			int midPoint = (low + high) /2;
			System.out.println("Is midPoint " + midPoint + " your number yes/no?: 1 for yes, 0 for no ");
			int answer = scan2.nextInt();
			
			if(answer == 1){
				return;
			}
			
			else{
				System.out.println("Is the correct number greater than midpoint? 1 for yes, 0 for no " );
				int answer2 = scan2.nextInt();
				
				if(answer2 == 1){
					guessNum(midPoint+1, high);//higher than midpoint 
				}
				
				else{
					guessNum(low, midPoint-1);//lower than midpoint 
				}//end else 
				
			}//end else 
		}//end if 
		
	
		
		
	}//end guessNum method 

}//end class
