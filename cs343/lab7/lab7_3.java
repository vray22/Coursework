/*
Victor Lozoya 
lab7 
March 27th 
This code is a study between QuickHoareFast and Fast 3-way partitioning. ( J. Bentley and D. McIlroy)
basically I sort the same array and time the total time after 1 million iterations 


*/




import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;




public class lab7_3{



	public static double Q3time(int[] a){
		Stopwatch timer = new Stopwatch();
		sort3(a, 0, a.length - 1);
		return timer.elapsedTime();
	}


	public static double QHtime(int[] a){
		Stopwatch timer = new Stopwatch();
		QuickHoareFast.sort(a); 
		return timer.elapsedTime();
	}



	private static void sort3(int[] a, int lo, int hi){ // See page 289 for public sort() that calls this method.
		
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

	private static void exch(int[] a, int i, int j) {
        	int swap = a[i];
        	a[i] = a[j];
        	a[j] = swap;
    	}



	public static void main(String[] args){

		int[] a = {1, 56, 22, 2, 3, 34, 1, 45, 35, 1, 77, 1, 88, 1};  
	 	int[] b = new int[a.length];  
		int[] d = new int[a.length]; 
		System.arraycopy(a,0,b,0,a.length);
		System.arraycopy(a,0,d,0,a.length);

		double time = 0;
		double time2 = 0;


		for(int v = 0; v < 1000000; v++){
			time += QHtime(b);
			time2 += Q3time(d);

			StdRandom.shuffle(a);
			System.arraycopy(a,0,b,0,a.length);
			System.arraycopy(a,0,d,0,a.length);	
			
		} 


		StdOut.println();
		StdOut.printf("Quick Hoare elapsed time: %f\n ", time );
		StdOut.printf("Quick fast 3 way time: %f\n ", time2);
	}
}
