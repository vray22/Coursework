/**
 * Victor Lozoya 
 * Date: 4/20/17
 * working with recursive methods creating patterns or 
 * solving problems recursively 
 * Lab8 
 * will create 4 methods and test them in the main with user input 
 */



import java.util.Scanner;
public class RecursiveMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner (System.in);
		
		System.out.println("Enter the first value: ");
		
		int m = scan.nextInt();
		System.out.println("Enter the second value: ");
		int n = scan.nextInt();
		//test triangle method with values user enters 
		triangle(m,n);
        System.out.println();
        
        
		System.out.println("Enter string you want to use: ");
		Scanner scan2 = new Scanner(System.in);
		String s = scan2.nextLine();
		System.out.println("Enter levels you want to use: ");
		
        int l = scan2.nextInt();
        //test my numbers method 
        numbers(s, l);
        System.out.println();
        
        System.out.println("Enter number for set in combinations: ");
		int k = scan.nextInt();
		System.out.println("Enter the number of r combinations: ");
		int j = scan.nextInt();
		//test my combinations method
		System.out.print("Value is : " + combinations(k,j));
		System.out.println();
		
		System.out.println("Enter the number of max asterieks: ");
		int v = scan.nextInt();
		System.out.println("Enter the number of index column to start: ");
		int i = scan.nextInt();
		//test my pattern method with user input 
		pattern(v, i);
		
		
	}//end of main 
	
	
		
		
		/*
		Parameters: m - number of asterisks in the first line
		n - number of asterisks in the middle 2 lines
		Precondition: m <= n, m > 0, n > 0
		Postcondition: The method has printed a pattern of 2*(n-m+1) lines
		to the standard output. The first line contains m asterisks, the next
		line contains m+1 asterisks, and so on up to a line with n asterisks.
		Then the pattern is repeated backwards, going n back down to m.
		Example output:
		triangle(3, 5) will print this:
		***
		*/
		public static void triangle(int m, int n){
			for(int i = 1; i <= m; i++){
				System.out.print("*");
			}
			System.out.println();	
			if(m == n)//base case 
				for(int i = 1; i <= m; i++){
					System.out.print("*");
				}
		   else if (m < n){
			   triangle(m+1, n);
			   System.out.println();
			   for(int i = 1; i <= m; i++){
					System.out.print("*");
				}//end for 
		  }//end else if 
	
		}//end triangle 
		
		/**
		 * 
		 * @param prefix string 
		 * @param levels int 
		 * will print prefix followed by a number and a dot 
		 * levels determine how many numbers and dots will be printed 
		 * numbers go up to 9 so if levels is 2 there will be 9*9 lines with 
		 * seq "prefix" 1.1. etc 
		 * stopping case is when levels reaches zero 
		 * other than that there will be a recursive call
		 */
		
		public static void numbers(String prefix, int levels){
			if(levels > 1){
				for(int i = 1; i < 10; i++ ){
					//prefix + i + ".";
					numbers(prefix + i + ".", levels-1);
			
					
				}
			}
			else
				for(int i = 1; i < 10; i++){
					System.out.println(prefix + i );
				}
		}//end numbers 
		
		
		/**
		 * 
		 * @param n int 
		 * @param i int 
		 * 
		 * // Precondition: n is a power of 2, n >= 1, i>= 0 
  // Postcondition: A pattern based on the above example has been 
  // printed. The longest line of the pattern has 
  // n stars beginning in column i of the output

		 */
		public static void pattern(int n, int i){
		if (n == 1){//base case 
		      for (int j = 0; j < i; j++)
		         System.out.print("  ");
		      System.out.println("* ");
		   } 
		   else{
		      pattern(n / 2, i);
		      for (int j = 0; j < i; j++){
		    	  System.out.print("  ");
		      }
		      for (int j = 0; j < n; j++){
		    	  System.out.print("* ");
		      }
		      System.out.println();
		      pattern(n/2 , n/2+i);
		   }
		}//end pattern 
		
		/**
		 * 
		 * @param n int
		 * @param r int 
		 * @return- double
		 * will return the number of possible combinations of r in a subset of n
		 * C(n,r) = !n/r!(n-r)! is the formula this recursive method solves  
		 */
		public static double combinations(int n, int r){
			
			if(r == 0 || r == n){//base case will return one 
				return 1;
			}
			else
				return combinations(n-1, r-1) + combinations(n-1, r);
		}
		
		

}
				
			
			
		
		

	



