package test.dsa.linkedlist;

public class ListNode {
    int val;
    ListNode next;
    public ListNode(){}
    public ListNode(int value) {
        this.val = value;
    }
    public ListNode(int value, ListNode next) {
        this.val = value;
        this.next = next;
    }

    public void print() {
        printListNode(this);
    }

    public static void printListNode(ListNode node) {
        while(node != null) {
            System.out.print(node.val + (node.next == null ? "" : " -> "));
            node = node.next;
        }
        System.out.println();
    }

    public static ListNode generateList(int ...nums) {
        ListNode head = null, prevNode = null, curNode;
        for(int num: nums) {
            curNode = new ListNode(num);
            head = head == null ? curNode : head;
            if(prevNode != null) {
                prevNode.next = curNode;
            }
            prevNode = curNode;
        }

        return head;
    }
}
