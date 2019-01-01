// File: IntTreeBag.java from the package edu.colorado.collections

// The implementation of most methods in this file is left as a student
// exercise from Section 9.5 of "Data Structures and Other Objects Using Java"

//import edu.colorado.nodes.IntBTNode; 

/******************************************************************************
* This class is a homework assignment;
* An <CODE>IntTreeBag</CODE> is a collection of int numbers.
*
* <dl><dt><b>Limitations:</b> <dd>
*   Beyond <CODE>Integer.MAX_VALUE</CODE> elements, <CODE>countOccurrences</CODE>,
*   and <CODE>size</CODE> are wrong. 
*
* <dt><b>Outline of Java Source Code for this class:</b><dd>
*   <A HREF="../../../../edu/colorado/collections/IntTreeBag.java">
*   http://www.cs.colorado.edu/~main/edu/colorado/collections/IntTreeBag.java
*   </A>
*
* <dt><b>Note:</b><dd>
*   This file contains only blank implementations ("stubs")
*   because this is a Programming Project for my students.
*
* @version
*   Jan 24, 1999
*
* @see IntArrayBag
* @see IntLinkedBag
******************************************************************************/
public class IntTreeBag implements Cloneable
{
   // Invariant of the IntTreeBag class:
   //   1. The elements in the bag are stored in a binary search tree.
   //   2. The instance variable root is a reference to the root of the
   //      binary search tree (or null for an empty tree).
   IntBTNode root;   


   /**
   * Insert a new element into this bag.
   * @param <CODE>element</CODE>
   *   the new element that is being inserted
   * <dt><b>Postcondition:</b><dd>
   *   A new copy of the element has been added to this bag.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory a new IntBTNode.
   **/
   public void add(int element)
   {      
	  IntBTNode cursor = root; 
      if(root == null){
    	  root = new IntBTNode(element, null, null);// Implemented by student.
      }
      else{
    	  boolean done = false; 
    	  while(!done){
    		 if(element <= cursor.getData()){
    			 if(cursor.getLeft() == null){
    				 IntBTNode newLeft = new IntBTNode(element, null, null);
    				 cursor.setLeft(newLeft);
    				 done = true; 
    				 
    			 }//end inner for
    			 else{
    				 cursor = cursor.getLeft();
    			 }
    		 }//end outer if
    		 else if(element > cursor.getData()){
    			 if(cursor.getRight() == null){
    				 IntBTNode newRight = new IntBTNode(element, null, null);
    				 cursor.setRight(newRight);
    				 done = true; 
    				
    			 }//end inner if
    			 else{
    				 cursor = cursor.getRight();
    			 }//end else
    		 }//end else if
    	  }//end while 
      }//end outer else 
      
      //root.print(0);
   }//end of method 


   /**
   * Add the contents of another bag to this bag.
   * @param <CODE>addend</CODE>
   *   a bag whose contents will be added to this bag
   * <dt><b>Precondition:</b><dd>
   *   The parameter, <CODE>addend</CODE>, is not null.
   * <dt><b>Postcondition:</b><dd>
   *   The elements from <CODE>addend</CODE> have been added to this bag.
   * @exception IllegalArgumentException
   *   Indicates that <CODE>addend</CODE> is null.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory to increase the size of the bag.
   **/
   public void addAll(IntTreeBag addend)
   {
      // Implemented by student.
	  IntBTNode addroot; 
	  if(root == addend.root){//addend is the same as the bag that activated this method
		 addroot = IntBTNode.treeCopy(addend.root);
		 addTree(addroot);
	  }
	  else
		  addTree(addend.root);
   }//end addAll
   
   
   /**
   * Generate a copy of this bag.
   * @param - none
   * @return
   *   The return value is a copy of this bag. Subsequent changes to the
   *   copy will not affect the original, nor vice versa. 
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for creating the clone.
   **/ 
   
public IntTreeBag clone( )
   {  // Clone an IntTreeBag object.
      // Student will replace this return statement with their own code:
      IntTreeBag answer = new IntTreeBag(); 
      
    	  answer.root =  IntBTNode.treeCopy(root);
       
      
      
      return answer; 
      
   }
   

   /**
   * Accessor method to count the number of occurrences of a particular element
   * in this bag.
   * @param <CODE>target</CODE>
   *   the element that needs to be counted
   * @return
   *   the number of times that <CODE>target</CODE> occurs in this bag
   **/
   public int countOccurrences(int target)
   {
      // Student will replace this return statement with their own code:
	  int count = 0;
	  IntBTNode cursor = root;
	  while(cursor != null){//keep checking tree while cursor is not null 
		  if(target < cursor.getData()){
			  cursor = cursor.getLeft();
		  }//end if 
		  else if(target > cursor.getData()){
			  cursor = cursor.getRight();
		  }//end else if 
		  else if(target == cursor.getData()){
			  count++;//increment count 
			  cursor = cursor.getLeft();
		  }//end else if
	  }
      return count;
   }
   
             
   /**
   * Remove one copy of a specified element from this bag.
   * @param <CODE>target</CODE>
   *   the element to remove from the bag
   * <dt><b>Postcondition:</b><dd>
   *   If <CODE>target</CODE> was found in the bag, then one copy of
   *   <CODE>target</CODE> has been removed and the method returns true. 
   *   Otherwise the bag remains unchanged and the method returns false. 
   **/
   public boolean remove(int target)
   {
      // Student will replace this return statement with their own code:
	   boolean answer = false; 
	   IntBTNode cursor = root;
	   IntBTNode parentOfCursor = null;
	   while(cursor.getData() != target || answer != true){
	      
		   if(cursor.getData() != target && target < cursor.getData()){
			   parentOfCursor = cursor;
			   cursor = cursor.getLeft();
		   }
		   else if(cursor.getData() != target && target > cursor.getData()){
			   parentOfCursor = cursor; 
			   cursor = cursor.getRight();
		   }
		   else if(root.getData() == target && cursor.getLeft()== null){
			   root = root.getRight();
			   answer = true;
		   }
		   else if(cursor.getData() == target && cursor.getLeft() == null){
			   if(cursor == parentOfCursor.getLeft()){
				   parentOfCursor.setLeft(cursor.getRight());
				   answer = true;
			   }
			   else{
				   parentOfCursor.setRight(cursor.getRight());
			   	   answer = true;
			   }//end else
		    
		   }
		  else if(cursor.getData() == target && cursor.getLeft() != null){
			  cursor.setData(cursor.getLeft().getRightmostData());
			  cursor.setLeft(cursor.getLeft().removeRightmost());
			  answer = true;
		  }
	   }
	   root.print(0);
      return answer;
   }
   
      
   /**
   * Determine the number of elements in this bag.
   * @param - none
   * @return
   *   the number of elements in this bag
   **/                           
   public int size( )
   {
      return IntBTNode.treeSize(root);
   }
   

   /**
   * Create a new bag that contains all the elements from two other bags.
   * @param <CODE>b1</CODE>
   *   the first of two bags
   * @param <CODE>b2</CODE>
   *   the second of two bags
   * <dt><b>Precondition:</b><dd>
   *   Neither b1 nor b2 is null.
   * @return
   *   the union of b1 and b2
   * @exception IllegalArgumentException
   *   Indicates that one of the arguments is null.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for the new bag.
   **/   
   
public static IntTreeBag union(IntTreeBag b1, IntTreeBag b2)
   {
      // Student will replace this return statement with their own code:
	   IntTreeBag answer = new IntTreeBag(); 
	   answer.addTree(b1.root);
	   answer.addTree(b2.root);
	   answer.root.print(0);
      return answer;
   }
   /**
    * precondition: addroot is reference to the root of a binary search tree
    * that is separate from the binary search tree of the bag that activated 
    * this method.
    * postCondition: all the elements from the addroot's binary search tree
    * have been added to the binary search tree of the bag that activated 
    * this method 
    * @param addroot
    */
   private void addTree(IntBTNode addroot){
	   if(addroot != null){
		   add(addroot.getData());
		   addTree(addroot.getLeft());
		   addTree(addroot.getRight());
	   }
   }
   
  /**
public static IntTreeBag sortedArrayToBST(int[] data, int first, int last)
   {
	   
	   int middleIndex = (first+last)/2;//get middle index 
	   int rootElement = data[middleIndex];//set rootElement to middle of array 
	   IntBTNode r = new IntBTNode(rootElement, null, null);//root of bag is now middle index
	   IntTreeBag answer = new IntTreeBag();  
	   answer.root = r;
	   
	  if(middleIndex != 0){
		  
		  answer.root.setLeft(sortedArrayToBST(data, first, middleIndex-1));
		
	  }
	  if(middleIndex < last){
		   
		   sortedArrayToBST(data, middleIndex+1, last);
		   answer.root.setRight(r);
	   }
	  else{}
		  
		   
	  
	   answer.root.print(0);
	   return answer; 
   }
   **/
      
}