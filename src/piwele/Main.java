package piwele;

import piwele.ds.SinglyLinkedList;
import piwele.ds.CircularSinglyLinkedList;

public class Main {

    public static void main(String[] args) {

        SinglyLinkedList<String> mySinglyList = new SinglyLinkedList<String>();
        //CircularSinglyLinkedList<String> mySinglyList = new CircularSinglyLinkedList<String>();
        mySinglyList.add("a");
        mySinglyList.add("b");
        mySinglyList.add("c");
        mySinglyList.add("d");
        mySinglyList.add("e");
        mySinglyList.add("f");
        mySinglyList.display();
        System.out.println("size1= "+mySinglyList.size());
        mySinglyList.remove(2);
        mySinglyList.display();
        System.out.println("contains c = "+mySinglyList.contains("c"));
        mySinglyList.remove(2);
        System.out.println("contains c = "+mySinglyList.contains("c"));
        mySinglyList.display();
        System.out.println("size2= "+mySinglyList.size());
        mySinglyList.clear();
        System.out.println("size3= "+mySinglyList.size());
        mySinglyList.add("the end");
        mySinglyList.display();
    }

}
