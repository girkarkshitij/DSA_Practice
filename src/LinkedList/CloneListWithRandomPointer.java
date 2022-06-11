class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        
        Node itr = head, front = head;
        
        while(itr != null){
            front = itr.next;
            
            Node copy = new Node(itr.val);
            itr.next = copy;
            copy.next = front;
            
            itr = front;
        }
        
        itr = head;
        while(itr != null){
            if(itr.random != null){
                itr.next.random = itr.random.next;
            }
            itr = itr.next.next;
        }
        
        itr = head;
        Node dummy = new Node(0);
        Node copy = dummy;
        
        while(itr != null){
            front = itr.next.next;
            copy.next = itr.next;
            copy = copy.next;
            itr.next = front;
            itr = front;
        }
        
        return dummy.next;
    }
}
