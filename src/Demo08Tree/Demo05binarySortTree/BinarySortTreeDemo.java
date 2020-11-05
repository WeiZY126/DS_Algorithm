package Demo08Tree.Demo05binarySortTree;

public class BinarySortTreeDemo {
    public static void main(String[] args) throws Exception {
        int[] arr = {7, 3, 10, 12, 5, 1, 9,2};
        BinarySortTree bst = new BinarySortTree();
        for (int i : arr) {
            bst.add(new Node(i));
        }
        bst.delNode(10);
        bst.infixOrder();
    }

}

class BinarySortTree {
    Node root;

    public void add(Node node) {
        if (root == null)
            root = node;
        else
            root.add(node);
    }

    public void infixOrder() {
        if (root != null)
            root.infixOrder();
        else
            System.out.println("空树");
    }

    //查找要删除的节点
    public Node search(int value) {
        if (root == null)
            return null;
        else
            return root.search(value);
    }

    //查找父节点
    public Node searchParent(int value) {
        if (root == null)
            return null;
        else
            return root.searchParent(value);
    }

    //编写方法,传入节点（当作二叉排序树的根节点），
    // 返回以node为根节点的最小节点的值,并删除最小节点
    public int delRightTreeMin(Node node){
        Node target = node;
        //循环地查找左节点
        while (target.left!=null){
            target = target.left;
        }
        //这时target就指向了最小节点
        //删除最小节点
        delNode(target.value);
        return target.value;
    }
    //删除节点
    public void delNode(int value) {
        if (root == null)
            return;
        else {
            Node targetNode = search(value);
            if (targetNode == null)
                return;
            //如果二叉树只有一个节点
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }
            //找到父节点
            Node parent = searchParent(value);
            //如果删除的节点是叶子节点
            if (targetNode.left == null && targetNode.right == null) {
                if (parent.left != null && targetNode == parent.left)
                    parent.left = null;
                else if (parent.right != null && targetNode == parent.right)
                    parent.right = null;
            }else if (targetNode.left!=null&&targetNode.right!=null){
                int minVal = delRightTreeMin(targetNode.right);
                targetNode.value=minVal;
            }else{//删除只有一棵子树的节点
                if (targetNode.left!=null){
                    if (parent.left==targetNode){
                        parent.left=targetNode.left;
                    }else {
                        parent.right=targetNode.left;
                    }
                }else{
                    if (parent.left==targetNode){
                        parent.left=targetNode.right;
                    }else {
                        parent.right=targetNode.right;
                    }
                }
            }
        }
    }
}

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    public Node() {
    }

    @Override
    public String toString() {
        return "value=" + value;
    }

    //添加节点方法
    //递归添加,需要满足二叉排序树的要求
    public void add(Node node) {
        if (node == null)
            return;
        //判断传入的节点值，和当前子树的根节点的值得关系
        if (node.value < this.value) {
            if (this.left == null)
                this.left = node;
            else
                this.left.add(node);
        } else {
            if (this.right == null)
                this.right = node;
            else
                this.right.add(node);
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.left != null)
            this.left.infixOrder();
        System.out.println(this);
        if (this.right != null)
            this.right.infixOrder();
    }

    //查找要删除的节点
    public Node search(int value) {
        if (this.value == value)
            return this;
        else if (this.value > value) {
            if (this.left == null)
                return null;
            return this.left.search(value);
        } else {
            if (this.right == null)
                return null;
            return this.right.search(value);
        }
    }

    //查找要删除节点的父节点
    public Node searchParent(int value) {
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
            return this;
        } else {
            if (value < this.value && this.left != null)
                return this.left.searchParent(value);
            else if (value >= this.value && this.right != null)
                return this.right.searchParent(value);
            else
                return null;
        }
    }
}
