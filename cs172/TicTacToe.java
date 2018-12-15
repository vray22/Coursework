// CS 172
// TicTacToe
// Lab10
// Written by: Victor Lozoya
// Oct 26. 2016
// play TicTacToe with the user and computer 
import java.util.Scanner; //allows scanner input 
import java.util.Random;//allows random generator 
class TicTacToe //title of class 
{ 
       public static void main(String args[ ]) //main body start   
        {     
           char status = '-'; // status choices are '-', 'X', 'O', 'T'
           char [ ][ ] gameBoard = { {'-', '-', '-'}, 
                                     {'-', '-', '-'},                               
                                     {'-', '-', '-'} };//creates 2D array 
            Scanner scan = new Scanner(System.in); //allows new scanner     
            Random generator = new Random( );  //allows random generator    
            System.out.println("Let’s play Tic Tac Toe. You will be X and I will be O");  //tells user lets play tic tac toe and displays gameboard    
            display(gameBoard); //calls method display gameboard 
            status = gameStatus(gameBoard);
            while(status == '-'){ //while loop that calls certain methods userMove, display, computerMove, while status isn't - 
              
               userMove(scan, gameBoard);//calls method userMove 
               display(gameBoard);//Calls method display 
               if( (status = gameStatus(gameBoard) ) != '-')
               break;
               computerMove(generator, gameBoard); 
               display(gameBoard);
               
               status = gameStatus(gameBoard);
              
            }
            if(status == 'X')//if statements that tell you if user won or computer or if it was a tie depending on certain conditions 
            {
              System.out.println("you win!"); 
            }
            else if(status == 'O') 
            {
              System.out.println("I win!"); 
            }
            else
            {
              System.out.println("We tied "); 
            }
       }//end of main 
     public static void display(char [ ][ ] gameBoard)//start of display mehtod 
     {
            for (int i=0; i < 3; i++)//creates the game board with empty spaces and vertical lines and dashes and plus signs 
            {  
               for (int j = 0; j < 3; j++){
               if(gameBoard[i][j] == '-')
               {
                 System.out.print("   "); 
               } 
                else 
                {
                  System.out.print(" " + gameBoard[i][j] +  " ");
                }
                 if(j<2)
                {
                  System.out.print("|");//vertical line printed 
                }
               } 
               if(i < 2)
               {
                 System.out.println("\n---+---+---");//three dashes with plus signs printed 
               }        
               
               
            } //end of outer loop
            System.out.println();//prints line after every row   
     }//end of display
     
      public static void userMove(Scanner scan, char [ ][ ] gameBoard)   
      {     
          int row, col;     
          do 
          {       
          System.out.print("Enter row(0..2) and column(0..2) of your move: ");       
            row = scan.nextInt( );       
            col = scan.nextInt( );     
          }
            while ( row < 0 || row > 2 || col < 0 || col > 2 || gameBoard[row][col] != '-' );     
            gameBoard[row][col] = 'X';   
      } // end userMove nethod 
      
       public static void computerMove(Random generator, char [ ][ ] gameBoard)   
       { 
         int row, col; //initialize row and column 
    
         do{
             row = generator.nextInt(3);
             col = generator.nextInt(3);
         } //end of do while loop 
         while(gameBoard[row][col] != '-');//do while loop that generates a random number betweeen 0-2 and checks if it fits in the display 
         gameBoard[row][col] = 'O'; //inputs and O if the area is empty 
         System.out.println("My move was row " + row + " and column " + col); 
       } // end computerMove method 
       
       
      //---------------------------------------------------- 
      // Method gameStatus takes as input a 2-dimentional array
      // representing the Tic Tac Toe board and returns one of
      // the following 4 characters:
      //
      // 'X' if there exists a row, a column, or a diagonal with three X marks,
      // 'O' if there exists a row, a column, or a diagonal with
      //    three O marks,
      // '-' if none of the above conditinos apply and there is
      //    at least one '-' in the two-dimentional array (the game is not over yet),
      // 'T' if none of the above conditinos apply (the game is over, we have a tie).
      //----------------------------------------------
       
       public static char gameStatus(char [ ][ ] gameBoard)   
       {      
       char status = 'T' ;     
         for(int i = 0; i < 3; i++)//checks rows and sees if they are all the same nd if so returns that value 
         {
            if(gameBoard[i][0] == gameBoard[i][1] && gameBoard[i][1] == gameBoard[i][2])
            {
               return gameBoard[i][0];
    
            }
            if(gameBoard[0][i] == gameBoard[1][i] && gameBoard[1][i] == gameBoard[2][i])//checks columns if all three equal each other and returns value 
            {
              return gameBoard[1][i]; 
            }
         }//end of loop 

         if(gameBoard[0][0] == gameBoard [1][1] && gameBoard[1][1] == gameBoard [2][2])//checks if all elements in array diagonal positions are equal if so returns value  
         {
           return gameBoard[1][1]; 
         } 
         else if(gameBoard[2][0] == gameBoard [1][1] && gameBoard[1][1] == gameBoard[0][2])//checks other diagnol elements in array and if all equal returns value 
         {
           return gameBoard[2][0]; 
         } 
         
        for(int i =0; i < 3; i++)//loop that checks if there is any empty spaces as - if so returns value to keep playing 
        {
          for(int j=0; j < 3; j++)
          {
             if(gameBoard[i][j] == '-')
                return '-';  
          }
       }// end of loop     
       
        return status;
       } // end gameStatus method 
       
   
}//end of class 