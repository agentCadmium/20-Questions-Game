package datastructures;

/**
 * DefaultBinaryTreeNode is the class for a basic binary tree node,
 * with data of type T and pointers to left and right children.
 */
public class DefaultBinaryTreeNode <T> implements BinaryTreeNode<T>{
		 
	private T node; //basic binary tree node
	private BinaryTreeNode<T> leftNode, rightNode; //left and right children

	/**
	 * Constructor
	 */
	public DefaultBinaryTreeNode() {
		node = null;
		leftNode = null;
		rightNode = null;
	}
	
	
	/**
	 * Gets the data stored at this node.
	 * @return Object data.
	 */
	@Override
	public T getData() {
		return node;
	}
	
	/**
  	 * Sets the data stored at this node.
	 */
	@Override
	public void setData(T data) {		
		node = data;
	}

   /**
    * Gets the left child.
    * @return BinaryTreeNode that is left child,
    * or null if no child.
    */	
	@Override
	public BinaryTreeNode<T> getLeftChild() {
		return leftNode;
	}

   /**
    * Gets the right child.
	* @return BinaryTreeNode that is right child,
	* or null if no child.
	*/
	@Override
	public BinaryTreeNode<T> getRightChild() {
		return rightNode;
	}

   /**
    * Sets the left child.
    */
	@Override
	public void setLeftChild(BinaryTreeNode<T> left) {
		leftNode=left;		
	}

   /**
    * Set the right child.
    */
	@Override
	public void setRightChild(BinaryTreeNode<T> right) {
		rightNode=right;
	}

	/**
	 * Tests if this node is a leaf (has no children).
	 * @return true if leaf node.
	 */
	@Override
	public boolean isLeaf() {
		if (leftNode==null && rightNode==null){
			return true;
		} else return false;		
	}

}
