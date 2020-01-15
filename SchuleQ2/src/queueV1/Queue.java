package queueV1;


public class Queue {

	private Node head;
	private Node tail;
	
	private Object dataType;
	
	public Queue(Object object) {
		// TODO Auto-generated constructor stub
		dataType = object;
	}

	public void enqueue(Object ob){
		if(ob.getClass().equals(dataType.getClass())){
			
			if(head == null&&tail==null){
				Node n = new Node(ob, null);
				head = n;
				tail = n;
			}else{
				Node n = new Node(ob, null);
				tail.setNext(n);
				tail = n;
			}
			
		}else{
			System.out.println("Wrong Data Type!!");
		}
	}
	
	public Object dequeue(){
		Node r = head;
		head = r.getNext();
		
		return r.getData();
	}
	
	public boolean isEmty(){
		if(head == null){
			return true;
		}else{
			return false;
		}
	}
}
