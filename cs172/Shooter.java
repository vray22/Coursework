// CS 172
// Shooter 
// Lab12
// Written by: Victor Lozoya
// Nov. 16, 2016
// class to create shooters with accuracy and if he is still alive or not 

public class Shooter //title 
{
   //instance variable 
   private String shooterName;
   private double shootingAccuracy; 
   private boolean stillAlive; 
   
   //constructor accept and initialize name and shooting accuracy 
   public Shooter(String shooterName, double shootingAccuracy) 
   {
      this.shooterName = shooterName; 
      this.shootingAccuracy = shootingAccuracy; 
      stillAlive = true; //everytime shooter created than stillAlive is true 
   }
   
   public String getName()                                    
   {
      return shooterName; 
   }//end of getName 
   
   public double getAccuracy() 
   {
      return shootingAccuracy; 
   }//end of getAccuracy
   
   public boolean isAlive()
   {
      return stillAlive; 
   } //end of isAlive 
   
   public void ShootAtTarget(Shooter target)
   {
       if(Math.random() < shootingAccuracy)//if random generated number is less than shooting accuracy than target is hit 
       {
           target.stillAlive = false; 
       }
        
   }//end of ShootAtTarget
   
   
}//end of class