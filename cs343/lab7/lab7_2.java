/*
Victor Lozoya 
lab7
March 27th 
This code attempts to sort an array using the Fast 3-way partitioning. ( J. Bentley and D. McIlroy) implementation 


*/





import java.util.*;
import edu.princeton.cs.algs4.StdRandom;





public class lab7_2{


	public static void sort(int[] a){
		StdRandom.shuffle(a);
		// Eliminate dependence on input.
		sort(a, 0, a.length - 1);
	}

	private static void sort(int[] a, int lo, int hi){ // See page 289 for public sort() that calls this method.
		
		int p = lo+1, q = hi, i = lo+1, j = hi; 
		//Comparable temp; 
		//Comparable v = lo;
		while (i<=j){
			while(a[i] < a[lo]){ i++;}

			while(a[j] > a[lo]){ j--;}
			exch(a,i,j); 
			if(a[i] == a[lo]) exch(a, i, p); p++;
			if(a[j] == a[lo]) exch(a, j, q); q--; 
			
		}
		while(p>=lo){
			exch(a, j, p);
		}
		while(q<=hi){
			exch(a, i, q);
		}

		

	}

	//private static boolean less(int v, Comparable w) {
        //	return v.compareTo(w) < 0;
    	//}

	private static void exch(int[] a, int i, int j) {
        	int swap = a[i];
        	a[i] = a[j];
        	a[j] = swap;
    	}


	public static void main(String[] args){

		//int n = Integer.parseInt(args[0]);
		int[] a = {3, 5, 6, 7, 3, 3, 8, 12, 15, 3, 3, 7, 3}; 
		System.out.println(Arrays.toString(a));
		sort(a);
		System.out.println(Arrays.toString(a)); 
	}
	

}
