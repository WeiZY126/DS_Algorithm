package Demo06Sort;

import java.util.Arrays;

public class Demo05QuickSort {
    public static void main(String[] args) throws Exception {
        int arr[] = {-9,78,0,23,-567,70};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void quickSort(int[] arr,int left,int right){
        int l = left;//左下标
        int r = right;//右下标
        //pivot 中轴
        int pivot = arr[(left+right)/2];
        int temp=0;
        //循环的目的是让比pivot值小的放到左边，比pivot大的放在右边
        while (l<r){
            //在pivot的左边一直找，找到一个大于等于pivot的值才退出
            while (arr[l]<pivot){
                l+=1;
            }
            //在pivot的右边一直找，找到一个小于等于pivot的值才退出
            while (arr[r]>pivot){
                r-=1;
            }
            //如果l>=r成立，说明pivot两边的值，已经按照左边全部是小于等于pivot的值，右边全部是大于等于pivot的值
            if (l>=r) {
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换完后发现arr[l]=pivot 相等 r--，前移一下
            if (arr[l]==pivot)
                r-=1;
            //如果交换完后发现arr[r]=pivot 相等 l++，后移一下
            if (arr[r] == pivot)
                l++;
        }
        //如果l=r 必须l++，r--，否则出现栈溢出
        if (l==r){
            l++;
            r--;
        }
        //向左递归
        if (left<r){
            quickSort(arr,left,r);
        }
        //向右递归
        if (right>l)
            quickSort(arr,l,right);
    }
}
