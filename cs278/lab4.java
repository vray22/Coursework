package lab4cs278;
import java.util.Scanner;
/**
 * 
 * @author Victor Loozya 
 * Lab4 
 * will use methods to figure out if input of ten integers makes 
 * quantified statements true  or false 
 * will figure out a particular domain which makes a false and b true 
 * Sept 21st 
 * CS278 
 *
 */




public class lab4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create my domains will make two copies to compare for x,y 
        int[] domain = new int[10];
        int[] domain2 = new int[10];
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter ten different digits for domain: ");
        for(int x = 0; x <10; x++) {//inputs integers into array 
        	domain[x] = scan.nextInt();
        	
        }
        domain2 = domain;//duplicate of domain 
        //statements to print out truth values for statements a b c d and d1 hard coded 
        System.out.println("a) " + a(domain, domain2));
        System.out.println("b) " + b(domain, domain2));
        System.out.println("c) " + c(domain, domain2));
        System.out.println("d) " + d(domain, domain2));
        System.out.println("D1 " + "{ " + "7 1 -1 7 13 15 17 19 23 25" + " } makes statement a false and b true");
	}//end main 
	/**
	 * 
	 * @param d integer array 
	 * @param b integer array 
	 * will use nested for loops to create truth table for P(x,y) 
	 * other methods are very similiar to this one I'm sure I code create one method alone for all four statements 
	 * @return string 
	 */
	public static String a(int[] d, int[] b) {
		String answer = "True";
		String truthVal = "";
		String[][] table = new String[10][10];
		for(int i = 0; i < 9; i++) {  
			for(int j = 0; j < 9; j++) {
				if(((d[i] + b[j]) % 2== 1)|| (d[i] % 3 == 0)) {//p(x,y) is here 
					truthVal = "True";
					table[i][j] = truthVal; 
				}//end if
				else {
					truthVal = "False";
					table[i][j] = truthVal; 
				}//end of else 
			
			}//end inner loop 
		}//end outer loop
		String[] allX = new String[9];
		for(int i = 0; i < 9; i++) {
			allX[i] = "False"; 
		}
		//check if domain x has at least one true value then it will break 
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(table[i][j].equals("True")) {
					allX[i] = "True";
					break;
				}//end if 
			       
			}//end inner loop 
		}// end outer loop 
		
		for(int i = 0; i < 9; i++) {
			if(allX[i].equals("False")){
				return answer = "False";
			}
		}
		
		
		return answer; 
	}//end expression A
	/**
	 * 
	 * @param d
	 * @param b
	 * will create table of truth vals and use that to determine if the statment b is true 
	 * 
	 * @return string 
	 */
	public static String b(int[] d, int[] b) {
		String answer = "False";
		String truthVal = "";
		String[][] table = new String[10][10];
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(((d[i] + b[j]) % 2 == 1) || (d[i] % 3 == 0)) {
					truthVal = "True";
					table[i][j] = truthVal; 
				}//end if
				else {
					truthVal = "False";
					table[i][j] = truthVal; 
				}//end of else 
			
			}//end inner loop 
		}//end outer loop
		String[] allX = new String[9];
		for(int i = 0; i < 9; i++) {
			allX[i] = "True"; 
		}
		
		//go through truth table and determine if domain has one false in it 
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(table[i][j].equals("False")) {
					allX[i] = "False";
					break;
				}//end if 
			       
			}//end inner loop 
		}// end outer loop 
		
		//if at least one domain of x has all true values then one of allX should be true 
		for(int i = 0; i < 9; i++) {
			if(allX[i].equals("True")){
				return answer = "True";
			}
		}
		
		
		return answer; 
	}//end expression B
	
	
	
/**
 * 
 * @param d
 * @param b
 * @return String 
 */
	public static String c(int[] d, int[] b) {
		String answer = "True";
		String truthVal = "";
		String[][] table = new String[10][10];
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(((d[i] + b[j]) % 2 == 1) || (d[i] % 3 == 0)) {
					truthVal = "True";
					table[i][j] = truthVal; 
				}//end if
				else {
					truthVal = "False";
					table[i][j] = truthVal; 
				}//end of else 
			
			}//end inner loop 
		}//end outer loop
		String[] allX = new String[9];
		for(int i = 0; i < 9; i++) {
			allX[i] = "False"; 
		}
		//once one truth value is found in domain then loop breaks to next domain 
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(table[i][j].equals("True")) {
					allX[i] = "True";
					break;
				}//end if 
			       
			}//end inner loop 
		}// end outer loop 
		for(int i = 0; i < 9; i++) {
			if(allX[i].equals("True")){
				return answer;
			}
		}
		
		
		return answer; 
	}//end expression c
	/**
	 * 
	 * @param d
	 * @param b
	 * both integer arrays from user input values 
	 * @return String 
	 */
	
	public static String d(int[] d, int[] b) {
		String answer = "True";
		String truthVal = "";
		String[][] table = new String[10][10];
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(((d[i] + b[j]) % 2 == 1) || (d[i] % 3 == 0)) {
					truthVal = "True";
					table[i][j] = truthVal; 
				}//end if
				else {
					truthVal = "False";
					table[i][j] = truthVal; 
				}//end of else 
			
			}//end inner loop 
		}//end outer loop
		
		//create array string to see if quantified statement d is true 
		String[] allX = new String[9];
		for(int i = 0; i < 9; i++) {
			allX[i] = "True"; 
		}
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(table[i][j].equals("False")) {
					allX[i] = "False";
					break;
				}//end if 
			       
			}//end inner loop 
		}// end outer loop 
		for(int i = 0; i < 9; i++) {
			if(allX[i].equals("False")){
				return answer = "False";
			}
		}
		
		
		return answer; 
	}//end expression d
	
	

}//end lab4 
