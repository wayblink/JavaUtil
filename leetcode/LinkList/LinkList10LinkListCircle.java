package LinkList;

/**
 * Link List Circle
 * 
 * 判断链表是否有环
 * 
 * 快慢指针
 * @author reus
 *
 */
public class LinkList10LinkListCircle {

    
    public static boolean hasCircle(ListNode head){
        ListNode ptr1=head;
        ListNode ptr2=head;
        while(ptr2.next!=null&&ptr1.next!=null){
            ptr2=ptr2.next.next;
            ptr1=ptr1.next;
            if(ptr1==ptr2){
                return true;
            }
        }
       return false;
        
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr={1,2,3,4,5,6,7};
        ListNode head=new ListNode(arr);
        ListNode node=head;
        while(node.next!=null){
            node=node.next;
        }
        node.next=head;
        System.out.println(hasCircle(head));
    }

}
