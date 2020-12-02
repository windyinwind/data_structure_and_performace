package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		this.head = new LLNode(null);
		this.tail = new LLNode(null);
		this.head.next = tail;
		this.tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		if(element == null) {
			throw new IllegalArgumentException("List can't take null");
		}
		
		LLNode<E> newNode = new LLNode<E>(element);
		newNode.prev = tail.prev;
		newNode.next = tail;
		tail.prev.next = newNode;
		tail.prev = newNode;
		this.size++;
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if(index >= size || index < 0) {
			throw new IndexOutOfBoundsException("NyLinkedList get method index outOfBound : " + index );
		} else {
			LLNode<E> targetNode = getNode(index);
			return targetNode.data;
		}
		
	}
	
	private LLNode<E> getNode(int index) {
		LLNode<E> currentNode = head;
		for(int i = 0; i < size; i++) {
			currentNode = currentNode.next;
			if(i == index) {
				return currentNode;
			}
		}
		return null;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		if(element == null) {
			throw new IllegalArgumentException("List can't take null");
		}
		if(index > size || index < 0) {
			throw new IndexOutOfBoundsException("LLNode add failed: " + index);
		}
		LLNode<E> newNode = new LLNode<E>(element);
		LLNode<E> node = getNode(index);
		if(node == null) {
			newNode.next = head.next;
			newNode.prev = head;
			head.next.prev = newNode;
			head.next = newNode;
			
		} else {
			newNode.prev = node.prev;
			newNode.next = node;
			newNode.prev.next = newNode;
			node.prev = newNode;

		}
		
		this.size++;
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
	
		if(index >= size || index < 0) {
			throw new IndexOutOfBoundsException("LLNode remove outOfBound: " + index);
		}
		LLNode<E> targetNode = getNode(index);
		
		targetNode.prev.next = targetNode.next;
		targetNode.next.prev = targetNode.prev;
		
		this.size--;
		return targetNode.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		if(element == null) {
			throw new IllegalArgumentException("List can't take null");
		}
		if(index >= size || index < 0) {
			throw new IndexOutOfBoundsException("LLNode set failed: " + index);
		}
		LLNode<E> node = getNode(index);
		E oldValue = node.data;
		node.data = element;
		return oldValue;
	} 
	
	public String toString() {
		String output= "";
		LLNode<E> curNode = head;
		while(curNode != null) {
			output += curNode.toString();
			curNode = curNode.next;
		}
		return output;
	}
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor
	public LLNode(E e, LLNode prev) {
		this(e);
		this.prev = prev;
		prev.next = this;
		
	}


	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}
	
	public String toString() {
		return "prev: " + prev +" ,data = " + data + ", next" + next +"\n";
	}

}
