/*
 * Name: Victor Lozoya 
 * CS272
 * Lab5
 * Create methods swap, concat, reverse, and merge and test them 
 * 3/13/2017
 */
public class DLinkTester {
	/*
	 * swap nodes x and y as well as links of x and y 
	 * and neighbors
	 * @param:
	 *       two references to nodes x and y 
	 *  Post Condition:
	 *                 will return true if x and y were swapped 
	 *                 if not it will return false if any links or x and y 
	 *                 are null 
	 */
	public static boolean swap(DNode x, DNode y){
		if(x == null || y == null){
			return false; 
		}
		else if(x.getNext() == null || x.getPrev() == null){
			return false; 
		}
		else if(y.getNext() == null || y.getPrev() == null){
			return false; 
		}
		else{
			if(x == y){
				return true; 
			}
			else if(y.getPrev() == x){
				
			    DNode px = x.getPrev();
				DNode ny = y.getNext();
				px.setNext(y);
				x.setNext(ny);
				x.setPrev(y);
				ny.setNext(x);
				y.setPrev(px); 
				y.setNext(x);
			}
			else if(y.getNext() == x){
				DNode py = y.getPrev(); 
				DNode nx = x.getNext();
				py.setNext(x);
				y.setNext(nx);
				y.setPrev(x);
				nx.setNext(y);
				x.setPrev(py);
				x.setNext(y);
			}
			else{
				DNode px = x.getPrev();
				DNode nx = x.getNext(); 
				DNode py = y.getPrev(); 
				DNode ny = y.getNext(); 
				px.setNext(y);
				nx.setPrev(y);
				x.setNext(ny);
				x.setPrev(py);
				py.setNext(x);
				ny.setPrev(x);
				y.setNext(nx);
				y.setPrev(px);
				
			}
		 return true; 
		}
   }//end swap 
    /*
     * take two DList and concat them to make a new List N 
     * @param:
     *       references to two doubly linked list L and M 
     * PostCondition:
     *            will return reference to new node that has 
     *            been concatenated        
     *
     */
	public static DList concat(DList L, DList M){
		DList n = new DList();
		DNode x = L.getFirst(); 
		DNode px = new DNode(null, null, null);
		while(x.getNext() != null){
			if(x == L.getFirst()){
				String element = x.getElement();
			    DNode addend = new DNode(element, null, null);
			    n.addFirst(addend);
			    px = n.getFirst();
			    x = x.getNext();
			}
			else{
				String element = x.getElement();
				DNode addend = new DNode(element, null, null);
				n.addAfter(px, addend);
				px = px.getNext(); 
				x = x.getNext(); 
				}
		}
		x = M.getFirst();
		while(x.getNext() != null){
			String element = x.getElement();
			DNode addend = new DNode(element, null, null);
			n.addAfter(px, addend);
			px = px.getNext(); 
			x = x.getNext(); 
		}
		return n; 
	}//end concat 
	/*
	 * will take a doubly linked list and reverse order of elements 
	 * @param:
	 *       reference to a doubly linked list 
	 *  PostCondition:
	 *                none 
	 */
	public static void reverse(DList L){
	    String temp;
	    int size = L.size();
	    int i = 1;
	    temp = L.getLast().getElement();
	    L.getLast().setElement(L.getFirst().getElement());
	    L.getFirst().setElement(temp);
	    DNode x = L.getLast();
	    DNode x2 = L.getFirst();
	    while(i < size/2){
	    	temp = x.getPrev().getElement();
	    	L.getPrev(x).setElement(x2.getNext().getElement());
	    	L.getNext(x2).setElement(temp);
	    	x = x.getPrev();
	    	x2 = x2.getNext();
	    	i++;
	    }
  }//end reverese
	/*
	 * will create a new doubly linked list with element from two other list
	 * adds first element of first list then first of second list and so on
	 * @param:
	 *       reference to two new doubly linked list
	 *  PostCondition:
	 *       will return new doubly linked list with elements from parameters     
	 */
	public static DList merge(DList L, DList M){
		DNode x = L.getFirst();
		String temp = x.getElement();
		DNode y = M.getFirst();
		String temp2 = y.getElement();
		DList n = new DList();
		DNode cn = new DNode(temp, null,null); 
		DNode cn2 = new DNode(temp2, null,null); 
		if(x.getElement() != null){
			n.addFirst(cn);
			
			if(y.getElement() != null){
				n.addLast(cn2);
				y = y.getNext();
			 }
		  x = x.getNext(); 	
		}
	while(x.getElement() != null){
		    temp = x.getElement();
		    DNode next = new DNode(temp, null, null);
			n.addLast(next);
			
			if(y.getElement() != null){
				temp2 = y.getElement();
				DNode nextM = new DNode(temp2, null, null);
				n.addLast(nextM);
				y = y.getNext();
			}
	   x = x.getNext();
	}
	if(x.getElement() == null){
		while(y.getElement() != null){
			temp2 = y.getElement();
			DNode nextM = new DNode(temp2, null, null);
			n.addLast(nextM);
			y = y.getNext(); 
		}
	}
   return n; 
  }//end merge
	
	/* 
	 * will test methods i have just creted 
	 */
	public static void main(String[] args) {
		DList xList = new DList(); // TODO Auto-generated method stub
        DNode x = new DNode("2", null, null);
        DNode v = new DNode("3", null, null);
        xList.addFirst(x);
        xList.addAfter(x, v);
        System.out.println("First List is: " + xList);
        //test swap method with x previous of y 
        System.out.println("Test swap method should return true: " + DLinkTester.swap(x, v)); 
        System.out.println("Nodes swaped " + xList);
        //test swap method with x next of y 
        System.out.println("Another swap test should be true: " + DLinkTester.swap(x, v));
        System.out.println("Elements should be back to original " + xList);
        //test swap with elements not next to each other 
        DList vList = new DList(); 
        DNode m = new DNode("5", null, null);
        DNode y = new DNode("6", null, null);
        DNode t = new DNode("8", null, null);
        DNode o = new DNode("9", null, null);
        vList.addFirst(m);
        vList.addAfter(m, y);
        vList.addAfter(y, t);
        vList.addAfter(t, o);
        System.out.println(vList);
        System.out.println("Test swap three should be true " + DLinkTester.swap(m, o));//test swap
        System.out.println("After swap " + vList);
        //test concat method
        DList mList = new DList(); 
        DNode m1 = new DNode("4", null, null);
        DNode m2 = new DNode("6", null, null);
        mList.addFirst(m1);
        mList.addAfter(m1, m2);
        System.out.println("New concat of vList and mList is: " + DLinkTester.concat(vList, mList));
       
        System.out.println("Doesn't change original list: " + vList);
        DLinkTester.reverse(vList);//test reverse method 
        System.out.println("List in reverse: " + vList);
        
        DNode m3 = new DNode("10",null,null);
        DNode m4 = new DNode("11",null,null);
        DNode m5 = new DNode("12",null,null);
        DNode m6 = new DNode("13",null,null);
        DNode m7 = new DNode("14",null,null);
        DNode m8 = new DNode("15",null,null);
        DList testRev = new DList();
        testRev.addFirst(m3);
        testRev.addAfter(m3, m4);
        testRev.addAfter(m4, m5);
        testRev.addAfter(m5, m6);
        testRev.addAfter(m6, m7);
        testRev.addAfter(m7, m8);
        System.out.println("Current list: " + testRev);
        DLinkTester.reverse(testRev);//test reverse method 
        System.out.println("New list in reverse: " + testRev);
        //test Merge method 
        DList testMerge = new DList(); 
        DList testMerge2 = new DList(); 
        DNode one = new DNode("one",null, null);
        DNode two = new DNode("two",null, null);
        DNode three = new DNode("three",null, null);
        testMerge.addFirst(one);
        testMerge.addAfter(one, two);
        testMerge.addAfter(two, three);
        DNode uno = new DNode("1",null, null);
        DNode duece = new DNode("2",null, null);
        DNode tray = new DNode("3",null, null);
        testMerge2.addFirst(uno);
        testMerge2.addAfter(uno, duece);
        testMerge2.addAfter(duece, tray);
        System.out.println("First list being used: " + testMerge);
        System.out.println("Second list being used: " + testMerge2);
        System.out.println("Merge: " + DLinkTester.merge(testMerge, testMerge2));
        
        //test merge again 
        DList testMerge3 = new DList(); 
        DList testMerge4 = new DList(); 
        DNode four = new DNode("four",null, null);
        DNode five = new DNode("five",null, null);
        DNode six = new DNode("six",null, null);
        testMerge3.addFirst(four);
        testMerge3.addAfter(four, five);
        testMerge3.addAfter(five, six);
        DNode quad = new DNode("4",null, null);
        DNode cinco = new DNode("5",null, null);
        DNode siX = new DNode("6",null, null);
        DNode sev = new DNode("7",null, null);
        DNode eight = new DNode("8",null, null);
        DNode nine = new DNode("9",null, null);
        testMerge4.addFirst(quad);
        testMerge4.addAfter(quad, cinco);
        testMerge4.addAfter(cinco, siX);
        testMerge4.addAfter(siX, sev);
        testMerge4.addAfter(sev, eight);
        testMerge4.addAfter(eight, nine);
        System.out.println("First list being used: " + testMerge3);
        System.out.println("Second list being used: " + testMerge4);
        System.out.println("Merge: " + DLinkTester.merge(testMerge3, testMerge4));
        System.out.println("Test concat method: " + DLinkTester.concat(testMerge3, testMerge4));//test concat method 
        
   }//end main 

}//end class 
