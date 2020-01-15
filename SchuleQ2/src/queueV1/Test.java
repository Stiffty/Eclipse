package queueV1;

public class Test {

	private int i;

	public Test(int t) {
		// TODO Auto-generated constructor stub
		i = t;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Queue q = new Queue(new Test(0));
		
		q.enqueue(new Test(2));
		q.enqueue(new Test(3));
		q.enqueue(new Test(4));
		q.enqueue(new Test(5));
		q.enqueue(new Test(6));
		q.enqueue(new Test(7));

		Test o;
		while (!q.isEmty()) {
			o =  (Test) q.dequeue();
			System.out.println(o.getI());
		}

	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

}
