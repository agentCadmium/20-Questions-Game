package datastructures;

/**
 * DefaultBinaryTree is the class for a basic binary tree. 
 */

public class DefaultBinaryTree <T> implements BinaryTree<T>{

	private BinaryTreeNode <T> root;	
	private LinkedList<T> traversal;
	
	/**
	 * Constructor
	 */
	public DefaultBinaryTree() {
		//root=null;		
	}

	/**
	 * Gets the root node for this tree.
	 * 
	 * @return root or null if tree is empty.
	 */	
	@Override
	public BinaryTreeNode<T> getRoot() {		
		return root;
	}

	/**
	 * Sets the root node for this tree.
	 */
	@Override
	public void setRoot(BinaryTreeNode<T> root) {
		this.root=root;	
	}

	/**
	 * Tests if the tree is empty.
	 * 
	 * @return true if tree has no data.
	 */
	@Override
	public boolean isEmpty() {
		if (root==null){
			return true;			
		} else return false;		
	}

	
	/**
	 * Gets the data of this tree using in-order traversal.
	 * 
	 * @return in-order List
	 */
	@Override
	public LinkedList<T> inorderTraversal() {
		traversal=new LinkedList<T>();
		if (root==null){
			return null;
		} else {
			inorderTraversal(root, traversal);
			return traversal;
		}
	}

	private void inorderTraversal(BinaryTreeNode<T> node, LinkedList<T> traversal){
		if (node!=null){
			inorderTraversal(node.getLeftChild(), traversal);
			//System.out.println(node.getData());
			if (traversal.isEmpty()==true){
				traversal.insertFirst(node.getData());
			} else{
				traversal.insertLast(node.getData());	
			}
			
			inorderTraversal(node.getRightChild(), traversal);
		}
	}


	
	/**
	 * Gets the data of this tree using pre-order traversal.
	 * 
	 * @return pre-order List.
	 */
	@Override
	public LinkedList<T> preorderTraversal() {
		traversal=new LinkedList<T>();
		if (root==null){
			return null;
		} else {
			preorderTraversal(root, traversal);
			return traversal;
		}
	}
	
	private void preorderTraversal(BinaryTreeNode<T> node, LinkedList<T> traversal){
		if (node!=null){
			//System.out.println(node.getData());
			if (traversal.isEmpty()==true){
				traversal.insertFirst(node.getData());
			} else{
				traversal.insertLast(node.getData());	
			}
			preorderTraversal(node.getLeftChild(), traversal);
			preorderTraversal(node.getRightChild(), traversal);
		}
	}
	
		
	/**
	 * Gets the data of this tree using post-order traversal.
	 * 
	 * @return post-order List.
	 */	
	@Override
	public LinkedList<T> postorderTraversal() {
		traversal=new LinkedList<T>();
		if (root==null){
			return null;
		} else {
			postorderTraversal(root, traversal);
			return traversal;
		}
	}

	private void postorderTraversal(BinaryTreeNode<T> node, LinkedList<T> traversal){
		if (node!=null){
			postorderTraversal(node.getLeftChild(), traversal);
			postorderTraversal(node.getRightChild(), traversal);
			//System.out.println(node.getData());
			if (traversal.isEmpty()==true){
				traversal.insertFirst(node.getData());
			} else{
				traversal.insertLast(node.getData());	
			}
		}
	}
		
	/**
	 * Prints the tree using in-order traversal.
	 * 
	 * @return in-order String
	 */
	@Override
	public String inorderString() {
		return inorderTraversal().toString();
	}
	
	/**
	 * Prints the tree using pre-order traversal.
	 * 
	 * @return pre-order String
	 */
	@Override
	public String preorderString() {
		return preorderTraversal().toString();
	}
	
	/**
	 * Prints the tree using post-order traversal.
	 * 
	 * @return post-order String
	 */
	@Override
	public String postorderString() {
		return postorderTraversal().toString();
	}


}
