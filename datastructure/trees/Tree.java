package datastruct.tree;

import java.util.ArrayList;
import java.util.LinkedList;

public class Tree {
    
    public int val;   
    public Tree[] children;
    
    public Tree(int val){
        this.val=val;
    }
    
    public Tree(int val,Tree[] children){
        this.val=val;
        this.children=children;
    }
    
    public void setChildren(Tree[] children){
        this.children=children;
    }
    
    public ArrayList<Integer> levelTraverse() {       
        Tree root=this;
        LinkedList<Tree> queue = new LinkedList<Tree>();  
        ArrayList<Integer> list=new ArrayList<Integer>();
        Tree current = null;  
        queue.add(root);//将根节点入队  
        while(!queue.isEmpty())  
        {  
            current = queue.poll();//出队队头元素并访问  
            list.add(current.val);
            if(current.children!=null){
                for(int i=0;i<current.children.length;i++){
                    queue.add(current.children[i]);
                }
            }
        }  
        return list;
    }      
    
    BinTree toBinTree(){
        
        Tree treeNode=this;
        BinTree bTreeNode=new BinTree();
        bTreeNode.data=treeNode.val;
        
        BinTree temp=bTreeNode;
        //判断是否有子节点
        if(treeNode.children!=null){
            //如果有子节点，遍历它们依次处理
            for(int i=0;i<treeNode.children.length;i++){
                //递归调用，将每个子节点也转换为二叉树节点
                BinTree ttemp=((Tree) treeNode.children[i]).toBinTree();
                //第一个节点，放在左子树上
                if(i==0){
                    temp.left=ttemp;
                    temp=(BinTree) temp.left;//游标指向第一子节点
                }else{
                    temp.right=ttemp;//第二个子节点放在第一个子节点的右子树上，以此类推
                    temp=(BinTree) temp.right;
                }
            }
        }

        return bTreeNode;
    }
}
