package LinkList;

/**
 * 
 * Partition List 
 * 
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

   You should preserve the original relative order of the nodes in each of the two partitions.

   For example,
   Given 1->4->3->2->5->2 and x = 3,
   return 1->2->2->4->3->5.
 * @author reus
 *
 */
public class LinkList2PartitionList {

    class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val=val;
        }
    }
    
    public ListNode partition(ListNode head, int x) {
        if(head==null||head.next==null)
            return head;
        
        ListNode small = new ListNode(-1);
        ListNode newsmallhead = small;
        ListNode big = new ListNode(-1);
        ListNode newbighead = big;
        
        while(head!=null){
            if(head.val<x){
                small.next=new ListNode(head.val);
                small=small.next;
            }else{
                big.next=new ListNode(head.val);
                big=big.next;
            }
            head=head.next;
        }
        
        small.next=newbighead.next;
        return newsmallhead.next;
    }
    
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
