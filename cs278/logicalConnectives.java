/**
 * Victor Lozoya 
 * Lab2
 * ask for values of p, q, and r and determine if statenments are true 
 * based on those values 
 * Sept. 7th, 2017
 * cs278 
 */


package cs278Lab2;

import java.util.Scanner;

public class logicalConnectives {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ask for values and input them into string vals 
		Scanner scan = new Scanner(System.in);
        System.out.println("Enter truth-value of p: ");
        String pVal = scan.next();
        String pVal2 = pVal;
        System.out.println("Enter truth-value of q: ");
        String qVal = scan.next();
        String qVal2 = qVal; 
        System.out.println("Enter truth-value of r: ");
        String rVal = scan.next();
        String rVal2 = rVal; 
        
        String answer = "T";
        
        answer = conj(impl(neg(pVal), qVal), impl(rVal, pVal));//use methods with values inserted 
        System.out.println("Truth value of statement 1: " + answer);//returns true or false 
        String p = disj(neg(pVal2), rVal2);
        String q = disj(qVal2, neg(impl(rVal2, qVal2)));
        String answer2 = conj(p,q);//use methods with values 
        System.out.println("Truth value of statement 2: " + answer2);
        
        
	}
	/**
	 * 
	 * @param a
	 * will do negation on the value passed as a 
	 * @return either true or false 
	 */
	public static String neg(String a){
		String answer = "T";
		
		if(a.equals("T") || a.equals("t")){
			answer = "F";
		}
		
		if(a.equals("F") || a.equals("f")){
			answer = "T";
		}
		
		
		return answer;
	}//end method 
	/**
	 * 
	 * @param a
	 * @param b
	 * figures out the disjunction of two values a and b 
	 * @return true or false value 
	 */
	public static String disj(String a, String b){
		String answer = "T";
		
		if(((a.equals("T")) || a.equals("t")) && ((b.equals("T") || b.equals("T")))){
			answer = "F";
		}
		if(((a.equals("T")) || a.equals("t")) && ((b.equals("F") || b.equals("f")))){}
		if(((a.equals("F")) || a.equals("f")) && ((b.equals("T") || b.equals("T")))){}
		if(((a.equals("F")) || a.equals("f")) && ((b.equals("F") || b.equals("f")))){
			answer = "F";
		}
		
		return answer; 
	}//end of disj
	
	/**
	 * 
	 * @param a
	 * @param b
	 * determines conjuction of two values a and b 
	 * @return true or false value 
	 */
	public static String conj(String a, String b){
		String answer = "T";
		if(((a.equals("T")) || a.equals("t")) && ((b.equals("T") || b.equals("T")))){}
		if(((a.equals("T")) || a.equals("t")) && ((b.equals("F") || b.equals("f")))){
			answer = "F";
		}
		if(((a.equals("F")) || a.equals("f")) && ((b.equals("T") || b.equals("T")))){
			answer = "F";
		}
		if(((a.equals("F")) || a.equals("f")) && ((b.equals("F") || b.equals("f")))){
			answer = "F";
		}
		
		return answer; 
	}
	/**
	 * 
	 * @param a
	 * @param b
	 * determines implication of a and b 
	 * @return true or false value 
	 */
	public static String impl(String a, String b){
		String answer = "T";
		
		if(((a.equals("T")) || a.equals("t")) && ((b.equals("T") || b.equals("T")))){}
		if(((a.equals("T")) || a.equals("t")) && ((b.equals("F") || b.equals("f")))){
			answer = "F";
		}
		if(((a.equals("F")) || a.equals("f")) && ((b.equals("T") || b.equals("T")))){}
		if(((a.equals("F")) || a.equals("f")) && ((b.equals("F") || b.equals("f")))){}
		
		return answer; 
	}//end method 
	
	

}//end class 
