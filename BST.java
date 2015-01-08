//Class for a Binary Search Tree
public class BST{
	
	//Reference to root node of the tree
	static public Node root;
	
	/*
	 * Create a simple binary tree 
	 */
	public static void createBST(int data) {
		if(root==null) {
			root = new Node(data);
		}
		else {
			Node traverser = root;
			while (true) { 
				if (data > traverser.data) {
					if (traverser.right == null) {
						traverser.right = new Node(data);
						break;
					}
					else
						traverser = traverser.right; 
				}
				else {
					if (traverser.left == null) {
						traverser.left = new Node(data);
						break;
					}
					else
						traverser = traverser.left;
				}
			}
		}
	}
	
	/*
	 * Method to print Inorder traversal of binary tree
	 */
	public static void inorderBST(Node root) {
		if(root!=null) {
			inorderBST(root.left);
			System.out.print(" " + root.data);
			inorderBST(root.right);
		}
	}
	
	/*
	 * Method to print Preorder traversal of binary tree
	 */
	public static void preorderBST(Node root) {
		if(root!=null) {
			System.out.print(" " + root.data);
			preorderBST(root.left);
			preorderBST(root.right);
		}
	}
	
	/*
	 * Method to print Postorder traversal of binary tree
	 */
	public static void postorderBST(Node root) {
		if(root!=null) {
			postorderBST(root.left);
			postorderBST(root.right);
			System.out.print(" " + root.data);
		}
	}
	
	/*
	 * Method to check if the binary tree is a binary search tree
	 */
	public static boolean checkBST(Node root) {
		if(root == null )
			return true;
		else {
			if((root.left!=null && root.data < root.left.data) || 
				( root.right!=null && root.data > root.right.data ))
				return false;
			else return (checkBST(root.left) || checkBST(root.left));
		}
		
	}
	
	/*
	 * Method to check if the tree is balanced
	 */
	public static boolean isBalanced(Node root) {
		if(root== null)
			return true; 
		
		if (isBalancedHeight(root)==-1)
			return false;
		
		return true;
	}
	
	/*
	 * Method to see if the sub trees are balanced 
	 */
	public static int isBalancedHeight(Node root) {
		if(root== null)
			return 0; 
		
		int left = isBalancedHeight(root.left);
		int right = isBalancedHeight(root.right);
		
		if(left==-1||right==-1)
			return -1;
		
		if(Math.abs(left-right)>1)
			return -1;
		
		return Math.max(left , right) + 1;
		
	}

	//Driver for the binary tree operations 
	public static void main(String []args) {
		int input[] = {1,2,3,4,6,5,7};
		System.out.print("Input: ");
		for (int i = 0 ; i< input.length ; i++) {
			createBST(input[i]);
			System.out.print(input[i]);
		}
		System.out.println("\nInorder traversal of tree");
		inorderBST(root);
		System.out.println("\nPostorder traversal of tree");
		postorderBST(root);
		System.out.println("\nPreorder traversal of tree");
		preorderBST(root);
		if(checkBST(root)) 
			System.out.println("\n Binary tree is a Binary search tree");
		else 
			System.out.println("\n Binary tree is not a Binary search tree");
		if(isBalanced(root)) 
			System.out.println("\n Binary tree is balanced");
		else 
			System.out.println("\n Binary tree is not balanced");
	}
}

//Class to define the structure of a node 
class Node {
	int data;
	Node left;
	Node right;
	
	//Constructor for Node
	public Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}