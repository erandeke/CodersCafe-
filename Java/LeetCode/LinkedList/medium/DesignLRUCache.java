package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kedar Erande
 */
public class DesignLRUCache {

    Node head = new Node(0, 0);
    Node tail = new Node(0, 0); // required to remove the least recently used that would yeild the results in O(1)
    //If we do not use tail then operation to find the least recently used will be O(n) since we need to traverse till last
    int capacity;
    Map<Integer, Node> map = new HashMap<>();

    public DesignLRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;

    }

    static class Node {
        int key;
        int value;
        Node next;
        Node prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            next = null;
            prev = null;

        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            //remove that since the value we need to update
            remove(map.get(key));
        }
        if (map.size() == capacity) {
            remove(tail.prev); //The capacity is full so time to remove the least recently used
        }
        insert(new Node(key, value));
    }

    public void insert(Node node) {
        map.put(node.key, node);
        node.next = head.next;
        head.next = node;
        node.prev = head;
        node.next.prev = node;
        System.out.println("successfully inserted---> " + node.key);
    }

    public void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        System.out.println("successfully deleted record---> " + node.key);
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        } else
            return -1;

    }


    public static void main(String[] args) {


    }
}
