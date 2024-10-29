/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public static int getCount(ListNode node){
        int count=0;
        ListNode curr = node;
        while(curr!=null){
            count++;
            curr=curr.next;
        }
        return count;
    }
    public static ListNode getIntersection(int d,ListNode n1,ListNode n2){
        for(int i=0;i<d;i++){
            n1=n1.next;
        }
        while(n1!=null && n2!=null){
            if(n1==n2){
                return n1;
            }
            n1=n1.next;
            n2=n2.next;
        }
        return null;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int c1 = getCount(headA);
        int c2 = getCount(headB);
        if(c2>c1){
            return getIntersection(c2-c1,headB,headA);
        }else{
            return getIntersection(c1-c2,headA,headB);
        }

    }
}