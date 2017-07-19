package LinkList;

/**
 * 䔟
Given a list, rotate the list to the right by k places, where k is non-negative.
For example: Given 1->2->3->4->5->null , k=2 , return 4->5->1->2->3->null
 * @author reus
 *
 */
public class LinkList5RotateList {

    /**
     * my solution
     * 
     * not good enough
     * @param head
     * @return
     */
    public static ListNode rotate(ListNode head){
        ListNode fakehead=new ListNode(-1);
        fakehead.next=head;
        ListNode pre=fakehead;
        ListNode cur=head;
        while(cur.next!=null){
            cur=cur.next;
            pre=pre.next;
        }
        fakehead.val=cur.val;
        pre.next=null;
        return fakehead;
    }
    
    public static ListNode rotate(ListNode head,int k){
        for(int i=0;i<k;i++){
            head=rotate(head);
        }
        return head;
    }
    
    /**
     * good solution
     * 
     * @param args
     */
    
    public static ListNode rotateGood(ListNode head,int k){
        int num=0;
        ListNode node=head;
        while(node.next!=null){
            num++;
            node=node.next;
        }
        k=k%num;
        node.next=head;
        while(k>=0){
            node=node.next;
            k--;
        }
        head=node.next;
        node.next=null;
        return head;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr={1,2,3,4,5,6,7};
        ListNode head=new ListNode(arr);
        head=rotateGood(head, 3);
        head.traverse();
    }

}
