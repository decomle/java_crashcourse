package test.dsa.linkedlist;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class IntersectionNode {
    public static ListNode[] generateTest() {
        ListNode intersection = new ListNode(8, new ListNode(4, new ListNode(5)));
        ListNode headA = new ListNode(4, new ListNode(1, intersection));
        ListNode headB = new ListNode(5, new ListNode(6, new ListNode(1, intersection)));
        return new ListNode[]{headA, headB};
    }

    public static ListNode findInterSectionBrute(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode node = headA;
        while(node != null) {
            set.add(node);
            node = node.next;
        }
        node = headB;
        while(node!=null) {
            if(set.contains(node)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public static ListNode findInterSection(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode curA = headA, curB = headB;
        while(curA != curB) {
            curA = curA.next == null ? headB : curA.next;
            curB = curB.next == null ? headA : curB.next;
        }
        return curA;
    }


    public static void main(String[] args) {
        ListNode[] pair = generateTest();
        ListNode headA = pair[0];
        ListNode headB = pair[1];

        ListNode intersection = findInterSection(headA, headB);
        Optional.ofNullable(intersection).ifPresentOrElse(ListNode::printListNode, () -> System.out.println("No Intersection"));
    }
}
