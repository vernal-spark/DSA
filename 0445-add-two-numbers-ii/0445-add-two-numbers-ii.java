/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public static ListNode reverse(ListNode head){
        if(head==null || head.next==null)return head;
        ListNode curr = head, prev = null;
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        l1 = reverse(l1);
        l2 = reverse(l2);
        int carry = 0;
        while(l1!=null || l2!=null){
            int sum = 0;
            if(l1!=null){
                sum+=l1.val;
            }
            if(l2!=null){
                sum+=l2.val;
            }
            if(carry>0){
                sum += carry;
                carry = 0;
            }
            if(sum>9){
                carry = sum/10;
                sum = sum % 10;
            }
            curr.next = new ListNode(sum);
            curr = curr.next;
            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }
        }
        if(carry>0){
            curr.next = new ListNode(carry);
            curr = curr.next;
        }
        return reverse(dummy.next);
    }
}