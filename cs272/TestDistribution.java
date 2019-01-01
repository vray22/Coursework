//Victor Lozoya
//lab2
//CS272
//this program calls methods from Pseudorandom class to create objects and then test those methods
//ask user input for values of variables and uses for loop iterate one million  times 


import java.util.Scanner;//allows input from user 
public class TestDistribution {//start of class TestDistribution 
	private static Scanner scnr; //creates new scanner 

	public static void main(String[] args) {//start of main 
		scnr = new Scanner (System.in);
		
		//ask user to input values for variables 
		System.out.println("Enter the values for the multiplier, seed, increment, and modulus");
		//create objects and stores input value to them 
		int mul = scnr.nextInt();
		int sd = scnr.nextInt();
		int inc = scnr.nextInt();
		int mod = scnr.nextInt();
		
		//creates new object test using the input values from user as parameters 
		Pseudorandom test =  new Pseudorandom(mul,sd, inc, mod);
		
		//creates counts for the ten different intervals 
		int count1 = 0, count2 = 0, count3 = 0, count4 = 0, count5 = 0, count6 = 0, count7 = 0, count8 = 0, count9 = 0, count10 = 0;
		double psRan;//new variable Pseudo random number 
		
		//for loop that calls the next double and next int method and then checks what interval that the number is in  using if statements
		//increments count at that interval if true 
		for(int i = 0; i < 1000000; i++){
			psRan = test.nextDouble();
			test.nextInt();
			if(psRan >= 0.0 && psRan < 0.1){
				count1++; 
			}
			if(psRan >= 0.1 && psRan < 0.2){
				count2++;
			}
			if(psRan >= 0.2 && psRan < 0.3){
				count3++; 
			}
			if(psRan >= 0.3 && psRan < 0.4){
				count4++;
			}
			if(psRan >= 0.4 && psRan < 0.5){
				count5++; 
			}
			if(psRan >= 0.5 && psRan < 0.6){
				count6++;
			}
			if(psRan >= 0.6 && psRan < 0.7){
				count7++; 
			}
			if(psRan >= 0.7 && psRan < 0.8){
				count8++; 
			}
			if(psRan >= 0.8 && psRan < 0.9){
				count9++;
			}
			if(psRan >= 0.9 && psRan < 1.0){
				count10++; 
			}
		}//end for loop 
		
		
		//print statements that print out a table with each interval and the number of occurrences 
		System.out.println("Range\t\t" + "Number of Occurrences" );
		System.out.println("[0.0..0.1)\t" + count1);
		System.out.println("[0.1..0.2)\t" + count2);
		System.out.println("[0.2..0.3)\t" + count3);
		System.out.println("[0.3..0.4)\t" + count4);
		System.out.println("[0.4..0.5)\t" + count5);
		System.out.println("[0.5..0.6)\t" + count6);
		System.out.println("[0.6..0.7)\t" + count7);
		System.out.println("[0.7..0.8)\t" + count8);
		System.out.println("[0.8..0.9)\t" + count9);
		System.out.println("[0.9..1.0)\t" + count10);
		
	}//end of main 

}//end of class 
