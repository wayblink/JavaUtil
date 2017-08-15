package LinkList;

public class LinkList7SwapNodesinPairs {

    public static ListNode swap(ListNode head){
        ListNode ptr1=head;
        ListNode ptr2=head.next;
        while(ptr1.next!=null&&ptr2.next!=null){
            int temp=ptr1.val;
            ptr1.val=ptr2.val;
            ptr2.val=temp;
            ptr1=ptr2.next;
            ptr2=ptr1.next;
        }
        return head;
        
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr={1,2,3,4,5,6,7};
        ListNode head=new ListNode(arr);
        head=swap(head);
        head.traverse();
    }

}
