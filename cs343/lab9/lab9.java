/*
Victor Lozoya 
lab9
April 17th 
This program will check if 2 components and vertices are reachable 
will use KosarajuSharirSCC for components and TransitiveClosure for vertices



*/



import java.util.*;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.KosarajuSharirSCC;
import edu.princeton.cs.algs4.TransitiveClosure; 
import edu.princeton.cs.algs4.Digraph;




public class lab9{
	/*
	params: Digraph, int v and w which represent components and vertices
	This method will create an instance of a strong connected component and a transitive closure based on Digraph g
	return: boolean[] which holds the answers for the reachability of both v and w
	*/
	public static boolean[] TransitiveClosure1(Digraph G, int v, int w){
		boolean reachable[] = new boolean[2];		//to store answers 
		KosarajuSharirSCC scc = new KosarajuSharirSCC(G);
		TransitiveClosure tc = new TransitiveClosure(G);
		reachable[0] = scc.stronglyConnected(v, w);
		reachable[1] = tc.reachable(v, w);
		
		return reachable; 
		

	}

	public static void main(String[] args){


		Digraph G = new Digraph(new In(args[0]));
		boolean[] reach = new boolean[2];
		int v = Integer.parseInt(args[1]);
		int w = Integer.parseInt(args[2]); 
		reach = TransitiveClosure1(G, v, w); 
		if(reach[0] == true){
			StdOut.printf("component %d is reachable from component %d \n", v, w);
		}
		else{
			StdOut.printf("component %d isn't reachable from component %d \n", v, w);
		}

		 
		if(reach[1] == true){
			StdOut.printf("vertex %d is reachable from vertex %d \n ", v, w);
		}
		else{
			StdOut.printf("vertex %d isn't reachable from vertex %d \n", v, w);
		} 


	}


}
