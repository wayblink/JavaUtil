package LinkList;


public class LinkList3RemoveDuplicateFromSortedList {

    class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val=val;
        }
    }
    
    public ListNode remove(ListNode head){
        if(head==null||head.next==null)
            return head;
        
        ListNode node=head;
        
        while(node.next!=null){
            if(node.val==node.next.val){
                node.next=node.next.next;
            }
            node=node.next;
        }
        return head;
    }
    
    public static void main(String[] args) {
        
    }

}
