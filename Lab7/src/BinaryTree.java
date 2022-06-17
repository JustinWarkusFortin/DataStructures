/**
 * Represents the Binary Tree data structure
 * 
 * @author Linda Crane
 * @author Melissa Sienkiewicz
 *
 */
public class BinaryTree {

	/**
	 * Reference to the root Node of the tree
	 */
	BinaryTreeNode root = null;

	/**
	 * Insert the data into the tree
	 * 
	 * @param newData New int to store in the tree
	 */
	public void insertInTree(int newData) {
		if (root == null)
			root = new BinaryTreeNode(newData);
		else
			root.insert(newData);
	}

	/**
	 * Method to display the contents of the tree
	 */
	public void displayInOrder() {
		displayInOrder(root);
	}

	/**
	 * Traverse the tree using InOrder traversal and display the content to the
	 * console
	 * 
	 * @param subRoot The node to start with
	 */
	private void displayInOrder(BinaryTreeNode subRoot) {				//in order traversal steps: recursiverly traverse left subtree, root node, right subtree 
		if (subRoot == null)
			return;
		displayInOrder(subRoot.getLeft());
		System.out.print(" " + subRoot.getData() + " ");
		displayInOrder(subRoot.getRight());
	}

	/**
	 * recursively check the conditions to see which branch is longer until the
	 * bottom is reached.
	 * 
	 * @param binaryTreeNode Node to get information from
	 * @return the height of the tree
	 */
	public int treeHeight(BinaryTreeNode binaryTreeNode) {
		if (binaryTreeNode == null) {
			return 0; // if the node is null, the height is 0
		}
		int leftBranch = treeHeight(binaryTreeNode.getLeft()); // get the height of the left branch
		int rightBranch = treeHeight(binaryTreeNode.getRight()); // get the height of the right branch

		if (rightBranch > leftBranch) {
			return 1 + rightBranch;
		} else {
			return 1 + leftBranch;
		}

	}
}
