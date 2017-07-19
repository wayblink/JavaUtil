package LinkList;

public class LinkList9ReverseList {

    public static ListNode reverse(ListNode head){
        if(head.next==null){
            return head;
        }
        ListNode node=head;
        int num=1;
        while(node.next!=null){
            num++;
            node=node.next;
        }
        node=node.next;
        while(--num>=0){
            ListNode temp=head.next;
            head.next=node;
            node=head;
            head=temp;
        }
        head=node;
        
        return head;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr={1,2,3,4,5,6,7};
        ListNode head=new ListNode(arr);
        head=reverse(head);
        head.traverse();
    }

}
