import java.util.*;

public class ReorderList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
	}
	
	 public static void reorderList(ListNode head) {
	        if(head==null||head.next==null) return; 
	        
	        ListNode slow=head,fast=head;
	        ListNode pre=null;
	        while(fast!=null&&fast.next!=null){
	            pre=slow;
	            slow=slow.next;
	            fast=fast.next.next;
	        }
	        
	        pre.next=null;
	        ListNode secondlist=reverse(slow);
	        
	        ListNode firstlist=head;
	        merge(firstlist,secondlist);
	        
	       // return firstlist;
	    }
	    
	    public static ListNode reverse(ListNode head){
	        if(head==null||head.next==null) return head;
	        
	        ListNode l1=head;
	        ListNode l2=null;
	        while(l1!=null){
	            ListNode temp=l1;
	            l1=l1.next;
	            temp.next=l2;
	            l2=temp;
	        }
	        
	        return l2;
	    }
	    
	    public static void merge(ListNode l1,ListNode l2){
	        ListNode current=l1;
	        while(current!=null&&current.next!=null){
	            ListNode temp2=l2;
	            l2=l2.next;
	            temp2.next=current.next;
	            current.next=temp2;
	            current=temp2.next;
	        }
	        
	        if(current.next==null){
	            current.next=l2;
	        }
	        
	    }

}
