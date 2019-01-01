// File: DoubleLinkedSeq.java from the package edu.colorado.collections

// This is an assignment for students to complete after reading Chapter 4 of
// "Data Structures and Other Objects Using Java" by Michael Main.


/******************************************************************************
* This class is a homework assignment;
* A DoubleLinkedSeq is a collection of double numbers.
* The sequence can have a special "current element," which is specified and 
* accessed through four methods that are not available in the sequence class 
* (start, getCurrent, advance and isCurrent).
*
* <dl><dt><b>Limitations:</b>
*   Beyond Int.MAX_VALUE elements, the size method
*   does not work.
*
* <dt><b>Note:</b><dd>
*   This file contains only blank implementations ("stubs")
*   because this is a Programming Project for my students.
*
* <dt><b>Outline of Java Source Code for this class:</b><dd>
*   <A HREF="../../../../edu/colorado/collections/DoubleLinkedSeq.java">
*   http://www.cs.colorado.edu/~main/edu/colorado/collections/DoubleLinkedSeq.java
*   </A>
*   </dl>
*
* @version
*   Jan 24, 1999
******************************************************************************/
public class DoubleLinkedSeq implements Cloneable
{
    private double manyNodes;
    private DoubleNode head;
    private DoubleNode tail;
    private DoubleNode cursor;
    private DoubleNode precursor; 
   /**
   * Initialize an empty sequence.
   * @param - none
   * <dt><b>Postcondition:</b><dd>
   *   This sequence is empty.
   **/   
   public DoubleLinkedSeq()
   {
      manyNodes = 0; 
      head = null;
      tail = null;
      cursor = null;
      precursor = null; // Implemented by student.
   }
    
 
   /**
   * Add a new element to this sequence, after the current element. 
   * @param element</CODE>
   *   the new element that is being added
   * <dt><b>Postcondition:</b><dd>
   *   A new copy of the element has been added to this sequence. If there was
   *   a current element, then the new element is placed after the current
   *   element. If there was no current element, then the new element is placed
   *   at the end of the sequence. In all cases, the new element becomes the
   *   new current element of this sequence. 
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for a new node.
   **/
   public void addAfter(double element)
   {
      if(head == null){// Implemented by student.
    	  head = new DoubleNode(element, null);
    	  tail = head; 
    	  cursor = head; 
    	  precursor = null; 
      }//end if
      else{
    	  if(isCurrent() == true && manyNodes == 1){
    		  tail.addNodeAfter(element);
    		  precursor = head;
    		  tail = head.getLink();
    		  cursor = tail;
    		  
    	  }//end if
    	  else{
    		  cursor.addNodeAfter(element); 
    		  precursor = cursor;
    		  cursor = cursor.getLink();
    		  tail = cursor; 
    	  }//end else
    	  
      }//end else
      manyNodes++; 
   }


   /**
   * Add a new element to this sequence, before the current element. 
   * @param element</CODE>
   *   the new element that is being added
   * <dt><b>Postcondition:</b><dd>
   *   A new copy of the element has been added to this sequence. If there was
   *   a current element, then the new element is placed before the current
   *   element. If there was no current element, then the new element is placed
   *   at the start of the sequence. In all cases, the new element becomes the
   *   new current element of this sequence. 
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for a new node.
   **/
   public void addBefore(double element)
   {
      if(head == null){
    	  head = new DoubleNode(element,null);
    	  tail = head; 
    	  cursor = head;
    	  precursor = null; // Implemented by student.
      }
      else{
    	  if(isCurrent() == true && manyNodes == 1){
    		  head = new DoubleNode(element, head);
    		  cursor = head;
    	  }//end if
    	  else if(isCurrent() == true && manyNodes > 1){
    		    if(cursor == head){
    		    	head = new DoubleNode(element, head);
    		    	cursor = head;
    		    }
    		    else{
    		    	precursor.addNodeAfter(element);
    		        cursor = precursor.getLink(); 
    		    }
    	  }//end else
      }//end else
      manyNodes++; 
   }
   
   
   /**
   * Place the contents of another sequence at the end of this sequence.
   * @param addend</CODE>
   *   a sequence whose contents will be placed at the end of this sequence
   * <dt><b>Precondition:</b><dd>
   *   The parameter, addend</CODE>, is not null. 
   * <dt><b>Postcondition:</b><dd>
   *   The elements from addend</CODE> have been placed at the end of 
   *   this sequence. The current element of this sequence remains where it 
   *   was, and the addend</CODE> is also unchanged.
   * @exception NullPointerException
   *   Indicates that addend</CODE> is null. 
   * @exception OutOfMemoryError
   *   Indicates insufficient memory to increase the size of this sequence.
   **/
   public void addAll(DoubleLinkedSeq addend)
   {
      DoubleNode[] copyInfo;
      if(addend == null)
    	  throw new IllegalArgumentException("append is null.");
         if(addend.manyNodes > 0){
    	   copyInfo = DoubleNode.listCopyWithTail(addend.head);
    	   copyInfo[1].setLink(head);
    	   head = copyInfo[0];
    	   manyNodes += addend.manyNodes; 
    	   
      }
    }
      
   
   
   /**
   * Move forward, so that the current element is now the next element in
   * this sequence.
   * @param - none
   * <dt><b>Precondition:</b><dd>
   *   isCurrent()</CODE> returns true. 
   * <dt><b>Postcondition:</b><dd>
   *   If the current element was already the end element of this sequence 
   *   (with nothing after it), then there is no longer any current element. 
   *   Otherwise, the new element is the element immediately after the 
   *   original current element.
   * @exception IllegalStateException
   *   Indicates that there is no current element, so 
   *   advance</CODE> may not be called.
   **/
   public void advance( )
   {
	   if(isCurrent() != true){// Implemented by student.
	          throw new IllegalStateException("no current element");
	      }
	      else
	    	  precursor = cursor;
	    	  cursor = cursor.getLink(); // Implemented by student.
   }
   
   
   /**
   * Generate a copy of this sequence.
   * @param - none
   * @return
   *   The return value is a copy of this sequence. Subsequent changes to the
   *   copy will not affect the original, nor vice versa. 
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for creating the clone.
   **/ 
   public DoubleLinkedSeq clone( )
   {  // Clone a DoubleLinkedSeq object.
	   DoubleLinkedSeq clone1;// Student will replace this return statement with their own code:
	      
	      try
	      {
	    	  clone1 = (DoubleLinkedSeq) super.clone();
	      }
	      catch(CloneNotSupportedException e)
	      {
	    	  throw new RuntimeException
	    	  ("This class does not implement clonable");
	      }
	      
	      clone1.head = DoubleNode.listCopy(head);
	      return clone1; 
   }
   

   /**
   * Create a new sequence that contains all the elements from one sequence
   * followed by another.
   * @param s1</CODE>
   *   the first of two sequences
   * @param s2</CODE>
   *   the second of two sequences
   * <dt><b>Precondition:</b><dd>
   *   Neither s1 nor s2 is null.
   * @return
   *   a new sequence that has the elements of s1</CODE> followed by the
   *   elements of s2</CODE> (with no current element)
   * @exception NullPointerException.
   *   Indicates that one of the arguments is null.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for the new sequence.
   **/   
   public static DoubleLinkedSeq concatenation(DoubleLinkedSeq s1, DoubleLinkedSeq s2)
   {
      // Student will replace this return statement with their own code:
	   if(s1 == null || s2 == null)// Student will replace this return statement with their own code:
           throw new IllegalArgumentException("s1 is null");
      
      DoubleLinkedSeq s3 = new DoubleLinkedSeq(); 
      s3.addAll(s2);
      s3.addAll(s1);
      return s3; 
   }


   /**
   * Accessor method to get the current element of this sequence. 
   * @param - none
   * <dt><b>Precondition:</b><dd>
   *   isCurrent()</CODE> returns true.
   * @return
   *   the current element of this sequence
   * @exception IllegalStateException
   *   Indicates that there is no current element, so 
   *   getCurrent</CODE> may not be called.
   **/
   public double getCurrent( )
   {
	   double element = 0; 
	      if(isCurrent() != true){// Student will replace this return statement with their own code:
	      throw new IllegalStateException ("no current element, getCurrent may not be called");
	      }
	      else
	    	  element = element + (cursor.getData()) ;
	      return element; 
   }


   /**
   * Accessor method to determine whether this sequence has a specified 
   * current element that can be retrieved with the 
   * getCurrent</CODE> method. 
   * @param - none
   * @return
   *   true (there is a current element) or false (there is no current element at the moment)
   **/
   public boolean isCurrent( )
   {
      boolean x; 
      if(cursor != null)// Student will replace this return statement with their own code:
          x = true;
      else
    	  x = false; 
      return x; 
   }
              
   /**
   * Remove the current element from this sequence.
   * @param - none
   * <dt><b>Precondition:</b><dd>
   *   isCurrent()</CODE> returns true.
   * <dt><b>Postcondition:</b><dd>
   *   The current element has been removed from this sequence, and the 
   *   following element (if there is one) is now the new current element. 
   *   If there was no following element, then there is now no current 
   *   element.
   * @exception IllegalStateException
   *   Indicates that there is no current element, so 
   *   removeCurrent</CODE> may not be called. 
   **/
   public void removeCurrent( )
   {
      if(isCurrent() != true){
    	  throw new IllegalStateException ("no current element");// Implemented by student.
      }
      else{ 
             if(precursor != null){
    	        precursor.removeNodeAfter();
                if(cursor.getLink() == null){
                	
        	        cursor = null;
        	        tail = precursor;
                }
                    else{
                    	precursor = cursor; 
                        cursor = cursor.getLink();
                    }
        	      
             }
            else{
            	head = head.getLink();
                cursor = head;
            }
         manyNodes--; 
      }
            	
   }
                 
   
   /**
   * Determine the number of elements in this sequence.
   * @param - none
   * @return
   *   the number of elements in this sequence
   **/ 
   public int size( )
   {
      int size = (int) manyNodes;// Student will replace this return statement with their own code:
      return size;
   }
   
   
   /**
   * Set the current element at the front of this sequence.
   * @param - none
   * <dt><b>Postcondition:</b><dd>
   *   The front element of this sequence is now the current element (but 
   *   if this sequence has no elements at all, then there is no current 
   *   element).
   **/ 
   public void start( )
   {
      if (cursor != head){
    	  cursor = head; // Implemented by student.
    	  precursor = null;
      }
   }
   /**
    * Print out the elements of a list by creating clone.
    * @param - none
    * <dt><b>Postcondition:</b><dd>
    *   returns the elements of the list when the print statement is called for a list.
    **/ 
   public String toString(){
	   DoubleLinkedSeq clone = new DoubleLinkedSeq(); 
	   clone = this.clone();
	   String elements = "{";
	   for(clone.cursor = head; clone.cursor != null; clone.cursor = clone.cursor.getLink()){
		   elements = elements + (clone.cursor.getData() + ","); 
	   }
	    
	   elements = elements + ")";
	   
	   return elements;  
   }
   /**
    * add new element at the front of this sequence.
    * @param - double element
    * <dt><b>Postcondition:</b><dd>
    *   The added element is at the front of this sequence and is now the current element (but 
    *   if this sequence has no elements at all, then there is no current 
    *   element).
    **/ 
   public void addAtFront(double element){
	   head = new DoubleNode(element, head);
	   cursor = head; 
	   precursor = null; 
	   
   }
   /**
    * remove element at front of this seq
    * @param
    *        none
    *        post condition: the first element has been removed from sequence
    */
   public void removeAtFront(){
	   head = head.getLink();
	   cursor = head; 
	   precursor = null; 
	   
	   manyNodes--;
   }
   /**
    * will return new sequence with elements in reverse from old sequence 
    * old sequence will remain unchanged
    * @param :
    *         none 
    * @return
    * will return a new sequence with the elements reversed from the old untouched 
    * sequence 
    */
   public DoubleLinkedSeq reverse(){
	   DoubleLinkedSeq rev = new DoubleLinkedSeq();
	   for(cursor = head; cursor != null; cursor = cursor.getLink()){
		   rev.addBefore(this.getCurrent());
	   }
	   
	   return rev; 
   }
   /**
    * will return new sequence with every other element from old sequence 
    * old sequence will remain unchanged
    * @param :
    *         none 
    * @return
    * will return a new sequence with the every other element from the old untouched 
    * sequence 
    */
   public DoubleLinkedSeq everyOther(){
	   DoubleLinkedSeq everyOther = new DoubleLinkedSeq(); 
	   int count = 2; 
	   for(cursor = head; cursor != null; cursor = cursor.getLink()){
		   if(count % 2 == 0){
			   everyOther.addAfter(this.getCurrent());
		   }
		   else {}
		   
		 count += 1; 
	   }
	   return everyOther; 
	   
}
   /*
    * this method will remove all elements smaller than the value passed as paramater 
    * pre condition: 
    * 				must be a sequence with at least one element to check 
    * @param
    *        double value 
    *  Post condition:
    *        the new sequence without the elements smaller than value
    *        if all element smaller than it makes the sequence empty  
    */
   public void removeSmaller(double value){
	   DoubleNode cursor2; 
	for(cursor = head; cursor != null; cursor = cursor.getLink()){
		if(cursor.getData() < value){
			if(cursor == head){
				head = head.getLink(); 
				manyNodes--; 
			}
			else{
				cursor2 = cursor; 
				this.removeCurrent();
				cursor = cursor2;
				manyNodes--; 
			}
		}
	}
   }
 
   /*
    * will make the current element the integer position passed in
    * the 1st element is in the front 
    * @Param
    * 				an integer 
    * precondition 
    * 				there must not be an empty sequence 
    * post condition 
    * 		the new current element will be the element at the position of the integer value passed in  
    */
   public void toIth(int integer){
	   int count = 1; 
	   for(cursor = head; cursor != null; cursor = cursor.getLink()){
		   if(count == integer){
			   break; 
		   }
		   else{}
		   count++;
	 }
   }
}
   
	 
		   
	   
   
	   
   

  

           
