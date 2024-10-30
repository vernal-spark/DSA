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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)return null;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(true){
            ListNode min = null;
            int minIndex = -1;
            for(int i=0;i<lists.length;i++){
                if(min==null||(lists[i]!=null && lists[i].val<min.val)){
                    min = lists[i];
                    minIndex = i;
                }
            }
            if(min == null)break;
            curr.next = min;
            curr = curr.next;
            lists[minIndex]=lists[minIndex].next;
        }
        return dummy.next;
    }
}