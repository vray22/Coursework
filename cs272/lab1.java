//Victor Lozoya 
//lab1
//CS272
//Jan 31st, 2017
//This program gets input from user and stores them into an array of 100
//stops inputting when you enter -1 and finds average, total number of grades, and standard deviation 


//allows for input from user
import java.util.Scanner; 
public class lab1 {//start of class lab1

	private static Scanner scnr;

	public static void main(String[] args) {
		scnr = new Scanner(System.in);
		//creates array grades of 100 
		int[] grades = new int[100];
		//initialize my variables 
		int totalGrades = 0; 
		double mean; 
		double stanDev = 1; 
		double sum = 0;
		double sumA = 0; 
		 
		int input = 0;
		int i = 0;
		//while loop that ask user to enter scores condition is if input is not equal to -1
		System.out.println(("Please enter the scores" + "(-1 indicates end of input)"));
		while(input != -1){
			
			input = scnr.nextInt();//input becomes next int entered by user 
			//if statement that inputs grade into array of grades as long as it isn't equal to -1 
			//also adds to total grades and adds the value to the current sum 
			if(!(input == -1)){
			 grades[i] = input;
			 i++;
			 totalGrades++;
			 sum = sum + input; 
			}
		}
		mean = sum / totalGrades; //determine the average 
		//print statements that print total number of grades and mean 
		System.out.println("Total number of grades is " + totalGrades); 
		System.out.println("The mean is " + mean);
		
		//for loop that goes through array of grades and finds variance 
		for(i = 0; i < totalGrades ; i++ ){
			sumA =   sumA + Math.pow(grades[i] - mean, 2);
			
		}
		//finds the standard deviation and prints it out 
		stanDev = Math.sqrt((sumA)/totalGrades); 
		System.out.println("Standard deviation is " + stanDev);
				
		
	}//end of main 

}//end of class 
