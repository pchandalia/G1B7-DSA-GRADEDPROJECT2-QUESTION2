package com.greatlearning.main;
import com.greatlearning.bst.model.Node;
public class TreeConversionDriver {
	Node node = null;
	private Node prevNode = null;
	private Node skewedTreeNode = null;

	//Function to convert BST to right skewed tree
	public void bstToSkewedConversion(Node root, int order) {
		if (root == null)
			return;
		if (order > 0)
			bstToSkewedConversion(root.right, order);
		else
			bstToSkewedConversion(root.left, order);

		Node rightNode = root.right;
		Node leftNode = root.left;

		if (skewedTreeNode == null)
			skewedTreeNode = root;
		else
			prevNode.right = root;

		root.left = null;
		prevNode = root;

		if (order > 0)
			bstToSkewedConversion(leftNode, order);
		else
			bstToSkewedConversion(rightNode, order);
	}

	// prints all values in the tree by traversing through the right subtree of the BST
    
	public void printSkewedTree() {
		if (skewedTreeNode == null)
			return;
		while (skewedTreeNode != null) {
			System.out.print(skewedTreeNode.root + " ");
			skewedTreeNode = skewedTreeNode.right;
		}
	}

	//Driver code
	public static void main(String[] args) {

		TreeConversionDriver treeConversion = new TreeConversionDriver();
		treeConversion.node = new Node(50);
		treeConversion.node.left = new Node(30);
		treeConversion.node.right = new Node(60);
		treeConversion.node.left.left = new Node(10);
		treeConversion.node.right.left = new Node(55);

		treeConversion.bstToSkewedConversion(treeConversion.node, 0);

		treeConversion.printSkewedTree();
	}
}


