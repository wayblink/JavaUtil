package LinkList;

/**
 * Reorder List
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
    reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

    You must do this in-place without altering the nodes' values.

    For example,
    Given {1,2,3,4}, reorder it to {1,4,2,3}.
    
    本题思路如下：首先将题目所给单链表从中间分割为两个单链表，再将后半个单链表反向，最后合并两个单链表即可。
 * @author reus
 *
 */
public class LinkList12ReorderList {
   
    public static ListNode reorderList(ListNode head){
        ListNode fakeHead=new ListNode(-1);
        fakeHead.next=head;
        ListNode ptr1=fakeHead;
        ListNode ptr2=fakeHead;
        while(ptr2.next!=null){
            ptr1=ptr1.next;
            ptr2=ptr2.next;
            if(ptr2.next==null){
                break;
            }else{
                ptr2=ptr2.next;
            }
        }
        ptr1=ptr1.next;
        ListNode node =head;
        while(ptr1!=null){
            ListNode temp1=ptr1.next;
            ListNode temp2=node.next;
            ptr1.next=node.next;
            node.next=ptr1;
            ptr1=temp1;
            node=temp2;
        }
        node.next=null;
        return head;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr={1,2,3,4,5,6,7};
        ListNode head=new ListNode(arr);
        head=reorderList(head);
        head.traverse();
    }

}
