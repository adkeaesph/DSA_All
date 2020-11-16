package basic_structures;

public class Stack<T> {
	private SinglyLinkedList<T> list;
	
	public Stack() {
		list = new SinglyLinkedList<>();
	}
	
	public void push(T data) throws Exception{
		if(isFull())
			throw new Exception("Stack is full!");
		list.insertAtStart(data);
	}
	
	public T pop() throws Exception {
		if(isEmpty())
			throw new Exception ("Stack is empty!");
		T toBePopped = list.getHead().getData();
		list.deleteAtStart();
		return toBePopped;
	}
	
	public T peek() throws Exception {
		if(isEmpty()) 
			throw new Exception ("Stack is empty!");
		
		return list.getHead().getData();
	}
	
	public boolean isEmpty() {
		return list.getSize() == 0;
	}
	
	public boolean isFull() {
		return list.getSize() == Integer.MAX_VALUE;
	}
	
	public int getSize() {
		return list.getSize();
	}

	@Override
	public String toString() {
		return "Stack top to bottom:\n" + list;
	}
}
