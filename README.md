# JavaUtil
My Own Util Library

FileUtil.java
工作过程中总结出来的一些文件操作方法

SortUtil.java
其中排序算法的实现示例：冒泡排序，选择排序，插入排序，希尔排序，快速排序，堆排序，归并排序

BinTree.java
二叉树的创建和遍历方法，包括非递归的前中后层序和递归的前中后序遍历，以及Morris中序遍历。

TestBinTree.java是BinTree.java的使用示范; TestBinTreeTraverse。java是BinTree.java的多个遍历方法的速度比较测试。

测试结果：
递归前序：     651173286
递归中序：     925679129
递归后序：     929790927
非递归前序： 201688572
非递归中序： 266293307
非递归后序： 514292122
非递归层序： 331009451
Morris：   169144627

Morris最快，前序其次，后续最慢，非递归比递归快，但非递归需要使用堆栈消耗额外空间。

