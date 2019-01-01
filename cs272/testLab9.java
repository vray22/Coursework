//Victor Lozoya 
//Lab9
//april 27th 
//will test my printleaves method created in BTNode class
public class testLab9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//create tree to test my printLeaves method 
		BTNode test1 = new BTNode(1, null, null);
		BTNode test2 = new BTNode(2, null, null);
		BTNode test3 = new BTNode(3, null, null);
		BTNode test4 = new BTNode(4, null, null);
		BTNode test5 = new BTNode(5, null, null);
		//start creating tree with test1 as root 
		
		test1.setLeft(test2);//set test2 as left child of test 1
		test1.setRight(test3);//set test3 as right child of test1
		//will set test4 as left child of the right child of root
		//will set test5 as right child of the right child of root 
		test1.getRight().setLeft(test4);
		test1.getRight().setRight(test5);
		//will test print leaves current leaves are 2, 4, and 5
		System.out.println("First test for printLeaves: ");
		test1.printLeaves();
		
		//will add a child to 4 which is a left child of the roots right child 
		BTNode test6 = new BTNode(6, null, null);
		test1.getRight().getLeft().setRight(test6);
		//willl test print leaves which should only print 2 5 and 6  not 4 anymore 
		System.out.println("Second test for printLeaves: ");
		test1.printLeaves();
		
	}

}
