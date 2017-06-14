package datastruct.tree;

import java.util.ArrayList;

public class TestBinTreeTraverse {

    public static void main(String[] args){
        //创建一个二叉树
        int[] arr=new int[100000];
        for(int i=0;i<arr.length;i++){
            arr[i]=i;
        }
        BinTree tree=BinTree.completeBinTree(arr);
        
        //创建一个线性表存储遍历结果
        ArrayList<Integer> list=new ArrayList<Integer>();
        
        //起始时间计时
        long start;
        long end;
        
        //统计每种方法的总时间
        long time1,time2,time3,time4,time5,time6,time7,time8;
        time1=0;
        time2=0;
        time3=0;
        time4=0;
        time5=0;
        time6=0;
        time7=0;
        time8=0;
        
        for(int i=0;i<100;i++){
            //递归前序
        start = System.nanoTime();
        list=tree.preOrderTraverse();
        //System.out.println(list.toString());
        end = System.nanoTime();
        //System.out.println(end-start);
        time1+=(end-start);
            //递归中序遍历
        start = System.nanoTime();
        list=tree.midOrderTraverse();
        //System.out.println(list.toString());
        end = System.nanoTime();
        //System.out.println(end-start);
        time2+=(end-start);
        
        //递归后序
        start = System.nanoTime();
        list=tree.afterOrderTraverse();
        //System.out.println(list.toString());
        end = System.nanoTime();
        //System.out.println(end-start);
        time3+=(end-start);
        
        //非递归前序
        start = System.nanoTime();
        list=tree.preOrderTraverse2();
        //System.out.println(list.toString());
        end = System.nanoTime();
        //System.out.println(end-start);
        time4+=(end-start);
        
        //非递归中序
        start = System.nanoTime();
        list=tree.midOrderTraverse2();
        //System.out.println(list.toString());
        end = System.nanoTime();
        //System.out.println(end-start);
        time5+=(end-start);
        
        //非递归后序
        start = System.nanoTime();
        list=tree.afterOrderTraverse2();
        //System.out.println(list.toString());
        end = System.nanoTime();
        //System.out.println(end-start);
        time6+=(end-start);
        
        //非递归层序
        start = System.nanoTime();
        list=tree.levelTraverse();
        //System.out.println(list.toString());
        end = System.nanoTime();
        //System.out.println(end-start);
        time7+=(end-start);
        
        //Morris中序遍历
        start = System.nanoTime();
        list=tree.MorrisTraverse();
        //System.out.println(list.toString());
        end = System.nanoTime();
        //System.out.println(end-start);
        time8+=(end-start);
        }
        
        System.out.println("递归前序：     "+time1);
        System.out.println("递归中序：     "+time2);
        System.out.println("递归后序：     "+time3);
        System.out.println("非递归前序： "+time4);
        System.out.println("非递归中序： "+time5);
        System.out.println("非递归后序： "+time6);
        System.out.println("非递归层序： "+time7);
        System.out.println("Morris：   "+time8);
    }
}
