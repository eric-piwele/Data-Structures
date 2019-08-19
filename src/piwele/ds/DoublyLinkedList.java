/**
 * Simple implementation of LinkedList
 * @author  Eric Piwele
 * @version 1.0
 * @since   2019-08-16
 */

package piwele.ds;


import piwele.adt.ListAdt;
import piwele.adt.node.DoublyNode;

import java.util.Iterator;

public class DoublyLinkedList<T> implements ListAdt<T> {

    private DoublyNode<T> head;
    private DoublyNode<T> tail;
    private int size = 0;

    @Override
    public Boolean add(T t) {
        //System.out.println(t +" size = "+size());
        if(isEmpty()){
            add(t, 0);
        }else {
            add(t, size);
        }
       return true;
    }

    private void addHead(T t) {
        DoublyNode<T> node = new DoublyNode<>(t);
        node.next = head;
        if(head != null) {
            head.previous = node;
        }
        if(tail == null){
            tail = node;
        }
        head = node;
    }

    private void addTail(T t) {
        DoublyNode<T> node = new DoublyNode<>(t);
        node.previous = tail;
        tail.next = node;
        tail = node;
    }

    public void add(T data, int index) {
        if (index < 0 || index > size) {
            throw new RuntimeException("invalid position");
        }

        if (index == 0) {
            addHead(data);
        }else if(index == size){
            addTail(data);
        } else {
            DoublyNode<T> cursor = head;
            DoublyNode<T> node = new DoublyNode<>(data);
            for (int i = 1; i <= index; ++i) {
                cursor = cursor.next;
            }
            node.previous = cursor.previous;
            node.next = cursor;
            cursor.previous = node;
        }
        size++;
    }


    @Override
    public Boolean contains(T t) {
        DoublyNode<T> node = head;
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


    private T removeHead(){
        if(isEmpty()) {
            throw new RuntimeException("empty list");
        }
        T removed = head.value;
        head = head.next;
        head.previous = null;
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
            DoublyNode<T> cursor = head;
            for (int i = 1; i < index; ++i) {
                cursor = cursor.next;
            }
            // cursor now is node at index - 1
            DoublyNode<T> targetNode = cursor.next;
            removed = targetNode.value;
            System.out.println("target = "+targetNode.value+" -- cursor = "+cursor.value);
            cursor.next = targetNode.next;
            targetNode.next.previous = cursor;

        }
        size--;
        return removed;
    }

    public void display() {
        DoublyNode<T> current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }


    public Iterator<T> iterator() {
        return new Iterator<T>() {
            DoublyNode<T> cursor = head;
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

