/*******************************************************************************
* read.java
* Purpose: This program randomly generates SQL entries given user input
*
*   Instructions:  1) change directories to this file
*                  2) javac read.java
*                  3) java read
*                  4) enter 1, 2, or 3 corresponding to the instructions in terminal
*                  5) enter number of rows desired in text file
*                  6) enter the desired ID to start at, for players or games
*
********************************************************************************/

import java.io.*;               //import library for IO, used for filereading functions
import java.util.Scanner;       //import scanner for user input
import java.util.Random;        //import for random generations

public class read
{ 
    public static void main(String[] args)throws Exception 
    {
        /*INITIALIZE AND INSTANTIATE DATA*/
        Random rand  = new Random();
        Scanner scnr = new Scanner(System.in);
        int numRows = 0, FileChoice = 0, idStart = 0;
        String first[] = new String[40];            //arrays to hold data for teams, names, and fields
        String last[] = new String[40];
        String teams[] = new String[32];
        String pos[] = new String[3];
        char result[] = new char[3];
        String stad[] = new String[31];
        String pName = "";
        String Name = "";
        int randF, randL, randT, randP;     //random holders
        int randD, randM, randS, randR;
        
        System.out.println("SQL Random Table Generator");
        System.out.println();
        
        result[0] = 'W';            //results of the game
        result[1] = 'L';
        result[2] = 'T';
        
        first[0] = "Andrew";        //first names of the players
        first[1] = "Shane";
        first[2] = "Victor";
        first[3] = "Robert";
        first[4] = "Mark";
        first[5] = "Ben";
        first[6] = "Phillip";
        first[7] = "Melvin";
        first[8] = "Daunte";
        first[9] = "Mike";
        first[10] = "Tom";
        first[11] = "Josh";
        first[12] = "Kobe";
        first[13] = "LeBron";
        first[14] = "Alex";
        first[15] = "Devin";
        first[16] = "Justin";
        first[17] = "Chase";
        first[18] = "Blake";
        first[19] = "Pedro";
        first[20] = "Matt";
        first[21] = "Dustin";
        first[22] = "Tiger";
        first[23] = "Vince";
        first[24] = "Kyle";
        first[25] = "Rajon";
        first[26] = "Lance";
        first[27] = "Chris";
        first[28] = "James";
        first[29] = "Kyrie";
        first[30] = "Jared";
        first[31] = "Russel";
        first[32] = "Robby";
        first[33] = "Alshon";
        first[34] = "Carl";
        first[35] = "Will";
        first[36] = "Pete";
        first[37] = "Janseh";
        first[38] = "Evan";
        first[39] = "Tim";
        
        last[0] = " Baca";                  //last names of the players
        last[1] = " Grayson";
        last[2] = " Navarro";
        last[3] = " Lozoya";
        last[4] = " Dale";
        last[5] = " Roberts";
        last[6] = " Williams";
        last[7] = " Cooper";
        last[8] = " Johnson";
        last[9] = " Bryant";
        last[10] = " James";
        last[11] = " Paul";
        last[12] = " Harden";
        last[13] = " Westbrook";
        last[14] = " George";
        last[15] = " Ball";
        last[16] = " Kuzma";
        last[17] = " McKee";
        last[18] = " Stephenson";
        last[19] = " Rivers";
        last[20] = " Gordon";
        last[21] = " Durant";
        last[22] = " Curry";
        last[23] = " Green";
        last[24] = " Irving";
        last[25] = " Brown";
        last[26] = " Smith";
        last[27] = " Anthony";
        last[28] = " Tucker";
        last[29] = " Pitt";
        last[30] = " Chavez";
        last[31] = " Billingley";
        last[32] = " Turner";
        last[33] = " Machado";
        last[34] = " Wilson";
        last[35] = " Tate";
        last[36] = " Gruden";
        last[37] = " Lynch";
        last[38] = " Goodwin";
        last[39] = " Marshall";
        
        pos[0] = "QB";                          //position names
        pos[1] = "WR";
        pos[2] = "RB";
        
        teams[0] = "Chargers";                  //team names
        teams[1] = "Broncos";
        teams[2] = "Chiefs";
        teams[3] = "Raiders";
        teams[4] = "Bengals";
        teams[5] = "Browns";
        teams[6] = "Steelers";
        teams[7] = "Ravens";
        teams[8] = "Rams";
        teams[9] = "Seahawks";
        teams[10] = "49ers";
        teams[11] = "Cardinals";
        teams[12] = "Saints";
        teams[13] = "Panthers";
        teams[14] = "Bucaneers";
        teams[15] = "Falcons";
        teams[16] = "Patriots";
        teams[17] = "Dolphins";
        teams[18] = "Bills";
        teams[19] = "Jets";
        teams[20] = "Giants";
        teams[21] = "Cowboys";
        teams[22] = "Redskins";
        teams[23] = "Eagles";
        teams[24] = "Jaguars";
        teams[25] = "Texans";
        teams[26] = "Titans";
        teams[27] = "Colts";
        teams[28] = "Packers";
        teams[29] = "Loins";
        teams[30] = "Bears";
        teams[31] = "Vikings";
        
        stad[0] = "Oakland Coliseum";               //stadium names
        stad[1] = "LA Memorial Coliseum";
        stad[2] = "New Era Field";
        stad[3] = "Mercedes Benz Superdome";
        stad[4] = "EverBank Field";
        stad[5] = "Soldier Field";
        stad[6] = "Lincloln Financial";
        stad[7] = "Bank ofA Stadium";
        stad[8] = "Nissan Srtadium";
        stad[9] = "Fed Ex Field";
        stad[10] = "Levi's Stadium";
        stad[11] = "First Energy Field";
        stad[12] = "Paul Brown Stadium";
        stad[13] = "Sports Authority";
        stad[14] = "MetLife Stadium";
        stad[15] = "StubHub Center";
        stad[16] = "Ford Field";
        stad[17] = "NRG Stadium";
        stad[18] = "U of P Stadium";
        stad[19] = "ArrowHead Field";
        stad[20] = "Raymond James Field";
        stad[21] = "M&T bank Stadium";
        stad[22] = "Gillette Stadium";
        stad[23] = "Lucas Oil Field";
        stad[24] = "Hard Rock Field";
        stad[25] = "US Bank Stadium";
        stad[26] = "Mercedes Benz Field";
        stad[27] = "Lambeau Field";
        stad[28] = "Heinz Field";
        stad[29] = "CenturyLink Field";
        stad[30] = "Cowboy Stadium";
        

        do{
            System.out.println("1. Players");           //terminal menu
            System.out.println("2. Games");
            System.out.println("3. Plays");
            System.out.print("Enter the number corresponding to table you would like Generated: ");
            FileChoice = scnr.nextInt();
        
            switch(FileChoice){                             //assignment of file names
                case(1):
                    System.out.println("players.txt chosen to write to!");
                    Name = "players.txt";
                    break;
                case(2):
                    System.out.println("games.txt chosen to write to!");
                    Name = "games.txt";
                    break;
                case(3):
                    System.out.println("plays.txt chosen to write to!");
                    Name = "plays.txt";
                    break;
                default:
                    System.out.println("Invalid Entry");
            }
        }while(FileChoice < 1 || FileChoice > 3);
        
        System.out.print("Please enter the amount of random rows to enter: ");
        numRows = scnr.nextInt();                           //get the number of rows to randomize
        if(FileChoice == 1 || FileChoice == 2){
            System.out.print("Please enter ID to start at: ");
            idStart = scnr.nextInt();
        }
        
        try{
            File file = new File(Name);                     //assign file name
            
            if(!file.exists()){                             //create file in THIS directory if doesnt exist here
                file.createNewFile();
            }
            PrintWriter pw = new PrintWriter(file);         //write to file function
            
            if(FileChoice == 1){
                for(int i = 0; i <= numRows; i++){
                    randF = rand.nextInt(40);       //randomization for names and teams
                    randL = rand.nextInt(40);
                    randP = rand.nextInt(3);
                    randT = rand.nextInt(32);
                    pName = first[randF] + last[randL];     //cocatenate first and last name
                    pw.printf("%d,\t", idStart);            //print id
                    pw.printf("%40s, ", pName);             //print name to file
                    pw.printf("%20s, ", teams[randT]);      //print teams to file
                    pw.printf("\t");
                    pw.print(pos[randP]);                   //print position to file
                    pw.printf(",\t");
                    pw.print(rand.nextInt(50));             //print TDs to file
                    pw.printf(",\t");
                    pw.print(rand.nextInt(5000));           //print Yards to file
                    pw.printf(",\t");
                    pw.print(rand.nextInt(9000000));        //print random Salary
                    pw.println();
                    idStart = idStart + 1;
                }
            }
            
            if(FileChoice == 2)
            {
                for(int i = 0; i <= numRows; i++)
                {
                    pw.printf("%d\t\t", idStart);           //print id's to file
                    idStart = idStart + 1;
                    randM = rand.nextInt(3)+10;
                    randD = rand.nextInt(20)+10;
                    pw.print("20180"+randM+randD);          //print date to file
                    /*note that date is ater september and day is between 10 and 30 */
                    randS = rand.nextInt(31);
                    pw.printf(", %40s, \t", stad[randS]);       //print stadium top file
                    randR = rand.nextInt(3);
                    pw.print(result[randR]);
                    pw.printf("\t");
                    pw.print(rand.nextInt(60000)+1000);         //print random attendance
                    pw.printf("\t");
                    pw.println(rand.nextInt(2900000)+1000000);  //print random net income from game
                    
                }
            }
            
            if(FileChoice == 3)
            {
                for(int i = 0; i <= numRows; i++){
                    pw.printf("%d\t\t", rand.nextInt(numRows)+1);      //print random ID'S
                    pw.printf(",%d\n", rand.nextInt(9999)+1);          //print random ID's
                }
            }
            pw.close();                         //close files
            
        }catch(IOException e){
            e.printStackTrace();
        }
        
    } 
}
