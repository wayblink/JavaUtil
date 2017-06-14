package datastruct.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class BinTree {

    public int data;
    public BinTree left;
    public BinTree right;
    
    public BinTree(){
        
    }
    public BinTree(int data){
        this.data=data;
    }
    
    //根据数组创建完全二叉树
    public static BinTree completeBinTree(int[] arr){
        int count=0;
        int length=arr.length;
        BinTree root=new BinTree(arr[count++]);
        LinkedList<BinTree> queue=new LinkedList<BinTree>();
        queue.add(root);
        
        while(count<length){
            BinTree lastNode=queue.poll();
            if(count<length){
                lastNode.left=new BinTree(arr[count++]);
                queue.add(lastNode.left);
            }
            if(count<length){
                lastNode.right=new BinTree(arr[count++]);
                queue.add(lastNode.right);
            }
        }
        return root;
    }        
        
    //前序遍历，返回数列
    public ArrayList<Integer> preOrderTraverse(){
        BinTree root=this;
        ArrayList<Integer> list=new ArrayList<Integer>();
        
        list.add(root.data);
        
        if(root.left!=null){
            list.addAll(root.left.preOrderTraverse());
        }
        if(root.right!=null){
            list.addAll(root.right.preOrderTraverse());
        }
        return list;
    }
    
    //中序遍历，返回数列
    public ArrayList<Integer> midOrderTraverse(){
        BinTree root=this;
        
        ArrayList<Integer> list=new ArrayList<Integer>();
        
        if(root.left!=null){
            list.addAll(root.left.midOrderTraverse());
        }
        list.add(root.data);
        if(root.right!=null){
            list.addAll(root.right.midOrderTraverse());
        }
        
        return list;
    }
    
    //后序遍历返回数列
    public ArrayList<Integer> afterOrderTraverse(){
        BinTree root=this;
        ArrayList<Integer> list=new ArrayList<Integer>();
        if(root.left!=null){
            list.addAll(root.left.afterOrderTraverse());
        }
        if(root.right!=null){
            list.addAll(root.right.afterOrderTraverse());
        }
        list.add(root.data);
        return list;
    }
    
    public ArrayList<Integer> preOrderTraverse2(){
        
        BinTree node=this;
        ArrayList<Integer> list=new ArrayList<Integer>();
        Stack<BinTree> s = new Stack<BinTree>();    
        
        while (node != null || !s.empty()) {    
            while (node != null) {
                list.add(node.data);
                s.push(node);    
                node = node.left;    
            }    
            if (!s.empty()) {    
                node = s.pop();    
                node = node.right;    
            }    
        } 
        
        return list;
    }
    
    public ArrayList<Integer> midOrderTraverse2(){
        BinTree node =this;
        ArrayList<Integer> list =new ArrayList<Integer>();
        Stack<BinTree> s=new Stack<BinTree>();
        
        while(node!=null||!s.isEmpty()){
            while(node!=null){
                s.push(node);
                node=node.left;
            }
            if(!s.empty()){
                node=s.pop();
                list.add(node.data);
                node=node.right;
            }
        }
        return list;
    }
    
    public ArrayList<Integer> afterOrderTraverse2(){
        BinTree node =this;
        ArrayList<Integer> list =new ArrayList<Integer>();
        Stack<BinTree> s=new Stack<BinTree>();
        
        Stack<Integer> s2 = new Stack<Integer>();    
        Integer i = new Integer(1);    
        while (node!= null || !s.empty()) {    
            while (node != null) {    
                s.push(node);    
                s2.push(new Integer(0));    
                node = node.left;    
            }    
            while (!s.empty() && s2.peek().equals(i)) {    
                s2.pop();    
                list.add(s.pop().data);
            }    
    
            if (!s.empty()) {    
                s2.pop();    
                s2.push(new Integer(1));    
                node = s.peek();    
                node = node.right;    
            }    
        } 
        return list;
    }
    
    public ArrayList<Integer> MorrisTraverse() {  
        ArrayList<Integer> list = new ArrayList<Integer>();  
        BinTree root=this;
          
        BinTree node = root;  
        while(node != null) {  
            if(node.left == null) {  
                list.add(node.data);  
                node = node.right;  
            } else {  
                BinTree tmp = node.left;  
                while(tmp.right != null && tmp.right != node)  
                    tmp = tmp.right;  
                if(tmp.right == null) {  
                    tmp.right = node;  //找到当前节点的前驱节点  
                    node = node.left;  
                } else {  
                    list.add(node.data);  
                    tmp.right = null;  //恢复二叉树  
                    node = node.right;  
                }  
            }  
        }  
        return list;  
    } 
    
    public ArrayList<Integer> levelTraverse() {
  
        BinTree root=this;
        LinkedList<BinTree> queue = new LinkedList<BinTree>();  
        ArrayList<Integer> list=new ArrayList<Integer>();
        BinTree current = null;  
        queue.add(root);//将根节点入队  
        while(!queue.isEmpty())  
        {  
            current = queue.poll();//出队队头元素并访问  
            list.add(current.data);
            if(current.left != null)//如果当前节点的左节点不为空入队  
            {  
                queue.add(current.left);  
            }  
            if(current.right != null)//如果当前节点的右节点不为空，把右节点入队  
            {  
                queue.add(current.right);  
            }  
        }  
        return list;
    }      
}
