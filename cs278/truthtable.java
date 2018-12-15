/**
 * 
 * @author Victor Lozoya 
 * Lab1
 * August 29, 2017 
 * cs278
 *
 */

public class truthtable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create my hard coded strings with all possible values of three variables 
        String one = " T T T ";
        String two = " T T F ";
        String three = " T F T ";
        String four = " T F F ";
        String five = " F T T ";
        String six = " F T F ";
        String seven = " F F T ";
        String eight = " F F F ";
        
        //initialize count and i 
        int count; 
        int i;
        
        //for loop to go from 1 to 255 and increment count by 1
        for(count = 1; count < 256; count++) {
        	i = count;
        	
        	//hard code truth table plus p q r proposition 
        	System.out.println("Truth table " + i + ":");
        	System.out.println("p q r proposition ");
        	System.out.println("--------------");
        	System.out.print(one);
        	
        	//series of if statements to see if T value will be printed for current count 
        	//will also print string after each bit number is checked 
        	if(i >= 128){
        		System.out.println("T");
        		i = i - 128;//if count is bigger than number than T will be printed and i becomes difference of 128 and i 
        	}
        	else 
        		System.out.println("F");
        	    
        	System.out.print(two);
        	if(i >= 64){
        		System.out.println("T");
        		i = i - 64;
        	}
        	else 
        		System.out.println("F");
        	System.out.print(three);
        	if(i >= 32){
        		System.out.println("T");
        		i = i - 32;
        	}
        	else 
        		System.out.println("F");
        	
        	System.out.print(four);
        	if(i >= 16){
        		System.out.println("T");
        		i = i - 16;
        	}
        	else 
        		System.out.println("F");
        	
        	System.out.print(five);
        	if(i >= 8){
        		System.out.println("T");
        		i = i - 8;
        	}
        	else 
        		System.out.println("F");
        	System.out.print(six);
        	if(i >= 4){
        		System.out.println("T");
        		i = i - 4;
        	}
        	else 
        		System.out.println("F");
        	
        	System.out.print(seven);
        	if(i >= 2){
        		System.out.println("T");
        		i = i - 2;
        	}
        	else 
        		System.out.println("F");
        	
        	System.out.print(eight);
        	if(i >= 1){
        		System.out.println("T");
        		i = i - 1;
        	}
        	else 
        		System.out.println("F");
        	
        	
        	
        }  //end for loop 
	}//end main 

}//end class 
