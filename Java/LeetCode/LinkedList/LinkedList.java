package LinkedList;

/**
 * @author Kedar Erande
 */

import java.io.*;

// Java program to implement
// a Singly Linked List
/*

  1)Insert element
  2)Print list
  3)delete element by key
  4)delete element at position
 */
public class LinkedList {
    static Node head;


    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }


    }

    public static LinkedList insert(LinkedList list, int data) {
        Node new_node = new Node(data);
        new_node.next = null;
        if (list.head == null) {
            list.head = new_node;
        } else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node;
        }
        return list;
    }

    private static void printLinkedList(LinkedList list) {
        Node currnode = list.head;
        while (currnode != null) {
            System.out.println("Data value is " + currnode.data);
            currnode = currnode.next;
        }
    }

    private static LinkedList deleteBykey(LinkedList list, int key) {
        //CASE 1: When key is found at head
        Node curreNode = list.head;
        Node prevNode = list.head;
        if (curreNode != null && curreNode.data == key) {
            //simply unlink the head and link the currNode.next
            list.head = curreNode.next;
            System.out.println("Deleted the head since key found at head");
            return list;

        }
        //CASE 2 : when element is at middle
        while (curreNode != null && curreNode.data != key) {
            //store the previous node
            prevNode = curreNode.next;
            curreNode = curreNode.next;

        }
        if (curreNode != null) {
            //assign the currNode's next node to previous next
            prevNode.next = curreNode.next;
            System.out.println("Key found deleting it");
            return list;
        }

        //CASE III if no key found

        if (curreNode == null) {
            System.out.println("No key found");
            return list;
        }
        return list;
    }

    private static LinkedList deleteByIndex(LinkedList list, int index) {
        //CASE if the index is head
        int counter = 0;
        Node currNode = list.head;
        Node prevNode = null;
        if (index == counter) {
            list.head = currNode.next;
            System.out.println("delete the key at head for index " + index);
            return list;
        }

        while (currNode != null) {
            if (index == counter) {
                prevNode.next = currNode.next;
                System.out.println("deleted the elemenet found at index" + index);
                return list;
            } else {
                prevNode = currNode;
                currNode = currNode.next;
                counter++;
            }
        }
        if (currNode == null) {
            System.out.println("No element found");
            return list;
        }
        return list;
    }


    // Driver code
    public static void main(String[] args) {
        /* Start with the empty list. */
        LinkedList list = new LinkedList();

        //
        // ******INSERTION******
        //

        // Insert the values
        list = insert(list, 1);
        list = insert(list, 2);
        list = insert(list, 3);
        list = insert(list, 4);
        list = insert(list, 5);
        list = insert(list, 6);
        list = insert(list, 7);
        list = insert(list, 8);

        // Print the LinkedList
        printLinkedList(list);//op 1,2,3,4,5,6,7,8

        list = deleteBykey(list, 1); //op 2-> 8
        System.out.println();
        printLinkedList(list);
        System.out.println();
        list = deleteBykey(list, 4);// op 2,3,5,6,7,8
        System.out.println();
        printLinkedList(list);
        System.out.println();
        list = deleteBykey(list, 10);//no found
        System.out.println();
        printLinkedList(list);
        System.out.println();

        //deleteByIndex

        list = deleteByIndex(list, 2);//3 -> 8
        printLinkedList(list);
    }
}
