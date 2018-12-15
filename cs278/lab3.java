/**
 * Victor Lozoya
 * CS278
 * Lab3
 * Sept 14 
 * This program will ask user for 10 digits and determine if the quantified statemets are true or false 
 */


import java.util.Scanner;

public class lab3{

      public static void main(String[] args){
        //askuser for ten integers and store in array of integers 
        Scanner scan = new Scanner(System.in);
        int nums[] = new int[10];    
        System.out.println("Enter 10  values for domain: ");
        for(int i =0; i<9; i++){
            nums[i]=scan.nextInt();
        }
        
        //print out the resluts of each quantified statement 
        System.out.println("a) " + a(nums) ); 
        System.out.println("b) " + b(nums) );
        System.out.println("c) " + c(nums) );
        System.out.println("d) " + d(nums) );
        System.out.println("e) " + e(nums) ); 
     }
     /**
      * 
      * @param array of integers num
      * will user for loop combine with if statements to see if quantified statements are true or false 
      * will call methods impl which is implementation 
      * @return string 
      */
     public static String a(int num[]){
         String answer = "True";
         
         for(int i = 0; i<9; i++){
        	 String a = "T";
             String b = "T"; 
            if(num[i] >  0){
                a = "F";
            }
            if(num[i] % 2 == 0){
                b = "F";
            } 
            if(impl(a, b) == "F"){
               return answer = "False";
            }
            else{}
         }
       return answer;
     }//end of method a 
     /**
      * 
      * @param array of integers num
      * @return string true or false 
      * will use for loop with if statements to determine if quantified statement is true or false 
      * will call method impl which implementation 
      */
     public static String b(int num[]){
          String answer = "False";
          String a = "T";
          String b = "T";
          for(int i =0; i < 9; i++){
        	 
             if(num[i] > 0){
                a = "F";
             }
             if(num[i] % 2 == 0){
                b = "F";
             }
             if(impl(a, b) == "T"){
               return answer = "True";
             }
             else{}
           }
          return answer;
      }//end method b 
     /**
      * 
      * @param integer array num
      * @return string true or false 
      * will call method conj which is conjuction between two true and false values 
      * uses for loop with if statements 
      */
     public static String c(int num[]){
           String answer = "False";
           String a = "T";
           String b = "T";
           for(int i = 0; i < 9; i++){
        	  
              if(num[i] > 0){
                a = "F";
              }
              if(num[i] % 2 == 0){
                 b = "T";
              }
              if(conj(a, b) == "T"){
                 return answer = "True";
              }
                else{}
           }
          return answer; 
      }//end of method c 
     /**
      * 
      * @param integer array num
      * @return string true or false 
      * will call method impl 
      * uses for loops and if statements 
      */
     public static String d(int num[]){
           String answer = "True";
           
           for(int i = 0; i < 9; i++){
        	   String a = "T";
               String b = "T"; 
              if(num[i] % 3 != 0){
                a = "F";
              }
              if(num[i] % 5 != 0){
                b = "F";
              }
              if(impl(a, b) == "F"){
                return answer = "False";
              }
              else{}
            }
          return answer;
      }//end method d
      /**
       * 
       * @param integer array num
       * @return string true or false 
       * call method impl
       * uses for loops and if statements while going throug array num 
       */
      public static String e(int num[]){
           String answer = "False";
           String a = "T";
           String b = "T";
           for(int i = 0; i < 9; i++){
        	  
              if(num[i] % 3 != 0){
                a = "F";
              }
              if(num[i] % 5 != 0){
                b = "F";
              }
              if(impl(a, b) == "T"){//calls method impl 
                return answer = "True";
              }
              else{}
            }
          return answer; 
      }//end method e 



/**
	 * 
	 * @param a
	 * @param b
	 * determines implication of a and b 
	 * @return true or false value 
	 */
	public static String impl(String a, String b){
		String answer = "T";
		
		if(((a.equals("T")) || a.equals("t")) && ((b.equals("T") || b.equals("T")))){}
		if(((a.equals("T")) || a.equals("t")) && ((b.equals("F") || b.equals("f")))){
		     return answer = "F";
		}
		if(((a.equals("F")) || a.equals("f")) && ((b.equals("T") || b.equals("T")))){}
		if(((a.equals("F")) || a.equals("f")) && ((b.equals("F") || b.equals("f")))){}
		
		return answer; 
	}//end method 




	/**
	 * 
	 * @param a
	 * @param b
	 * determines conjuction of two values a and b 
	 * @return true or false value 
	 */
	public static String conj(String a, String b){
		String answer = "T";
		if(((a.equals("T")) || a.equals("t")) && ((b.equals("T") || b.equals("T")))){}
		if(((a.equals("T")) || a.equals("t")) && ((b.equals("F") || b.equals("f")))){
			answer = "F";
		}
		if(((a.equals("F")) || a.equals("f")) && ((b.equals("T") || b.equals("T")))){
			answer = "F";
		}
		if(((a.equals("F")) || a.equals("f")) && ((b.equals("F") || b.equals("f")))){
			answer = "F";
		}
		
		return answer; 
	}//end method conj



}//end of class
