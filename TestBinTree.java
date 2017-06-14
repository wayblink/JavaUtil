package datastruct.tree;

import java.util.ArrayList;

public class TestBinTree {

    public static void main(String[] args){
        int[] arr={1,2,3,4,5,6};
        BinTree node=BinTree.completeBinTree(arr);
        
        ArrayList<Integer> array1 =node.preOrderTraverse();
        for(int i=0;i<array1.size();i++){
            System.out.print(array1.get(i)+" ");
        }
        System.out.println("\n-------------\n");
        
        ArrayList<Integer> array2 =node.midOrderTraverse();
        for(int i=0;i<array2.size();i++){
            System.out.print(array2.get(i)+" ");
        }
        System.out.println("\n-------------\n");
        
        ArrayList<Integer> array3 =node.afterOrderTraverse();
        for(int i=0;i<array3.size();i++){
            System.out.print(array3.get(i)+" ");
        }
        System.out.println("\n-------------\n");
    }
}
