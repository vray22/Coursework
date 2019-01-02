/*
Victor Lozoya 
lab6 
mar 6th 
will run studies on BST.java and RedBlackBST to see which 
one has better performance on insertions and deletions



*/





import edu.princeton.cs.algs4.RedBlackBST;
//import BST.java; 
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.StdOut;

public class lab6{

	public static double bstTime(int[] a){
		double time = 0;
		BST<Integer, Integer> s = new BST<Integer, Integer>(); 
		for(int i = 0; i < a.length; i++){
			Stopwatch timer = new Stopwatch();			
			s.put(a[i], 1);
			time += timer.elapsedTime();
		}
		return time;
	}

	public static double rbTime(int[] a){
		double time = 0; 
		RedBlackBST<Integer, Integer> st = new RedBlackBST<Integer, Integer>();
		for(int i = 0; i < a.length; i++){
			Stopwatch timer = new Stopwatch();			
			st.put(a[i], 1);
			time += timer.elapsedTime();
		}
		return time; 
	}

	public static double bstTimeDel(int[] a){
		double time = 0;
		BST<Integer, Integer> s = new BST<Integer, Integer>(); 
		for(int i = 0; i < a.length; i++){
			//Stopwatch timer = new Stopwatch();			
			s.put(a[i], 1);
			//time += timer.elapsedTime();
		}
		for(int j = a.length-1; j >= 0; j--){
			Stopwatch timer = new Stopwatch();			
			s.delete(a[j]);
			time += timer.elapsedTime();
		}
		return time;
	}

	public static double rbTimeDel(int[] a){
		double time = 0; 
		RedBlackBST<Integer, Integer> st = new RedBlackBST<Integer, Integer>();
		for(int i = 0; i < a.length; i++){
			//Stopwatch timer = new Stopwatch();			
			st.put(a[i], 1);
			//time += timer.elapsedTime();
		}
		for(int j = a.length-1; j >= 0; j--){
			Stopwatch timer = new Stopwatch();			
			st.delete(a[j]);
			time += timer.elapsedTime();
		}
		return time; 
	}


	public static double bstTimeDelIns(int[] a){
		double time = 0;
		BST<Integer, Integer> s = new BST<Integer, Integer>(); 
		for(int i = 0; i < a.length; i++){
			Stopwatch timer = new Stopwatch();			
			s.put(a[i], 1);
			time += timer.elapsedTime();
		}
		for(int j = a.length-1; j >= 0; j--){
			Stopwatch timer = new Stopwatch();			
			s.delete(a[j]);
			time += timer.elapsedTime();
		}
		return time;
	}

	public static double rbTimeDelIns(int[] a){
		double time = 0; 
		RedBlackBST<Integer, Integer> st = new RedBlackBST<Integer, Integer>();
		for(int i = 0; i < a.length; i++){
			Stopwatch timer = new Stopwatch();			
			st.put(a[i], 1);
			time += timer.elapsedTime();
		}
		for(int j = a.length-1; j >= 0; j--){
			Stopwatch timer = new Stopwatch();			
			st.delete(a[j]);
			time += timer.elapsedTime();
		}
		return time; 
	}


	public static void main(String[] args){


		int n = Integer.parseInt(args[0]);

		double time1 = 0;
		double time2 = 0; 
		double time3 = 0;
		double time4 = 0; 
		double time5 = 0; 
		double time6 = 0; 

		int[] a = new int[n]; 
		int[] b = new int[n]; 
		for(int i = 0; i < n; i++){
			a[i] = (int) StdRandom.uniform();
		}
		System.arraycopy(a,0,b,0,a.length);
		time1 = bstTime(a); 
		time2 = rbTime(b); 
		StdOut.printf("for insert only bst time %7.3f: ", time1);
		StdOut.printf("red black time %7.3f: \n", time2);

		int[] c = new int[n]; 
		int[] d = new int[n]; 
		for(int i = 0; i < n; i++){
			c[i] = (int) StdRandom.uniform();
		}
		System.arraycopy(c,0,d,0,c.length);
		time3 = bstTimeDel(c);
		time4 = rbTimeDel(d); 
		StdOut.printf("for delete only bst time %7.3f: ", time3);
		StdOut.printf("red black time %7.3f: \n", time4);

		int[] f = new int[n]; 
		int[] g = new int[n]; 
		for(int k = 0; k < n; k++){
			f[k] = (int) StdRandom.uniform();
		}
		System.arraycopy(f,0,g,0,f.length);
		time5 = bstTimeDelIns(f);
		time6 = rbTimeDelIns(g); 
		StdOut.printf("for insert/delete bst time %7.3f: ", time5);
		StdOut.printf("red black insert/delete time %7.3f: \n", time6);
	}//end main 
}//end class 
		
