package Demo08Tree;

public class Demo01BinaryTree {
    public static void main(String[] args) throws Exception {
        //创建一棵二叉树
        BinaryTree binaryTree = new BinaryTree();
        //创建需要的节点
        Node node1 = new Node(4);
        Node node2 = new Node(2);
        Node node3 = new Node(8);
        Node node4 = new Node(6);
        //先手动创建该二叉树
        binaryTree.setRoot(node1);
        node1.setLeft(node2);
        node1.setRight(node3);
        node3.setLeft(node4);
//        System.out.println("前序");
//        binaryTree.preOrder();
//        System.out.println("中序");
//        binaryTree.infixOrder();
//        System.out.println("后续");
//        binaryTree.postOrder();

        binaryTree.preOrder();
        binaryTree.delNode(8);
        System.out.println("----");
        binaryTree.preOrder();

//        System.out.println(node1.preOrderSearch(4));
    }
}

//定义一个BinaryTree二叉树
class BinaryTree {
    private Node root;

    public BinaryTree() {
    }

    public BinaryTree(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    //前序遍历
    public void preOrder() {
        if (this.root != null)
            this.root.preOrder();
    }

    //中序
    public void infixOrder() {
        if (this.root != null)
            this.root.infixOrder();
    }

    //后续
    public void postOrder() {
        if (this.root != null)
            this.root.postOrder();
    }


    public void delNode(int num) {
        if (root != null) {
            if (root.getNum() == num)
                root = null;
            else
                root.delNode(num);
        } else
            System.out.println("树为空");
    }

}

//先创建节点
class Node {
    private int num;
    private Node left;
    private Node right;

    public Node(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node() {
    }

    @Override
    public String toString() {
        return "{" +
                "num=" + num + "}";
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this);//先输出父节点
        //递归向左子树
        if (this.left != null)
            this.left.preOrder();
        //递归右子树
        if (this.right != null)
            this.right.preOrder();
    }

    //中序
    public void infixOrder() {
        //递归向左子树
        if (this.left != null)
            this.left.infixOrder();
        System.out.println(this);//输出父节点
        //递归右子树
        if (this.right != null)
            this.right.infixOrder();
    }

    //后续
    public void postOrder() {
        //递归向左子树
        if (this.left != null)
            this.left.postOrder();
        //递归右子树
        if (this.right != null)
            this.right.postOrder();
        System.out.println(this);//输出父节点
    }

    //前序遍历查找
    public Node preOrderSearch(int num) {
        if (this.num == num)
            return this;
        //递归向左子树
        if (this.left != null)
            this.left.preOrderSearch(num);
        //递归右子树
        if (this.right != null)
            this.right.preOrderSearch(num);
        return null;
    }

    //递归删除
    public void delNode(int num) {
        if (this.left != null && this.left.getNum() == num) {
            this.left = null;
            return;
        }
        if (this.right != null && this.right.getNum() == num) {
            this.right = null;
            return;
        }
        if (this.left != null)
            this.left.delNode(num);
        if (this.right != null)
            this.right.delNode(num);

    }
}
