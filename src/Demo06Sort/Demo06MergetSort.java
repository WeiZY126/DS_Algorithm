package Demo06Sort;

import java.util.Arrays;

public class Demo06MergetSort {
    public static void main(String[] args) throws Exception {
        int arr[] = {8,4,5,7,1,3,6,2};
        int temp[] = new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));
    }
    //分+合方法
    public static void mergeSort(int[] arr,int left,int right,int temp[]){
        if (left<right){
            int mid = (left+right)/2;//中间索引
            //向左递归分解
            mergeSort(arr,left,mid,temp);
            //向右递归分解
            mergeSort(arr,mid+1,right,temp);
            //合并
            merge(arr,left,mid,right,temp);
        }
    }
    //合并的方法
    public static void merge(int[] arr,int left,int right,int mid,int temp[]){
        int i = left;//初始化i，左边有序序列的初始索引
        int j = mid+1;//初始化j，右边有序序列的初始索引
        int t = 0;//指向temp数组的当前索引

        //1.先把左右两边（有序）的数据按规则填充到temp数组，直到左右两边有序序列有一边处理完毕
        while (i<=mid&&j<=right){
            //将左边元素拷贝到temp数组
            if (arr[i]<=arr[j]){
                temp[t]=arr[i];
                i++;
                t++;
            }else {
                temp[t] = arr[j];
                j++;
                t++;
            }
        }
        //2.将有剩余的一边的数据依次全部填充到temp
        while (i<=mid){//左边还有剩余，全部填充
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j<=right){
            temp[t] = arr[j];
            t++;
            j++;
        }
        //3.将temp数组拷贝到arr
        //注意：并不是每次都拷贝所有的
        t=0;
        int tempLeft = left;
        //第一次合并tempLeft=0,right=1//tempLeft=2 right=3//tL=0 ri=3
        //最后一次 tL=0,ri=7
        while (tempLeft<=right){
            arr[tempLeft] = temp[t];
            tempLeft++;
            t++;
        }
    }
}
