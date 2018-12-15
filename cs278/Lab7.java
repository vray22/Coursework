import java.util.Scanner;
/**
 * 
 * @author Victor Lozoya 
 * oct 12th 
 * lab7 
 * cs278 
 *
 */

public class Lab7 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 int n = 0; 
		 int onto = 0; 
			int one = 0;
			int bi = 0; 
		 Scanner scan = new Scanner(System.in);
	     System.out.println("Enter n: ");
	     n = scan.nextInt();
	     char X[] = new char[3];
	     X[0] = 'a';
	     X[1] = 'b';
	     X[2] = 'c';
	     
	     int Y[] = new int[n+1];
	     
	     for(int i = 0; i <= n-1; i++) {
	    	 Y[i] = 0;
	     }
	     int count = 1; 
	     int i, j, k; 
	     for(i = 0; i <=n; i++){//first loop 
	    	 if(i==0){
	    	 System.out.print("f" + count + "(a)=" + i + " ");
	    	 Y[i]++;
	    	 }
	    	 if(i>0){
	    		 System.out.print("f" + count + "(a)=" + i + " ");
				 Y[i]++;
				 
	    		
	    	 }
	    	 for(j = 0; j<=n; j++){//middle loop 
	    		 if(j==0){
	    			 System.out.print("f" + count + "(b)=" + j + " ");
	    			 Y[j]++;
	    		 }
	    		 if(j>0){
	    			 
	    			 System.out.print("f" + count + "(a)=" + i + " ");
	    			 Y[i]++;
    				 System.out.print("f" + count + "(b)=" + j + " ");
    				 Y[j]++;
    				 
    				 
    				
	    		 }
	    		
	    		 for(k = 0; k<=n; k++){//start of outer loop 
	    			 if(k==0){
	    			 System.out.println("f" + count + "(c)=" + k + " ");
	    			 Y[k]++;
	    			 
	    			 System.out.print("f" + count);
	    			 checkFunction(Y, onto, one, bi);//call method again 
	    			 count++;
	    			 }
	    			 if(k > 0){
	    				 System.out.print("f" + count + "(a)=" + i + " ");
	    				 Y[i]++;
	    				 System.out.print("f" + count + "(b)=" + j + " ");
	    				 Y[j]++; 
	    				 System.out.println("f" + count + "(c)=" + k + " ");
	    				 Y[k]++; 
	    				 
	    				 System.out.print("f" + count);
	    				 checkFunction(Y, onto, one, bi);//check if function is one to one onto or bijection 
	    				 count++; 
	    			 }//end if 
	    		 }//end inner for
	    	 }//end inner for 
	     }//end outer loop 
	     System.out.println("There are " + (count-1) + " functions");
         System.out.println(onto + " are onto");
         System.out.println(one + " are one to one ");
         System.out.println(bi + " are bijections ");
	}//end main 
	
	/**
	 * 
	 * @param n
	 * @param onto
	 * @param one
	 * @param bi
	 * will go through array and check values to see if onto one to one or bijection 
	 * will reset array at end 
	 */
	
	public static void checkFunction(int[] n, int onto, int one, int bi){
		
		boolean isOneToOne = true;
		boolean isOnto = true; 
		
		for(int i = 0; i < n.length; i++){
			if(n[i] > 1){
				isOneToOne = false; 
				break;
			}
			
		}
		for(int i = 0; i < n.length; i++){
			if(n[i] > 0){}
			
			else if(n[i] == 0){
				isOnto = false;
			}
		}
		
		if(isOneToOne){
			System.out.print(" is one to one, ");
			one++; 
		}
		else
			System.out.print(" not one to one, ");
		
		if(isOnto){
			System.out.print(" is onto, ");
			onto++;
		}
		else
			System.out.print(" not onto, ");
		
		if( isOneToOne && isOnto){
			System.out.println(" is bijection. ");
			bi++; 
		}
		else 
			System.out.println(" not bijection. ");
		
		for(int i = 0; i < n.length; i++){
			n[i] = 0;
		}//end for 
		
		
	}//checkFunction 

}//end class 
