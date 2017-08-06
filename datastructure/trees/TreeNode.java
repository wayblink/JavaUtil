package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(){}
    
    public TreeNode(int val){
        this.val=val;
    }
    
    public static TreeNode build(int[] arr){
        if(arr.length==0){
            return null;
        }
        TreeNode root=new TreeNode(arr[0]);
        LinkedList<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int count=1;
        int length=arr.length;
        while(count<length){
            TreeNode node=queue.poll();
            if(count<length){
                node.left=new TreeNode(arr[count++]);
                queue.add(node.left);
            }
            if(count<length){
                node.right=new TreeNode(arr[count++]);
                queue.add(node.right);
            }
        }
        return root;
        
    }
    
    public static TreeNode construct(int[] preArr, int preStart, int[] inArr, int inStart, int length){
        if(preArr==null||inArr==null||length==0){
            return null;
        }
        TreeNode root = new TreeNode(preArr[preStart]);
        int leftLength = 0;
        while(leftLength < length) {
            if (inArr[leftLength + inStart] == root.val){
                break;
            }
            leftLength++;
        }
        
        root.left = construct(preArr, preStart + 1, inArr, inStart, leftLength);
        root.right = construct(preArr, preStart + leftLength + 1, inArr, inStart+leftLength+1, length-leftLength-1);
        return root;
    }

    public static TreeNode construct(int[] preArr, int[] inArr){
        if(preArr.length == inArr.length){
            return construct(preArr, 0, inArr, 0, preArr.length);
        }else{
            System.out.println("Wrong input length");
            return null;
        }
    }
    
    public void levelTraverse(){
        LinkedList<TreeNode> queue=new LinkedList<>();
        queue.add(this);
        while(!queue.isEmpty()){
            TreeNode node =queue.poll();
            System.out.println(node.val);
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
        }
    }
    
    public ArrayList<ArrayList<Integer>> levelTraverseAsList(){
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        LinkedList<TreeNode> cur=new LinkedList<>(),next=new LinkedList<>();
        if(this==null){
            return result;
        }else{
            cur.add(this);
        }
        while(!cur.isEmpty()){
            ArrayList<Integer> curLevel=new ArrayList<>();
            while(!cur.isEmpty()){
                TreeNode node = cur.poll();
                curLevel.add(node.val);
                System.out.print(node.val+" ");
                if(node.left!=null){
                    next.add(node.left);
                }
                if(node.right!=null){
                    next.add(node.right);
                }
            }
            System.out.println();
            result.add(curLevel);
            LinkedList<TreeNode> temp=new LinkedList<>();
            temp=cur;
            cur=next;
            next=temp;
        }
        return result;
    }
    
    public ArrayList<ArrayList<Integer>> zigzagTraverse(){
        if(this==null){
            return null;
        }
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        LinkedList<TreeNode> cur=new LinkedList<>(),next=new LinkedList<>();
        cur.add(this);       
        int zigzag=0;
        while(!cur.isEmpty()){
            ArrayList<Integer> curLevel=new ArrayList<>();
            TreeNode node=cur.poll();
            curLevel.add(node.val);
            System.out.print(node.val+" ");
            if(zigzag==0){
                if(node.left!=null){
                    next.push(node.left);
                }
                if(node.right!=null){
                    next.push(node.right);
                } 
            }else{  
                if(node.right!=null){
                    next.push(node.right);
                }
                if(node.left!=null){
                    next.push(node.left);
                }

            }

            
            if(cur.isEmpty()){
                System.out.println();
                zigzag=1-zigzag;
                result.add(curLevel);
                LinkedList<TreeNode> temp=cur;
                cur=next;
                next=temp;
            }
        }
        return result;
        
    }
    
    public void preOrderTraverse1(){
        if(this!=null){
            System.out.print(val+" ");
        }
        if(this.left!=null){
            this.left.preOrderTraverse1();
        }
        if(this.right!=null){
            this.right.preOrderTraverse1();
        }
    }
    
    public void inOrderTraverse1(){
        if(this.left!=null){
            this.left.inOrderTraverse1();
        }

        System.out.print(val+" ");
        
        if(this.right!=null){
            this.right.inOrderTraverse1();
        }
    }
    
    public void postOrderTraverse1(){
        if(this.left!=null){
            this.left.postOrderTraverse1();
        }
        if(this.right!=null){
            this.right.postOrderTraverse1();
        }

        System.out.print(val+" ");
        
    }
    
    public void preOrderTraverse2(){
        LinkedList<TreeNode> stack=new LinkedList<>();
        TreeNode node=this;
        while(node!=null||!stack.isEmpty()){
            while(node!=null){
                System.out.print(node.val+" ");
                stack.push(node);
                node=node.left;
            }
            if(!stack.isEmpty()){
                node=stack.pop();
                node=node.right;
            }
        }
    }
    public void inOrderTraverse2(){
        LinkedList<TreeNode> stack=new LinkedList<>();
        TreeNode node=this;
        while(node!=null||!stack.isEmpty()){
            while(node!=null){
                stack.push(node);
                node=node.left;
            }
            if(!stack.isEmpty()){
                node=stack.pop();
                System.out.print(node.val+" ");
                node=node.right;
            }
        }
        
    }
    
    /**
     * 后序遍历：可以被遍历的节点都要进栈出栈两次，所以添加第二个栈用来标示进栈次数
     *
     * @param root
     */
    public void postOrderTraverse2() {
        TreeNode root=this;
        if (root != null) {
            // 用来保存节点的栈
            ArrayList<TreeNode> stack = new ArrayList<TreeNode>();
            // 用来保存标志位的栈
            ArrayList<Integer> stack2 = new ArrayList<Integer>();
            // 两个栈共用的栈指针
            int top = -1;
            int tag;
            TreeNode current = root;
            do {
                //将所有左子节点进栈
                while (current != null) {
                    stack.add(current);
                    stack2.add(0);
                    top++;
                    current = current.left;
                }
                //取出栈顶节点，并判断其标志位
                current = stack.get(top);
                tag = stack2.get(top);
                stack2.remove(top);
                if (tag == 0) {
                    // tag为0,表明该节点第一次进栈，还需要进栈一次，同时修改标志位
                    current = current.right;
                    stack2.add(1);
                } else {
                    // tag不位0,表明非首次进栈，可以遍历了。
                    stack.remove(top);
                    top--;
                    System.out.print(current.val+" ");
                    current = null;
                }
            } while (current != null || top != -1);
        }
    }
    
    public static void main(String[] args){
//        int[] arr={1,2,3,4,5,6,7,8};
//        TreeNode tree=TreeNode.build(arr);
//        tree.levelTraverseAsList();
//        tree.zigzagTraverse();
//        tree.preOrderTraverse1();
//        System.out.println();
//        tree.preOrderTraverse2();
//        System.out.println();
//        
//        tree.inOrderTraverse1();
//        System.out.println();
//        tree.inOrderTraverse2();
//        System.out.println();
//        tree.postOrderTraverse2();
//        System.out.println();
//        tree.postOrderTraverse1();
        
        int[] preArr = {1,2,4,7,3,5,6,8};
        int[] inArr = {4,7,2,1,5,3,8,6};
        TreeNode root = construct(preArr, inArr);
        root.levelTraverse();
        System.out.println();
        root.preOrderTraverse1();
        System.out.println();
        root.inOrderTraverse1();
    }
}
