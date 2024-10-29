/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> nodeMap = new HashMap<>();
        Node ans = new Node(0);
        Node ansCurr = ans;
        Node curr = head;
        while(curr!=null){
            Node newNode = new Node(curr.val);
            nodeMap.put(curr,newNode);
            ansCurr.next = newNode;
            ansCurr = newNode;
            curr=curr.next;
        }
        curr = head;
        ansCurr = ans.next;
        while(curr!=null){
            Node random=curr.random;
            if(random!=null){
                Node equivalentNode = nodeMap.get(random);
                ansCurr.random=equivalentNode;
            }
            curr=curr.next;
            ansCurr=ansCurr.next;
        }
        return ans.next;
    }
}