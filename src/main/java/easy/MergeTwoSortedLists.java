package easy;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode();
        ListNode listNode2 = new ListNode();
        ListNode listNode3 = new ListNode();
        listNode1.val = 1;
        listNode1.next = listNode2;
        listNode2.val = 2;
        listNode2.next = listNode3;
        listNode3.val = 4;

        ListNode listNode4 = new ListNode();
        ListNode listNode5 = new ListNode();
        ListNode listNode6 = new ListNode();
        listNode4.val = 1;
        listNode4.next = listNode5;
        listNode5.val = 3;
        listNode5.next = listNode6;
        listNode6.val = 4;

        ListNode listNode = new MergeTwoSortedLists().mergeTwoLists(listNode1, listNode4);
        System.out.println(listNode);
    }


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list2 == null) {
            return list1;
        }

        if (list1 == null) {
            return list2;
        }

        if (list1.val <= list2.val) {

            list1.next = mergeTwoLists(list1.next, list2);
        } else {
            list1 = mergeTwoLists(list2, list1);
        }

        return list1;
    }


}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
