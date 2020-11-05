package Demo08Tree;

public class Demo02ArrBinaryTree {
    public static void main(String[] args) throws Exception {
        int[] arr = {1,2,3,4,5,6,7};
        ArrayBinaryTree abt = new ArrayBinaryTree(arr);
        abt.preOrder(0);
    }
}
//编写一个ArrayBinaryTree，实现顺序存储二叉树遍历
class ArrayBinaryTree{
    private int[] arr;//存储数据节点的数组

    //编写方法，完成顺序存储二叉树的前序遍历

    /**
     *
     * @param index 表示数组下标
     */
    public void preOrder(int index){
        //如果数组为空或者arr.length=0
        if (arr==null||arr.length==0)
            return;
        System.out.println(arr[index]);
        if (index*2+1<arr.length)
            preOrder(index*2+1);
        if (index*2+2<arr.length)
            preOrder(index*2+2);
    }

    public ArrayBinaryTree() {
    }

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }
}
