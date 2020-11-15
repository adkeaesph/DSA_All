package core_structure;

public class GraphNode<T> {
	private T data;
	private int weight;
	private GraphNode<T> next;
	
	public GraphNode() {
		
	}
	
	public GraphNode(T data) {
		this();
		this.data = data;
	}
	
	public GraphNode(T data, int weight) {
		this(data);
		this.weight = weight;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public GraphNode<T> getNext() {
		return next;
	}

	public void setNext(GraphNode<T> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "[" + data + ", " + weight + "]";
	}
	
}
