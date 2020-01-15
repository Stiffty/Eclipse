package queueV1;

public class Node {

	private Object data;
	private Node next;
	
	public Node(Object data,Node next) {
		// TODO Auto-generated constructor stub
		this.data = data;
		this.next = next;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

}
