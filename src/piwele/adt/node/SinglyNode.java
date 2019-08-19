package piwele.adt.node;


public class SinglyNode<T> {
    public T value;
    public SinglyNode<T> next;

    public SinglyNode(T value) {
        this.value = value;
        this.next = null;
    }
}
