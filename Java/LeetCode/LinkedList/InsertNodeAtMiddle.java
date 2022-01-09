/**
 * @author Kedar Erande
 */
public class InsertNodeAtMiddle {
    static Node head;

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public static void insertAtMiddle(int data) {
        Node new_node = new Node(data);
        if (head == null) {
            head = new_node;
        } else {
            Node slow = head;
            Node fast = head.next;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            new_node.next = slow.next;
            slow.next = new_node;

        }
    }

    public static void display() {
        Node currNode = head;
        while (currNode != null) {
            System.out.println("The elements in the LL are " + currNode.data);
            currNode = currNode.next;
        }
    }


    public static void main(String[] args) {
        head = null;
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(4);
        head.next.next.next = new Node(5);

        insertAtMiddle(3);
        display();


    }
}
