package stack;

public class Stack<E> {

    private Node top = null;

    public E peek(){
        return (E) top.getData();
    }

    public void push(E input){
        Node n = new Node(input,top);
        top = n;
    }

    public void pop(){
        top = top.getNext();
    }

    public boolean isEmpty() {
        if (top == null) {
            return true;
        }else{
            return false;
        }
    }
}
