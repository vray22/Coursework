/*
Victor Lozoya
this program will use selection in quick to find median of
random sequence but will count the number of comparisons
will find ratio of the number of elements in seq and total comparisons


*/



import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.StdOut;

public class lab5_2{

	static double count = 0; 



	 private static int partition(Comparable[] a, int lo, int hi) {
		int i = lo;
		int j = hi + 1;
		Comparable v = a[lo];
		while (true) { 

		    // find item on lo to swap
		    ++count; 
		    while (less(a[++i], v)) {
		       if (i == hi) break;	// new increment to global 
		    }

		    // find item on hi to swap
		    ++count; 
		    while (less(v, a[--j])) {
		       if (j == lo) break;      // new added increment to global 
		    }

		    // check if pointers cross
		    if (i >= j) break;

		    exch(a, i, j);
		}

		// put partitioning item v at a[j]
		exch(a, lo, j);

		// now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
		return j;
	    }


	    public static Comparable select(Comparable[] a, int k) {
		if (k < 0 || k >= a.length) {
		    throw new IllegalArgumentException("index is not between 0 and " + a.length + ": " + k);
		}
		StdRandom.shuffle(a);
		int lo = 0, hi = a.length - 1;
		while (hi > lo) {
		    int i = partition(a, lo, hi);
		    if      (i > k) hi = i - 1;
		    else if (i < k) lo = i + 1;
		    else return a[i];
		}
		return a[lo];
	    }


	 // is v < w ?
	    private static boolean less(Comparable v, Comparable w) {
				
		if (v == w) return false;   // optimization when reference equals
		return v.compareTo(w) < 0;
	    }
		
	    // exchange a[i] and a[j]
	    private static void exch(Object[] a, int i, int j) {
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	    }


	public static double timeMean(int n, int k){
		Comparable med = 0; 
		double time = 0;

		Comparable[] a = new Comparable[n]; 
		//create random sequence of n length
		for(int i = 0 ; i < n; i++){
			a[i] = i;
		}
 		//for(int v = 0; v <= 1000; v++){
	
			
		med = select(a, k);  
		//}
		time = count; 
		count = 0; 
		return time; 
	}

	public static double gcd(double x, double y){
		double d = 1; 
		for(int i = 1; i <= x && i <= y; ++i){
			if(x%i == 0 && y%i == 0){
				d = i; 
			}
		}
		return d; 
	}
	public static void main(String[] args){
		
		int n = Integer.parseInt(args[0]);
		
		
		//double prev = timeMean(n/2, ((n/2)/2)); 
		for(int v = n; v <= 1000000; v+=v){
			double time = timeMean(v, v/2); 
			double divisor = gcd(v, time);
			double num = v/divisor;
			double den = time/divisor; 
			StdOut.printf("%6d %7.1f ", v, time);
			StdOut.printf("%6.0f", num);
			StdOut.printf("/");
			StdOut.printf("%6.0f \n", den); 
			//prev = time; 
		} 
		

			 
	}
}
