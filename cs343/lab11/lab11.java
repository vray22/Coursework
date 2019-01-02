/*
Victor Lozoya 
lab11
will create straight line code and output based on input from user
will search for a particular pattern in some txt 
will use kmp method to compute the dfa then use search to get the dfa of the txt
*/





import java.util.*;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.KMP;


public class lab11{

	//private String pat;
	private static int[][] dfa;

	public static void myKMP(String pat){ // Build DFA from pattern.
		//this.pat = pat;
		int M = pat.length();
		int R = 256;
		dfa = new int[R][M];
		dfa[pat.charAt(0)][0] = 1;
		for (int X = 0, j = 1; j < M; j++){ // Compute dfa[][j].
			for (int c = 0; c < R; c++){
				dfa[c][j] = dfa[c][X];

			}
			dfa[pat.charAt(j)][j] = j+1;
			X = dfa[pat.charAt(j)][X];
		}
	}
	/*
	added an array of integers to store the state 
	added the parameter pattern as well 
	*/
	public static int search(String txt, int[]x, String pat){ // Simulate operation of DFA on txt.
		int i, j, N = txt.length(), M = pat.length();
		for (i = 0, j = 0; i < N && j < M; i++){
			j = dfa[txt.charAt(i)][j];
			//StdOut.printf("%s \n", j);
			x[i] = j;//this is where i store the state 
		}
		if (j == M) return i - M; // found (hit end of pattern)
		else
		return N;
		// not found (hit end of text)
	}




	public static void main(String[] args) {
		String pat = args[0];
		String txt = args[1];
		int[] states = new int[256];
		char[] pattern = pat.toCharArray();
		myKMP(pat);//generate dfa 
		int offset = search(txt, states, pat);//use dfa on text 

		StdOut.printf("\t int i = -1; \n");
		StdOut.printf("sm: i++;\n");
		//loop will help output the staightline code for the particular pattern 
		for(int i = 0; i < pat.length(); i++){
	            if(i == 0){//first state increments i by one 
			StdOut.printf("s%d: if (txt[i]) != '%s' goto sm;\n",i,pat.charAt(i));
		    }
                    else StdOut.printf("s%d: if (txt[i]) != '%s' goto s%d;\n",i,pat.charAt(i),states[i]);//will go to state stored in array for current index 
		}
		StdOut.printf("\t return i-%d\n",offset);
 	}

}
