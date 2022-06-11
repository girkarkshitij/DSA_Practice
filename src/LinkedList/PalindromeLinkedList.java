class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head.next == null)
            return true;
        
        ListNode slow=head, fast=head;
        
        while(fast.next != null && fast.next.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        slow.next = reverse(slow.next);
        slow = slow.next;
        
        while(slow!=null){
            if(head.val != slow.val)
                return false;
            
            head=head.next;
            slow=slow.next;
        }
        
        return true;
    }
    
    ListNode reverse(ListNode head){
        ListNode pre = null, next = null;
        
        while(head != null){
            next = head.next;
            head.next = pre;
            pre=head;
            head=next;
        }
        
        return pre;
    }
}
