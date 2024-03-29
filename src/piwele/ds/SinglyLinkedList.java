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

public class SinglyLinkedList<T> implements ListAdt<T> {

    private SinglyNode<T> head;

    @Override
    public Boolean add(T t) {
        //System.out.println(t +" size = "+size());
        if(isEmpty()){
            add(t, 0);
        }else {
            add(t, size());
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
        }while (node.next != null);
        return false;
    }

    @Override
    public void clear() {
        head = null;
    }

    @Override
    public Boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Integer size() {
        if (head == null) {
            return 0;
        } else {
            SinglyNode<T> node = head;
            int size = 1;
            while (node.next != null) {
                node = node.next;
                size++;
            }
            return size;
        }
    }

    private void addHead(T t) {
        SinglyNode<T> node = new SinglyNode<>(t);
        node.next = head;
        head = node;
    }

    public void add(T data, int index) {
        if (index < 0 || index > size()) {
            throw new RuntimeException("invalid position");
        }

        if (index == 0) {
            addHead(data);
        } else {
            SinglyNode<T> cursor = head;
            SinglyNode<T> node = new SinglyNode<>(data);
            for (int i = 1; i <= index; ++i) {
                if(cursor.next == null){
                    break;
                }
                cursor = cursor.next;
            }
            node.next = cursor.next;
            cursor.next = node;
        }
    }

    private T removeHead(){
        if(isEmpty()) {
            throw new RuntimeException("empty list");
        }
        T removed = head.value;
        head = head.next;
       return removed;
    }

    public T remove(int index) {
        if (index < 0 || index > size()) {
            throw new RuntimeException("invalid index");
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
        return removed;
    }

    public void display() {
        SinglyNode<T> current = head;
        while (current != null) {
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

