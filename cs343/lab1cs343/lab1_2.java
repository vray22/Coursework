/**
Victor Lozoya
will solve the cubic root of a given double number 

**/

public class lab1_2{


	public static double cubic(double c)
	{			
		if (c < 0) return Double.NaN;
		double err = 1e-15;
		double t = c;
		double temp;
		double temp2;
		while (Math.abs(t - c/Math.pow(t,2)) > err * t){
                        temp = c/Math.pow(t,2);
			temp2 = 2*t;
			t = (temp + temp2)/3.0;
			//System.out.println(t);
	        }
		return t;
	}


	public static void main(String[] args){
		//test cases
		System.out.println("cubic root of 125: " + cubic(125));
		System.out.println("cubic root of 8: " + cubic(8));
	} 
} 
