package LinkList;

public class LinkList8ReverseNodesinKGroup {
 
        public static ListNode reverseKGroup(ListNode head, int k) {  
            ListNode cur = head;  
            int cnt = 0;  
            // get next group  
            while (cur != null && cnt != k) {  
                cur = cur.next;  
                cnt++;  
            }  
            if (cnt == k) {  
                cur = reverseKGroup(cur, k);  
                // reverse  
                while (0 <= --cnt) {  
                    ListNode tmp = head.next;  
                    head.next = cur;  
                    cur = head;  
                    head = tmp;  
                }  
                head = cur;  
            }  
            return head;  
        }  
    
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr={1,2,3,4,5,6,7};
        ListNode head=new ListNode(arr);
        head=reverseKGroup(head, 3);
        head.traverse();
    }

}
