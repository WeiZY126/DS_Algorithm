package Demo06Sort;

import java.util.Date;
import java.util.Random;

public class ATest {
    public static void main(String[] args) {
        int arr[] = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = new Random().nextInt(80000);
        }
        System.out.println(new Date());
//        Demo04ShellSort.shellSort2(arr); //0s
//        Demo04ShellSort.shellSort(arr); //9s
//        Demo03InsertSort.insertSort(arr); //1s
//        Demo02SelectSort.selectSort(arr); //3s
//        Demo01BubbleSort.bubbleSort(arr); //13s
//        Demo05QuickSort.quickSort(arr,0,arr.length-1);//0s
//        Demo07RadixSort.radixSort(arr);
        System.out.println(new Date());
    }
}
