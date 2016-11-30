package RedBlackTree;

public class Test {

	public static void main(String [] args) {
		// initial test
		int [] data = {1, 6, -1, 23, 44};
		RedBlackTree test = new RedBlackTree(data);
		test.rPrintTree(test.getHead());
		System.out.println(" ");
		
		/*
		// test clear and isEmpty
		test.clearTree();
		test.rPrintTree(test.getHead()); // should print nothing
		System.out.println("Expect true: " + test.isEmpty());
		
		// make sure the tree object can still be repopulated
		test.insert(3);
		test.insert(-10);
		test.insert(50);
		test.rPrintTree(test.getHead());
		System.out.println(" ");	
		
		// clear it again
		test.clearTree();
		*/
	}

}
