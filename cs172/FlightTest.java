// CS 172
// Student
// Lab11
// Written by: Victor Lozoya
// Nov. 7, 2016
//uses the four get methods to print out the airname, num, origin, and destination and uses four set methods to change second flight's parameters created and prints out flight after each change  

public class FlightTest //title of class 
{
    public static void main (String[] args)//start of main 
    {
        Flight flight1 = new Flight("US Air", 347, "Boston", "London");//first flight created including the four parameters it requires based on flight class
        System.out.println("Flight Created: "+flight1);//prints out flight created using toString method without being called 
        System.out.println("The airline name is "+flight1.getAirName());//call on the four get methods from class flight and prints them out 
        System.out.println("The flight number is "+flight1.getNum());
        System.out.println("The flight's origin city is "+flight1.getOrigin());
        System.out.println("The flight's destination city is "+flight1.getDestination());
        
        Flight flight2 = new Flight("Delta", 2061, "Philadelphia", "Atlanta");//new flight created using the 4 parameters of flight class 
        System.out.println("Another flight created: "+ flight2);//prints out flight created using toString method from flight class without calling it directly 
        //use the four set methods to change the airname, num, origin, and destination uses the toString method without calling to print out flight after each change 
        flight2.setAirName("United");
        System.out.println("The airline name has changed to United: \t"+flight2);
        
        flight2.setNum(4384);
        System.out.println("The flight number has changed to 4384:   \t"+flight2);
        
        flight2.setOrigin("El Paso");
        System.out.println("The origin city has changed to El Paso: \t"+flight2);
        
        flight2.setDestination("Houston");
        System.out.println("The destination city has changed to Houston: \t"+flight2); 

    }//end of main 
    
}//end of class 