package piwele;

import piwele.ds.CircularDoublyLinkedList;
import piwele.ds.SinglyLinkedList;
import piwele.ds.CircularSinglyLinkedList;
import piwele.ds.DoublyLinkedList;

public class Main {

    public static void main(String[] args) {

        //SinglyLinkedList<String> myList = new SinglyLinkedList<String>();
        //CircularSinglyLinkedList<String> myList = new CircularSinglyLinkedList<String>();
        //DoublyLinkedList<String> myList = new DoublyLinkedList<String>();
        CircularDoublyLinkedList<String> myList = new CircularDoublyLinkedList<>();
        myList.add("a");
        myList.add("b");
        myList.add("c");
        myList.add("d");
        myList.add("e");
        myList.add("f");
        myList.display();
        System.out.println("size1= "+myList.size());
        System.out.println("contains c = "+myList.contains("c"));
        System.out.println("removed = "+myList.remove(2));
        System.out.println("contains c = "+myList.contains("c"));
        myList.display();
        System.out.println("size2= "+myList.size());
        myList.add("C",2);
        myList.display();
        System.out.println("size3= "+myList.size());
        myList.clear();
        System.out.println("size4= "+myList.size());
        myList.add("the end");
        myList.display();
    }

}
