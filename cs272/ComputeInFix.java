/*
 * Victor Lozoya 
 * 3/30/2017
 * Lab6
 * ComputeInFix
 * 
 * will use stacks to evaluate an expression in infix notation 
 */


import java.util.Scanner;

 

public class ComputeInFix {//start of class

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//will ask user for expression and call the evaluate method 
		//will then print out the result 
		Scanner scan = new Scanner(System.in);
        String expression = " ";
        System.out.println("Please enter an expression " );
        expression = scan.nextLine();
        int test = evaluate(expression);
        System.out.println("Expression evaluates to: " + test);
	}
   
	
	/*
	 * Method that will take an expression, evaluate it and return the value
	 * @param:
	 * 			one type String
	 * pre:
	 * 		no negatives in the expression or any other 
	 *  	operation other than (+, -, *, /) 
	 *   	must use integers in expression 
	 * post:
	 * 		will return integer value of expression or might throw exceptions if it isn't balanced 
	 * 		correctly 
	 *   	
	 */
	 
   public static int evaluate(String express){
	   //create both stacks one of type Integer and Character 
	   LinkedStack<Integer> numStack = new LinkedStack<Integer>(); 
	   LinkedStack<Character> opStack = new LinkedStack<Character>();
	   int i = 0;
       char s;
        
       //do loop that goes through the expression 
       //use if statements to determine what stack the character will go into 
       
       do{
    	   s = express.charAt(i);
    	   if(s == '('){
    		   opStack.push(s);
    	   }
    	   else if(s == '0'||s == '1'||s == '2' ||s =='3'||s =='4' ||s =='5'|| s =='6'|| s =='7'||s == '8' || s =='9'){
    		   int k = i;
    		   int answer;

    		   while (k < express.length() && Character.isDigit(express.charAt(k))) { 
    		           k++;
    		   }
    		   answer = Integer.parseInt(express.substring(i,k)); // convert a substring starting at 
    		                           // index start and ending at index i-1 into an integer
    		   i = k -1 ; 
    		   numStack.push(answer);
    	   }
    	   else if(s == '+' || s == '-' || s == '*' || s == '/'){
    		   while(!opStack.isEmpty() && opStack.peek() != '(' && isNotLowerPrecedence(opStack.peek(), express.charAt(i+1))){
    			   int opnd1 ; 
    			   int opnd2;
    			   opnd2 = numStack.pop(); 
				   opnd1 = numStack.pop(); 
    			   //user switch statement to compute the arithmetic using the pop instruction 
				   //answer is pushed onto the number stack 
				   switch(opStack.pop()){
				   case '+':numStack.push(opnd1 + opnd2);
				   			break;
				   case '-':numStack.push(opnd1 - opnd2);
				   			break;
				   case '*':numStack.push(opnd1 * opnd2);
				   			break;
				   case '/':numStack.push(opnd1 / opnd2);
				            break; 
				   default : throw new IllegalArgumentException("Illegal operation");
    		   }
    	     }
    		   opStack.push(express.charAt(i));//push next operation onto stack 
    		   
    	 }
    	 else{//character a )
    		   while(opStack.peek() != '(' && !opStack.isEmpty()){
    			   int opnd1;
    			   int opnd2; 
    			   opnd2 = numStack.pop();
    			   opnd1 = numStack.pop(); 
    			   //compute operation on first two num popped 
    			   //save answer in numStack 
    			   switch(opStack.pop()){
    			   case '+':numStack.push(opnd1 + opnd2);
		   			  break;
		           case '-':numStack.push(opnd1 - opnd2);
		   			  break;
		           case '*':numStack.push(opnd1 * opnd2);
		   			 break;
		           case '/':numStack.push(opnd1 / opnd2);
		             break; 
		           default : throw new IllegalArgumentException("Illegal operation");
	              }
    		   }
    		   if(opStack.peek() != '('){
    			   throw new IllegalArgumentException("Unbalanced parantheses");
    		   }
    		   else
    			   opStack.pop(); 
    	   }
    	   
    	
      i++ ;
	}while(i < express.length());//condition while i is not as long as express length 
       
    while(!opStack.isEmpty()){
    	int opnd1;
		int opnd2; 
        opnd2 = numStack.pop();
   	    opnd1 = numStack.pop(); 
		   
		switch(opStack.pop()){
		   case '+':numStack.push(opnd1 + opnd2);
			  break;
           case '-':numStack.push(opnd1 - opnd2);
			  break;
           case '*':numStack.push(opnd1 * opnd2);
			 break;
           case '/':numStack.push(opnd1 / opnd2);
             break; 
           case ')':opStack.pop();
        	   break;
           default : throw new IllegalArgumentException("Illegal operation");
       }
    }
    
    if(!opStack.isEmpty()){
    	throw new IllegalArgumentException("Input expression did not have balanced parantheses");
    }
    
    return numStack.pop(); 
       

  }//end of evaluate 

	/*
	 * check if top operation on opStack is not of lower precedence than the next operation 
	 * in the expression return true if it is not 
	 * @param:
	 * 				two types of char 
	 * postcondition:
	 * 			return check true if it is not of lowerPrecedence or false if it is 
	 */
	public static boolean isNotLowerPrecedence(char s1, char s2){
		boolean check = true; 
		char lowerPrec = '+';
		char lowerPrec2 = '-';
		char highPrec = '*';
		char highPrec2 = '/';
		if(s1 == lowerPrec || s1 == lowerPrec2){
			if(s2 == highPrec || s2 == highPrec2){
				check = false; 
			}
			else{}
			
		}
		return check; 
	}//end isNotLowerPrecedence 
}//end class ComputeInFix 

