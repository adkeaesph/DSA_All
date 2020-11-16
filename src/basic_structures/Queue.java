package basic_structures;

public class Queue<T> {
	private SinglyLinkedList<T> list;
	
	public Queue() {
		list = new SinglyLinkedList<>();
	}
	
	public boolean isFull() {
		return list.getSize() == Integer.MAX_VALUE;
	}
	
	public boolean isEmpty() {
		return list.getSize() == 0;
	}
	
	public void enqueue(T data) throws Exception {
		if(isFull())
			throw new Exception ("Queue is full!");
		list.insertAtEnd(data);
	}
	
	public void dequeue() throws Exception {
		if(isEmpty())
			throw new Exception ("Queue is empty!");
		list.deleteAtStart();
	}
	
	public T peekFront() throws Exception {
		if(isEmpty())
			throw new Exception ("Queue is empty!");
		return list.getHead().getData();
	}
	
	public T peekRear() throws Exception {
		if(isEmpty())
			throw new Exception ("Queue is empty!");
		return list.getLast().getData();
	}

	@Override
	public String toString() {
		return "Queue front to rear:\n" + list;
	}
	
	
}
