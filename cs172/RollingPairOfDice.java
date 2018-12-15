// CS 172
// RollingPairOfDice
// Lab12
// Written by: Victor Lozoya
// Nov. 16, 2016
// calls methods from pairofDice.java and creates new pair of dice 

public class RollingPairOfDice//title of class 
{
   public static void main (String[] args)//start of main 
    {
      PairOfDice pairOfDice1 = new PairOfDice (); //creates new object pair of dice1
      pairOfDice1.setFaceValueOfdie1(1); //calls setfacevalueofdie1
      pairOfDice1.setFaceValueOfDie2(1);//calls setfacevalueofdie2
      
      pairOfDice1.getFaceValueOfDie1(); //calls getfacevalueofdie1
      pairOfDice1.getFaceValueOfDie2(); //calls getfacevalueofdie2
      
      pairOfDice1.rollOfDice();//calls rollofdice method
      
      pairOfDice1.sumOfDice();//calls sumofdice method 
      
      System.out.println (pairOfDice1.toString()); //calls toString method 
       
    } //end of main 
} //end of class 