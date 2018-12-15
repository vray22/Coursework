/**
 * Victor Lozoya 
 * Lab6 
 * subsets 
 * ask user for number of elements and elements in set 
 * generate subsets with mask 
 * figure out what subsets equal n and print them out 
 */



import java.util.Scanner;


public class Lab6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int size = 0; 
	       Scanner scan = new Scanner(System.in);
	       System.out.println("Enter size of set: ");
	       size = scan.nextInt();
	       int set[] = new int[size];
	       System.out.println("Enter elements: ");
	       
	       for(int i = 0; i < size; i++) {
	    	   set[i] = scan.nextInt();
	       }
	       
	       int n = 0; 
	       System.out.println("Enter n: ");
	       n = scan.nextInt(); 
	       int count = 0; 
	       for(int i = 0; i < size; i++) {
	    	   count += set[i]; 
	       }
	       
	       System.out.println("Subsets with sum: " + n);
	       
	       if(count == n) {
			   System.out.print("{ ");
			   for(int j = 0; j < size; j++) {
				   System.out.print(set[j] + " ");
			   }
			   System.out.println("}");
	       }
	       
	       int count2 = 0; 
	       //make subsets of set using mask 
	       for(int i = 0; i <= Math.pow(2,size)-1 ; i++) {
	    	   
	    	   
	    	   count2 = 0; 
	    	   for(int k = 0; k < size; k++ ) {
	    		 
	    		   if((i & (1<<k)) > 0) {
	    			   count2 += set[k];
	    			   
	    			   //System.out.print(set[k] + " ");
	    			   
	    		   }//end if 
	    		   
	    	  }//end for
	          if(count2 == n){//if subset equals n 
	        	  System.out.print("{ ");
	        	  for(int k = 0; k < size; k++ ) {
	 	    		 
		    		   if((i & (1<<k)) > 0) {
		    			   
		    			   
		    			   System.out.print(set[k] + " ");
		    			   
		    		   }//end if 
		    		   
		    	  }//end for
	        	  
	        	  System.out.println("} ");	
	          }//end if 
	    	     	   
	    	   
	       }//end outer for 
		
		
	}//end main 

}//end class
