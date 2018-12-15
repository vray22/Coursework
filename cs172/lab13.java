// CS 172
// triangle,joinedTriangle,backwards,binary to decimal  
// Lab13
// Written by: Victor Lozoya
// Nov. 28, 2016
// use recursive methods to create a triangle made of asterisks plus a joined triangle, prints string backwards, converts binary to decimal using recursive methods 
public class lab13
{
  public static void triangle(int n) 
  {
     if(n > 0)//base case 
     {
       triangle(n-1);//method calls itself 
       for(int i = 0; i <= n-1 ; i++)
       System.out.print("*");
       System.out.println();
     }//end of if 
  }//end of triangle 

   public static void joinedTriangles(int n) 
   {
    if(n>0)//base case 
    {
      for(int i = 0; i < n; i++){
        System.out.print("*");   
        }   
     System.out.println();
     joinedTriangles(n-1);//method calls itself 
     
     for(int i = 0; i <= n-1 ; i++)
       System.out.print("*");
       System.out.println();
    }//end of if 
     
   }//end of joinedTriangles 
 
   public static void backwards(String word) 
   { 
     if(word.length() == 0)//base case 
     return;
   
     else//recursive case
     System.out.print(word.substring(word.length()-1));
     backwards(word.substring(0, word.length() - 1));//method calls itself  
   }//end of backwards 
 
   public static int convert(String binNumber)
   {
     int temp; //initialize temp
     if(binNumber.length() == 0)//base case
     return 0; 
   
     else//recursive case 
     temp = Integer.parseInt(binNumber.substring(0,1)) * (int) Math.pow(2,binNumber.length()-1);//use parseInt method to convert string to int then multiple the first index with 2 raised to the power of length-1 
     return (temp + convert(binNumber.substring(1,binNumber.length())));//method calls itself  
   }//end of convert 
   
  
   public static void main(String[] args)
   {
     //calls recursive method convert 3 times
     System.out.println("Binary: 110 " + "Decimal: " + convert("110"));
     System.out.println("Binary: 111 " + "Decimal: " + convert("111"));
     System.out.println("Binary: 1101 " + "Decimal: " + convert("1101"));
     System.out.println();
    
     //calls recursive method triangle 3 times
     triangle(3);
     System.out.println();
     triangle(4);
     System.out.println();
     triangle(5);
     System.out.println();
   
     //calls recursive method joinedTriangles 3 times 
     joinedTriangles(3);
     System.out.println();
     joinedTriangles(4);
     System.out.println();
     joinedTriangles(5);
     System.out.println();
     
     //calls recursive method backwards 3 times 
     backwards("Get");
     System.out.println();
     backwards("Paid");
     System.out.println();
     backwards("AllDay");
   
   
   }//end of main 
}//end of class 
