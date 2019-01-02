/*
Victor Lozoya 
lab8
Use bfs to solve pouring containers problem 
*/




import java.util.*;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;




public class lab8_2{
	
	public static boolean marked[][][] = new boolean[11][8][5];//for containers 
	public static StringBuilder edgeTo[][][] = new StringBuilder[11][8][5];//to store path to vertices
	public static boolean answer = false; //true if there is such a pouring that leaves 2 in the 7 or 4 pint container 

	public static boolean bfs(int i, int j, int k){
		Queue<Integer> q = new Queue<Integer>();
		marked[i][j][k] = true; 
		//StdOut.printf("%d %d %d\n", i, j , k); 
		q.enqueue(i);
		q.enqueue(j);
		q.enqueue(k); 


		while(!q.isEmpty()){

			int i1 = q.dequeue();
			int j1 = q.dequeue();
			int k1 = q.dequeue();
			StringBuilder s = new StringBuilder();
			s.append(i1);
			s.append(j1);
			s.append(k1);
			StdOut.printf("%s \n", s);//this is the current vertice
			if(j1==2 || k1==2){ answer = true; }  //target
			else if (!marked[Math.max(j1+i1-7,0)][Math.min(j1+i1,7)][k1]){
				
				edgeTo[(Math.max(j1+i1-7,0))][Math.min(j1+i1,7)][k1] = s;//c1->c2
				marked[Math.max(j1+i1-7,0)][Math.min(j1+i1,7)][k1] = true;
				q.enqueue(Math.max(j1+i1-7,0));
				q.enqueue(Math.min(j1+i1,7));
				q.enqueue(k1);
			}			

			else if (!marked[Math.min(i1+j1,10)][Math.max(i1+j1-10,0)][k1]){

				 edgeTo[Math.min(i1+j1,10)][Math.max(i1+j1-10,0)][k1] = s;//c2->c1
				 marked[Math.min(i1+j1,10)][Math.max(i1+j1-10,0)][k1] = true;
				 q.enqueue(Math.min(i1+j1,10));
				 q.enqueue(Math.max(i1+j1-10,0));
				 q.enqueue(k1);
			}
			
			else if (!marked[Math.max(k1+i1-4,0)][j1][Math.min(k1+i1,4)]){

				 edgeTo[Math.max(k1+i1-4,0)][j1][Math.min(k1+i1,4)] = s;//c1->c3
				 marked[Math.max(k1+i1-4,0)][j1][Math.min(k1+i1,4)] = true;
				 q.enqueue(Math.max(k1+i1-4,0));
				 q.enqueue(j1);
				 q.enqueue(Math.min(k1+i1,4));
			}

			else if (!marked[Math.min(i1+k1,10)][j1][Math.max(i1+k1-10,0)]){
				
				 edgeTo[Math.min(i1+k1,10)][j1][Math.max(i1+k1-10,0)] = s;//c3->c1
				 marked[Math.min(i1+k1,10)][j1][Math.max(i1+k1-10,0)] = true; 
				 q.enqueue(Math.min(i1+k1,10));
				 q.enqueue(j1);
				 q.enqueue(Math.max(i1+k1-10,0));
			}
		
			else if (!marked[i1][Math.max(k1+j1-4,0)][Math.min(k1+j1,4)]){

				 edgeTo[i1][Math.max(k1+j1-4,0)][Math.min(k1+j1,4)] = s;//c2->c3
				 marked[i1][Math.max(k1+j1-4,0)][Math.min(k1+j1,4)] = true; 
				 q.enqueue(i1);
				 q.enqueue(Math.max(k1+j1-4,0));
				 q.enqueue(Math.min(k1+j1,4));
			}
		
			else if (!marked[i1][Math.min(j1+k1,7)][Math.max(j1+k1-7,0)]){

				 edgeTo[i1][Math.min(j1+k1,7)][Math.max(j1+k1-7,0)] = s;//c3->c2
				 marked[i1][Math.min(j1+k1,7)][Math.max(j1+k1-7,0)] = true;
				 q.enqueue(i1);
				 q.enqueue(Math.min(j1+k1,7));
				 q.enqueue(Math.max(j1+k1-7,0));
			}
		}//end while
		
		return answer; 
	}

	public static void main(String[] args){
		 
		
	 	bfs(0,7,4);
		StdOut.printf("%s \n", answer);
		//StdOut.printf("%d %d %d\n", i, j, k);
	}

}
