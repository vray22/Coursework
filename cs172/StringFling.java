// CS172 
// StringFling 
// Lab5
// Written by: Victor Lozoya 
// Sept. 14, 2016 
// does multiple things with strings inputted by users


import java.util.Scanner;//allows me to input scanner 
public class StringFling//title of class
{
   public static void main(String[] args)
   {
         
         String string1 = "";//initiliaze string1
         String string2 = "";//initiliaze string2
         String string3 = "";//initiliaze string3
          
           
         Scanner scnr = new Scanner(System.in);//ask user to enter string1 and becomes string1
         System.out.print("Enter string1 ");
         string1 = scnr.nextLine();
         
         
         Scanner scnr2 = new Scanner(System.in);//ask user to enter string2 which becomes string2
         System.out.print("Enter string2 ");
         string2 = scnr.nextLine();
         
         System.out.println("The length of first string is " + string1.length()+ " the length of second string is " + string2.length());//prints length of first and second strings
         System.out.println("The first string in all uppercase is " + string1.toUpperCase() );//prints first string in all uppercase
         System.out.println("The second string in all lowercase is " + string2.toLowerCase() );//prints string2 in all lowercase 
         
         string3 = (string1.toUpperCase());//string3 becomes string1 in all uppercase 
         string3 = string3.concat(string2.toLowerCase());//string 3 combines with string2 in all lowercase 
         System.out.println("Concatenation of the strings is " + string3); //prints results
         
         String string4 = string3.substring(string3.length()-1);//string4 becomes last character of string3
         
         
         String string5 = string3.substring(0,1);//string5 becomes first character of string3
         
         
         String string6 = string3.substring(1, string3.length()-1);//string6 becomes string3 without first and last characters 
         System.out.println("Concatenation with first and last characters swapped is " + string4 + string6 + string5 );//prints out string4 then string6 then string5
         
         System.out.println("The character at index 4 of first string is " + string1.charAt(4));//prints character at index 4
         string2 = string2.replace('a','*');//replaces vowels with *
         string2 = string2.replace('e','*');
         string2 = string2.replace('i','*'); 
         string2 = string2.replace('o','*');
         string2 = string2.replace('u','*'); 
         System.out.println("The lowercase version of the second string with vowels replaced with " + " * " + " is " + string2); //prints results  
                  
       
         
      
         
     }
}//end of program 