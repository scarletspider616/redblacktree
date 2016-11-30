package RedBlackTree;
public class RedBlackTree {

	private Node head = new Node();
	public RedBlackTree(int [] input_data) {
		for (int element: input_data) {
			insert(element);
		}
	}
	public RedBlackTree() {
		// empty obj
	}
	
	public Node getHead() {
		return head;
	}
	
	public void insert(int x) {
		// allows you to insert an element into the red black tree
		if (isEmpty()) { // insert case 1
			head = new Node(x, null, null, null, "black");
		}
		else {
			Node temp = head;
			while (!temp.isNil()) {
				if (x >= temp.key) {
					if (temp.rchild.isNil()) {
						temp.rchild = new Node(x, temp, null, null, "red");
						case1(temp.rchild);
						break;
					}
					else temp = temp.rchild;
				}
				else if (x < temp.key) {
					if (temp.lchild.isNil()) {
						temp.lchild = new Node(x, temp, null, null, "red");
						case1(temp.lchild);
						break;
					}
				}
			}


		}
	}


	public void rotate_left(Node n) {
		/* rotate functions use the following pseudocodes:
		 * http://software.ucv.ro/~mburicea/lab8ASD.pdf
		 */
		Node right = n.rchild;
		n.rchild = right.lchild;
		right.lchild.parent = n;
		right.parent = n.parent;
		if (n.parent == null) {
			head = right;
		}
		else if (n.isLChild()) {
			n.parent.lchild = right;
		}
		else {
			n.parent.rchild = right;
		}
		right.lchild = n;
		n.parent = right;
	}

	public void rotate_right(Node n) {
		Node left = n.lchild;
		n.lchild = left.rchild;
		left.rchild.parent = n;
		left.parent = n.parent;
		if (n.parent == null) {
			head = left;
		}
		else if (!n.isLChild()) {
			n.parent.rchild = left;
		}
		else {
			n.parent.lchild = left;
		}
		left.rchild = n;
		n.parent = left;
	}

	public void case1(Node n) {
		if (n.parent == null) {
			n.colour = "black";
		}
		else {
			case2(n);
		}
	}

	public void case2(Node n) {
		Node parent = n.parent;
		if (parent.colour.equals("black")) {
			return;
		}
		else case3(n);
	}

	public void case3(Node n) {
		Node uncle = n.getUncle();
		Node parent = n.parent;
		if (!uncle.isNil() && uncle.colour.equals("red")) {
			parent.colour = "black";
			uncle.colour = "black";
			Node grandparent = n.getGrand();
			grandparent.colour = "red";
			case1(grandparent);
		}
		else case4(n);
	}

	public void case4(Node n) {
		Node parent = n.parent;

		if(!n.isLChild() && parent.isLChild()) {
			rotate_left(parent);
			n = n.lchild;
		}
		else if (n.isLChild() && !parent.isLChild()) {
			rotate_right(parent);
			n = n.rchild;
		}
		case5(n);
	}

	public void case5(Node n) {
		Node grandparent = n.parent.parent;
		n.parent.colour = "black";
		//grandparent.colour = "red";
		if (n.isLChild()) rotate_right(grandparent);
		else rotate_left(grandparent);
	}


	public boolean isEmpty() {
		return head.isNil();
	}
	void clearTree() {
		// remove all items
		head = new Node();
	}
	void rPrintTree(Node n) {
		// in order traversal 
		if (n.lchild != null) rPrintTree(n.lchild);
		if (!n.isNil()) System.out.print(n.key + " colour: " + n.colour + ", ");
		if (n.rchild != null) rPrintTree(n.rchild);
	}
}
