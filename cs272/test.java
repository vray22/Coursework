/**
 * Victor Lozoya 
 * Lab10
 * 5/4/17
 * will test methods i created in inttreebag.java 
 * 
 */


import java.util.Scanner;
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
         int test[] = new int[5];
         test[0] = 2;
         test[1] = 3;
         test[2] = 5;
         test[3] = 7;
         test[4] = 9;
       
         IntTreeBag.sortedArrayToBST(test, 0, 4);
         
         /**t.add(5);
         t.add(6);
         t.add(8);
         t.add(5);
         System.out.println(t.remove(6));
         /**
         System.out.println(t.countOccurrences(5));
         
         t2.add(7);
         t2.add(10);
         t2.add(81);
         t2.add(52);
         **/
       
         //IntTreeBag.union(t, t2);
		Scanner scan = new Scanner(System.in);
		 System.out.println("How many element are there? ");
		 int elements = scan.nextInt();
		 
		 int data[] = new int[elements];
		 int i = 0;
		 //will ask user to input a number to add to array 
		 while(i < elements){
			 System.out.println("Please enter " + i + " integer for array ");
			 data[i] = scan.nextInt();
			 i++;
		 }
		 
		 insertionsort(data, 0, elements);//call my insertion sort to sort array
		 System.out.print("Sorted array: ");
		 for(int k = 0; k < data.length; k++)
		 {
			 System.out.print(data[k] + " ");
		 }
		 System.out.println();
		 IntTreeBag t = new IntTreeBag();
		 for(int v = 0; v < data.length; v++){
			 t.add(data[v]);//test add method 
		 }
		 System.out.println("BST (tree1) obtained from sorted array: " );
		 t.root.print(0);
		 
		 IntTreeBag t2 = t.clone();//test clone method 
		 System.out.println("Clone of tree is(tree2): ");
		 t2.root.print(0);//use print method from btnode class to print tree 
		 
		 int answer = 3;
	
		 
		while(answer != 0){//will prompt user to enter 1 2 or 0 to add, remove, quit 
			
		 System.out.println("Please enter 1 to add, 2 to remove, 0 to exit ");
		 answer = scan.nextInt();
		 if(answer == 1 ){
			 System.out.println("Please enter element you would like to add: ");
			 int elementToAdd = scan.nextInt();
			 t2.add(elementToAdd);//test add
			 System.out.println("Updated tree 2: ");
			 t2.root.print(0);
		 }
		 else if(answer == 2){
			 System.out.println("Please enter element to remove: " );
			 int elementToRemove = scan.nextInt();
			 t2.remove(elementToRemove);//test remove 
			 System.out.println("Updated tree 2: ");
			 t2.root.print(0);
		 }
	  }//end while 
		
		System.out.println("Please enter element to count occurances: ");
		int elementOccur = scan.nextInt();
		int num = t2.countOccurrences(elementOccur);//test count occurances with user input 
		System.out.println(elementOccur + " occurs " + num + " times in tree 2 ");
		System.out.println("Tree 3 (union of tree 1 and tree2) " );
		IntTreeBag.union(t, t2);
		
		System.out.println("Result of adding all nodes from tree 2 to tree 1 " );
		t.addAll(t2);//test my addall method 
		t.root.print(0);
		 
		 
		 
		
         
	}
	/**
	 * 
	 * @param data
	 * @param first
	 * @param n
	 * will take an array and use insertion sort to sort the array element from smallest
	 * to largest 
	 * no return type 
	 * array should not be empty 
	 */
	public static void insertionsort(int[] data, int first, int n)
	{
		int i, j;
		int entry; 
		for(i = 1; i<n; i++)
		{
			entry = data[first+i];
			for(j = first+i; (j>first) && (data[j-1]) > entry; j--)
			{
				data[j] = data[j-1];
				 
			}
			data[j] = entry;
		}
	}

}
