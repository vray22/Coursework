/**
 * Victor Lozoya 
 * Lab9
 * use recursion to solve summations
 * Oct 26th 
 * will create two recursive methods and call them in main 
 * get input of n from user
 */


package cs278Lab9;
import java.util.Scanner; 

public class Lab9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter value of n: ");
		int n = scan.nextInt(); 
        System.out.println("Value of first summation is: " + sum1(n));
        System.out.println("Value of second summation is: " + sum2(n));
	}
	/**
	 * 
	 * @param n
	 * @return int summation of 2^i
	 */
	public static int sum1(int n) {
	   if(n == 0) {//base case 
			return 1; 
		}
		int sum2 = sum1(n-1);//recursive inductive step compute up to n-1
		int lastTerm = (int)Math.pow(2,n); //separate from summation 
		return (sum2 + lastTerm); 
	}//end sum1
	/**
	 * 
	 * @param n
	 * @return int summation of i(i+1)
	 */
	public static int sum2(int n) {
		if(n == 1) {//base step 
			return 2;
		}
		int sum2 = sum2(n-1);//recursive inductive step compute up to n-1
		int lastTerm = n*(n+1);//separate from summation 
		return(sum2 + lastTerm);
	}//end sum2

}//end class
