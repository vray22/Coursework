/**
 * Lab 5
 * @author Victor Lozoya 
 *CS 278 
 *find counterexample 
 *Sept 28th 
 */

public class lab5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create squares
		int[] squares = new int[100];
        for(int i = 0; i <= 99; i++ ) {
        	squares[i] = i*i;
        }
        
        
        
        boolean answer = true; 
        int num = 0;
        
        for(int n = 3; answer != false; n+=2) {
        	for(int i = 0; i < 101; i++) {
        		
        		 if(i == 100){
        	    	 answer = false;
        	    	 num = n;
        	    	 break;
        	   } // end if 
        		
        	    int dubSq = squares[i] * 2; 
                int dif = n - dubSq; 
              
              if(isPrime(dif) == true) {
        		  break;
              }//check next odd number 
        	  else if(isPrime(dif) != true) {}//check next square * 2
        	  }//end inner for 
        	    
       }//answer is not true found counter example 
        	
      
           System.out.println(num);
        		
        
        //end outer loop 
        
        
	}
	
	/**
	 * 
	 * @param n
	 * @return boolean false or true 
	 * checks if a number is prime or not 
	 */
public static boolean isPrime(int n ) {
	boolean isPrime = true;
	
	if(n < 0){
		return isPrime = false;
	}
	
	if(n % 2 == 0) {
		return isPrime = false; 
	}
	for(int i = 3; i*i <= n; i+=2 ) {
		if(n % i == 0) {
			return isPrime = false; 
		}
	}
	return isPrime; 
}//end isPrime 



}//end class 
