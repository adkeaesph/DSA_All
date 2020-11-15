package basic_structures;

import core_structure.SinglyNode;

public class SinglyLinkedList<T> {
	private SinglyNode<T> head;
	private SinglyNode<T> last;
	private int size;

	public SinglyLinkedList() {
		head = new SinglyNode<>(); // only single node with no data represents that an empty list has come into
									// existence.
		last = head;
		size = 0;
	}

	public SinglyLinkedList(T headData) {
		this();
		head.setData(headData); // singleton list
		size++;
	}

	public SinglyNode<T> getHead() {
		return head;
	}

	public void setHead(SinglyNode<T> head) {
		this.head = head;
	}

	public SinglyNode<T> getLast() {
		return last;
	}

	public void setLast(SinglyNode<T> last) {
		this.last = last;
	}

	public int getSize() {
		return size;
	}

	public void insertAtStart(T data) {
		if (size == 0)
			head.setData(data);
		else {
			SinglyNode<T> newHead = new SinglyNode<>(data);
			newHead.setNext(head);
			head = newHead;
		}
		size++;
	}

	public void insertAtEnd(T data) {
		if (size == 0)
			head.setData(data);
		else {
			SinglyNode<T> newLast = new SinglyNode<>(data);
			last.setNext(newLast);
			last = last.getNext();
		}
		size++;
	}
	
	public void insertAtPosition(T data, int position) throws Exception {
		if(position < 0 || position > size)
			throw new Exception("Invalid position!");
		if(position == 0)
			insertAtStart(data);
		else if(position == size)
			insertAtEnd(data);
		else {
			int index = 0;
			SinglyNode<T> temp = head, next;
			while(temp.getNext()!=null) {
				index++;
				if(index == position) {
					next = temp.getNext();
					SinglyNode<T> current = new SinglyNode<>(data);
					temp.setNext(current);
					current.setNext(next);
					break;
				}
				temp = temp.getNext();
			}
		}
	}

	public void deleteAtStart() throws Exception {
		if (size == 0)
			throw new Exception("List is empty!");
		if (size == 1)
			head.setData(null);
		else
			head = head.getNext();
		size--;
	}

	public void deleteAtEnd() throws Exception {
		if (size == 0)
			throw new Exception("List is empty!");
		if (size == 1)
			last.setData(null);
		else {
			last = null;
			SinglyNode<T> temp = head;
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			last = temp;
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
			SinglyNode<T> temp = head, next;
			while(temp.getNext()!=null) {
				index++;
				if(index == position) {
					next = temp.getNext().getNext();
					temp.setNext(next);
					break;
				}
				temp = temp.getNext();
			}
		}
	}

	@Override
	public String toString() {
		return "SinglyLinkedList [head=" + head.getData() + ", last=" + last.getData() + ", size=" + size + "]";
	}

}
