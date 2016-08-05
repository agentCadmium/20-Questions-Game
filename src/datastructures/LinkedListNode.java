package datastructures;

/**
 * Class represents one node in a generic linked list
 * Node holds objects of type T
 */
class LinkedListNode<T> {
	
	//the data stored in the Node of type T
	private T data;
	
	//reference to next link
	private LinkedListNode<T> next;
	
	/**
	 * Set the data stored at this node.
	 */
	public void setData( T data ){
		this.data = data;
		
	}
	/**
	 * Get the data stored at this node.
	 */
	public T getData(){
		return this.data;
	}
	 
	/**
	 * Set the next pointer to passed node.
	 */
	public void setNext( LinkedListNode<T> node ){
		this.next = node;
	}
	 
	/**
	 * Get (pointer to) next node.
	 */
	public LinkedListNode<T> getNext(){
		return this.next;
	}
	 
	/**
	 * Returns a String representation of this node.
	 */
	public String toString(){
		return getData().toString();
	}

}
