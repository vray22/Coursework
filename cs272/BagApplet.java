// File: BagApplet.java
// This applet is a small example to illustrate how to write an interactive 
// Applet to test the methods of another class. This first version tests
// three of the IntArrayBag methods.
// -- Michael Main (main@colorado.edu)

// import edu.colorado.collections.IntArrayBag;
import java.applet.Applet;
import java.awt.*;          // Imports Button, Canvas, TextArea, TextField
import java.awt.event.*;    // Imports ActionEvent, ActionListener


public class BagApplet extends Applet
{  
   // An IntArrayBag for this Applet to manipulate:
   private IntArrayBag b = new IntArrayBag( );
   private IntArrayBag v = new IntArrayBag(); 


   // These are the interactive Components that will appear in the Applet.
   // We declare one Button for each IntArrayBag method that we want to be able to
   // test. If the method has an argument, then there is also a TextField
   // where the user can enter the value of the argument.
   // At the bottom, there is a TextArea to write messages.
   private Button    sizeButton             = new Button("size( )");
   private Button    b1addButton              = new Button("b1add( )");
   private TextField elementText            = new TextField(10);
   private Button    countOccurrencesButton = new Button("countOccurrences( )");
   private TextField targetText             = new TextField(10);
   private TextArea  feedback               = new TextArea(7, 60);
   private Button    b1toString             = new Button("b1.toString()");
   private Button    b2toString             = new Button("b2.toString()");
   private Button    b1removeAll            = new Button("b1.removeAll(b2)");
   private Button    b2removeAll            = new Button("b2.removeAll(b1)");
   private Button    b2add                  = new Button("b2.add()");
   private Button    b1remove               = new Button("b1.remove()");
   private Button    b2remove               = new Button("b2.remove()");
   private Button    b1equalsb2             = new Button("b1.equals(b2)");
   private Button    intersection           = new Button("intersection(b1, b2");
   
   public void init( )
   {      
      // Some messages for the top of the Applet:   
      add(new Label("This test program has created a bag."));
      add(new Label("Press buttons to activate the bag's methods."));
      addHorizontalLine(Color.blue);
       
     
      
      // The Button and TextField for testing the add method:
      add(b1addButton);
      //button for b1remove
      add(b1remove);
      add(elementText);
     
      //button for b2add
      add(b2add);
      
      //button for b2remove
      add(b2remove);
      addNewLine(); 
      
      
      //button for b1toString
      add(b1toString);
      
      //button for b2toString
      add(b2toString);
      addNewLine();
      
      //button for b1removeAll
      add(b1removeAll);
       
      
      //button for b2removeAll
      add(b2removeAll); 
      addNewLine(); 
      
      //button for b1.equals(b2)
      add(b1equalsb2);
      addNewLine(); 
      
      //button for intersection
      add(intersection);
      
      // A TextArea at the bottom to write messages:
      addHorizontalLine(Color.blue);
      addNewLine( );
      feedback.setEditable(false);
      feedback.append("I am ready for your first action.\n");
      add(feedback);
      
      // Tell the Buttons what they should do when they are clicked:
      sizeButton.addActionListener(new SizeListener( ));
      b1addButton.addActionListener(new AddListener( ));
      countOccurrencesButton.addActionListener(new CountOccurrencesListener( ));
      b1toString.addActionListener(new b1stringListener());
      b2toString.addActionListener(new b2stringListener());
      b1removeAll.addActionListener(new b1removeAllListener());
      b2removeAll.addActionListener(new b2removeAllListener());
      b2add.addActionListener(new b2addListener());
      b1remove.addActionListener(new b1removeListener());
      b2remove.addActionListener(new b2removeListener() );
      b1equalsb2.addActionListener(new b1equalsb2Listener());
      intersection.addActionListener(new intersectionListener());
   }
   
   class intersectionListener implements ActionListener{
	   public void actionPerformed(ActionEvent event){
		   IntArrayBag newBag = new IntArrayBag();
		   newBag = IntArrayBag.intersection(b, v);
		   
		   feedback.append(newBag.toString() + "\n"); 
	   }
   }
   
   class b1equalsb2Listener implements ActionListener{
	   public void actionPerformed(ActionEvent event){
		   boolean x = false; 
		   x = b.equals(v);
		   if(x == true){
			   feedback.append("bag1 is equal to bag2 \n");
		   }
		   else
			   feedback.append("bag1 is not equal to bag2\n");
   }
 }
   
   class b2removeListener implements ActionListener{
	   public void actionPerformed(ActionEvent event){
		   try
	       {
	          String userInput = elementText.getText( );
	          int element = Integer.parseInt(userInput);
	          v.remove(element);
	          feedback.append(element + " has been removed from the bag2.\n");
	       }
	       catch (NumberFormatException e)
	       {
	          feedback.append("Type an integer before clicking button.\n");
	          elementText.requestFocus( );
	          elementText.selectAll( );
	       }
		   
	   }
   }
   
   class b1removeListener implements ActionListener{
	   public void actionPerformed(ActionEvent event){
		   try
	       {
	          String userInput = elementText.getText( );
	          int element = Integer.parseInt(userInput);
	          b.remove(element);
	          feedback.append(element + " has been removed from the bag1.\n");
	       }
	       catch (NumberFormatException e)
	       {
	          feedback.append("Type an integer before clicking button.\n");
	          elementText.requestFocus( );
	          elementText.selectAll( );
	       }
		   
	   }
   }

   class b1removeAllListener implements ActionListener{
	   public void actionPerformed(ActionEvent event){
		   boolean x = false;
		   x = b.removeAll(v);
		   if(x == true ){
			 feedback.append("All elements from bag2 have been removed from bag1 \n");  
		   }
		   else
			   feedback.append("No elements have been removed\n"); 
	   }
	   
   }
   
   class b2removeAllListener implements ActionListener{
	   public void actionPerformed(ActionEvent event){
		   boolean x = false; 
		   x = v.removeAll(b); 
		   if(x == true){
			   feedback.append("All elements from bag1 have been removed from bag2\n");
		   }
		   else
			   feedback.append("No elements have been removed\n"); 
	   }
   }
   
   class b2addListener implements ActionListener{
	   public void actionPerformed(ActionEvent event){
	   try
       {
          String userInput = elementText.getText( );
          int element = Integer.parseInt(userInput);
          v.add(element);
          feedback.append(element + " has been added to the bag2.\n");
       }
       catch (NumberFormatException e)
       {
          feedback.append("Type an integer before clicking button.\n");
          elementText.requestFocus( );
          elementText.selectAll( );
       }
    } 
   }
   
   class SizeListener implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
	   feedback.append("The bag has size " + b.size( ) + ".\n");
      }
   }
   
   class b1stringListener implements ActionListener{
	   public void actionPerformed(ActionEvent event){
		   feedback.append(b.toString() + "\n");
	   }
   }
   class b2stringListener implements ActionListener{
	   public void actionPerformed(ActionEvent event){
		   feedback.append(v.toString() + "\n");
	   }
   }
   
   class AddListener implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
         try
         {
            String userInput = elementText.getText( );
            int element = Integer.parseInt(userInput);
            b.add(element);
            feedback.append(element + " has been added to the bag1.\n");
         }
         catch (NumberFormatException e)
         {
            feedback.append("Type an integer before clicking button.\n");
            elementText.requestFocus( );
            elementText.selectAll( );
         }
      }                   
   }

   
   class CountOccurrencesListener implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
         try
         {
            String userInput = targetText.getText( );
            int target = Integer.parseInt(userInput);
            feedback.append(target + " occurs ");
            feedback.append(b.countOccurrences(target) + " times.\n");
         }
         catch (NumberFormatException e)
         {
            feedback.append("Type a target before clicking button.\n");
            targetText.requestFocus( );
            targetText.selectAll( );
         }  
      }                   
   }
   

   private void addHorizontalLine(Color c)
   {  
      // Add a Canvas 10000 pixels wide but only 1 pixel high, which acts as
      // a horizontal line to separate one group of components from the next.
      Canvas line = new Canvas( );
      line.setSize(10000,1);
      line.setBackground(c);
      add(line);
   }

   
   private void addNewLine( ) 
   {  
      // Add a horizontal line in the background color. The line itself is
      // invisible, but it serves to force the next Component onto a new line.
      addHorizontalLine(getBackground( ));
   }

      
}

