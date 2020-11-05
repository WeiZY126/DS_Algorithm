package Demo06Sort;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class Demo04ShellSort {
    public static void main(String[] args) {
        int arr[] = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        shellSort(arr);
        shellSort2(arr);
    }

    //使用逐步推导的方式来编写希尔排序
    public static void shellSort(int arr[]) {
        int temp = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                //遍历各组中所有的元素（共gap组，每组有个元素,步长gap）
                for (int j = i - gap; j >= 0; j -= gap) {
                    //如果当前元素大于加上步长后的元素，说明需要交换
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }


//        //希尔排序第一轮
//        //因为第一轮排序是将10个数据分成了5组
//        for (int i = 5; i < arr.length; i++) {
//            //遍历各组中所有的元素（共5组，每组2个元素）
//            for (int j = i - 5; j >= 0; j -= 5) {
//                //如果当前元素大于加上步长后的元素，说明需要交换
//                if (arr[j]>arr[j+5]){
//                    temp = arr[j];
//                    arr[j] = arr[j+5];
//                    arr[j+5] = temp;
//                }
//            }
//        }
//        System.out.println(Arrays.toString(arr));
//
//        //希尔排序第二轮
//        //因为第一轮排序是将5个数据分成了2组
//        for (int i = 2; i < arr.length; i++) {
//            //遍历各组中所有的元素（共5组，每组2个元素）
//            for (int j = i - 2; j >= 0; j -= 2) {
//                //如果当前元素大于加上步长后的元素，说明需要交换
//                if (arr[j]>arr[j+2]){
//                    temp = arr[j];
//                    arr[j] = arr[j+2];
//                    arr[j+2] = temp;
//                }
//            }
//        }
//        System.out.println(Arrays.toString(arr));
//
//        //希尔排序第三轮
//        //因为第三轮排序是将10个数据分成了1组
//        for (int i = 1; i < arr.length; i++) {
//            //遍历各组中所有的元素（共5组，每组2个元素）
//            for (int j = i - 1; j >= 0; j -= 1) {
//                //如果当前元素大于加上步长后的元素，说明需要交换
//                if (arr[j]>arr[j+1]){
//                    temp = arr[j];
//                    arr[j] = arr[j+1];
//                    arr[j+1] = temp;
//                }
//            }
//        }
//        System.out.println(Arrays.toString(arr));
    }

    //对交换式shell排序进行优化->移位法
    public static void shellSort2(int arr[]) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //从第gap个元素开始，逐个对其所在的组进行直接插入排序
            for (int i = gap; i < arr.length; i++) {
                int val = arr[i];
                int index = i - gap;
                while (index >= 0 && val < arr[index]) {
                    arr[index + gap] = arr[index];
                    index = index - gap;
                }
                arr[index + gap] = val;
            }
        }
    }
}
