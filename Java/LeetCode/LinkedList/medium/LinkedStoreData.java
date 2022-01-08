package LinkedList.medium;

/**
 * @author Kedar Erande
 * Problem to remove nth element from end
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class LinkedStoreData {

    ListNode head;

    static class ListNode {
        int data;
        ListNode next;


        public ListNode(int data) {
            this.data = data;
            next = null;
        }
    }


    public static LinkedStoreData insert(LinkedStoreData linkedStore, int data) {
        ListNode listNode = new ListNode(data);
        if (linkedStore.head == null) {
            linkedStore.head = listNode;
        } else {
            ListNode last = linkedStore.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = listNode;
        }
        return linkedStore;

    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode slow = start, fast = start;


        //Move fast in front so that the gap between slow and fast becomes n
        for (int i = 1; i <= n + 1; i++) {
            fast = fast.next;
        }
        //Move fast to the end, maintaining the gap
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //Skip the desired node
        slow.next = slow.next.next;
        return start.next;
    }

    public static void main(String[] args) {
        LinkedStoreData linkedStoreData = new LinkedStoreData();
        linkedStoreData = insert(linkedStoreData, 1);
        linkedStoreData = insert(linkedStoreData, 2);
        linkedStoreData = insert(linkedStoreData, 3);
        linkedStoreData = insert(linkedStoreData, 4);
        linkedStoreData = insert(linkedStoreData, 5);

        int n = 2;
        ListNode head = linkedStoreData.head;
        ListNode li = linkedStoreData.removeNthFromEnd(head, n);


    }
}
