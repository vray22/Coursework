/*
Victor Lozoya 
lab7 
March 27th 2018 
this problem is the hash attack which looks for 2^n strings the size 2^n that 
might have the same hashcode



*/




import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdOut;
import java.util.*;





public class lab7{


	public static void main(String[] args){

		int n = Integer.parseInt(args[0]);
		String temp = " "; 

		if(n <= 1){StdOut.printf("number must be greater than 1 \n");}


		int x = (int) Math.pow(2, n); 
		int k = 0;
		char c = ' ';  
		int hV;
		HashMap<Integer, Integer> a = new HashMap<>();
		boolean found = false; 

		
		for(int j=0; j<10000000; j++){
		   //StdOut.printf("%d \n ", j);
			for(int i =0; i < x; i++){
				k = (int) StdRandom.uniform(32, 126);
				c = (char) k; 
				temp = temp.concat(Character.toString(c)); 
			}
		   //StdOut.printf("%s \n", temp);
		   hV = temp.hashCode(); 
		   if (a.containsKey(hV))
			a.put(hV,a.get(hV)+1);
		   else
			a.put(hV,1);
		   if(a.get(hV) >= x){StdOut.printf("Found 2^n strings with same hashcode \n"); found = true; break; }
		   else{};
		   //StdOut.printf("%d \n", hV);
		   temp = " ";  
		}
		if(found == false){StdOut.printf("Didn't find 2^n strings with same hashcode \n");}
	}
}
