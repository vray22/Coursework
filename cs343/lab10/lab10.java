/*
Victor Lozoya 
lab10 
make slight changes to DijkstraSP and figure out if it becomes more efficient 
*/



import java.util.*;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.Stopwatch;





public class lab10{
	private DirectedEdge[] edgeTo;
	private double[] distTo;
	private IndexMinPQ<Double> pq;

	public void DijkstraSP(EdgeWeightedDigraph G, int s){
		edgeTo = new DirectedEdge[G.V()];
		distTo = new double[G.V()];
		pq = new IndexMinPQ<Double>(G.V());
		for (int v = 0; v < G.V(); v++){
			distTo[v] = Double.POSITIVE_INFINITY;
		}
		distTo[s] = 0.0;
		for (int v = 0; v < G.V(); v++){//for every vertex insert into queue
			pq.insert(v, distTo[v]);
		}
		while (!pq.isEmpty()){
			relax(G, pq.delMin());
		}
	}

	private void relax(EdgeWeightedDigraph G, int v){
		for(DirectedEdge e : G.adj(v)){
			int w = e.to();
			if (distTo[w] > distTo[v] + e.weight()){
				distTo[w] = distTo[v] + e.weight();
				edgeTo[w] = e;
				pq.decreaseKey(w, distTo[w]);//since all vertices are in queue remove without check 
			}
		}
	}

	public double distTo(int v){	
		return distTo[v];
	}

	public boolean hasPathTo(int v){
		return distTo[v] < Double.POSITIVE_INFINITY;
	}

	public Iterable<DirectedEdge> pathTo(int v){
		if (!hasPathTo(v)) return null;
		Stack<DirectedEdge> path = new Stack<DirectedEdge>();
		for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()])
			path.push(e);
		return path;
	}
	//will return the time it takes to determine the shortest path tree 
	public static double estimateTime(EdgeWeightedDigraph G, int x){
		double time = 0; 
		Stopwatch timer = new Stopwatch();
		DijkstraSP sp = new DijkstraSP(G, x);
		time = timer.elapsedTime();
		return time;
	}



	public static void main(String[] args) {
		In in = new In(args[0]);
		EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);
		int s = Integer.parseInt(args[1]);
		EdgeWeightedDigraph[] result = new EdgeWeightedDigraph[100];//store graph 100 times 

		for(int i = 0; i < 100; i++){
			result[i] = G;
		}

		// compute shortest paths
		double time = 0; 
		for(int v = 0; v < 100; v++){
			time += estimateTime(result[v], s);//add time elapsed 
		}
		
		


		// print shortest path
		/*
		for (int t = 0; t < G.V(); t++) {
		    if (sp.hasPathTo(t)) {
		        StdOut.printf("%d to %d (%.2f)  ", s, t, sp.distTo(t));
		        for (DirectedEdge e : sp.pathTo(t)) {
		            StdOut.print(e + "   ");
		        }
		        StdOut.println();
		    }
		    else {
		        StdOut.printf("%d to %d         no path\n", s, t);
		    }
		}*/
		StdOut.printf("%f \n", time/100);//print out average 
	    }

}
