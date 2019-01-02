/*
Victor Lozoya 
Lab4
Will find the kendall tau distance between two arrays
will use inversion class after creating integer[] bn from both a and b 
will take user input and generate two arrays from range 0 to n
will shuffle both arrays before calling dist method to allow random permutations

Feb. 20th 2018 
*/





import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Inversions;
import edu.princeton.cs.algs4.StdRandom;





public class kTau{
	
	public static long dist(int[] a, int[] b){
		
		int n = a.length; 
		int[] ai = new int[n]; 
		for(int i = 0; i < n; i++){
			ai[a[i]] = i; 
		}


		Integer[] bn = new Integer[n];
		for(int i = 0; i < n; i++){
			bn[i] = ai[b[i]];
		}

		return Inversions.count(bn); 
	}


	public static void main(String[] args){
				
		int n = Integer.parseInt(args[0]);
		int[] a = new int[n];
		int[] b = new int[n]; 
		for(int i = 0; i < n; i++){
			a[i] = i; 
			b[i] = i;
		}

		StdRandom.shuffle(a);
		StdRandom.shuffle(b);
		 		
		for(int i = 0; i < a.length; i++){
			StdOut.print(a[i] + " ");
		}
		StdOut.println();
		for(int i = 0; i < b.length; i++){
			StdOut.print(b[i] + " ");
		}
		StdOut.println();
		
		StdOut.println("kendall tau distance = " + kTau.dist(a, b)); 
	}
}//end class 
