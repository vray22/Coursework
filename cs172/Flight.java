// CS 172
// Student
// Lab11
// Written by: Victor Lozoya
// Nov. 7, 2016
//start flight information by setting and getting the airlinename, origin, destination, and number  

public class Flight //title of class 
{ 
   String airLineName, flightOrigin, flightDestination;//initialize instance variables  
   int flightNumber; 
   

   public Flight (String airName, int num, String origin, String destination)//creates constructor with four parameters each equaling one of the instance variables  
   {
        airLineName = airName; 
        flightOrigin = origin; 
        flightDestination = destination; 
        flightNumber = num;  
   }//end of constructor 
   
   public String getAirName()//method to get airName prints out the airline name is followed by airName 
   {
         return airLineName; 
   }//end of getairname 
   
   public int getNum()//method to get flightNumber which prints out the flight number is followed by flightNumber 
   {
      return flightNumber; 
   }//end of get flightnumber 
   
   public String getOrigin()//method to get origin prints out origin city is plus flightOrigin 
   {
         return flightOrigin; 
   }//end of get origin 
   
   public String getDestination()//method to get flights destination and prints out flights destination city is followed by flightDestination 
   {
         return flightDestination;  
   }//end of getDestination 
   
   public void setAirName(String airname)//set airlinename 
   {
        airLineName = airname; 
        
   }//end of setAirName 
   
   public void setNum(int n)//set flightnumber 
   {
       flightNumber = n; 
        
   }//end of setNum 
   
   public void setOrigin(String origin)//set flight origin 
   {
        flightOrigin = origin;

   }//end of setorigin 
   
   public void setDestination(String destination)//set flight destination 
   {
       flightDestination = destination;
       
   }//end of setdestination 
   
   public String toString ()//toString method to print out airLine information 
   {
        return (airLineName+ " " + flightNumber+ " --From: " + flightOrigin + "," + " To: " + flightDestination );
   }//end of toString 
}//end of class flight 
   
   

   