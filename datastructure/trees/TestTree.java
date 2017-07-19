package datastruct.tree;

import java.util.ArrayList;

public class TestTree {

    public static void main(String[] args){
        
        //创建一般树
        Tree tree=new Tree(0);
        Tree node1=new Tree(1);
        Tree node2=new Tree(2);
        Tree node3=new Tree(3);
        Tree node4=new Tree(4);
        Tree node5=new Tree(5);
        Tree node6=new Tree(6);
        
        tree.setChildren(new Tree[]{node1,node2,node3});
        node1.setChildren(new Tree[]{node4,node5});
        node2.setChildren(new Tree[]{node6});
        
        //遍历一般树
        ArrayList<Integer> array =tree.levelTraverse();
        for(int i=0;i<array.size();i++){
            System.out.print(array.get(i)+" ");
        }
        System.out.println("\n--------------\n");
        //一般树转为二叉树
        BinTree tree2=tree.toBinTree();
        //遍历转型得到的二叉树
        ArrayList<Integer> array2 =tree2.levelTraverse();
        for(int i=0;i<array2.size();i++){
            System.out.print(array2.get(i)+" ");
        }
    }
}
