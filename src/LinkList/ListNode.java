package LinkList;

public class ListNode {
    int val;
    ListNode next;
    public ListNode(int val){
        this.val=val;
    }
    
    public void traverse(){
        ListNode node=this;
        while(node!=null){
            System.out.println(node.val);
            node=node.next;
        }
    }
    
    public ListNode(int[] arr){
        this.val=arr[0];
        ListNode node =this;
        for(int i=1;i<arr.length;i++){
            node.next=new ListNode(arr[i]);
            node=node.next;
        }
        
    }
}
