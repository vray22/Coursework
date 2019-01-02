
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdStats;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;

public class hw2Q3 {

   public static void shuffle(int[] a) {
      int n = a.length;
      for (int i = 0; i < n; i++) {
          // Exchange a[i] with random element in a[i..n-1]
          int r = i + StdRandom.uniform(n-i);
          int temp = a[i];
          a[i] = a[r];
          a[r] = temp;
      }
   }


   public static void resetArray(int[] a) {
      for (int i=0; i < a.length; i++) a[i] = i;
   }

   //get factorial of n
   public static int fact(int n){
	if(n <= 1) return 1;
	else return n * fact(n-1); 
   }
   
   public static void main(String[] args) {  // java hw1q3d 1000000
      int n = Integer.parseInt(args[1]);   
      int k = Integer.parseInt(args[0]);
      int[] a = new int[k];
      int factorial = fact(k); 
      String temp = " "; 
      HashMap<String, Integer> count = new HashMap<String, Integer>();//create hashmap 

      for (int i=0; i<n; i++) {
          resetArray(a);
          shuffle(a);
	  for(int v = 0; v < k; v++)
	  {
		temp += Integer.toString(a[v]) + " ";//create string with element of array a 
	  }

	  if(count.containsKey(temp))//check if string exist if so increment count 
	  {
		int val = count.get(temp);
		val++; 		
		count.put(temp, val); 
	  }
	  else count.put(temp, 1); //store new string with val 1
          
	  temp = " "; 
      }

      double[] freq = new double[factorial];
      double temp2 = 0.0; 
      int j = 0;
      for(Map.Entry<String, Integer> entry : count.entrySet())//iterate through hashmap and store freq to area 
      {
	temp2 = entry.getValue(); 
        freq[j] =  1.0*temp2/n;
        j++;
          
      }

      if (j != factorial) {
         StdOut.printf("not all permutations are generated\n");
         return;
      }
          
      StdOut.printf("1/720 = %f\n",    1.0/720);
      StdOut.printf("mean is %f\n",    StdStats.mean(freq));
      StdOut.printf("std dev is %f\n", StdStats.stddev(freq));

   }//end main 

}//end class
