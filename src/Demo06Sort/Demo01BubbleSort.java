package Demo06Sort;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class Demo01BubbleSort {
    public static void main(String[] args) {
//        int arr[] = {3, 9, -1, 10, -2};
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(80000);
        }
        System.out.println(Arrays.toString(arr));
        Long l1 = new Date().getTime();
        bubbleSort(arr);
        System.out.println(new Date().getTime() - l1);
        System.out.println(Arrays.toString(arr));

    }

    public static void bubbleSort(int[] arr) {
        //时间复杂度（n^2）
        //第一趟排序，将最大的排在最后
        int temp = 0;//临时变量
        boolean flag = false;//标识 标识是否进行过交换
        for (int j = 0; j < arr.length; j++) {
            for (int i = 0; i < arr.length - 1 - j; i++) {
                //如果前面的数比后面的数大则交换
                if (arr[i] > arr[i + 1]) {
                    flag = true;
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            if (!flag) {
                //说明在趟排序中一次交换都没有发生
                break;
            } else
                flag = false;

        }
    }

}
