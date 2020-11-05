package Demo08Tree;

import java.util.Arrays;

public class Demo04HeapSort {
    public static void main(String[] args) throws Exception {
        int[] arr = {4, 6, 8, 5, 9};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //编写一个堆排序的方法
    public static void heapSort(int[] arr) {
        int temp = 0;
        /*//分步完成
        adjustHeap(arr,1,arr.length);

        adjustHeap(arr,0,arr.length);
        System.out.println(Arrays.toString(arr));*/

        //完成最终代码
        for (int i = arr.length/2-1;i>=0;i--){
            adjustHeap(arr,i,arr.length);
        }
        for (int j = arr.length-1;j>0;j--){
            //交换
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr,0,j);
        }
    }
    //将一个数组（二叉树）调整成一个大顶堆

    /**
     * 功能：完成将以i指向的非叶子节点的树调整成大顶堆
     *
     * @param arr    待调整数组
     * @param i      表示非叶子节点的在数组中的索引
     * @param length 对多少个元素进行调整，length是在逐渐减少
     */
    public static void adjustHeap(int[] arr, int i, int length) {

        int temp = arr[i];//先取出当前元素的值，保存临时变量
        //开始调整
        //k=i*2+1 k是i节点的左子节点
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {//说明左子节点值小于右子节点
                k++;//k指向右子节点
            }
            if (arr[k]>temp){
                arr[i] =arr[k];//把较大的值赋给当前节点
                i=k;//i指向k，继续循环比较
            }else{
                break;//
            }
        }
        //当for循环结束后，已经将以i为父节点的树的最大值放在了最顶上
        arr[i]=temp;
    }
}
