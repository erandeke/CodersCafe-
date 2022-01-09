/**
 * @author Kedar Erande
 */
public class ImplementDoublyLinkedList {
    static Node head;

    static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            next = null;
            prev = null;
        }
    }

    public static void insertAtFront(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            newNode.next = null;
            newNode.prev = null;
            head = newNode;
        } else {
            newNode.next = head;
            newNode.prev = null;
            head.prev = newNode;
            head = newNode;
        }
    }


    public static void insertAfterNode(int data, Node prev_node) {
        Node newNode = new Node(data);
        if (prev_node == null) {
            System.out.println("No previous node found");
            return;
        }
        newNode.next = prev_node.next;
        prev_node.next = newNode;
        newNode.prev = prev_node;
        if (newNode.next != null) {
            newNode.next.prev = newNode;
        }

    }

    public static void insertBeforeNode(int data, Node nextNode) {
        if (nextNode == null) {
            System.out.println("Cannot be inserted since nextNode is null");
        }
        Node newNode = new Node(data);
        newNode.prev = nextNode.prev;
        newNode.next = nextNode;
        nextNode.prev = newNode;
        //check if new node added is not head
        if (newNode.prev != null) {
            newNode.prev.next = nextNode;
        } else {
            head = newNode;
        }

    }


    public static void insertAtEnd(int data) {
        Node newNode = new Node(data);
        newNode.next = null;
        Node last = head;
        if (head == null) {
            newNode.prev = null;
            head = newNode;
        }
        //Traverse to the last.next
        while (last.next != null) {
            last = last.next;
        }

        last.next = newNode;
        newNode.prev = last;


    }


    public static void printList(Node node) {
        Node last = head;
        while (node != null) {
            System.out.println("Traversing in front  --->" + node.data);
            last = node;
            node = node.next;
        }
        System.out.println();
        System.out.println();
        while (last != null) {
            System.out.println("Traversing back --->" + last.data);
            last = last.prev;
        }
    }


    public static void main(String[] args) {
        head = null;
        head = new Node(2);
        head.next = new Node(5);
        head.next.prev = head;
        insertAtFront(1);
        System.out.println("Insert element at front --->");
        printList(head);
        System.out.println("Insert element after node --->");
        insertAfterNode(3, head.next);
        System.out.println();
        System.out.println();
        printList(head);
        System.out.println();
        System.out.println("Insert element before node --->");
        insertBeforeNode(4, head.next.next.next);
        printList(head);
        System.out.println();
        System.out.println();
        insertAtEnd(6);
        System.out.println();
        System.out.println("Printing Insertion At End----->");
        printList(head);


    }
}
