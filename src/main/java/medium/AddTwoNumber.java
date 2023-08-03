package medium;

public class AddTwoNumber {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode1 = solution.createListNode(new int[]{2, 4, 3}, 0);
        ListNode listNode2 = solution.createListNode(new int[]{5, 6, 4}, 0);
//        solution.printListNode(listNode1);
//        System.out.println();
//        solution.printListNode(listNode2);

        ListNode listNode = solution.addTwoNumbers(listNode1, listNode2);
        solution.printListNode(listNode);
    }


}


class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /**
         * 1. 迴圈各val*10*n並加總sum
         * 2. n為有next時+1
         * 3. next為null時跳出迴圈
         * 4. 用遞歸方式把sum和10取餘數拆解成ListNode
         */

        int sum = 0;
        int len = -1;
        int tenMutiple;
        while (l1 != null || l2 != null) {
            len++;
            tenMutiple = 10 ^ len;
            if (l1 != null) {
                sum += l1.val * tenMutiple;
                l1 = l1.next;
            }
            if (l1 != null) {
                sum += l1.val * tenMutiple;
                l2 = l2.next;
            }


        }


       return createListNodeBySum(sum, 0, len);
    }

    public ListNode createListNodeBySum(int sum, int start, int len) {
        ListNode listNode = new ListNode();

        if (start != len) {
            start++;
            listNode.next = createListNodeBySum(sum, start, len);
        }

        listNode.val = sum / (10 ^ start);

        return listNode;
    }

    public ListNode createListNode(int val) {
        ListNode listNode = new ListNode();
        listNode.val = val;
        return listNode;
    }


    public ListNode createListNode(int[] array, int index) {
        ListNode listNode = null;
        if (index < array.length) {
            listNode = new ListNode();
            listNode.val = array[index];
            index++;
            listNode.next = createListNode(array, index);
        }

        return listNode;
    }

    public void printListNode(ListNode listNode) {
        String seperator = "";
        if (listNode != null) {
            if (listNode.next != null) {
                seperator = ",";
            }
            System.out.print(listNode.val + seperator);
            printListNode(listNode.next);
        }
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
}