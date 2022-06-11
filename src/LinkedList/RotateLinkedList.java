class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;
        
        int length = 1;
        ListNode t = head;
        while(t.next != null){
            t = t.next;
            length++;
        }
        t.next = head;
        
        if(k >= length)
            k %= length;
        
        int target = length-k;
        ListNode temp = head;
        for(int i=1; i<target; i++){
            temp = temp.next;
        }
        
        ListNode ans = temp.next;
        temp.next = null;
        
        return ans;
    }
}
