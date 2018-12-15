// CS 172
// Dual 
// Lab12
// Written by: Victor Lozoya
// Nov. 16, 2016
// class to have dual of shooters using various methods from shooter.java

public class Duel//title of class 
{
   public static void main (String[] args)
   {
      //initialize count for shooters 
      int alexCount = 0; 
      int bradCount = 0; 
      int carlCount = 0; 
      for(int i = 1; i <= 10000; i++)//for loop stops when i is more than 10000
      {
        //creates new shooters alex,brad,carl
        Shooter alex = new Shooter("Alex", 0.33); 
        Shooter brad = new Shooter("Brad", 0.5);
        Shooter carl = new Shooter("Carl", 1.0);
        
        int countOfPeople = 3;//intiliaze countOfPeople  
        //while loop exucutes as long as countOfPeople is greater than 1 
        while(countOfPeople > 1)
        {
           //if statements that allow alex to shoot if he is alive and as long as other shooters are too 
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
           //if statements to allow brad to shoot others still alive 
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
           //if statements allow carl to shoot others still alive subtracts 1 from countOfPeople if someone dies 
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
             
        }//end of while loop
        //if statements that add to shooters count if they are last one to stand 
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
      //print out the probabilities of each shooter winning after duals   
      System.out.printf("Alex won %d / 10,000 or %.2f",alexCount, ((double)alexCount)/100);
      System.out.println("%");
      System.out.printf("Brad won %d / 10,000 or %.2f",bradCount, ((double)bradCount)/100);
      System.out.println("%");
      System.out.printf("Carl won %d / 10,000 or %.2f",carlCount, ((double)carlCount)/100);
      System.out.println("%");
   }//end of main
}//end of class