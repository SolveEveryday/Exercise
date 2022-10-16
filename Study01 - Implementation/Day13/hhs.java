public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultNode = new ListNode();
        ListNode tempNode = resultNode;

        int tempValue = 0;

        while (true) {
            int l1Value = 0, l2Value = 0, sumValue;

            if (l1 != null) {
                l1Value = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                l2Value = l2.val;
                l2 = l2.next;
            }

            sumValue = l1Value + l2Value + tempValue;
            tempValue = sumValue / 10;

            tempNode.val = sumValue % 10;

            if (l1 == null && l2 == null && tempValue == 0) {
                break;
            }

            tempNode.next = new ListNode();
            tempNode = tempNode.next;
        }

        return resultNode;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(5))));

        ListNode l3 = new Solution().addTwoNumbers(l1, l2);
        System.out.println();
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