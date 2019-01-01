/*
 * Victor Lozoya 
 * 3/30/2017
 * Lab6
 * Palindrom
 * will use stacks to see if a sequence of integers is palindromic 
 */

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		
		//initialize stacks
		LinkedStack<Integer> s1 = new LinkedStack<Integer>();// TODO Auto-generated method stub
		LinkedStack<Integer> s2 = new LinkedStack<Integer>();
		LinkedStack<Integer> s3 = new LinkedStack<Integer>();
		
		//ask user for seq num and store it in num 
		System.out.println("How many integers are in sequence? ");
		Scanner scnr = new Scanner(System.in); 
		Scanner scnr2 = new Scanner(System.in);
		int num, input, origNum;
		num = scnr.nextInt(); 
		origNum = num; 
		
		//will ask user to enter the seq of integers and store into stack one and two 
		System.out.println("Please enter a sequence of " + num + " integers ");
		while(num > 0){
			input = scnr2.nextInt(); 
			s1.push(input);
			s2.push(input);
			
			num--; 
		}
		
		num = origNum; 
		//will pop one stack and push elements onto third stack 
		while(!s1.isEmpty()){
			s3.push(s1.pop());
			num --; 
		}
		
		//will compare each element from original stack and third stack which is new seq 
		//if each is correct answer stays true otherwise becomes false loop breaks 
        num = origNum;
        boolean answer = true; 
        while( !s2.isEmpty() && answer == true){
        	int element, element2;
        	
        	element = s2.pop(); 
        	element2 = s3.pop();
        	if(element != element2){
        		answer = false;  
        		
        	}
        	num--;
        }
        //print if seq is palindromic or not 
        if(answer == true){
        	System.out.println("This sequence is palindromic ");
        }
        else
        	System.out.println("This sequence is not palindromic ");
        
	}

}//end class palindrom 
