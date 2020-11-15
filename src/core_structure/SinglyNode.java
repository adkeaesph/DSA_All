package core_structure;

public class SinglyNode<T> {
	private T data;
	private SinglyNode<T> next;
	
	public SinglyNode() {
		this.data = null;
		this.next = null;
	}
	
	public SinglyNode(T data) {
		this();
		this.data = data;
	}
	
	public SinglyNode(T data, SinglyNode<T> next) {
		this(data);
		this.next = next;
	}
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public SinglyNode<T> getNext() {
		return next;
	}
	public void setNext(SinglyNode<T> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "SinglyNode [data=" + data + ", next=" + next + "]";
	}
	
	
}
