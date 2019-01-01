//Victor Lozoya
//lab2
//CS272
//Feb 2nd, 2017
//this class creates methods which find a pseudo random number 

public class Pseudorandom {
	//create private variables 
	private int multiplier, increment, modulus, seed; 
	
	//constructor which initializes the private variables 
	//Pseudorandom
	//public Pseudorandom(int mul, int sd, int inc, int mod)
	//has four parameters all types int mul, sd, inc, mod
	//all parameters are set to equal the private int variables which allows access and makes them public 
	public Pseudorandom(int mul, int sd, int inc, int mod){
		multiplier = mul;
		seed = sd; 
		increment = inc; 
		modulus = mod; 
	}
	
	//changeSeed
	//public void changeSeed(int new_seed)
	//has one parameter type int 
	//sets seed equal to new_seed 
	//no return value 
	public void changeSeed(int new_seed){
		seed = new_seed; 
		
	}
	
	//nextInt()
	//public int nextInt()
	//no parameters 
	//modulus must not be zero
	//this method creates integer num and sets it equal to a certain equation 
	//calls the changeSeed method and uses the num as the parameter for changeSeed
	//returns num
	public int nextInt(){
		int num = (multiplier * seed + increment) % modulus ;
		changeSeed(num); 
		return num;  
		
	}
	
	//nextDouble()
	//public double nextDouble()
	//returns value between the ranges of [0..1)
	//no parameters
	//returns a double value 
	public double nextDouble(){
		return ((multiplier * seed + increment) %  modulus) / (double) modulus;
	}
	 
}//end of class 


