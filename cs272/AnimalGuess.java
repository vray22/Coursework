// FILE: AnimalGuess.java
// This animal-guessing program illustrates the use of the binary tree node class.

//import edu.colorado.nodes.BTNode;
import java.util.Scanner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import java.io.FileOutputStream;
import java.io.FileNotFoundException;

/******************************************************************************
* The <CODE>AnimalGuess</CODE> Java application illustrates the use of
* the binary tree node class is a small animal-guessing game.
*
* <p><dt><b>Java Source Code for this class:</b><dd>
*   <A HREF="../applications/Animals.java">
*   http://www.cs.colorado.edu/~main/applications/Animals.java
*   </A>
*
* @author Michael Main 
*   <A HREF="mailto:main@colorado.edu"> (main@colorado.edu) </A>
*
* @version
*   Jul 22, 2005
******************************************************************************/
public class AnimalGuess
{
   private static Scanner stdin = new Scanner(System.in);
   
   /**
   * The main method prints instructions and repeatedly plays the 
   * animal-guessing game. As the game is played, the taxonomy tree
   * grows by learning new animals. The <CODE>String</CODE> argument
   * (<CODE>args</CODE>) is not used in this implementation.
   **/
   public static void main(String[ ] args)
   {   
	   Scanner scan = new Scanner(System.in);
	   /**
	   System.out.println("Enter filename: " );
	   String filename = scan.nextLine();
	   Scanner input = null;
	   try {
	      input = new Scanner(new FileInputStream(filename));    
	   } 
	   catch(FileNotFoundException fnfe) {
	      System.out.println("File " + filename + 
	   		   " was not found or could not be opened.");
	      System.exit(0);
	   }
	   //test my readFromFile method 
	   BTNode<String> root;
	   root = readFromFile(input);
	   
	   root.printLeaves();
	   //test size and see if it matches up 
	   System.out.println(root.treeSize(root));
	   
	   System.out.println("Enter file to write to: " );
	   filename = scan.nextLine();
	   PrintWriter output = null;
	   try 
	   {
	      output = new PrintWriter(new FileOutputStream(filename));
	   }
	   catch(FileNotFoundException fnfe) 
	   {
	      System.out.println("Error opening output file " + filename);
	      System.exit(0);
	   }
	   
	   writeToFile(output, root);

	   

	   output.close();
	   
	   System.out.println("Enter file to read from after writing to it: " );
	   filename = scan.nextLine();
	   try {
		      input = new Scanner(new FileInputStream(filename));    
		   } 
		   catch(FileNotFoundException fnfe) {
		      System.out.println("File " + filename + 
		   		   " was not found or could not be opened.");
		      System.exit(0);
		   }
		   //test my readFromFile method 
		   BTNode<String> root2;
		   root2 = readFromFile(input);
		   root2.printLeaves();
	   **/
	  System.out.println("Please enter filename: " );
	   String filename = scan.nextLine();
	   Scanner input = null;
	   try {
	      input = new Scanner(new FileInputStream(filename));    
	   } 
	   catch(FileNotFoundException fnfe) {
	      System.out.println("File " + filename + 
	   		   " was not found or could not be opened.");
	      System.exit(0);
	   }
      BTNode<String> root;

      
      root = readFromFile(input);//root starts from file root
      System.out.println("Knowledge tree is read from: " + filename);
      instruct( );
      do
         play(root);
      while (query("Shall we play again?"));

      System.out.println("Thanks for teaching me a thing or two.");
      System.out.println("Now I know the following animals: " );
      root.printLeaves();
      
      //update file with updated tree 
      PrintWriter output = null;
	   try 
	   {
	      output = new PrintWriter(new FileOutputStream(filename));
	   }
	   catch(FileNotFoundException fnfe) 
	   {
	      System.out.println("Error opening output file " + filename);
	      System.exit(0);
	   }
	   
	   writeToFile(output, root);
       output.close();
       
       System.out.println();
       System.out.println();
       System.out.println("Updated knowledge tree is written to file:" + filename);
      
   }
   
   
   /**
   * Print instructions for the animal-guessing game.
   **/
   public static void instruct( )
   {
      System.out.println("Please think of an animal.");
      System.out.println("I will ask some yes/no questions to try to figure");
      System.out.println("out what you are.");
   }
   

   /**
   * Play one round of the animal guessing game.
   * @param <CODE>current</CODE>
   *   a reference to the root node of a binary taxonomy tree that will be
   *   used to play the game.
   * <dt><b>Postcondition:</b><dd>
   *   The method has played one round of the game, and possibly
   *   added new information about a new animal.
   * @exception java.lang.OutOfMemoryError
   *   Indicates that there is insufficient memory to add new
   *   information to the tree.
   **/
   public static void play(BTNode<String> current)
   {
      while (!current.isLeaf( ))
      {
         if (query(current.getData( )))
            current = current.getLeft( );
         else
            current = current.getRight( );
      }

      System.out.print("My guess is " + current.getData( ) + ". ");
      if (!query("Am I right?"))
         learn(current);
      else
         System.out.println("I knew it all along!");
   }
   

   /**
   * Construct a small taxonomy tree with four animals.
   * @param - none
   * @return
   *   a reference to the root of a taxonomy tree with the animals:
   *   kangaroo, mouse, trout, robin.
   * @exception OutOfMemoryError
   *   Indicates that there is insufficient memory to create the tree.
   **/
   public static BTNode<String> beginningTree( )   
   {
      BTNode<String> root;
      BTNode<String> child;

      final String ROOT_QUESTION = "Are you a mammal?";
      final String LEFT_QUESTION = "Are you bigger than a cat?";
      final String RIGHT_QUESTION = "Do you live underwater?";
      final String ANIMAL1 = "Kangaroo";
      final String ANIMAL2 = "Mouse";
      final String ANIMAL3 = "Trout";
      final String ANIMAL4 = "Robin";
    
      // Create the root node with the question �Are you a mammal?�
      root = new BTNode<String>(ROOT_QUESTION, null, null);

      // Create and attach the left subtree.
      child = new BTNode<String>(LEFT_QUESTION, null, null);
      child.setLeft(new BTNode<String>(ANIMAL1, null, null));
      child.setRight(new BTNode<String>(ANIMAL2, null, null));
      root.setLeft(child);

      // Create and attach the right subtree.
      child = new BTNode<String>(RIGHT_QUESTION, null, null);
      child.setLeft(new BTNode<String>(ANIMAL3, null, null));
      child.setRight(new BTNode<String>(ANIMAL4, null, null));
      root.setRight(child);

      return root;
   }
 
 
   /**
   * Elicits information from the user to improve a binary taxonomy tree.
   * @param <CODE>current</CODE>
   *   a reference to a leaf node of a binary taxonomy tree
   * <dt><b>Precondition:</b><dd>
   *   <CODE>current</CODE> is a reference to a leaf in a binary
   *   taxonomy tree
   * <dt><b>Postcondition:</b><dd>
   *   Information has been elicited from the user, and the tree has
   *   been improved.
   * @exception OutOfMemoryError
   *   Indicates that there is insufficient memory to add new
   *   information to the tree. 
   **/
   public static void learn(BTNode<String> current)
   // Precondition: current is a reference to a leaf in a taxonomy tree. This
   // leaf contains a wrong guess that was just made.
   // Postcondition: Information has been elicited from the user, and the tree
   // has been improved.
   {
      String guessAnimal;   // The animal that was just guessed
      String correctAnimal; // The animal that the user was thinking of
      String newQuestion;   // A question to distinguish the two animals
      
      // Set Strings for the guessed animal, correct animal and a new question.
      guessAnimal = current.getData( );
      System.out.println("I give up. What are you? ");
      correctAnimal = stdin.nextLine( );
      System.out.println("Please type a yes/no question that will distinguish a");
      System.out.println(correctAnimal + " from a " + guessAnimal + ".");
      System.out.print("Your question: ");
      newQuestion = stdin.nextLine( );
      
      // Put the new question in the current node, and add two new children.
      current.setData(newQuestion);
      System.out.println("As a " + correctAnimal + ", " + newQuestion);
      if (query("Please answer"))
      {
         current.setLeft(new BTNode<String>(correctAnimal, null, null));
         current.setRight(new BTNode<String>(guessAnimal, null, null));
      }
      else
      {
         current.setLeft(new BTNode<String>(guessAnimal, null, null));
         current.setRight(new BTNode<String>(correctAnimal, null, null));
      }         
   }

   public static boolean query(String prompt)
   {
      String answer;
	
      System.out.print(prompt + " [Y or N]: ");
      answer = stdin.nextLine( ).toUpperCase( );
      while (!answer.startsWith("Y") && !answer.startsWith("N"))
      {
	 System.out.print("Invalid response. Please type Y or N: ");
	 answer = stdin.nextLine( ).toUpperCase( );
      }

      return answer.startsWith("Y");
   }
   /**
    * 
    * @param input
    * @return type is BTNode<String> which is the root 
    * method will create a tree by reading from file passed as param 
    */
   public static BTNode < String> readFromFile(Scanner input)
   {
	   	BTNode<String> temp; 
	   String str = input.nextLine();
	   if(str.charAt(0) != '?'){//base case
		   temp = new BTNode<String>(str,null,null);
		   return temp;
	   }
	   else{
		   temp = new BTNode<String>(str, readFromFile(input), readFromFile(input));
		   return temp;
	   }
   }//end readFromFile
   /**
    * 
    * @param output
    * @param root
    * method will write a tree to a file starting at the root
    */
   public static void writeToFile(PrintWriter output, BTNode < String> root){
	   String s = root.getData();
	   
	   if(root.isLeaf()){//base case 
		   output.write(s);
		   output.println();
	   }
	   else{
		   output.write(s);
		   output.println();
		   BTNode<String> temp = root.getLeft();
		   writeToFile(output, temp);
		   temp = root.getRight();
		   writeToFile(output, temp);
	   }
   }//end writeToFile


}




