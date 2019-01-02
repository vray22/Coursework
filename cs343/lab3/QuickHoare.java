/*
Victor Lozoya
Lab3
cs343
Feb13, 2018
This class implements Hoare's partition method which doesn't check array out of bonds
I will compare running times of Quick, QuickHoare, and Quick3way and see which is more efficient


*/

import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.Quick3way;


public class QuickHoare
{
	

	    public static boolean less(Comparable v, Comparable w) {
        	if (v == w) return false;   // optimization when reference equals
        	return v.compareTo(w) < 0;
    	}
        
    	// exchange a[i] and a[j]
    	public static void exch(Object[] a, int i, int j) {
        	Object swap = a[i];
        	a[i] = a[j];
        	a[j] = swap;
    	}



	public static int partition(Comparable[] a, int lo, int hi)
	{ // Partition into a[lo..i-1], a[i], a[i+1..hi].
		int i = lo-1, j = hi;
		// left and right scan indices
		Comparable v = a[lo];
		// partitioning item
		while (true)
		{ // Scan right, scan left, check for scan complete, and exchange.
			//while (less(a[++i], v)); //if (i == hi) break;
			//while (less(v, a[--j])); //if (j == lo) break;
			//no out of bounds check in this new method 
			do{
			   j = j-1;
			} while(!a[j].equals(v) && !less(a[j], v));
			
			do{
			   i = i+1; 
			}while(less(v, a[i]) && !a[i].equals(v));
 
			if (i >= j) return j; 

			exch(a, i, j);
			 
		}
	 
	// with a[lo..j-1] <= a[j] <= a[j+1..hi].
	}







	public static void sort(Comparable[] a)
	{
		//StdRandom.shuffle(a);
		// Eliminate dependence on input.
		sort(a, 0, a.length - 1);
	}

	
	private static void sort(Comparable[] a, int lo, int hi)
	{
		if (hi <= lo) return;
		int j = partition(a, lo, hi); // Partition (see page 291).
		sort(a, lo, j);
		// Sort left part a[lo .. j-1].
		sort(a, j+1, hi);
		// Sort right part a[j+1 .. hi].
	}


	public static double QHtime(String[] a){
		Stopwatch timer = new Stopwatch();
		QuickHoare.sort(a); 
		return timer.elapsedTime();
	}

	public static double Qtime(String[] a){
		Stopwatch timer = new Stopwatch();
		Quick.sort(a); 
		return timer.elapsedTime();
	}	

	public static double Q3time(String[] a){
		Stopwatch timer = new Stopwatch();
		Quick3way.sort(a); 
		return timer.elapsedTime();
	}	
	public static void main(String[] args){

		String[] a = StdIn.readAllStrings(); 
	 	String[] b = new String[a.length];  
		String[] d = new String[a.length]; 
		System.arraycopy(a,0,b,0,a.length);
		System.arraycopy(a,0,d,0,a.length);

		double time = 0;
		double time2 = 0; 
		double time3 = 0; 

		
		for(int v = 0; v < 1000000; v++){
			time += QHtime(a);
			time2 += Qtime(b);
			time3 += Q3time(d);
			StdRandom.shuffle(a);
			System.arraycopy(a,0,b,0,a.length);
			System.arraycopy(a,0,d,0,a.length);	
			
		} 
		
		StdOut.println();
		StdOut.printf("Quick Hoare elapsed time: %f\n ", time );
		StdOut.printf("Quick elapsed time: %f\n ", time2);
		StdOut.printf("Quick3way elapsed time: %f\n ", time3); 
		StdOut.printf("Quick Hoare is: %2.1f percent faster than quick \n", (((time2-time)/time2)*100));
		StdOut.printf("Quick Hoare is: %2.1f percent faster than quick3way \n", (((time3-time)/time3)*100)); 
		//StdOut.printf("Quick3way dev: %.3f\n ", StdStats.stddev(freq3));  
	}//end main

}//end class
