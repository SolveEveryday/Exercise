class Solution {
    fun addTwoNumbers(l1: ListNode, l2: ListNode): ListNode {
        val result = ListNode((l1.`val` + l2.`val`) % 10)
        var carry = (l1.`val` + l2.`val`) / 10
        
        var resultCurrent = result
        var l1Current: ListNode? = l1.next
        var l2Current: ListNode? = l2.next
        while (l1Current !== null || l2Current !== null) {
            val num1 = l1Current?.`val` ?: 0
            val num2 = l2Current?.`val` ?: 0
            val sum = num1 + num2 + carry
            
            resultCurrent.next = ListNode(sum % 10)
            carry = sum / 10
            
            resultCurrent = resultCurrent.next
            l1Current = l1Current?.next
            l2Current = l2Current?.next
        }
        if (carry == 1) {
            resultCurrent.next = ListNode(1)
        }
        
        return result
    }
}