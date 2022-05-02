package listClasses;

import java.util.*;

/**
 * Implements a generic sorted list using a provided Comparator. It extends
 * BasicLinkedList class.
 * 
 * @author Dept of Computer Science, UMCP
 * 
 */

public class SortedLinkedList<T> extends BasicLinkedList<T> {

	private Comparator<T> comparator;

	public SortedLinkedList(java.util.Comparator<T> comparator) {

		super();
		this.comparator = comparator;

	}

	public SortedLinkedList<T> add(T element) {

		Node newNode = new Node(element);
		Node current = head;
		Node header = this.head;
		Node footer = this.tail;

		if (header == null) {
			
			newNode.next = footer;
			header = newNode;
			footer = newNode;
			
		} else {

			if (comparator.compare((T) header.data, element) > 0) {

				newNode.next = header;
				header = newNode;
				
			} else {

				if (comparator.compare((T) footer.data, element) <= 0) {

					footer.next = newNode;
					footer = newNode;
					footer.next = null;
					
				} else {

					while (comparator.compare((T) current.next.data, element) < 0) {

						current = current.next;

					}

					newNode.next = current.next;
					current.next = newNode;

				}

			}

		}

		listSize++;
		return this;
	}

	public SortedLinkedList<T> remove(T targetData) {

		super.remove(targetData, comparator);
		return this;

	}

	public SortedLinkedList<T> addToEnd(T data) {

		throw new UnsupportedOperationException("Invalid operation for sorted list");

	}

	public SortedLinkedList<T> addToFront(T data) {

		throw new UnsupportedOperationException("Invalid operation for sorted list");

	}

}