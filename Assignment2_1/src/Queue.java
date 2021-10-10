
/**
 * 
 * A class that implements a queue.  It is your job to complete this class.  Your queue
 * will use a linked list constructed by LinkedListElements.  However, your queue must be general and allow
 * setting of any type of Object.  Also you cannot use ArrayLists or arrays (you will get zero).  
 * @author you
 *
 */

import java.util.NoSuchElementException;

public class Queue {
	//The front of the queue
	private QueueElement head;
	//The back of the queue
	private QueueElement tail;

	//TODO:  You need some data to store the queue.  Put the attributes here.
	
	
	/**
	 * Constructs an empty Queue.
	 */
	public Queue () {
	    //TODO: Write the Queue constructor
		head = null;
		tail = null;
	}
	
	/**
	 * Returns true if the queue is empty
	 */
	public boolean isEmpty () {
	    //TODO:  Needs to return true when empty and false otherwise
		return ((head == null) && (tail == null));
	}
	
	
	/**
	 * Returns the element at the head of the queue
	 */
	public Object peek () throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		else {
			return head.getElement();
		}
	}
	
	/**
	 * Removes the front element of the queue
	 */
	public void dequeue () throws NoSuchElementException {
	    //Dequeue code is needed here
		if(isEmpty()) {
		      throw new NoSuchElementException();
		}
		else {
			  head = head.getNext();
			  if (head == null) {
				  tail = null;
			  }
		}
	}
	
	/**
	 * Puts an element on the back of the queue.
	 */
	public void enqueue (Object element) {
	    //Enqueue code is needed here
		QueueElement node = new QueueElement (element, null);
		if (tail == null) {
			head = node;
			tail = node;
		}
		else {
			tail.setNext(node);
			tail = node;
		}
	}
	
	/**
	 * Method to print the full contents of the queue in order from head to tail.
	 */
	public void print () {
	    //Code to print the code is needed here
		if (isEmpty()) {
			System.out.println("The queue is empty");
		}
		else {
			QueueElement curElement = head;
			while (curElement != null) {
				System.out.println(curElement.getElement().toString());
				curElement = curElement.getNext();
			}
		}
	}
}
