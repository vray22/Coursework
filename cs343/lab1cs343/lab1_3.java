/**
Victor Lozoya
will use shuffle method to shuffle elements of array 
will store those new permutations inside an array of strings
will shuffle once more to count occurances and get average plus standard deviations 
Jan. 30th
**/



import java.util.Random; 
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats; 

public class lab1_3{

  public static void shuffle(double[] a){
	int N = a.length;
	for (int i = 0; i < N; i++){ // Exchange a[i] with random element in a[i..N-1]
		int r = i + StdRandom.uniform(N-i);
		double temp = a[i];
		a[i] = a[r];
		a[r] = temp;
	}
  }



  public static void main(String[] args){

	double[] a = {1, 2, 3, 4, 5, 6};
	double[] a2 = {1, 2, 3, 4, 5, 6}; 
        String[] b = new String[720];
	b[0] = "1 2 3 4 5 6"; 
	String temp = " ";  
	double[] c = new double[720]; 
	double sum = 0; 
	double average = 0; 
        //this loop stores results        
	for(int j=0; j<720;j++){

	    shuffle(a);
	   for(int i = 0; i<=5; i++){
		//System.out.print(a[i] + " ");
		temp += Double.toString(a[i]) + " ";
		
	  }//end inner loop 
	   b[j] = temp; //store result in string array 
	 //  System.out.println(b[j]);
	   temp = " ";  
	}//end outer loop 
	

	//loop to shuffle again and count occurances to determine frequencies
	for(int k = 0; k < 720; k++){
		shuffle(a); 
		for(int t = 0; t <= 5; t++){
			temp += Double.toString(a[t]) + " ";
		}//end inner loop 
		for(int p = 0; p < b.length; p++){
			if(temp.equals(b[p])){
			   c[p]++;
			} 
			else{}; 
		}//end loop
	   temp = " "; 
	}//end outer loop 
	 for(int y = 0; y < c.length; y++){
		//System.out.println(c[y]);
		sum += c[y];
	 }
	average = sum / 720; 
	System.out.println("Average: " + average); 
 	System.out.println("Standard Dev: " + StdStats.stddev(c));  
	System.out.println("Population standard dev: " + StdStats.stddevp(c));      
  }//end main 
}
