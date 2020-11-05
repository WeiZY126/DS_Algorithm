package Demo06Sort;

import java.util.Arrays;

public class Demo02SelectSort {
    public static void main(String[] args) {
        int arr[] = {3, 9, -1, 10, -2};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //选择排序
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int min = arr[i];
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    index = j;
                }
            }
            if (index != i) {
                arr[index] = arr[i];
                arr[i] = min;
            }
        }
    }
}
