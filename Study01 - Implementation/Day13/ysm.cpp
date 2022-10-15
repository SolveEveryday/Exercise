/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode* output = new ListNode();
        ListNode* now = output;
        int sum = 0;
        
        while(true) {
            if(l1) {
                sum += l1->val;
                l1 = l1->next;
            }
            if(l2) {
                sum += l2->val;
                l2 = l2->next;
            }
            now->val = sum%10;
            sum /= 10;
            
            if(l1 || l2 || sum) {
                now->next = new ListNode();
                now = now->next;
            } else break;
        }
        return output;
    }
};