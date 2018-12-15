// CS 172
// DueAlt 
// Lab12
// Written by: Victor Lozoya
// Nov. 16, 2016
// generates duals between shooters using various methods 

public class DuelAlt//start of class 
{
   public static void main (String[] args)
   {
      //initialize alex,brad, and carl count 
      int alexCount = 0; 
      int bradCount = 0; 
      int carlCount = 0; 
      for(int i = 1; i <= 10000; i++)//for loop that stops when i is more than 10,000
      {
        //creates shooters alex, brad, carl
        Shooter alex = new Shooter("Alex", 0.33); 
        Shooter brad = new Shooter("Brad", 0.5);
        Shooter carl = new Shooter("Carl", 1.0);
        
        int countOfPeople = 3;//initialize count of people  
        
        while(countOfPeople > 1)//start of while loop as long as countOfPeople is more than 1
        {
           //if statement allowing brad to shoot other shooters if they are alive subtracts 1 from countof people if someone is not alive            
           if(brad.isAlive())
           {
              if(carl.isAlive())
              {
                 brad.ShootAtTarget(carl);
                 if(!carl.isAlive())
                     countOfPeople = countOfPeople - 1;       
              }
              else
              {
                 brad.ShootAtTarget(alex);
                 if(!alex.isAlive())
                     countOfPeople = countOfPeople - 1;       
                     
              }
           }//end of bradalive 
           //if statements that allow carl to shoot other shooters if they are alive if someone dies subtracts from countofpeople
           if(carl.isAlive())
           {
              if(brad.isAlive())
              {
                 carl.ShootAtTarget(brad);
                 if(!brad.isAlive())
                     countOfPeople = countOfPeople - 1;       
              }
              else
              {
                 carl.ShootAtTarget(alex);
                 if(!alex.isAlive())
                     countOfPeople = countOfPeople - 1;       
              }
           }//end of carlalive
           //if statements that have alex shoot other shooters if they are alive 
           if(alex.isAlive())
           {
              if(carl.isAlive())
              {
                alex.ShootAtTarget(carl);
                if(!carl.isAlive())
                    countOfPeople = countOfPeople - 1;      
              }
              else
              {
                 alex.ShootAtTarget(brad);
                 if(!brad.isAlive())
                     countOfPeople = countOfPeople - 1;       
              } 
           }//end of alexlive

             
        }//end of while loop
        
        //if statements that add to shooters count if they are last one standing 
        if(alex.isAlive())
        {
           alexCount++; 
        } 
        else if(brad.isAlive())
        {
           bradCount++; 
        }
        else
        {
           carlCount++; 
        }
        
     }//end of for loop
      //print statements that print out probabilities of each shooter after the duals  
      System.out.printf("Alex won %d / 10,000 or %.2f",alexCount, ((double)alexCount)/100);
      System.out.println("%");
      System.out.printf("Brad won %d / 10,000 or %.2f",bradCount, ((double)bradCount)/100);
      System.out.println("%");
      System.out.printf("Carl won %d / 10,000 or %.2f",carlCount, ((double)carlCount)/100);
      System.out.println("%");      
   }//end of main
}//end of class