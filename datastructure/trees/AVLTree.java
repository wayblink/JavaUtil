package datastruct.avltree;

public class AVLTree <T extends Comparable<T>>{
    
    private AVLTreeNode<T> root;
    
    public AVLTree(){
        root=null;
    }
    
    class AVLTreeNode<T extends Comparable<T>>{
        T key;
        int height;
        AVLTreeNode<T> left;
        AVLTreeNode<T> right;
        
        public AVLTreeNode(T key,AVLTreeNode<T> left,AVLTreeNode<T> right){
            this.key=key;
            this.left=left;
            this.right=right;
            this.height=0;
        }
        
    }
    
    private int height(AVLTreeNode<T> tree){
        if(tree != null){
            return tree.height;
        }
        return 0;
    }
    
    public int height(){
        return height(root);
    }
    
    private AVLTreeNode<T> leftLeftRotation(AVLTreeNode<T> tree){
        AVLTreeNode<T> newTree;
        
        newTree=tree.left;
        tree.left=newTree.right;
        newTree.right=tree;
        
        tree.height=max(height(tree.left),height(tree.right))+1;
        newTree.height=max(height(newTree.left),height(tree))+1;
        
        return newTree;
    } 
    
    private AVLTreeNode<T> rightRightRotation(AVLTreeNode<T> tree){
        AVLTreeNode<T> newtree;
        
        newtree=tree.right;
        tree.right=newtree.left;
        newtree.left=tree;
        
        tree.height=max(height(tree.left),height(tree.right))+1;
        newtree.height=max(tree.height,height(newtree.right))+1;
        return newtree;
    }
    
    private AVLTreeNode<T> leftRightRotation(AVLTreeNode<T> tree){
        tree.left=rightRightRotation(tree.left);
        return leftLeftRotation(tree);
    }
    
    private AVLTreeNode<T> rightLeftRotation(AVLTreeNode<T> tree){
        tree.right=leftLeftRotation(tree.right);
        return rightRightRotation(tree);
    }
    
    public void insert(T key){
        root=insert(key,root);
    }
    
    private AVLTreeNode<T> insert(T key,AVLTreeNode<T> tree){
        if(tree==null){
            tree=new AVLTreeNode<T>(key,null,null);
        }else{
            int cmpflag=key.compareTo(tree.key);//compare flag, to decide which child to insert
            if(cmpflag < 0){
                tree.left=insert(key,tree.left);//insert into the left child tree
                //rotate if unbalanced
                if(height(tree.left)-height(tree.right)==2){
                    if(key.compareTo(tree.left.key)<0){
                        tree=leftLeftRotation(tree);
                    }else{
                        tree=leftRightRotation(tree);
                    }
                }
            }else if(cmpflag > 0){
                tree.right=insert(key,tree.right);//insert into the right child tree
                if(height(tree.right)-height(tree.left)==2){
                    if(key.compareTo(tree.right.key)<0){
                        tree=rightLeftRotation(tree);
                    }else{
                        tree=rightRightRotation(tree);
                    }
                }
            }else{
                System.out.println("Insert failed: the node has already exist");
            }
        }
        tree.height=max(height(tree.left),height(tree.right))+1;
        return tree;
    }
    
    public void remove(T key) {
        AVLTreeNode<T> z; 

        if ((z = search(root, key)) != null)
            root = remove(root, z);
    }
    
    /* 
     * 删除结点(z)，返回根节点
     *
     * 参数说明：
     *     tree AVL树的根结点
     *     z 待删除的结点
     * 返回值：
     *     根节点
     */
    private AVLTreeNode<T> remove(AVLTreeNode<T> tree, AVLTreeNode<T> z) {
        // 根为空 或者 没有要删除的节点，直接返回null。
        if (tree==null || z==null)
            return null;

        int cmp = z.key.compareTo(tree.key);
        if (cmp < 0) {        // 待删除的节点在"tree的左子树"中
            tree.left = remove(tree.left, z);
            // 删除节点后，若AVL树失去平衡，则进行相应的调节。
            if (height(tree.right) - height(tree.left) == 2) {
                AVLTreeNode<T> r =  tree.right;
                if (height(r.left) > height(r.right))
                    tree = rightLeftRotation(tree);
                else
                    tree = rightRightRotation(tree);
            }
        } else if (cmp > 0) {    // 待删除的节点在"tree的右子树"中
            tree.right = remove(tree.right, z);
            // 删除节点后，若AVL树失去平衡，则进行相应的调节。
            if (height(tree.left) - height(tree.right) == 2) {
                AVLTreeNode<T> l =  tree.left;
                if (height(l.right) > height(l.left))
                    tree = leftRightRotation(tree);
                else
                    tree = leftLeftRotation(tree);
            }
        } else {    // tree是对应要删除的节点。
            // tree的左右孩子都非空
            if ((tree.left!=null) && (tree.right!=null)) {
                if (height(tree.left) > height(tree.right)) {
                    // 如果tree的左子树比右子树高；
                    // 则(01)找出tree的左子树中的最大节点
                    //   (02)将该最大节点的值赋值给tree。
                    //   (03)删除该最大节点。
                    // 这类似于用"tree的左子树中最大节点"做"tree"的替身；
                    // 采用这种方式的好处是：删除"tree的左子树中最大节点"之后，AVL树仍然是平衡的。
                    AVLTreeNode<T> max = maximum(tree.left);
                    tree.key = max.key;
                    tree.left = remove(tree.left, max);
                } else {
                    // 如果tree的左子树不比右子树高(即它们相等，或右子树比左子树高1)
                    // 则(01)找出tree的右子树中的最小节点
                    //   (02)将该最小节点的值赋值给tree。
                    //   (03)删除该最小节点。
                    // 这类似于用"tree的右子树中最小节点"做"tree"的替身；
                    // 采用这种方式的好处是：删除"tree的右子树中最小节点"之后，AVL树仍然是平衡的。
                    AVLTreeNode<T> min = maximum(tree.right);
                    tree.key = min.key;
                    tree.right = remove(tree.right, min);
                }
            } else {
                AVLTreeNode<T> tmp = tree;
                tree = (tree.left!=null) ? tree.left : tree.right;
                tmp = null;
            }
        }

        return tree;
    }
    
    /* 
     * 销毁AVL树
     */
    private void destroy(AVLTreeNode<T> tree) {
        if (tree==null)
            return ;

        if (tree.left != null)
            destroy(tree.left);
        if (tree.right != null)
            destroy(tree.right);

        tree = null;
    }

    public void destroy() {
        destroy(root);
    }

    /*
     * 打印"二叉查找树"
     *
     * key        -- 节点的键值 
     * direction  --  0，表示该节点是根节点;
     *               -1，表示该节点是它的父结点的左孩子;
     *                1，表示该节点是它的父结点的右孩子。
     */
    private void print(AVLTreeNode<T> tree, T key, int direction) {
        if(tree != null) {
            if(direction==0)    // tree是根节点
                System.out.printf("%2d is root\n", tree.key, key);
            else                // tree是分支节点
                System.out.printf("%2d is %2d's %6s child\n", tree.key, key, direction==1?"right" : "left");

            print(tree.left, tree.key, -1);
            print(tree.right,tree.key,  1);
        }
    }

    public void print() {
        if (root != null)
            print(root, root.key, 0);
    }
    
    /*
     * 前序遍历"AVL树"
     */
    private void preOrder(AVLTreeNode<T> tree) {
        if(tree != null) {
            System.out.print(tree.key+" ");
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    /*
     * 中序遍历"AVL树"
     */
    private void inOrder(AVLTreeNode<T> tree) {
        if(tree != null)
        {
            inOrder(tree.left);
            System.out.print(tree.key+" ");
            inOrder(tree.right);
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    /*
     * 后序遍历"AVL树"
     */
    private void postOrder(AVLTreeNode<T> tree) {
        if(tree != null) {
            postOrder(tree.left);
            postOrder(tree.right);
            System.out.print(tree.key+" ");
        }
    }

    public void postOrder() {
        postOrder(root);
    }

    /*
     * (递归实现)查找"AVL树x"中键值为key的节点
     */
    private AVLTreeNode<T> search(AVLTreeNode<T> x, T key) {
        if (x==null)
            return x;

        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            return search(x.left, key);
        else if (cmp > 0)
            return search(x.right, key);
        else
            return x;
    }

    public AVLTreeNode<T> search(T key) {
        return search(root, key);
    }

    /*
     * (非递归实现)查找"AVL树x"中键值为key的节点
     */
    private AVLTreeNode<T> iterativeSearch(AVLTreeNode<T> x, T key) {
        while (x!=null) {
            int cmp = key.compareTo(x.key);

            if (cmp < 0)
                x = x.left;
            else if (cmp > 0)
                x = x.right;
            else
                return x;
        }

        return x;
    }

    public AVLTreeNode<T> iterativeSearch(T key) {
        return iterativeSearch(root, key);
    }

    /* 
     * 查找最小结点：返回tree为根结点的AVL树的最小结点。
     */
    private AVLTreeNode<T> minimum(AVLTreeNode<T> tree) {
        if (tree == null)
            return null;

        while(tree.left != null)
            tree = tree.left;
        return tree;
    }

    public T minimum() {
        AVLTreeNode<T> p = minimum(root);
        if (p != null)
            return p.key;

        return null;
    }
     
    /* 
     * 查找最大结点：返回tree为根结点的AVL树的最大结点。
     */
    private AVLTreeNode<T> maximum(AVLTreeNode<T> tree) {
        if (tree == null)
            return null;

        while(tree.right != null)
            tree = tree.right;
        return tree;
    }

    public T maximum() {
        AVLTreeNode<T> p = maximum(root);
        if (p != null)
            return p.key;

        return null;
    }
    
    private int max(int a,int b){
        return a > b ? a : b;
    }
}
