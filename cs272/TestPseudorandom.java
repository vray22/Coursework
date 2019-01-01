//Victor Lozoya 
//lab2
//CS272
//feb 2nd, 2017
//this program calls methods from Pseudorandom class to create objects and then test those methods
//ask user input for values of variables 

import java.util.Scanner;//allows input from user
 
public class TestPseudorandom {//start of class 
	private static Scanner scnr; //create new scanner 

	public static void main(String[] args) {
		
		//ask user to input the values and assigns to variables 
		scnr = new Scanner (System.in);
		System.out.println("Enter the values for the multiplier, seed, increment, and modulus");
		int mul = scnr.nextInt();
		int sd = scnr.nextInt();
		int inc = scnr.nextInt();
		int mod = scnr.nextInt();
		
		//creates new object test with variables the user entered as parameters 
		Pseudorandom test =  new Pseudorandom(mul,sd, inc, mod);
		
		//prints statements that call methods nextInt and nextDouble and print the values 
		System.out.println(test.nextInt());
		System.out.println(test.nextDouble()); 
		
	}//end of main
}//end of class 
