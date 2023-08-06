package medium;

// https://leetcode.com/problems/add-two-numbers/
public class AddTwoNumber {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode1 = solution.createListNode(new int[]{9}, 0);
        ListNode listNode2 = solution.createListNode(new int[]{1, 9, 9, 9, 9, 9, 9, 9, 9, 9}, 0);
        //0,0,0,0,0,0,0,0,0,0,1
//        solution.printListNode(listNode1);
//        System.out.println();
//        solution.printListNode(listNode2);

        ListNode listNode = solution.addTwoNumbers2(listNode1, listNode2);
        solution.printListNode(listNode);
        System.out.println();
    }


}


class Solution {

    /**
     * 建立鏈表頭的listNode，val無值，不可移動
     * 建立當前listNode，初始為鏈表頭，不斷迭代next
     * 迴圈獲取l1 l2的val，做加總給sum
     * sum可能會進位所以除10賦值carry
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode headNode = new ListNode(0);
        ListNode tmp = headNode;
        int sum;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            sum = l1 != null ? l1.val : 0;
            sum += l2 != null ? l2.val : 0;
            sum += carry;
            carry = sum / 10;
            tmp.next = new ListNode(sum%10);
            tmp = tmp.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        return headNode.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int sum;
        int num;
        int tenMutiple = 0;
        ListNode listNode = null;
        ListNode tmp;
        while (l1 != null || l2 != null) {
            sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            sum += tenMutiple;
            num = sum % 10;
            tenMutiple = sum / 10;

            if (listNode == null) {
                listNode = new ListNode(num);
                continue;
            }

            tmp = listNode;
            while (true) {
                if (tmp.next == null) {
                    break;
                }

                tmp = tmp.next;
            }

            tmp.next = new ListNode(num);
        }

        if (tenMutiple > 0) {
            tmp = listNode;
            while (true) {
                if (tmp.next == null) {
                    break;
                }

                tmp = tmp.next;
            }

            tmp.next = new ListNode(tenMutiple);
        }


        return listNode;
        //return createListNodeBySum(sum);
    }


    // 807 708
    public ListNode createListNodeBySum(int sum) {
        ListNode listNode = new ListNode();
        listNode.val = sum;

        if (sum >= 10) {
            listNode.val = sum % 10;
            sum /= 10;
            listNode.next = createListNodeBySum(sum);
        }

        return listNode;
    }

    public int getHightNumber(int num) {
        if (num >= 10) {
            num -= (num % 10);
            num /= 10;
            num = getHightNumber(num);
        }

        return num;
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