/**
 * Simple implementation of LinkedList
 * @author  Eric Piwele
 * @version 1.0
 * @since   2019-08-16
 */

package piwele.ds;


import piwele.adt.ListAdt;
import piwele.adt.node.SinglyNode;
import java.util.Iterator;

public class CircularSinglyLinkedList<T> implements ListAdt<T> {

    private SinglyNode<T> head;
    private SinglyNode<T> tail;
    private int size = 0;

    @Override
    public Boolean add(T t) {
        if(isEmpty()){
            addHead(t);
        }else {
            addTail(t);
        }
        return true;
    }

    @Override
    public Boolean contains(T t) {
        SinglyNode<T> node = head;
        if(isEmpty()){
            return false;
        }
        do {
            if(node.value.equals(t)){
                return true;
            }
            node = node.next;
        }while (node != head);
        return false;
    }

    @Override
    public void clear() {
       head = null;
       tail = null;
       size = 0;
    }

    @Override
    public Boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Integer size() {
        return size;
    }

    private void addHead(T t) {
        SinglyNode<T> node = new SinglyNode<>(t);
        head = node;
        if(tail != null){
            tail.next = head;
        }else{
            tail = head;
            tail.next = head;
        }
        size++;
    }

    private void addTail(T t) {
        SinglyNode<T> node = new SinglyNode<>(t);
        tail.next = node;
        tail = node;
        node.next = head;
        size++;
    }

    public void add(T data, int index) {
        if (index < 0 || index > size) {
            throw new RuntimeException("invalid index: "+index);
        }
        System.out.println("adding: "+data+" -- index= "+index);
        if (index == 0) {
            addHead(data);

        }else if(index == size){
            addTail(data);
        } else {
            SinglyNode<T> cursor = head;
            SinglyNode<T> node = new SinglyNode<>(data);
            for (int i = 1; i < index; ++i) {
                if(cursor.next == null){
                    break;
                }
                cursor = cursor.next;
            }
            node.next = cursor.next;
            cursor.next = node;
            size++;
        }
        System.out.println("adding: "+data);
    }

    private T removeHead(){
        if(isEmpty()) {
            throw new RuntimeException("empty list");
        }
        System.out.println("head = "+head +" --- tail= "+tail);
        T removed = head.value;
        head = head.next;
        tail.next = head;
        return removed;
    }

    public T remove(int index) {
        if (index < 0 || index > size()) {
            throw new RuntimeException("invalid index: "+index);
        }
        T removed;
        if (index == 0) {
            removed = removeHead();
        } else{
            SinglyNode<T> cursor = head;
            for (int i = 1; i < index; ++i) {
                cursor = cursor.next;
            }
            // cursor now is node at index - 1
            removed = cursor.next.value;
            cursor.next = cursor.next.next;
        }
        size--;
        return removed;
    }

    public void display() {
        if(size == 0) {
            return;
        }
        System.out.print(head.value + " ");
        SinglyNode<T> current = head.next;
        while (current.next != null ) {
            if(current == head) {
                break;
            }
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }


    public Iterator<T> iterator() {
        return new Iterator<T>() {
            SinglyNode<T> cursor = head;
            @Override
            public boolean hasNext() {
                return cursor != null;
            }

            @Override
            public T next() {
                if (hasNext()) {
                    T data = cursor.value;
                    cursor = cursor.next;
                    return data;
                }
                return null;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Remove not implemented.");
            }

        };
    }
}

