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
    public static int getMin(ListNode[] lists){
        int i=0;
        while( i<lists.length && lists[i]==null){
            i++;
        }
        if(i==lists.length)return -1;
        int idx = i;
        for(i=idx+1;i<lists.length;i++){
            if(lists[i]!=null && lists[i].val<lists[idx].val){
                idx = i;
            }
        }
        return idx;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)return null;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int index = getMin(lists);
        while(index>=0){
            curr.next = new ListNode(lists[index].val);
            curr = curr.next;
            lists[index] = lists[index].next;
            index = getMin(lists);
        }
        return dummy.next;
        
    }
}