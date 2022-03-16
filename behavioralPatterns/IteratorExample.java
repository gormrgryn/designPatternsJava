import java.util.Stack;

class IteratorExample {
	static class BinaryTree {
		public Node root;

		public BinaryTree() {
			root = null;
		}

		class Node {
			public int key;
			public Node leftChild;
			public Node rightChild;

			public Node(int k) { key = k; }
		}

		public void insert(int key) {
			Node newNode = new Node(key);
			if (root == null) { root = newNode; return; }

			Node current = root;
			Node parent;

			while (true) {
				parent = current;
				if (key < current.key) {
					current = current.leftChild;
					if (current == null) { parent.leftChild = newNode; return; }
				} else if (key > current.key) {
					current = current.rightChild;
					if (current == null) { parent.rightChild = newNode; return; }
				} else return;
			}
		}
		// . . .
	}
	static interface Iterator<T> {
		T first();
		T next();
		boolean isDone();
		T currentItem();
	}
	static class InorderIterator implements Iterator<BinaryTree.Node> {
		Stack<BinaryTree.Node> stack;
		BinaryTree.Node root;

		InorderIterator(BinaryTree tree) {
			root = tree.root;
			stack = new Stack<BinaryTree.Node>();
			placeInStack(root);
		}
		private void placeInStack(BinaryTree.Node node) {
			if (node ==  null) return;

			if (node.leftChild == null && node.rightChild == null) {
				stack.push(node);
				return;
			}
			placeInStack(node.rightChild);
			stack.push(node);
			placeInStack(node.leftChild);
		}

		public BinaryTree.Node first() { return stack.peek(); }
		public BinaryTree.Node next() { return stack.pop(); }
		public boolean isDone() { return stack.empty(); }
		public BinaryTree.Node currentItem() { return stack.peek(); }
	} // left root right

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.insert(50);
		tree.insert(60);
		tree.insert(70);
		tree.insert(55);
		tree.insert(40);
		tree.insert(30);
		tree.insert(45);
		InorderIterator iterator = new InorderIterator(tree);

		while (!iterator.isDone()) {
			System.out.println(iterator.next().key);
		}
	}


	// class PreorderIterator implements Iterator<BinaryTree.Node> {} // root left right
	// class PostprderIterator implements Iterator<BinaryTree.Node> {} // left right root
}