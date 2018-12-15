/**
 * Victor Lozoya 
 * Lab8
 * will determine DNF and CNF expression with given truth values from user
 * Oct. 19th 2017
 * CS278 
 */
import java.util.Scanner;
public class Lab8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//will create strings of hard coded values for p q and r
		    String one = " p=T, q=T, r=T ";
	        String two = " p=T, q=T, r=F ";
	        String three = " p=T, q=F, r=T ";
	        String four = " p=T, q=F, r=F ";
	        String five = " p=F, q=T, r=T ";
	        String six = " p=F, q=T, r=F ";
	        String seven = " p=F, q=F, r=T ";
	        String eight = " p=F, q=F, r=F ";
	        Scanner scan = new Scanner(System.in);
	        char[] values = new char[8];//store values from user in here 
	        //will use answer to see if I should call my cnf and dnf methods 
	        boolean answer = false;
	        boolean answer2 = false;
	        System.out.println("Please enter truth values for each row of the truth table ");
	        //for loop to store all inputs of truth values from user also will check boolean answers 
	        for(int i = 0; i < 8; i++) {
	        	if(i == 0) {
	        		System.out.print(one);
	        		System.out.println(" Truth value is (T/F) ");
	        		values[i] = scan.next().charAt(0); 
	        		if(values[i] == 'T') {
	        			answer = true; 
	        		}
	        		if(values[i] == 'F') {
	        			answer2 = true; 
	        		}
	        	}
	        	
	        	if(i == 1) {
	        		System.out.print(two);
	        		System.out.println(" Truth value is (T/F) ");
	        		values[i] = scan.next().charAt(0); 
	        		if(values[i] == 'T') {
	        			answer = true; 
	        		}
	        		if(values[i] == 'F') {
	        			answer2 = true; 
	        		}
	        	}
	        	
	        	if(i == 2) {
	        		System.out.print(three);
	        		System.out.println(" Truth value is (T/F) ");
	        		values[i] = scan.next().charAt(0); 
	        		if(values[i] == 'T') {
	        			answer = true; 
	        		}
	        		if(values[i] == 'F') {
	        			answer2 = true; 
	        		}
	        	}
	        	
	        	if(i == 3) {
	        		System.out.print(four);
	        		System.out.println(" Truth value is (T/F) ");
	        		values[i] = scan.next().charAt(0); 
	        		if(values[i] == 'T') {
	        			answer = true; 
	        		}
	        		if(values[i] == 'F') {
	        			answer2 = true; 
	        		}
	        	}
	        	
	        	if(i == 4) {
	        		System.out.print(five);
	        		System.out.println(" Truth value is (T/F) ");
	        		values[i] = scan.next().charAt(0); 
	        		if(values[i] == 'T') {
	        			answer = true; 
	        		}
	        		if(values[i] == 'F') {
	        			answer2 = true; 
	        		}
	        	}
	        	
	        	if(i == 5) {
	        		System.out.print(six);
	        		System.out.println(" Truth value is (T/F) ");
	        		values[i] = scan.next().charAt(0); 
	        		if(values[i] == 'T') {
	        			answer = true; 
	        		}
	        		if(values[i] == 'F') {
	        			answer2 = true; 
	        		}
	        	}
	        	
	        	if(i == 6) {
	        		System.out.print(seven);
	        		System.out.println(" Truth value is (T/F) ");
	        		values[i] = scan.next().charAt(0); 
	        		if(values[i] == 'T') {
	        			answer = true; 
	        		}
	        		if(values[i] == 'F') {
	        			answer2 = true; 
	        		}
	        	}
	        	
	        	if(i == 7) {
	        		System.out.print(eight);
	        		System.out.println(" Truth value is (T/F) ");
	        		values[i] = scan.next().charAt(0); 
	        		if(values[i] == 'T') {
	        			answer = true; 
	        		}
	        		if(values[i] == 'F') {
	        			answer2 = true; 
	        		}
	        	}
	        	
	        }//end for 
	        
	        if(answer == true) {
	        	System.out.println("DNF expression for truth table: ");
	        	System.out.println(DNF(values));
	        }
	        if(answer2 == true) {
	        	System.out.println("CNF expression for truth table: ");
	        	System.out.println(CNF(values));
	        }


	}//end main 
	/**
	 * 
	 * @param char[] a 
	 * @return string 
	 * array must not be empty must hold values T/F
	 */
	public static String DNF(char[] a) {
		String expression = "";
		//for loop to go through array and concat expression with correct string value 
		for(int i = 0; i < a.length; i++){
			if(i == 0 && a[i] == 'T'){
				expression = expression.concat("pqr");
			}
			if(i == 1 && a[i] == 'T'){
				expression = expression.concat("+pqr'");
			}
			if(i == 2 && a[i] == 'T'){
				expression = expression.concat("+pq'r");
			}
			if(i == 3 && a[i] == 'T'){
				expression = expression.concat("+pq'r'");
			}
			if(i == 4 && a[i] == 'T'){
				expression = expression.concat("+p'qr");
			}
			if(i == 5 && a[i] == 'T'){
				expression = expression.concat("+p'qr'");
			}
			if(i == 6 && a[i] == 'T'){
				expression = expression.concat("+p'q'r");
			}
			if(i == 7 && a[i] == 'T'){
				expression = expression.concat("+p'q'r'");
			}
		}//end for 
		
		return expression; 
	}//end DNF method 
	/** 
	 * 
	 * @param char[] a 
	 * @return string expression 
	 * array must have values T/F
	 * 
	 */
	public static String CNF(char[] a) {
		String expression = "";
		//for loop to go through char array and concat to expression the correct string 
		for(int i = 0; i < a.length; i++){
			if(i == 0 && a[i] == 'F'){
				expression = expression.concat("(p'+q'+r')");
			}
			if(i == 1 && a[i] == 'F'){
				expression = expression.concat("(p'+q'+r)");
			}
			if(i == 2 && a[i] == 'F'){
				expression = expression.concat("(p'+q+r')");
			}
			if(i == 3 && a[i] == 'F'){
				expression = expression.concat("(p'+q+r)");
			}
			if(i == 4 && a[i] == 'F'){
				expression = expression.concat("(p+q'+r')");
			}
			if(i == 5 && a[i] == 'F'){
				expression = expression.concat("(p+q'+r)");
			}
			if(i == 6 && a[i] == 'F'){
				expression = expression.concat("(p+q+r')");
			}
			if(i == 7 && a[i] == 'F'){
				expression = expression.concat("(p+q+r)");
			}
		}//end for 
		
		return expression; 
	}//end CNF method 

}//end class
