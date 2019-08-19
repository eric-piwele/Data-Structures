package piwele.adt.node;


public class DoublyNode<T> {
    public T value;
    public DoublyNode<T> next;
    public DoublyNode<T> previous;

    public DoublyNode(T value) {
        this.value = value;
        this.next = null;
        this.previous = null;
    }
}
