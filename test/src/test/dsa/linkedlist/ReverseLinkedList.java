package test.dsa.linkedlist;

public class ReverseLinkedList {
    public static ListNode reverseLinkedList(ListNode head) {
        ListNode current = head, prev = null, next = null;

        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        ListNode.printListNode(head);
        System.out.println("----------------");
        ListNode.printListNode(reverseLinkedList(head));
    }
}
