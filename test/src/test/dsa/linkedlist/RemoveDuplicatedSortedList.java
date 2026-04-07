package test.dsa.linkedlist;


public class RemoveDuplicatedSortedList {

    public static ListNode removeDuplicate(ListNode head) {
        ListNode cur = head;
        while(cur!=null && cur.next != null) {
            if(cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(2)))));
        ListNode cur = removeDuplicate(head);
        while(cur!=null) {
            System.out.println(cur.val + " ");
            cur = cur.next;
        }
    }
}
