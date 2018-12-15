// CS172 
// type of address  
// Lab5
// Written by: Victor Lozoya 
// Sept. 15, 2016 
// prints out type of web adress 

import java.util.Scanner;//allows me to input scanner 
public class WebAddress//title of class
{
   public static void main(String[] args)
   {
   
        String webAddress;//initialize 
        
        Scanner scnr = new Scanner(System.in);
        System.out.println(" Enter webaddress ");//prompts user to enter webaddress 
        webAddress = scnr.nextLine();//webAddress becomes input
        
        
        
        if(webAddress.endsWith(".gov"))//checks if webAddress ends in .gov
           {
               System.out.println("This is a government web address");//prints if it is government address
           } 
        else if(webAddress.endsWith(".edu"))//checks if webAddress ends in .edu
            {
               System.out.println("This is a university web address");//prints if it is a university web address
            }
        else if(webAddress.endsWith(".com"))//checks if webAddress ends in .com
            {
               System.out.println("This is a business web address");//prints if it is a business web address 
            }
        else if(webAddress.endsWith(".org"))//checks if webAddress ends in .org 
            {
               System.out.println("This is an organization web address");//prints if webAddress is a organization web address
            }
            else 
               { 
                  System.out.println("Web address is for another entity");//prints out web address is for another entity 
               } 
            
   }
}//end of type of address 