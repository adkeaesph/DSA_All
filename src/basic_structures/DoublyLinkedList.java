package basic_structures;

import core_structure.DoublyNode;

public class DoublyLinkedList<T> {
	private DoublyNode<T> head;
	private DoublyNode<T> last;
	private int size;
	
	public DoublyLinkedList() {
		head = new DoublyNode<>(); 	// only single node with no data represents that an empty list has come into
									// existence.
		last = head;
		size = 0;
	}
	
	public DoublyLinkedList(T data) {
		this();
		head.setData(data);			//singleton list
		size++;
	}

	public DoublyNode<T> getHead() {
		return head;
	}

	public void setHead(DoublyNode<T> head) {
		this.head = head;
	}

	public DoublyNode<T> getLast() {
		return last;
	}

	public void setLast(DoublyNode<T> last) {
		this.last = last;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public boolean isFull() {
		return size == Integer.MAX_VALUE;
	}
	
	public void insertAtStart(T data) throws Exception {
		if(isFull())
			throw new Exception("List is full!");
		if(size == 0) 
			head.setData(data);
		else {
			DoublyNode<T> newHead = new DoublyNode<>(data);
			newHead.setNext(head);
			head.setPrevious(newHead);
			head = newHead;
		}
		size++;
	}
	
	public void insertAtEnd(T data) throws Exception {
		if(isFull())
			throw new Exception("List is full!");
		if (size == 0)
			head.setData(data);
		else {
			DoublyNode<T> newLast = new DoublyNode<>(data);
			last.setNext(newLast);
			newLast.setPrevious(last);
			last = last.getNext();
		}
		size++;
	}
	
	public void insertAtPosition(T data, int position) throws Exception {
		if(isFull())
			throw new Exception("List is full!");
		if (position < 0 || position > size)
			throw new Exception("Invalid position!");
		if (position == 0)
			insertAtStart(data);
		else if (position == size)
			insertAtEnd(data);
		else {
			int index = 0;
			if(position < size/2) {
				DoublyNode<T> temp = head, next;
				while (temp.getNext() != null) {
					index++;
					if (index == position) {
						next = temp.getNext();
						DoublyNode<T> current = new DoublyNode<>(data);
						temp.setNext(current);
						current.setPrevious(temp);
						current.setNext(next);
						next.setPrevious(current);
						break;
					}
					temp = temp.getNext();
				}
			} else {
				position = size - position;
				DoublyNode<T> temp = last, previous;
				while (temp.getPrevious() != null) {
					index++;
					if (index == position) {
						previous = temp.getPrevious();
						DoublyNode<T> current = new DoublyNode<>(data);
						temp.setPrevious(current);
						current.setNext(temp);
						current.setPrevious(previous);
						previous.setNext(current);
						break;
					}
					temp = temp.getNext();
				}
			}
		}
	}
	
	public void deleteAtStart() throws Exception {
		if (size == 0)
			throw new Exception("List is empty!");
		if (size == 1)
			head.setData(null);
		else {
			head = head.getNext();
			head.setPrevious(null);
		}
		size--;
	}
	
	public void deleteAtEnd() throws Exception {
		if (size == 0)
			throw new Exception("List is empty!");
		if (size == 1)
			last.setData(null);
		else {
			DoublyNode<T> newLast = last.getPrevious();
			newLast.setNext(null);
			last = newLast;
		}
		size--;
	}
	
	public void deleteAtPosition(int position) throws Exception {
		if (size == 0)
			throw new Exception("List is empty!");
		if (position < 0 || position >= size)
			throw new Exception("Invalid position!");
		if (position == 0)
			deleteAtStart();
		else if (position == size - 1)
			deleteAtEnd();
		else {
			int index = 0;
			DoublyNode<T> temp = head, next;
			while (temp.getNext() != null) {
				index++;
				if (index == position) {
					next = temp.getNext().getNext();
					temp.setNext(next);
					if(next!=null)
						next.setPrevious(temp);
					break;
				}
				temp = temp.getNext();
			}
		}
	}
}
