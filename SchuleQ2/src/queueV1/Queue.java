package queueV1;


public class Queue<E> {

	private Node head;
	private Node tail;
	
	public void enqueue(E ob){
			if(head == null&&tail==null){
				Node n = new Node(ob, null);
				head = n;
				tail = n;
			}else{
				Node n = new Node(ob, null);
				tail.setNext(n);
				tail = n;
			}
	}
	
	public E dequeue(){
		Node r = head;
		head = r.getNext();
		
		return (E) r.getData();
	}
	
	public boolean isEmty(){
		if(head == null){
			return true;
		}else{
			return false;
		}
	}
}
