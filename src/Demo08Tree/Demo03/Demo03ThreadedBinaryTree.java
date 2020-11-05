package Demo08Tree.Demo03;

public class Demo03ThreadedBinaryTree {
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
        binaryTree.threadedList();
    }
}

//定义一个ThreadedBinaryTree二叉树
class BinaryTree {
    private Node root;
    //为了实现线索化，需要创建一个指向当前节点的前驱节点
    private Node pre = null;
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

    //编写中序线索化方法
    //node就是当前需要线索化的节点
    public void threadedNodes(Node node){
        //如果为空，就直接退出
        if (node==null)
            return;
        //1.先线索化左子树
        threadedNodes(node.getLeft());
        //2.线索化当前节点
        //处理当前节点的前驱节点
        if (node.getLeft() == null){
            //让当前节点的左指针指向前驱节点
            node.setLeft(pre);
            //修改当前节点的左指针类型
            node.setLeftType(1);
        }
        //处理后继节点
        if (pre!=null&&pre.getRight()==null){
            //让前驱节点的右指针指向当前节点
            pre.setRight(node);
            pre.setRightType(1);
        }
        //每处理一个节点后，让当前节点是下一个节点的前驱节点
        pre = node;
        //3.线索化右子树
        threadedNodes(node.getRight());
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

    //遍历线索二叉树的方法
    public void threadedList(){
        //定义一个变量，存储当前遍历的节点，从root开始
        Node node = root;
        while (node!=null){
            //循环找到leftType==1的节点，第一个找到的就是8节点
            //后面随着遍历而变化，因为当leftType==1时说明该节点是按照线索化处理后的有效节点
            while (node.getLeftType()==0){
                node = node.getLeft();
            }
            //打印当前节点
            System.out.println(node);
            //如果当前节点的右指针指向的是后继节点，就一直输出
            while (node.getRightType()==1){
                node=node.getRight();
                System.out.println(node);
            }
            //替换遍历的节点
            node=node.getRight();
        }
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
//创建Node
class Node {
    private int num;
    private Node left;
    private Node right;

    //如果lefttype=0 表示指向左子树，如果为1表示指向前驱节点
    private int leftType;
    private int rightType;

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

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