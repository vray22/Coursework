/*
 * Victor Lozoya 
 * Lab4
 * this will test all the methods from the doubleLinkedSeq class 
 * march 6th 2017 
 * CS272
 */
public class TestSequence{

	public static void main(String[] args) {
	DoubleLinkedSeq v = new DoubleLinkedSeq();
	DoubleLinkedSeq b = new DoubleLinkedSeq(); 
	//test my addBefore method and toString
	b.addBefore(3.0);
	b.addBefore(3.5);
	b.addBefore(3.7);
	b.addBefore(3.2);
	System.out.println("This is sequences after addBefore " + b);
	
	//test my addAfter method and getCurrent
	//test my reverse method and everyOther as well 
	b.addAfter(4.5);
	b.addAfter(4.6);
	b.addAfter(4.8);
	System.out.println("This is sequence after addAfter " + b);
	System.out.println("Current element is " + b.getCurrent());
	System.out.println("new seq in reverse order " + b.reverse());
	System.out.println("new seq with every other " + b.everyOther());
    
	//this will test my size and advance method 
	v.addAfter(4.0);
	v.addAfter(6.1);
	v.addAfter(6.2);
	v.addBefore(6.3);
	System.out.println("this is the sequence " + v);
	System.out.println("This is the size " + v.size());
	System.out.println("Current element: " + v.getCurrent());
	v.advance();
	System.out.println("New current after advance " + v.getCurrent());
	v.start(); //test my start method 
	System.out.println("with start method new current element is " + v.getCurrent());
	v.addAtFront(9.0);//test my add at front method 
	System.out.println("new sequence with add at front method " + v);
	v.removeAtFront();//test my remove at front method 
	System.out.println("New sequence with remove at front " + v);
	System.out.println("is there a current element? true or false " + v.isCurrent());//test my is current method
		
	//Now I will test my addAll method 
	DoubleLinkedSeq all = new DoubleLinkedSeq();
	System.out.println(v); 
	System.out.println("New Sequence with all v elements added ");
	all.addAll(v);
	System.out.println(all);
	
	//Testing my clone method 
	DoubleLinkedSeq cloner = new DoubleLinkedSeq(); 
	cloner.addAfter(9.0);
	cloner.addAfter(7.0);
	cloner.addAfter(9.9);
	DoubleLinkedSeq cloner2 = new DoubleLinkedSeq(); 
	cloner2 = cloner.clone(); 
	System.out.println("A clone of cloner is " + cloner2);
	cloner.addAfter(11.0);
	System.out.println("Cloner after adding new element is " + cloner);
	System.out.println("the clone2 remains unchanged " + cloner2 );
	
	//Now I will test my concatenation method 
	DoubleLinkedSeq vic = new DoubleLinkedSeq(); 
	DoubleLinkedSeq mel = new DoubleLinkedSeq(); 
	vic.addAfter(9.8);
	vic.addAfter(9.7);
	vic.addAfter(9.3);
	vic.addAfter(9.1);
	mel.addAfter(20.0);
	mel.addAfter(20.1);
	mel.addAfter(20.2);
	mel.addAfter(20.3);
	DoubleLinkedSeq vicMel = new DoubleLinkedSeq(); 
	vicMel = DoubleLinkedSeq.concatenation(vic, mel);
	System.out.println("vic and mel sequence concatenated is " + vicMel);
	
		//here I will test my removeCurrent and toIth method 
		DoubleLinkedSeq test = new DoubleLinkedSeq(); 
		test.addAfter(1.0);
		test.addAfter(2.0);
		test.addAfter(9.0);
		System.out.println("Here is the sequence " + test);
		System.out.println("Current element " + test.getCurrent());
		test.removeCurrent();
		System.out.println("New Seq with the current element removed " + test);
		test.toIth(2);
		System.out.println("After the toIth method new current is " + test.getCurrent());
		
		
		//this method I will test my removeSmaller 
		DoubleLinkedSeq test2 = new DoubleLinkedSeq(); 
		test2.addAfter(5.0);
		test2.addAfter(8.0);
		test2.addAfter(11.0);
		test2.addAfter(5.0);
		test2.removeSmaller(6.0);
		System.out.println("After elements lower than 6.0 removed new sequence is " + test2);
		
		
		
		
        
	}

}
