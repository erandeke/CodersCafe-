package LinkedList.medium;

/**
 * @author Kedar Erande
 *
 * Compare strings stored in two Linked Lists . Return true if the strings stored in both the lists are simillar.
 *
 * List 1 : "He" -> " llo" -> "wor" -> "ld"
 * List 2 : "H" --> "e" --> "ll" --> "owo" --> "r" --> "ld"
 */
public class LinkedStore {
    ListNode head;

    static class ListNode {
        String str;
        ListNode next;

        public ListNode(String str) {
            this.str = str;
            this.next = null;
        }

    }


    public LinkedStore insert(LinkedStore linkedStore, String str) {
        ListNode node = new ListNode(str);
        if (linkedStore.head == null) {
            linkedStore.head = node;
        } else {
            ListNode last = linkedStore.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = node;
        }
        return linkedStore;

    }


    public void printLinkedList(LinkedStore linkedStore) {
        ListNode currNode = linkedStore.head;
        while (currNode != null) {
            System.out.println("List items--> " + currNode.str);
            currNode = currNode.next;
        }
    }

    private static boolean areStringsEqual(LinkedStore linkedStore1, LinkedStore linkedStore2) {
        ListNode head1 = linkedStore1.head;
        ListNode head2 = linkedStore2.head;
        int i = 0;
        int j = 0;
        while (head1 != null && head2 != null) {
            if (i == head1.str.length()) {
                i = 0;
                head1 = head1.next;
            }
            if (j == head2.str.length()) {
                j = 0;
                head2 = head2.next;
            }
            if (head1 == null && head2 == null) {
                return true;
            } else if (head1 == null || head2 == null || head1.str.charAt(i) != head2.str.charAt(j)) {
                return false;
            }
            i++;
            j++;

        }
        return true;

    }


    public static void main(String[] args) {
        LinkedStore ls1 = new LinkedStore();
        LinkedStore ls2 = new LinkedStore();
        ls1.insert(ls1, "He");
        ls1.insert(ls1, "llo");
        ls1.insert(ls1, "wor");
        ls1.insert(ls1, "ld");
        System.out.println();
        ls1.printLinkedList(ls1);
        System.out.println("Second List for comparison------>");
        ls2.insert(ls2, "H");
        ls2.insert(ls2, "e");
        ls2.insert(ls2, "ll");
        ls2.insert(ls2, "owo");
        ls2.insert(ls2, "r");
        ls2.insert(ls2, "ld");

        ls2.printLinkedList(ls2);

        System.out.println(areStringsEqual(ls1, ls2));

    }


}
