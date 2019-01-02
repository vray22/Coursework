import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.Shell;
import edu.princeton.cs.algs4.StdOut;


public class DoublingRatio
{


	//param N length of array
	//will create random array of length N
	//use shellsort to sort array
	//return time to complete sort
	public static double timeTrial(int N)
	{
		Double[] a = new Double[N]; 
		for(int i = 0; i < N; i++){
			a[i] = StdRandom.uniform();
		}	
		Stopwatch timer = new Stopwatch();
		Shell.sort(a);
		return timer.elapsedTime();
	}


	public static void main(String[] args)
	{
		int N = Integer.parseInt(args[0]);//get argument from command line
		double prev = timeTrial(N/2); //get previous time
		for (int n = N; true; n += n)
		{
			double time = timeTrial(n);
			StdOut.printf("%6d %7.1f ", n, time);
			StdOut.printf("%5.1f\n", time/prev);
			prev = time; 
		}
	}
}
