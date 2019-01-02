//Victor Lozoya
//Lab2
//modify sortcompare so both sorting methods use same test cases
//Jan 6th, 2018 

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.Selection;
import edu.princeton.cs.algs4.Shell;
import edu.princeton.cs.algs4.Merge;
import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.Heap;
import edu.princeton.cs.algs4.StdOut;

public class lab2_1
{

	
	public static double time(String alg, Double[] a)
	{
		Stopwatch timer = new Stopwatch();
		if (alg.equals("Insertion")) Insertion.sort(a);
		if (alg.equals("Selection")) Selection.sort(a);
		if (alg.equals("Shell")) Shell.sort(a);
		if (alg.equals("Merge")) Merge.sort(a);
		if (alg.equals("Quick")) Quick.sort(a); 
		if (alg.equals("Heap")) Heap.sort(a);
		return timer.elapsedTime(); 


 
        }



	//added a new parameter to the method which is the other algorithim
	//new return type Double[]
	public static Double[] timeRandomInput(String alg, String alg2, int N, int T)
	{ // Use alg to sort T random arrays of length N.
		double total = 0.0;
		double total2 = 0.0;
		Double[] a = new Double[N];
		Double[] t = new Double[2];//going to store the times in this array 
		for (int j = 0; j < T; j++)
		{ // Perform one experiment (generate and sort an array).
			
			for (int i = 0; i < N; i++){
					a[i] = StdRandom.uniform();
					//b[i] = a[i];
				}
				total += time(alg, a);//same array but different sorting methods 
				total2 += time(alg2, a);
		}
		t[0] = total;//store values in array 
		t[1] = total2; 
		return t;
	}


	public static void main(String[] args)
	{
		String alg1 = args[0];
		String alg2 = args[1];
		int N = Integer.parseInt(args[2]);
		int T = Integer.parseInt(args[3]);
		Double[] b = timeRandomInput(alg1, alg2, N, T); // total for alg1
		double t1 = b[0]; // total for alg2
		double t2 = b[1];
		StdOut.printf("For %d random Doubles\n %s is", N, alg1);
		StdOut.printf(" %.1f times faster than %s\n", t2/t1, alg2);
	}
}

