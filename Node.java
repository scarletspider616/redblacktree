package RedBlackTree;
public class Node {
	// for improvement: fields should be private
	// make get and set methods ofc after that
	// since this is practically done i'll leave it for now
	int key;
	Node parent = null;
	Node lchild = null;
	Node rchild = null;
	String colour = "black";
	boolean nil = true;
	public Node(int nkey, Node nparent, Node nlchild, 
				Node nrchild, String ncolour) {
		key = nkey;
		parent = nparent;
		lchild = nlchild;
		rchild = nrchild;
		nil = false;
		colour = ncolour;
		fixNode();
		
	}
	public Node() {
		// nil node
	}
	public void fixNode() {
		if (lchild == null) {
			lchild = new Node();
			lchild.parent = this;
		}
		if (rchild == null) {
			rchild = new Node();
			rchild.parent = this;
		}
	}
	public boolean isNil() {
		return nil;
	}
	public Node getGrand() {
		if (parent == null) {
			return parent;
		}
		else {
			return parent.parent;
		}
	}
	public Node getUncle() {
		if (parent == null) return null;
		else if (parent.lchild == this) {
			return parent.rchild;
		}
		else return parent.lchild;
	}
	public boolean isLChild() {
		if (parent == null) return false;
		else if (parent.rchild == this) return false;
		else return true;
	}
	public boolean hasSibling() {
		if(parent == null) return false;
		else if (isLChild()) return (parent.rchild != null);
		else return (parent.lchild != null);
	}

}

