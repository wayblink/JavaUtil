package LinkList;

/**
 * Remove Nth Node From End of List
 * 
 * Given a linked list, remove the nth node from the end of list and return its head.
   For example, Given linked list: 1,2,3,4,5, and n = 2.
   After removing the second node from the end, the linked list becomes 1,2,3,5.
   Note:
   • Given n will always be valid.
   • Try to do this in one pass. 
 * @author reus
 *
 */
public class LinkList6RemoveNthNodeFromEndofList {

    public static ListNode remove(ListNode head,int k){
        ListNode fakehead=new ListNode(-1);
        fakehead.next=head;
        ListNode slow=fakehead;
        ListNode fast=fakehead;
        while(k>0){
            if(fast.next!=null){
                fast=fast.next;
                k--;
            }else{
                System.out.println("Not enough nodes");
                return head;
            }                    
        }
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return fakehead.next;        
    }
    
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7};
        ListNode head=new ListNode(arr);
        head=remove(head, 6);
        head.traverse();
    }

}
