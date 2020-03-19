

public class Node<T extends Student> {

	private T data;
	private Node next;

	Node(T data, Node next) {
		this.data = data;
		this.next = next;

	}

	Node(T data) {
		this.data = data;
		Node next = null;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

}
