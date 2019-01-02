/*
Victor Lozoya 
this lab will insert random nodes into an empty BST
will compute the average height after running 100 trials for size n




*/





import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.BST;

public class lab5_3{




	public static double height(int n){
		
		double h = 0; 
		


		for(int k = 0; k < 100; k++){
		   BST<String, Integer> st = new BST<String, Integer>();
			for(int i = 0; i < n; i++){
				String key = Double.toString(StdRandom.uniform());
				st.put(key, i); 
			}
			h += st.height(); 
		} 
		h = h/100; 
		return h; 
	}		 

	public static void main(String[] args){
		int n = Integer.parseInt(args[0]);
		double aH = 0; 
		 for(int i = n; i <= 1000000; i+=i){
		     aH = height(i); 
		     StdOut.printf("%d ", i);
		     StdOut.printf("%7.2f \n", aH); 
		}
	}
}
		
		
