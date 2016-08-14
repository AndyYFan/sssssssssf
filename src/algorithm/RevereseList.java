public class Solution {
    public ListNode ReverseList(ListNode head) {
		if(head == null)
        {
            return null;
        }
        
        
        if(head.next == null)
        {
            return head;
        }
        ListNode cur = head.next;
          if(head.next.next == null)
        {
            ListNode dummy = head.next;
            head.next.next = head;
            head.next = null;
            return dummy;
        }
        
        ListNode next = head.next.next;
        
       
        ListNode prev = head;
        prev.next = null;
        
  
        
        while(cur!=null)
        {
			next = cur.next;
            cur.next  = prev;
            prev = cur;
            cur = next;
            
        }
        return prev;
         
    }
}