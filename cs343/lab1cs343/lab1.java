/*
Victor Lozoya 
January 24, 2018
lab1
This program will implement horner's method 
for solving polynomials
*/

/**
pre-condition: double[] p must not be null
post-condition: will return the result of polynomial
param: array of double values
	a double value to plug into polynomial for x
**/
public class lab1{

	public static double EvalHornerMethod( double[] p, double x0){
         
		int length = p.length; 
		double result = p[0]; 
		for(int i = 1; i < length; i++){
			result = result*x0 + p[i];
        	}

        	return result;
	}

	public static void printCoef(double[] p, double x){
		System.out.println("Coefficients: "); 
		for(int i = 0; i < p.length; i++){
		    System.out.print(p[i] + " "); 
	   	}
		System.out.println(); 
		System.out.println("x: " + x);  
	}
		    	 

	public static void main (String[] args){
                //test cases 
		double[] p = {2, -6, 2, -1};
		double x0 = 3;
		double x1 = -2;
		printCoef(p, x0); 
		System.out.println("Value is " + EvalHornerMethod(p, x0));
		printCoef(p, x1); 
		System.out.println("Value: " + EvalHornerMethod(p,x1)); 

		double[] p2 = {3, 5, 2, 3};
		double v0 = 5;
		double v1 = -4;
		printCoef(p2,v0); 
	        System.out.println("Value: " + EvalHornerMethod(p2, v0));
		printCoef(p2,v1);  
		System.out.println("Value: " + EvalHornerMethod(p2, v1)); 
	}
} 
	
