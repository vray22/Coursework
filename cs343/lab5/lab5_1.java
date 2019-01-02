/*
Victor Lozoya 
this program will measure the time it takes for select method in quick 
to find the median of a random sequence. will run 1000 trials for each N number sequeces 
uses doubling ratio method to determine if takes linear time to find the median



*/




import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.StdOut;
public class lab5_1{


	public static double timeMean(int n, int k){
		Comparable med = 0; 
		double time = 0;

		Comparable[] a = new Comparable[n]; 
		//create random sequence of n length
		for(int i = 0 ; i < n; i++){
			a[i] = i;
		}
 		for(int v = 0; v <= 1000; v++){
	
			Stopwatch timer = new Stopwatch();
			med = Quick.select(a, k);
			time += timer.elapsedTime(); 
		}
		return time; 
	}		
	public static void main(String[] args){
		
		int n = Integer.parseInt(args[0]);
		
		
		double prev = timeMean(n/2, ((n/2)/2)); 
		for(int v = n; v <= 1000000; v+=v){
			double time = timeMean(v, v/2); 
			StdOut.printf("%6d %7.1f ", v, time);
			StdOut.printf("%5.1f\n", time/prev);
			prev = time; 
		} 
		

			 
	}
}
