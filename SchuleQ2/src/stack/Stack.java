package stack;

public class Stack<E> {

    private Node<E> top = null;
    private int length = 0;

    public E peek(){
        return (E) top.getData();
    }

    public Node<E> getTOP(){
        return top;
    }

    public void push(E input){
        Node<E> n = new Node<E>(input,top);
        top = n;
        length++;
    }

    public void pop(){
        top = top.getNext();
        length--;
    }

    public boolean isEmpty() {
        if (top == null) {
            return true;
        }else{
            return false;
        }
    }
    public int length(){
        return length;
    }
}
