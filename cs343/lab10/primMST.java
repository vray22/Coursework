/*
Victor Lozoya 
lab 10 
will remove the marked array feature and see if prims still runs efficiently 
*/



import java.util.*;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.PrimMST;



public class primMST{
	private Edge[] edgeTo;
	private double[] distTo;
	//private boolean[] marked;//remove marked array 
	private IndexMinPQ<Double> pq;

	public void PrimMST(EdgeWeightedGraph G, int s){//added vertex s
		edgeTo = new Edge[G.V()];
		distTo = new double[G.V()];
		//marked = new boolean[G.V()];
		for (int v = 0; v < G.V(); v++)
			distTo[v] = Double.POSITIVE_INFINITY;
		pq = new IndexMinPQ<Double>(G.V());
		distTo[s] = 0.0;//changed 0 to s 
		pq.insert(s, 0.0);//changed 0 to s
		while (!pq.isEmpty())
			visit(G, pq.delMin());

	}

	private void visit(EdgeWeightedGraph G, int v){ // Add v to tree; update data structures.
		//marked[v] = true;
		for (Edge e : G.adj(v)){
			int w = e.other(v);
			//if (marked[w]) continue;// v-w is ineligible.
			if (e.weight() < distTo[w]){ // Edge e is new best connection from tree to w.
				edgeTo[w] = e;
				distTo[w] = e.weight();
				if (pq.contains(w)) pq.change(w, distTo[w]);
				else pq.insert(w, distTo[w]);
			}
		}
	}


	public Iterable<Edge> edges(){
		Bag<Edge> mst = new Bag<Edge>();
		for (int v = 1; v < edgeTo.length; v++)
			mst.add(edgeTo[v]);
		return mst;
	}
	public double weight() {
		double weight = 0.0;
		for (Edge e : edges())
		    weight += e.weight();
		return weight;
    	}

	public static void main(String[] args) {
		In in = new In(args[0]);
		EdgeWeightedGraph G = new EdgeWeightedGraph(in);
		PrimMST mst = new PrimMST(G);
		for (Edge e : mst.edges()) {
		    StdOut.println(e);
		}
		StdOut.printf("%.5f\n", mst.weight());
    	}

}
