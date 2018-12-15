// CS 172
// PairOfDice
// Lab12
// Written by: Victor Lozoya
// Nov. 16, 2016
//creates new methods for pairofdice calling methods from die.java 

public class PairOfDice//title 
{
   Die die1;//creates new die1 and 2
   Die die2; 
  
   
   public PairOfDice()//creates method of pairofdice composed of new objects from die.java
   {
    die1 = new Die();
    die2 = new Die();
   }
   
   public void setFaceValueOfdie1(int value)//method created for facevalue of die1 using method setfacevalue from die.java 
   {
      die1.setFaceValue(value); 
      
   }  
   
   public void setFaceValueOfDie2 (int value) //method created for setfacevalue for die2 using method setfacevalue from die.java 
   {
      die2.setFaceValue(value); 
   }
   
   public int getFaceValueOfDie1 ()//next two methods are created to getfacevalue of die1 and die2 using getfacevalues from die.java
   {
      return die1.getFaceValue(); 
   }
   
   public int getFaceValueOfDie2 ()
   {
      return die2.getFaceValue(); 
   }
   
   public void rollOfDice()//roll of dice method created using die roll from die.java 
   {
      die1.roll();
      die2.roll();  
   }
   
   public int sumOfDice() //sumofdice method created using getfacevalue of both die 1 and 2 
   {
      int sum; 
      sum = die1.getFaceValue() + die2.getFaceValue(); 
      return sum; 
   }
   
   public String toString()//tostring method telling the outcome of both die plus the sum 
   {
      return(" Die one: " + die1 + " Die two: " + die2 + " sum: " + sumOfDice());  
   }
   
   
     
}//end of class 