package listClasses;

import java.util.*;

public class BasicLinkedList<T> implements Iterable<T> {
	
	/* Node definition */
	protected class Node {
		protected T data;
		protected Node next;

		protected Node(T data) {
			this.data = data;
			next = null;
		}
	}

	/* We have both head and tail */
	protected Node head, tail;
	
	/* size */
	protected int listSize;
	
	public BasicLinkedList() {
		
		head = null;
		tail = null;
		listSize = 0;
		
	}
	
	public int getSize() {
		
		return this.listSize;
		
	}
	
	public BasicLinkedList<T> addToEnd(T data) {
		Node temp = new Node(data);
		if(this.tail == null) {
			this.tail = temp;		
			if(this.head == null) {
				this.head = temp;			
			} else {
				this.head.next = tail;			
			}		
		} else {		
			this.tail.next = temp;
			this.tail = temp;		
		}
		
		this.listSize++;
		return this;
		
	}
	
	public BasicLinkedList<T> addToFront(T data) {
		
		Node temp = new Node(data);
		
		temp.next = this.head;
		this.head = temp;
		this.listSize++;
		
		return this;

	}
	
	public T getFirst() {
		
		return (head == null) ?  null : this.head.data;
		
	}
	
	public T getLast() {
		
		return (tail == null) ?  null : this.tail.data;
		
	}
	
	public T retrieveFirstElement() {
		
		T toReturn = null;
		
		if(this.head != null) {

			toReturn = this.head.data;
			this.head = this.head.next;
			this.listSize--;

		}
		
		return toReturn;

	}
	
	public T retrieveLastElement() {
		
		Node temp = head;
		Node dataToReturn;
		
		while(temp.next.next != null) {
				
			temp = temp.next;
				
		}
		
		dataToReturn = tail;
		tail = new Node(temp.data);
		tail.next = null;
		
		listSize--;
		
		return dataToReturn.data;
		
	}
	
	public BasicLinkedList<T> remove(T targetData, java.util.Comparator<T> comparator) {
		
		Node prev = null;
		Node temp = head;
		while(temp != null) {
			if(comparator.compare(temp.data, targetData) == 0) {

				listSize--;
				
				if(prev == null) {
					
					head = temp.next;
					
				} else {
					
					prev.next = temp.next;
					
				}
				
			}

			if(temp.next != head) {
				
				prev = temp;
			
			}
			
			temp = temp.next;
		
		}
	
        return this;

	}	
		
	
	public java.util.Iterator<T> iterator() {
		
		Iterator<T> iterator = new Iterator<T>() {
			
			private Node nodeCheck = head;

	        public boolean hasNext() {
	        
	        	return nodeCheck != null;
	        	
	        }

	        public T next() {
	        	
	        	T data = nodeCheck.data;
	
	        	nodeCheck = nodeCheck.next;
	        	
	        	return data;

	        }
	        
	        public void remove() {

	        	throw new UnsupportedOperationException();
	        
	        }
	        
		};
		
        return iterator;
        
	}
		

	public java.util.ArrayList<T> getReverseArrayList() {
				
		ArrayList<T> toReturn = new ArrayList<T>();
		reverseArrayList(head, toReturn);
		return toReturn;
		
	} 
	
	private void reverseArrayList(Node checker, ArrayList<T> answer) {

		if(checker != null && checker.next != null) {
			
			reverseArrayList(checker.next, answer);
			answer.add( checker.data);
			
		}
		
		if(checker.next == null) {
			
			answer.add(checker.data);
			
		}
							
	}
		
	  
	public BasicLinkedList<T> getReverseList() {
				
		BasicLinkedList<T> toReturn = new BasicLinkedList<T>();
		
		toReturn.head = reverseList(this.head);
		
		return toReturn;
		
	}
	
	private Node reverseList(Node checker) {
		
		if(checker == null || checker.next == null) {
			
			return checker;
			
		}
		
		Node recursiveCall = reverseList(checker.next);
		
		checker.next.next = checker;
		
		checker.next = null;
		
		return recursiveCall;
		
	}
	


}