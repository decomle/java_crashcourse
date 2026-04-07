package test.dsa.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class CycleLinkedList {
    public static ListNode generateList() {
        ListNode head = new ListNode(3);
        ListNode no1 = new ListNode(2);
        ListNode no2 = new ListNode(0);
        ListNode no3 = new ListNode(4);

        head.next = no1;
        head.next.next = no2;
        head.next.next = no3;
        no3.next = no1;

        return head;
    }

    // Time: O(n), Space: O(n)
    public static boolean isCyclingWithSet(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while(head!=null) {
            if(set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }

        return false;
    }

    // Time: O(n), space O(1)
    public static boolean isCycling(ListNode head) {
        if(head == null) {
            return false;
        }

        ListNode slow = head, fast = head;
        while(fast!=null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ListNode head = generateList();

        System.out.println(isCycling(head));
    }
}
