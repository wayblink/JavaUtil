package LinkList;

/**
 * 
 * 1： 两个指针，一个一次走两格，一个一次走一个。相遇了证明有环。

   2： 然后因为快的那个总是比慢的那个走快一步，当他们相遇后，再走k步（k是circle的结点数量）后，他们会再相遇，从而求出circle结点数量。

   3： 最后再设置两个指针（都是一次走一步），但一开始一个比另外一个领先k步，那么它们就会刚好在环的起点相遇。。


 * @author reus
 *
 */
public class LinkList11LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        if(head==null||head.next==null)
            return null;
        
        ListNode fast = head,slow=head;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;   
            }
            slow = slow.next;
            fast = fast.next.next;
            
            if(fast==slow)
                break;
        }
        
        slow = head;//slow back to start point
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow; //when slow == fast, it is where cycle begins
    }
    
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
