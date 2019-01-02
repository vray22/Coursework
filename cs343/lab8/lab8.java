/*
Victor Lozoya 
lab8 
use DFS to solve pouring container problem 
find pouring that leaves 2 in the 7 or 4 pint container 
*/



import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import java.util.*;








public class lab8{
	
	public static boolean marked[][][] = new boolean[11][8][5]; 
	public static Stack path = new Stack(); 
	public static boolean answer = false; 

	public static boolean dfs(int i, int j, int k){
		marked[i][j][k] = true; 
		StdOut.printf("%d %d %d\n", i, j , k); 
		if(j==2 || k==2){ answer = true; }  
		else if (!marked[Math.max(j+i-7,0)][Math.min(j+i,7)][k]) dfs(Math.max(j+i-7,0),Math.min(j+i,7),k);//c1->c2
		else if (!marked[Math.min(i+j,10)][Math.max(i+j-10,0)][k]) dfs(Math.min(i+j,10),Math.max(i+j-10,0),k);//c2->c1
		else if (!marked[Math.max(k+i-4,0)][j][Math.min(k+i,4)]) dfs(Math.max(k+i-4,0),j,Math.min(k+i,4));//c1->c3
		else if (!marked[Math.min(i+k,10)][j][Math.max(i+k-10,0)]) dfs(Math.min(i+k,10),j,Math.max(i+k-10,0));//c3->c1
		else if (!marked[i][Math.max(k+j-4,0)][Math.min(k+j,4)]) dfs(i,Math.max(k+j-4,0),Math.min(k+j,4));//c2->c3
		else if (!marked[i][Math.min(j+k,7)][Math.max(j+k-7,0)]) dfs(i,Math.min(j+k,7),Math.max(j+k-7,0));//c3->c2
		
		return answer; 
	}

	public static void main(String[] args){
		 
		
	 	dfs(0,7,4);
		StdOut.printf("%s \n", answer);
		//StdOut.printf("%d %d %d\n", i, j, k);
	}

}
