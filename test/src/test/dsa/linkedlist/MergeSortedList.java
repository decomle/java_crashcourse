package test.dsa.linkedlist;

public class MergeSortedList {
    public static ListNode mergeSortedList(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(), node = dummy;
        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                node.next = list1;
                list1 = list1.next;
            } else {
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }
        if(list1 != null) {
            node.next = list1;
        }
        if(list2 != null) {
            node.next = list2;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode list1 = ListNode.generateList(1,2,4);
        ListNode list2 = ListNode.generateList(1,3,4);
        list1.print();
        list2.print();
        mergeSortedList(list1, list2).print();
    }
}
