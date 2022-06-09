class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode l1 = list1, l2 = list2;
        if(l1 == null)
            return l2;
        
        if(l2 == null)
            return l1;
        
        if(l1 == null && l2 == null)
            return null;
        
        ListNode ans = new ListNode(0);
        ListNode temp = ans;
        
        while(l1!=null && l2!=null){
            if(l1.val <= l2.val){
                temp.next = l1;
                l1 = l1.next;
            }else{
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        
        if(l1 != null)
            temp.next = l1;
        
        if(l2 != null)
            temp.next = l2;
        
        return ans.next;
    }
}
